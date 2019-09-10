package PF02.Exs.Ex04;

public class Course {
    private String courseId;
    private String name;
    private Teacher responsible;

    public Course() {}

    public Course(String courseId, String name, Teacher responsible) {
        this.courseId = courseId;
        this.name = name;
        this.responsible = responsible;
    }

    public String getCourseId() { return courseId; }

    public void setCourseId(String courseId) { this.courseId = courseId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Teacher getResponsible() { return responsible; }

    public void setResponsible(Teacher responsible) { this.responsible = responsible; }
}
