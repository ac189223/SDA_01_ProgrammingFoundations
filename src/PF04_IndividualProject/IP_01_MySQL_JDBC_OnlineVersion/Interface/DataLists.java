package PF04_IndividualProject.IP_01_MySQL_JDBC_OnlineVersion.Interface;

import PF04_IndividualProject.IP_01_MySQL_JDBC_OnlineVersion.Model.Project;
import PF04_IndividualProject.IP_01_MySQL_JDBC_OnlineVersion.Model.Task;

import java.util.ArrayList;

public final class DataLists {
    /** =================    =================    Format of data    =================   ================= */
    /** =================    =================     to be fetched    =================   ================= */
    /** =================    =================     from database    =================   ================= */

    private final ArrayList<Task> tasks;
    private final ArrayList<Project> projects;

    public DataLists() {
        this.tasks = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() { return tasks; }
    public ArrayList<Project> getProjects() { return projects; }
}
