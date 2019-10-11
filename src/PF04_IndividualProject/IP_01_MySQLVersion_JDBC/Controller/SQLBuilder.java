package PF04_IndividualProject.IP_01_MySQLVersion_JDBC.Controller;

public class SQLBuilder {

    /** =================    =================    SQL queries    =================   ================= */

    public String readTasksSqlString() {
        return "SELECT id, title, due_date, status, project_id FROM tasks WHERE removal_date IS NULL;";
    }

    public String readProjectsSqlString() {
        return "SELECT id, title, due_date, status FROM projects WHERE removal_date IS NULL;";
    }

    public String saveData() { return  "Your data was saved to file"; }
}
