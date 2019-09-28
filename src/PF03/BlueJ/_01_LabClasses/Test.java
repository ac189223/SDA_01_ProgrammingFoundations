package PF03.BlueJ._01_LabClasses;

import java.util.Random;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        LabClass labClass = new LabClass(5);

        labClass.printList();
        labClass.setInstructor("Petra");
        labClass.setRoom("1205");
        labClass.setTime("20191002 11:00");
        labClass.enrollStudent(new Student("Johan O", "s23"));
        labClass.enrollStudent(new Student("Trevor Z", "s62"));
        labClass.enrollStudent(new Student("Mikka E", "s09"));
        labClass.enrollStudent(new Student("Betts Sue G", "s37"));
        labClass.enrollStudent(new Student("Karl M", "s87"));
        labClass.enrollStudent(new Student("Cindy T", "s11"));
        Random random = new Random();
        IntStream.range(0, 10)
                .forEach(i -> labClass.getStudents()
                .forEach(student -> student.addCredits(random.nextInt(5) * 10)));
        labClass.printList();
    }
}
