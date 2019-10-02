package PF04_IndividualProject.IP_PopUpsVersion;

import java.util.ArrayList;

public class ProjectRep {
    private ArrayList<Project> projects;

    public ProjectRep() { this.setProjects(new ArrayList<>()); }
    public ProjectRep(ArrayList<Project> projects) { this.setProjects(projects); }

    public ArrayList<Project> getProjects() { return projects; }

    public void setProjects(ArrayList<Project> projects) { this.projects = projects; }
}
