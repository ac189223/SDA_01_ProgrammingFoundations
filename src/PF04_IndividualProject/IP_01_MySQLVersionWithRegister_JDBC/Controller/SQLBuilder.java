package PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Controller;

import PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Model.Project;
import PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Model.Task;

public class SQLBuilder {

    /** =================    =================    SQL queries    =================   ================= */

    public String readTasksSqlString() {
        return "SELECT id, title, due_date, status, project_id FROM tasks;";
    }

    public String readProjectsSqlString() {
        return "SELECT id, title, due_date, status FROM projects;";
    }

    public String deleteTables() {
        return "DROP TABLE IF EXISTS tasks, projects;";
    }

    public String createTableProjects() {
        return "CREATE TABLE IF NOT EXISTS projects (" +
                "  id VARCHAR(7) NOT NULL," +
                "  title VARCHAR(50) NOT NULL," +
                "  due_date DATE NOT NULL," +
                "  status BOOLEAN NOT NULL DEFAULT FALSE," +
                "  PRIMARY KEY (id)," +
                "  UNIQUE INDEX id (id ASC)," +
                "  INDEX title (title ASC)," +
                "  INDEX due_date (due_date ASC))" +
                "DEFAULT CHARACTER SET = utf8;";
    }

    public String createTableTasks() {
        return "CREATE TABLE IF NOT EXISTS tasks (" +
                "  id VARCHAR(7) NOT NULL," +
                "  title VARCHAR(50) NOT NULL," +
                "  due_date DATE NOT NULL," +
                "  status BOOLEAN NOT NULL DEFAULT FALSE," +
                "  project_id VARCHAR(7) NULL DEFAULT NULL," +
                "  PRIMARY KEY (id)," +
                "  UNIQUE INDEX id (id ASC)," +
                "  INDEX title (title ASC)," +
                "  INDEX due_date (due_date ASC)," +
                "  INDEX project_id (project_id ASC)," +
                "  CONSTRAINT fk_tasks_projects" +
                "    FOREIGN KEY (project_id)" +
                "    REFERENCES projects (id)" +
                "    ON DELETE SET NULL" +
                "    ON UPDATE NO ACTION)" +
                "DEFAULT CHARACTER SET = utf8;";
    }

    public String populateTableProjects(Project project) {
        StringBuilder sqlString = new StringBuilder();
        sqlString.append("INSERT INTO projects ")
                .append("(id, title, due_date, status) ")
                .append("VALUES (")
                .append("'").append(project.getId()).append("', ")
                .append("'").append(project.getTitle()).append("', ")
                .append("'").append(getDate(project.getDueDate())).append("', ")
                .append(ifDone(project.ifDone())).append(");");
        return String.valueOf(sqlString);
    }

    public String populateTableTasks(Task task) {
        StringBuilder sqlString = new StringBuilder();
        sqlString.append("INSERT INTO tasks ")
                .append("(id, title, due_date, status, project_id) ")
                .append("VALUES (")
                .append("'").append(task.getId()).append("', ")
                .append("'").append(task.getTitle()).append("', ")
                .append("'").append(getDate(task.getDueDate())).append("', ")
                .append(ifDone(task.ifDone())).append(", ");
        if (task.getAssignedToProject() == "")
            sqlString.append("NULL);");
        else
            sqlString.append("'").append(task.getAssignedToProject()).append("');");
        return String.valueOf(sqlString);
    }

    private Appendable getDate(String dueDate) {
        StringBuilder date = new StringBuilder();
        date.append(dueDate, 0, 4).append("-")
                .append(dueDate, 4, 6).append("-")
                .append(dueDate, 6, 8);
        return date;
    }

    private StringBuilder ifDone(boolean ifDone) {
        StringBuilder done = new StringBuilder();
        if (ifDone)
            done.append("true");
        else
            done.append("false");
        return done;
    }

}
