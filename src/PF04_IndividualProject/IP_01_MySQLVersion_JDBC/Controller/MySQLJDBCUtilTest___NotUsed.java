package PF04_IndividualProject.IP_01_MySQLVersion_JDBC.Controller;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author mysqltutorial.org
 */
public class MySQLJDBCUtilTest___NotUsed {

    public static void main(String[] args) {
        // create a new connection from MySQLJDBCUtil
        try (Connection conn = MySQLJDBCUtil___NotUsed.getConnection()) {

            // print out a message
            if (conn == null)
                System.out.println("None.");
            else
                System.out.println("Connected to database successfully.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}