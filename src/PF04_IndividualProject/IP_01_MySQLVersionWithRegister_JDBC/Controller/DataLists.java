package PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Controller;

import PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Model.Project;
import PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Model.Task;

import java.util.ArrayList;

final class DataLists {
    private final ArrayList<Task> tasks;
    private final ArrayList<Project> projects;

    public DataLists(ArrayList<Task> tasks, ArrayList<Project> projects) {
        this.tasks = tasks;
        this.projects = projects;
    }

    public ArrayList<Task> getTasks() { return tasks; }
    public ArrayList<Project> getProjects() { return projects; }
}
