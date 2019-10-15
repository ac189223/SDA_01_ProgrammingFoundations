package PF04_IndividualProject.IP_01_MySQL_JDBC_OnlineVersion.Interface;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLControllerTasks extends MySQLController{

    /** =================    =================    MySQL controller for tasks    =================   ================= */

    // Add new task
    public void addNewTask(String id, String title, String dueDate) {
        try
        {
            Connection conn = (getMySQLConnector().startConnection());                      // Establish connection
            Statement stmt = conn.createStatement();
            stmt.execute(getQueryBuilder().addNewTask(id, title, dueDate));                 // Execute add task query
            getMySQLConnector().closeConnection(conn);                                      // Close connection
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("CREATE TASK - CANNOT EXECUTE =(");                          // Inform if unable to create task
        }
    }

    // Mark task as finished
    public void markTaskAsDone(String taskId) {
        try
        {
            Connection conn = (getMySQLConnector().startConnection());                      // Establish connection
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(getQueryBuilder().markTaskAsDone(taskId));                   // Execute mark task finished query
            getMySQLConnector().closeConnection(conn);                                      // Close connection
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("MARK TASK AS FINISHED - CANNOT EXECUTE =(");                    // Inform if unable to mark as finished
        }
    }

    // Mark task as unfinished
    public void markTaskAsNotDone(String taskId) {
        try
        {
            Connection conn = (getMySQLConnector().startConnection());                      // Establish connection
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(getQueryBuilder().markTaskAsNotDone(taskId));                // Execute mark task unfinished query
            getMySQLConnector().closeConnection(conn);                                      // Close connection
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("MARK TASK AS UNFINISHED - CANNOT EXECUTE =(");              // Inform if unable to mark as unfinished
        }
    }

    // Remove task
    public void removeTask(String taskId) {
        try
        {
            Connection conn = (getMySQLConnector().startConnection());                      // Establish connection
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(getQueryBuilder().removeTask(taskId));                       // Execute remove task query
            getMySQLConnector().closeConnection(conn);                                      // Close connection
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("REMOVE TASK - CANNOT EXECUTE =(");                          // Inform if unable to remove task
        }
    }

    // Set task due date
    public void setTaskDueDate(String taskId, String dueDate) {
        try
        {
            Connection conn = (getMySQLConnector().startConnection());                      // Establish connection
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(getQueryBuilder().setTaskDueDate(taskId, dueDate));          // Execute set due date for task
            getMySQLConnector().closeConnection(conn);                                      // Close connection
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SET TASK DUE DATE - CANNOT EXECUTE =(");                    // Inform if unable to set
        }
    }

    // Set task title
    public void setTaskTitle(String taskId, String title) {
        try
        {
            Connection conn = (getMySQLConnector().startConnection());                      // Establish connection
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(getQueryBuilder().setTaskTitle(taskId, title));              // Execute set title for task
            getMySQLConnector().closeConnection(conn);                                      // Close connection
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SET TASK TITLE - CANNOT EXECUTE =(");                       // Inform if unable to set
        }
    }
}