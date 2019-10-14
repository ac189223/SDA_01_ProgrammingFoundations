package PF04_IndividualProject.IP_01_MySQL_JDBC_OnlineVersion.Interface;

public class QueryBuilder {

    /** =================    =================    SQL queries    =================   ================= */

    // SQL queries to read tasks data
    public String readTasksSqlString() {
        return "SELECT id, title, due_date, status, project_id FROM tasks;";
    }

    // SQL queries to read projects data
    public String readProjectsSqlString() {
        return "SELECT id, title, due_date, status FROM projects;";
    }

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

    // Date format conversion (adding "-")
    private Appendable getDate(String dueDate) {
        StringBuilder date = new StringBuilder();
        date.append(dueDate, 0, 4).append("-")
                .append(dueDate, 4, 6).append("-")
                .append(dueDate, 6, 8);
        return date;
    }

    // SQL query to mark task as done
    public String markTaskAsDone(String id) {
        return "UPDATE tasks SET status = true WHERE id = '" + id + "';";
    }

    // SQL query to mark project as done
    public String markProjectAsDone(String id) {
        return "UPDATE projects SET status = true WHERE id = '" + id + "';";
    }

    // SQL query to add task to project
    public String addTaskToProject(String taskId, String projectId) {
        return "UPDATE tasks SET project_id = '" + projectId +
                "' WHERE id = '" + taskId + "';";
    }








    // Conversion of boolean to string
    private StringBuilder ifDone(boolean ifDone) {
        StringBuilder done = new StringBuilder();
        if (ifDone)
            done.append("true");
        else
            done.append("false");
        return done;
    }


}
