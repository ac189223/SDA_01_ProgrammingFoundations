package PF04_IndividualProject.IP_01_MySQL_JDBC_OnlineVersion.Interface;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLControllerProjects extends MySQLController{

    /** =================    =================    MySQL controller for projects    =================   ================= */

    // Add new project
    public void addNewProject(String id, String title, String dueDate) {
        try
        {
            Connection conn = (getMySQLConnector().startConnection());                      // Establish connection
            Statement stmt = conn.createStatement();
            stmt.execute(getQueryBuilder().addNewProject(id, title, dueDate));              // Execute add project query
            getMySQLConnector().closeConnection(conn);                                      // Close connection
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("CREATE PROJECT - CANNOT EXECUTE =(");                       // Inform if unable to create project
        }
    }

    // Mark project as finished
    public void markProjectAsDone(String projectId) {
        try
        {
            Connection conn = (getMySQLConnector().startConnection());                      // Establish connection
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(getQueryBuilder().markProjectAsDone(projectId));             // Execute mark project finished query
            getMySQLConnector().closeConnection(conn);                                      // Close connection
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("MARK PROJECT AS FINISHED - CANNOT EXECUTE =(");             // Inform if unable to mark as finished
        }
    }

    // Mark project as unfinished
    public void markProjectAsNotDone(String projectId) {
        try
        {
            Connection conn = (getMySQLConnector().startConnection());                      // Establish connection
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(getQueryBuilder().markProjectAsNotDone(projectId));          // Execute mark project unfinished query
            getMySQLConnector().closeConnection(conn);                                      // Close connection
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("MARK PROJECT AS UNFINISHED - CANNOT EXECUTE =(");           // Inform if unable to mark as unfinished
        }
    }

    // Remove project
    public void removeProject(String projectId) {
        try
        {
            Connection conn = (getMySQLConnector().startConnection());                      // Establish connection
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(getQueryBuilder().removeProject(projectId));                 // Execute remove project query
            getMySQLConnector().closeConnection(conn);                                      // Close connection
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("REMOVE PROJECT - CANNOT EXECUTE =(");                          // Inform if unable to remove project
        }
    }

    // Set project due date
    public void setProjectDueDate(String projectId, String dueDate) {
        try
        {
            Connection conn = (getMySQLConnector().startConnection());                      // Establish connection
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(getQueryBuilder().setProjectDueDate(projectId, dueDate));    // Execute set due date for project
            getMySQLConnector().closeConnection(conn);                                      // Close connection
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SET PROJECT DUE DATE - CANNOT EXECUTE =(");                 // Inform if unable to set
        }
    }

    // Set project title
    public void setProjectTitle(String projectId, String title) {
        try
        {
            Connection conn = (getMySQLConnector().startConnection());                      // Establish connection
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(getQueryBuilder().setProjectTitle(projectId, title));        // Execute set title for project
            getMySQLConnector().closeConnection(conn);                                      // Close connection
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SET PROJECT TITLE - CANNOT EXECUTE =(");                    // Inform if unable to set
        }
    }
}