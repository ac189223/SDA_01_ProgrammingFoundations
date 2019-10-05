package PF04_IndividualProject.IP_03_ControllerBackup;

public class Task {
    private String id;
    private String title;
    private String dueDate;
    private boolean done;
    private String assignedToProject;

    public Task(String title, String dueDate) {
        this.setTitle(title);
        this.setDueDate(dueDate);
        this.setDone(false);
        this.setAssignedToProject("");
    }

    public Task(String id, String title, String dueDate, boolean done) {
        this.setId(id);
        this.setTitle(title);
        this.setDueDate(dueDate);
        this.setDone(done);
        this.setAssignedToProject("");
    }

    public Task(String id, String title, String dueDate, boolean done, String assignedToProject) {
        this.setId(id);
        this.setTitle(title);
        this.setDueDate(dueDate);
        this.setDone(done);
        this.setAssignedToProject(assignedToProject);
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getDueDate() { return dueDate; }
    public boolean ifDone() { return done; }
    public String getAssignedToProject() { return assignedToProject; }

    public void setId(String id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }
    public void setDone(boolean done) { this.done = done; }
    public void setAssignedToProject(String assignedToProject) { this.assignedToProject = assignedToProject; }
}
