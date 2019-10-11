package PF04_IndividualProject.IP_01_MySQLVersion_JDBC.Controller;

public class MySQLConnector_ModelClass_Test {
    public static void main(String[] args) {
        MySQLConnector_ModelClass connector = new MySQLConnector_ModelClass();
        connector.readData("SELECT * FROM tasks");
        connector.appendData("INSERT INTO tasks (id, title, due_date, status_id, project_id) " +
                "VALUES ('task320', 'testing', '2019-11-21', 2, NULL)");
        connector.updateData("UPDATE tasks SET status_id = status_id - 1 " +
                "WHERE (project_id IS NULL AND status_id <> 1);");
        connector.deleteData("DELETE FROM tasks " +
                " WHERE id = 'task320'");
    }
}
