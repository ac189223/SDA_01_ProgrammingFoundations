package PF04_IndividualProject.IP_01_MySQLVersion_JDBC.Controller;

import java.sql.*;

public class MySQLConnector_ModelClass {

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
            System.out.println("NO CONNECTION =(");
        }
        return null;
    }

    public void closeConnection(Connection conn) {
        try
        {
            conn.close();
            // System.out.println("Disconnected from database");
        } catch (SQLException e) {
            System.out.println("CANNOT DISCONNECT =(");
        }
    }

    public void readData(String sqlString) {
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

    public void appendData(String sqlString) {
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

    public void updateData(String sqlString) {
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

    public void deleteData(String sqlString) {
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
