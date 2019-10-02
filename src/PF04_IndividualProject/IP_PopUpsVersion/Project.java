package PF04_IndividualProject.IP_PopUpsVersion;

import java.util.ArrayList;


public class Project extends Element{
    private ArrayList<Task> assignedTasks;

    static ProjectRep projectRep;

    public Project(String title, String dueDate) {
        super(title, dueDate);
        this.setId("proj" + checkedRandomId(projectRep.getProjects().stream().map(project -> project.getId().substring(project.getId().length()-3)).toArray()));
    }

        public Project(String title, String dueDate, ArrayList<Task> assignedTasks) {
        super(title, dueDate);
        this.setId("proj" + checkedRandomId(projectRep.getProjects().stream().map(project -> project.getId().substring(project.getId().length()-3)).toArray()));
        this.setAssignedTasks(assignedTasks);
    }

    public ArrayList<Task> getAssignedTasks() { return assignedTasks; }
    public void setAssignedTasks(ArrayList<Task> assignedTasks) { this.assignedTasks = assignedTasks; }
}