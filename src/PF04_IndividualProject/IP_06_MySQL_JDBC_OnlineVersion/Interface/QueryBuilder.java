package PF04_IndividualProject.IP_06_MySQL_JDBC_OnlineVersion.Interface;

public class QueryBuilder {

    /** =================    =================    SQL queries    =================   ================= */

    // SQL queries to read tasks data from database
    public String readTasksSqlString() {
        return "SELECT id, title, due_date, status, project_id FROM tasks WHERE deletion_date IS NULL;";
    }

    // SQL queries to read projects data from database
    public String readProjectsSqlString() {
        return "SELECT id, title, due_date, status FROM projects WHERE deletion_date IS NULL;";
    }

    /** =================    =================    SQL queries for tasks    =================   ================= */

    // SQL query to add new task to database
    public String addNewTask(String id, String title, String dueDate) {
        StringBuilder sqlString = new StringBuilder();
        sqlString.append("INSERT INTO tasks ")
                .append("(id, title, due_date) ")
                .append("VALUES (")
                .append("'").append(id).append("', ")
                .append("'").append(title).append("', ")
                .append("'").append(getDate(dueDate)).append("');");                // Convert date before adding
        return String.valueOf(sqlString);
    }

    // SQL query to mark task as finished
    public String markTaskAsDone(String taskId) {
        return "UPDATE tasks SET status = true WHERE id = '" + taskId + "';";
    }

    // SQL query to mark task as unfinished
    public String markTaskAsNotDone(String taskId) {
        return "UPDATE tasks SET status = false WHERE id = '" + taskId + "';";
    }

    // SQL query to remove task
    public String removeTask(String taskId) {
        return "DELETE FROM tasks WHERE id = '" + taskId + "';";
    }

    // SQL query to set task due date
    public String setTaskDueDate(String taskId, String dueDate) {
        return "UPDATE tasks SET due_date = '" + getDate(dueDate) + "' WHERE id = '" + taskId + "';";
    }

    // SQL query to set task title
    public String setTaskTitle(String taskId, String title) {
        return "UPDATE tasks SET title = '" + title + "' WHERE id = '" + taskId + "';";
    }

    // SQL query to set log dates for task
    public String setTaskLogDate(String taskId, String fieldName) {
        return "UPDATE projects SET " + fieldName + "  = CURRENT_TIMESTAMP WHERE id = '" + taskId + "';";
    }

    /** =================    =================    SQL queries for projects    =================   ================= */

    // SQL query to add new project to database
    public String addNewProject(String id, String title, String dueDate) {
        StringBuilder sqlString = new StringBuilder();
        sqlString.append("INSERT INTO projects ")
                .append("(id, title, due_date) ")
                .append("VALUES (")
                .append("'").append(id).append("', ")
                .append("'").append(title).append("', ")
                .append("'").append(getDate(dueDate)).append("');");                // Convert date before adding
        return String.valueOf(sqlString);
    }

    // SQL query to mark project as finished
    public String markProjectAsDone(String projectId) {
        return "UPDATE projects SET status = true WHERE id = '" + projectId + "';";
    }

    // SQL query to mark project as unfinished
    public String markProjectAsNotDone(String projectId) {
        return "UPDATE projects SET status = false WHERE id = '" + projectId + "';";
    }

    // SQL query to add task to project
    public String addTaskToProject(String taskId, String projectId) {
        return "UPDATE tasks SET project_id = '" + projectId +
                "' WHERE id = '" + taskId + "';";
    }

    // SQL query to remove assignation
    public String setTaskAssignationToNull(String taskId) {
        return "UPDATE tasks SET project_id = NULL WHERE id = '" + taskId + "';";
    }

    // SQL query to remove project
    public String removeProject(String projectId) {
        return "DELETE FROM projects WHERE id = '" + projectId + "';";
    }

    // SQL query to set project due date
    public String setProjectDueDate(String projectId, String dueDate) {
        return "UPDATE projects SET due_date = '" + getDate(dueDate) + "' WHERE id = '" + projectId + "';";
    }

    // SQL query to set project title
    public String setProjectTitle(String projectId, String title) {
        return "UPDATE projects SET title = '" + title + "' WHERE id = '" + projectId + "';";
    }

    // SQL query to set log dates for project
    public String setProjectLogDate(String projectId, String fieldName) {
        return "UPDATE projects SET " + fieldName + "  = CURRENT_TIMESTAMP WHERE id = '" + projectId + "';";
    }

    /** =================    =================    Conversion    =================   ================= */

    // Date format conversion (adding "-")
    private Appendable getDate(String dueDate) {
        StringBuilder date = new StringBuilder();
        date.append(dueDate, 0, 4).append("-")
                .append(dueDate, 4, 6).append("-")
                .append(dueDate, 6, 8);
        return date;
    }
}
