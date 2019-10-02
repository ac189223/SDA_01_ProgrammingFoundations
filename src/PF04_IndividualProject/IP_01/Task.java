package PF04_IndividualProject.IP_01;

public class Task {
    private String id;
    private String title;
    private String dueDate;
    private boolean done;
    private Project assignedToProject;

    public Task(String title, String dueDate) {
        this.setTitle(title);
        this.setDueDate(dueDate);
        this.setDone(false);
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDueDate() { return dueDate; }
    public boolean ifDone() { return done; }
    public Project getAssignedToProject() { return assignedToProject; }

    public void setId(String id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }
    public void setDone(boolean done) { this.done = done; }
    public void setAssignedToProject(Project assignedToProject) { this.assignedToProject = assignedToProject; }


}
