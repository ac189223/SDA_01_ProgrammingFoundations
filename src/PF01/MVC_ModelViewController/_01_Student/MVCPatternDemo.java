package PF01.MVC_ModelViewController._01_Student;

public class MVCPatternDemo {
    public static void main(String[] args) {

        // Fetch student record based on his roll no from the database
        Student model = retrieveStudentFromDatabase();

        // Create a view - write student details on console
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        controller.updateView();

        controller.setStudentName("John");
        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}
