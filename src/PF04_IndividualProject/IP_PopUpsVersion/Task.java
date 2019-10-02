package PF04_IndividualProject.IP_PopUpsVersion;

public class Task extends Element{
    private Project assignedToProject;

    static TaskRep taskRep = new TaskRep();

    public Task(String title, String dueDate) {
        super(title, dueDate);
        if (taskRep.getTasks().size() == 0)
            this.setId("task" + randomId());
        this.setId("task" + checkedRandomId(taskRep.getTasks().stream().map(task -> task.getId().substring(task.getId().length()-3)).toArray()));
    }

    public Task(String title, String dueDate, Project assignedToProject) {
        super(title, dueDate);
        this.setId("task" + checkedRandomId(taskRep.getTasks().stream().map(task -> task.getId().substring(task.getId().length()-3)).toArray()));
        this.setAssignedToProject(assignedToProject);
    }

    public Project getAssignedToProject() { return assignedToProject; }
    public void setAssignedToProject(Project assignedToProject) { this.assignedToProject = assignedToProject; }
}
