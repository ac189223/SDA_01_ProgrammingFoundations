package PF03.BlueJ._01_LabClasses;

public class Student{
    private String name;
    private String id;
    private int credits;

    public Student(String fullName, String studentID) {
        name = fullName;
        id = studentID;
        credits = 0;
    }

    public String getName() {
        return name;
    }
    public void changeName(String replacementName) {
        name = replacementName;
    }
    public String getStudentID() {
        return id;
    }
    public void addCredits(int additionalPoints) {
        credits += additionalPoints;
    }
    public int getCredits() {
        return credits;
    }
    public String getLoginName() {
        return name.substring(0,4) + id.substring(0,3);
    }
    public void print() {
        System.out.println(name + ", student ID: " + id +
                ", login: " + getLoginName() +
                ", credits: " + credits);
    }
}
