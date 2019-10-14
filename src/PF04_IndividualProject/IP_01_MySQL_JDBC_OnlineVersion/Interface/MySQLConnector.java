package PF04_IndividualProject.IP_01_MySQL_JDBC_OnlineVersion.Interface;

import java.sql.*;

public class MySQLConnector {
    private QueryBuilder sqlString = new QueryBuilder();

    public QueryBuilder getSqlString() { return sqlString; }

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










    public void createTable_CreateCopy(String sqlString) {
        try
        {
            Connection conn = (startConnection());
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE address_book (Last_Name char(50) default ''," +
                    "First_Name char(50),Email char(50),Phone_Number char(50))");
            stmt.execute("COPY address_book FROM 'address.dat' DELIMITER ',' NULL 'null'");
            closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("READ - CANNOT EXECUTE =(");
        }
    }

    public void readData_Select(String sqlString) {
        try
        {
            Connection conn = (startConnection());
            Statement stmt = conn.createStatement();
            ResultSet rs = null;
            rs = stmt.executeQuery(sqlString);
            while (rs.next())

                System.out.println(rs.getString(1).trim() + " " + rs.getString(2).trim());
            closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("READ - CANNOT EXECUTE =(");
        }
    }

    public void appendData_InsertUpdateDelete(String sqlString) {
        try
        {
            Connection conn = (startConnection());
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sqlString);
            closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("APPEND - CANNOT EXECUTE =(");
        }
    }

    public void updateData_InsertUpdateDelete(String sqlString) {
        try
        {
            Connection conn = (startConnection());
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sqlString);
            closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("UPDATE - CANNOT EXECUTE =(");
        }
    }

    public void deleteData_InsertUpdateDelete(String sqlString) {
        try
        {
            Connection conn = (startConnection());
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sqlString);
            closeConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DELETE - CANNOT EXECUTE =(");
        }
    }
}