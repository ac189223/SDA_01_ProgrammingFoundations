package PF02.Exs.Ex04;

public class Student {
    private String ssn;
    private String name;
    private Teacher tutor;

    public Student() {}

    public Student(String ssn, String name, Teacher tutor) {
        this.ssn = ssn;
        this.name = name;
        this.tutor = tutor;
    }

    public String getSsn() { return ssn; }

    public void setSsn(String ssn) { this.ssn = ssn; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Teacher getTutor() { return tutor; }

    public void setTutor(Teacher tutor) { this.tutor = tutor; }
}
