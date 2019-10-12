package PF04_IndividualProject.MySQLConnector;

public class MySQLConnector_ModelClass_Test {
    public static void main(String[] args) {
        MySQLConnector_ModelClass connector = new MySQLConnector_ModelClass();
        connector.readData_Select("SELECT * FROM tasks");
        connector.appendData_InsertUpdateDelete("INSERT INTO tasks (id, title, due_date, status_id, project_id) " +
                "VALUES ('task320', 'testing', '2019-11-21', 2, NULL)");
        connector.updateData_InsertUpdateDelete("UPDATE tasks SET status_id = status_id - 1 " +
                "WHERE (project_id IS NULL AND status_id <> 1);");
        connector.deleteData_InsertUpdateDelete("DELETE FROM tasks " +
                " WHERE id = 'task320'");
    }
}
