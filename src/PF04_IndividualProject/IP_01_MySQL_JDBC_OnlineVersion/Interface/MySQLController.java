package PF04_IndividualProject.IP_01_MySQL_JDBC_OnlineVersion.Interface;

import PF04_IndividualProject.IP_01_MySQL_JDBC_OnlineVersion.Model.Project;
import PF04_IndividualProject.IP_01_MySQL_JDBC_OnlineVersion.Model.Task;

import java.sql.*;

public class MySQLController {
    private QueryBuilder queryBuilder;
    private MySQLConnector mySQLConnector;

    public MySQLController () {
        this.setQueryBuilder(new QueryBuilder());
        this.setMySQLConnector(new MySQLConnector());
    }

    public QueryBuilder getQueryBuilder() { return queryBuilder; }
    public MySQLConnector getMySQLConnector() { return mySQLConnector; }

    public void setQueryBuilder(QueryBuilder queryBuilder) { this.queryBuilder = queryBuilder; }
    public void setMySQLConnector(MySQLConnector mySQLConnector) { this.mySQLConnector = mySQLConnector; }

    /** =================    =================    MySQL controller    =================   ================= */

    // Read data from database
    public DataLists readData() {
        DataLists dataLists = new DataLists();
        try
        {
            Connection conn = (getMySQLConnector().startConnection());                      // Establish connection
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(getQueryBuilder().readTasksSqlString());       // Execute select query against tasks table
            createTasks(dataLists, rs);                                                     // Append tasks to result set
            rs = stmt.executeQuery(getQueryBuilder().readProjectsSqlString());              // Execute select query against tasks table
            createProjects(dataLists, rs);                                                  // Append projects to result set
            getMySQLConnector().closeConnection(conn);                                      // Close connection
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("READ - CANNOT EXECUTE =(");                                 // Inform if unable to read
        }

        return dataLists;
    }

    // Append tasks from database to result set
    private void createTasks(DataLists dataLists, ResultSet rs) throws SQLException {
        while (rs.next())
            try {                                                                       // Add to array tasks assigned to projects
                dataLists.getTasks().add(new Task(rs.getString(1).trim(),
                        rs.getString(2).trim(),
                        rs.getString(3).trim().replace("-", ""),
                        rs.getBoolean(4),
                        rs.getString(5).trim()));
            } catch (NullPointerException e) {                                          // Add unassigned tasks to array
                dataLists.getTasks().add(new Task(rs.getString(1).trim(),
                        rs.getString(2).trim(),
                        rs.getString(3).trim().replace("-", ""),
                        rs.getBoolean(4)));
            }
    }

    // Append projects from database to result set
    private void createProjects(DataLists dataLists, ResultSet rs) throws SQLException {
        while (rs.next())                                                               // Add projects to array
            dataLists.getProjects().add(new Project(rs.getString(1).trim(),
                    rs.getString(2).trim(),
                    rs.getString(3).trim().replace("-", ""),
                    rs.getBoolean(4)));
    }

    // Assign task to the project
    public void addTaskToProject(String taskId, String projectId) {
        try
        {
            Connection conn = (getMySQLConnector().startConnection());                      // Establish connection
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(getQueryBuilder().addTaskToProject(taskId, projectId));      // Execute add task to project query
            getMySQLConnector().closeConnection(conn);                                      // Close connection
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ADD TASK TO PROJECT - CANNOT EXECUTE =(");                  // Inform if unable to add task to project
        }
    }

    // Set task assignation to project to null (unassigned task)
    public void setTaskAssignationToNull(String taskId) {
        try
        {
            Connection conn = (getMySQLConnector().startConnection());                      // Establish connection
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(getQueryBuilder().setTaskAssignationToNull(taskId));         // Execute remove assignation
            getMySQLConnector().closeConnection(conn);                                      // Close connection
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("REMOVE PROJECT ASSIGNATION - CANNOT EXECUTE =(");           // Inform if unable to remove
        }
    }

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