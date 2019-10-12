package PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Controller;

import PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Model.Project;
import PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Model.Register;
import PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Model.Task;

import java.sql.*;
import java.util.ArrayList;

public class MySQLConnector {
    private SQLBuilder sqlString = new SQLBuilder();

    public SQLBuilder getSqlString() { return sqlString; }

    public Connection startConnection()
    {
        Connection conn;
        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/";
        final String DB_NAME = "ip";
        final String USER_NAME = "root";
        final String PASSWORD = "ac01AC=!";

        try {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(URL + DB_NAME + "?user=" + USER_NAME + "&password=" + PASSWORD);
            return conn;
        } catch (Exception e) {
            System.out.println("NO CONNECTION =(");
        }
        return null;
    }

    public void closeConnection(Connection conn) {
        try
        {
            conn.close();
        } catch (SQLException e) {
            System.out.println("CANNOT DISCONNECT =(");
        }
    }

    public DataLists readData() {
        ArrayList<Task> tasks = new ArrayList<>();
        ArrayList<Project> projects = new ArrayList<>();
        try
        {
            Connection conn = (startConnection());
            Statement stmt = conn.createStatement();
            ResultSet rs = null;
            rs = stmt.executeQuery(getSqlString().readTasksSqlString());
            while (rs.next())
                try {
                    tasks.add(new Task(rs.getString(1).trim(), rs.getString(2).trim(),
                            rs.getString(3).trim().replace("-", ""),
                            rs.getBoolean(4), rs.getString(5).trim()));
                } catch (NullPointerException e) {
                    tasks.add(new Task(rs.getString(1).trim(), rs.getString(2).trim(),
                            rs.getString(3).trim().replace("-", ""),
                            rs.getBoolean(4)));
                }
            rs = stmt.executeQuery(getSqlString().readProjectsSqlString());
            while (rs.next())
                projects.add(new Project(rs.getString(1).trim(),rs.getString(2).trim(),
                        rs.getString(3).trim().replace("-", ""),
                        rs.getBoolean(4)));
            closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("READ - CANNOT EXECUTE =(");
        }

        return new DataLists(tasks, projects);
    }

    public void dropDatabase() {
        try
        {
            Connection conn = (startConnection());
            Statement stmt = conn.createStatement();
            stmt.execute(getSqlString().deleteTables());
            closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DELETE - CANNOT EXECUTE =(");
        }
    }

    public void createDatabase() {
        try
        {
            Connection conn = (startConnection());
            Statement stmt = conn.createStatement();
            stmt.execute(getSqlString().createTableProjects());
            stmt.execute(getSqlString().createTableTasks());
            closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("CREATE - CANNOT EXECUTE =(");
        }
    }

    public void populateTables(Register register) {
        try {
            Connection conn = (startConnection());
            conn.setAutoCommit(false);
            try (Statement stmt = conn.createStatement()) {
                register.getProjects()
                        .forEach(project -> {
                            try {
                                stmt.executeUpdate(getSqlString().populateTableProjects(project));
                            } catch (SQLException e) {
                                e.printStackTrace();
                                System.out.println("POPULATE - CANNOT EXECUTE =(");
                            }
                        });
                register.getTasks()
                        .forEach(task -> {
                            try {
                                stmt.executeUpdate(getSqlString().populateTableTasks(task));
                            } catch (SQLException e) {
                                e.printStackTrace();
                                System.out.println("POPULATE - CANNOT EXECUTE =(");
                            }
                        });
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
                System.out.println("POPULATE - CANNOT EXECUTE =(");
            }
            closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("POPULATE - CANNOT EXECUTE =(");
        }
    }

}
