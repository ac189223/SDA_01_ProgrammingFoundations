package PF04_IndividualProject.IP_01;

import java.util.ArrayList;

public class Project {
    private String id;
    private String title;
    private String dueDate;
    private boolean done;
    private ArrayList<Task> assignedTasks;

    public Project(String title, String dueDate) {
        this.setTitle(title);
        this.setDueDate(dueDate);
        this.setDone(false);
        this.setAssignedTasks(new ArrayList<>());
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDueDate() { return dueDate; }
    public boolean ifDone() { return done; }
    public ArrayList<Task> getAssignedTasks() { return assignedTasks; }

    public void setId(String id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }
    public void setDone(boolean done) { this.done = done; }
    public void setAssignedTasks(ArrayList<Task> assignedTasks) { this.assignedTasks = assignedTasks; }

}
