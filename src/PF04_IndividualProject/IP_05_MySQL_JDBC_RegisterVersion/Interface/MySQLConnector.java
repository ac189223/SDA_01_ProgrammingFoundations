package PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Interface;

import PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Model.Project;
import PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Model.Register;
import PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Model.Task;

import java.sql.*;
import java.util.ArrayList;

public class MySQLConnector {
    private SQLQueryBuilder sqlString = new SQLQueryBuilder();

    public SQLQueryBuilder getSqlString() { return sqlString; }

    /** =================    =================    MySQL database activities    =================   ================= */

    // Connection with database setup
    public Connection startConnection()
    {
        Connection conn;                                         // Setup connection properties
        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/";
        final String DB_NAME = "ip";
        final String USER_NAME = "root";
        final String PASSWORD = "ac01AC=!";

        try {
            Class.forName(DRIVER).newInstance();
            conn = DriverManager.getConnection(URL + DB_NAME + "?user=" + USER_NAME + "&password=" + PASSWORD);
            return conn;                                        // Return connection to work with
        } catch (Exception e) {
            System.out.println("NO CONNECTION =(");
        }
        return null;                                            // Return null if unable to connect
    }

    // Close connection with database
    public void closeConnection(Connection conn) {
        try
        {
            conn.close();
        } catch (SQLException e) {
            System.out.println("CANNOT DISCONNECT =(");         // Inform if unable to disconnect
        }
    }

    // Read data from database
    public DataLists readData() {
        ArrayList<Task> tasks = new ArrayList<>();
        ArrayList<Project> projects = new ArrayList<>();
        try
        {
            Connection conn = (startConnection());                              // Establish connection
            Statement stmt = conn.createStatement();
            ResultSet rs = null;                                                // Prepare to fetch results
            rs = stmt.executeQuery(getSqlString().readTasksSqlString());        // Execute select query against tasks table
            while (rs.next())
                try {                                   // Add to array tasks assigned to projects
                    tasks.add(new Task(rs.getString(1).trim(), rs.getString(2).trim(),
                            rs.getString(3).trim().replace("-", ""),
                            rs.getBoolean(4), rs.getString(5).trim()));
                } catch (NullPointerException e) {      // Add unassigned tasks to array
                    tasks.add(new Task(rs.getString(1).trim(), rs.getString(2).trim(),
                            rs.getString(3).trim().replace("-", ""),
                            rs.getBoolean(4)));
                }
            rs = stmt.executeQuery(getSqlString().readProjectsSqlString());    // Execute select query against tasks table
            while (rs.next())                                                  // Add projects to array
                projects.add(new Project(rs.getString(1).trim(),rs.getString(2).trim(),
                        rs.getString(3).trim().replace("-", ""),
                        rs.getBoolean(4)));
            closeConnection(conn);                                             // Close connection
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("READ - CANNOT EXECUTE =(");                    // Inform if unable to read
        }

        return new DataLists(tasks, projects);
    }

    // Delete tables from database
    public void dropTables() {
        try
        {
            Connection conn = (startConnection());                            // Establish connection
            Statement stmt = conn.createStatement();
            stmt.execute(getSqlString().deleteTables());                      // Execute drop query against tables
            closeConnection(conn);                                            // Close connection
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DELETE - CANNOT EXECUTE =(");                 // Inform if unable to delete tables
        }
    }

    // Recreate tables
    public void createTables() {
        try
        {
            Connection conn = (startConnection());                            // Establish connection
            Statement stmt = conn.createStatement();
            stmt.execute(getSqlString().createTableProjects());               // Execute create queries
            stmt.execute(getSqlString().createTableTasks());
            closeConnection(conn);                                            // Close connection
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("CREATE - CANNOT EXECUTE =(");                 // Inform if unable to create tables
        }
    }

    // Populate tables with data
    public void populateTables(Register register) {
        try {
            Connection conn = (startConnection());                            // Establish connection
            conn.setAutoCommit(false);
            try (Statement stmt = conn.createStatement()) {
                register.getProjects()
                        .forEach(project -> {
                            try {                                             // Create insert queries against projects
                                stmt.executeUpdate(getSqlString().populateTableProjects(project));
                            } catch (SQLException e) {
                                e.printStackTrace();
                                System.out.println("POPULATE - CANNOT EXECUTE =(");     // Inform if unable to write line
                            }
                        });
                register.getTasks()
                        .forEach(task -> {
                            try {                                             // Create insert queries against tasks
                                stmt.executeUpdate(getSqlString().populateTableTasks(task));
                            } catch (SQLException e) {
                                e.printStackTrace();
                                System.out.println("POPULATE - CANNOT EXECUTE =(");     // Inform if unable to write line
                            }
                        });
                conn.commit();                                                // Execute queries against tables
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
                System.out.println("POPULATE - CANNOT EXECUTE =(");           // Inform if unable to write
            }
            closeConnection(conn);                                            // Close connection
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("POPULATE - CANNOT EXECUTE =(");               // Inform if unable to populate
        }
    }
}