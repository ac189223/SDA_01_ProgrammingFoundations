package PF04_IndividualProject.IP_01_MySQLVersion_JDBC.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {

    public Connection startConnection()
    {
        Connection conn;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "ip";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "ac01AC=!";

        try
        {
            Class.forName(driver).newInstance();
            // conn = DriverManager.getConnection(url+dbName, userName, password);
            conn = DriverManager.getConnection(url + dbName + "?user=" + userName + "&password=" + password);
            // System.out.println("Connected to the database");
            return conn;
        }
        catch (Exception e)
        {
            // e.printStackTrace();
            // System.out.println("NO CONNECTION =(");
        }
        return null;
    }

    public void closeConnection(Connection conn) {
        try
        {
            conn.close();
            // System.out.println("Disconnected from database");
        } catch (SQLException e) {
            // System.out.println("CANNOT DISCONNECT =(");
        }
    }

    public void readData(Connection conn) {
        try
        {
            conn.close();
            // System.out.println("Disconnected from database");
        } catch (SQLException e) {
            // System.out.println("CANNOT DISCONNECT =(");
        }
    }
}
