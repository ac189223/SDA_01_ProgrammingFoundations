package PF02.Exs.Ex04;

public class Teacher {
    private String ssn;
    private String name;
    private Student tutorOf;
    private Course responsibleFor;

    public Teacher() {}

    public Teacher(String ssn, String name, Student tutorOf, Course responsibleFor) {
        this.ssn = ssn;
        this.name = name;
        this.tutorOf = tutorOf;
        this.responsibleFor = responsibleFor;
    }

    public String getSsn() { return ssn; }

    public void setSsn(String ssn) { this.ssn = ssn; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Student getTutorOf() { return tutorOf; }

    public void setTutorOf(Student tutorOf) { this.tutorOf = tutorOf; }

    public Course getResponsibleFor() { return responsibleFor; }

    public void setResponsibleFor(Course responsibleFor) { this.responsibleFor = responsibleFor; }
}
