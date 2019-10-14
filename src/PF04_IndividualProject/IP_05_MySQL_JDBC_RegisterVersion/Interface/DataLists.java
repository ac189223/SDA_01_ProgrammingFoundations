package PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Interface;

import PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Model.Project;
import PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Model.Task;

import java.util.ArrayList;

public final class DataLists {
    /** =================    =================    Format of data    =================   ================= */
    /** =================    =================     to be fetched    =================   ================= */
    /** =================    =================     from database    =================   ================= */

    private final ArrayList<Task> tasks;
    private final ArrayList<Project> projects;

    public DataLists(ArrayList<Task> tasks, ArrayList<Project> projects) {
        this.tasks = tasks;
        this.projects = projects;
    }

    public ArrayList<Task> getTasks() { return tasks; }
    public ArrayList<Project> getProjects() { return projects; }
}
