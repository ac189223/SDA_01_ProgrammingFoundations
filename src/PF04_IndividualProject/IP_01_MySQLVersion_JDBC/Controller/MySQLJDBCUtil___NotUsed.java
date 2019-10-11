package PF04_IndividualProject.IP_01_MySQLVersion_JDBC.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author mysqltutorial.org
 */
public class MySQLJDBCUtil___NotUsed {

    /**
     * Get database connection
     *
     * @return a Connection object
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = null;

        try (FileInputStream f = new FileInputStream("db.properties")) {

            String url       = "jdbc:mysql://localhost:3306/ip";
            String user      = "root";
            String password  = "ac01AC=!";


            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("None");

        }
        return conn;
    }

}