package PF04_IndividualProject.IP_03_CSVFile_ControllerVersion;

import java.util.ArrayList;

final class DataLists {
    private final ArrayList<Task> tasks;
    private final ArrayList<String> tasksIds;
    private final ArrayList<Project> projects;
    private final ArrayList<String> projectsIds;

    public DataLists(ArrayList<Task> tasks, ArrayList<String> tasksIds, ArrayList<Project> projects, ArrayList<String> projectsIds) {
        this.tasks = tasks;
        this.tasksIds = tasksIds;
        this.projects = projects;
        this.projectsIds = projectsIds;
    }

    public ArrayList<Task> getTasks() { return tasks; }
    public ArrayList<String> getTasksIds() { return tasksIds; }
    public ArrayList<Project> getProjects() { return projects; }
    public ArrayList<String> getProjectsIds() { return projectsIds; }
}
