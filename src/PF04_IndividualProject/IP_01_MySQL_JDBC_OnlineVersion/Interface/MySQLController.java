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

    // Append tasks to result set
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

    // Append projects to result set
    private void createProjects(DataLists dataLists, ResultSet rs) throws SQLException {
        while (rs.next())                                                               // Add projects to array
            dataLists.getProjects().add(new Project(rs.getString(1).trim(),
                    rs.getString(2).trim(),
                    rs.getString(3).trim().replace("-", ""),
                    rs.getBoolean(4)));
    }

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

    public void markTaskAsDone(String id) {
        try
        {
            Connection conn = (getMySQLConnector().startConnection());                      // Establish connection
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(getQueryBuilder().markTaskAsDone(id));                       // Execute mark task done query
            getMySQLConnector().closeConnection(conn);                                      // Close connection
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("MARK TASK AS DONE - CANNOT EXECUTE =(");                    // Inform if unable to mark as done
        }
    }

    public void markProjectAsDone(String id) {
        try
        {
            Connection conn = (getMySQLConnector().startConnection());                      // Establish connection
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(getQueryBuilder().markProjectAsDone(id));                       // Execute mark project done query
            getMySQLConnector().closeConnection(conn);                                      // Close connection
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("MARK PROJECT AS DONE - CANNOT EXECUTE =(");                 // Inform if unable to mark as done
        }
    }

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
}