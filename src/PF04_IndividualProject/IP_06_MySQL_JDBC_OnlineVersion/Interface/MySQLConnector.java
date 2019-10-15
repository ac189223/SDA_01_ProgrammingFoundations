package PF04_IndividualProject.IP_06_MySQL_JDBC_OnlineVersion.Interface;

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
}