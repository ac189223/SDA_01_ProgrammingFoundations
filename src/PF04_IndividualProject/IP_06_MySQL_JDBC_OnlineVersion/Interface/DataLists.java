package PF04_IndividualProject.IP_06_MySQL_JDBC_OnlineVersion.Interface;

import PF04_IndividualProject.IP_06_MySQL_JDBC_OnlineVersion.Model.Project;
import PF04_IndividualProject.IP_06_MySQL_JDBC_OnlineVersion.Model.Task;

import java.util.ArrayList;

/**
 * Represents a dataLists used as a format of data fetched from MySQL database
 *
 * @author andrzejcalka
 * @author =-_-=
 */
public final class DataLists {
    private final ArrayList<Task> tasks;
    private final ArrayList<Project> projects;

    /**
     * Constructor of a ready to work with dataList containing empty ArrayLists
     */
    public DataLists() {
        this.tasks = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    /**
     * Getters for this class
     */
    public ArrayList<Task> getTasks() { return tasks; }
    public ArrayList<Project> getProjects() { return projects; }
}
