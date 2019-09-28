package PF03.BlueJ._01_LabClasses;

import java.util.*;

public class LabClass {
    private String instructor;
    private String room;
    private String timeAndDay;
    private ArrayList<Student> students;
    private int capacity;
    
    public LabClass(int maxNumberOfStudents) {
        instructor = "unknown";
        room = "unknown";
        timeAndDay = "unknown";
        students = new ArrayList<Student>();
        capacity = maxNumberOfStudents;
    }

    public ArrayList<Student> getStudents() { return students; }

    public void enrollStudent(Student newStudent) {
        if (students.size() == capacity)
            System.out.println("The class is full, you cannot enrol.");
        else
            students.add(newStudent);
    }
    
    public int numberOfStudents() {
        return students.size();
    }
    public void setRoom(String roomNumber) {
        room = roomNumber;
    }
    public void setTime(String timeAndDayString) {
        timeAndDay = timeAndDayString;
    }
    public void setInstructor(String instructorName) {
        instructor = instructorName;
    }
    
    public void printList() {
        System.out.println("Lab class " + timeAndDay);
        System.out.println("Instructor: " + instructor + "   Room: " + room);
        System.out.println("Class list:");
        students.forEach(Student::print);
//        students.forEach(student -> student.print());
//        for (Student student: students) student.print();
        System.out.println("Number of students: " + numberOfStudents());
    }
}
