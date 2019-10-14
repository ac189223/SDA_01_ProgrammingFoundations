package PF04_IndividualProject.IP_01_MySQL_JDBC_OnlineVersion.Model;

import java.util.ArrayList;
import java.util.Random;

public class Register {
    private ArrayList<Task> tasks;
    private ArrayList<String> tasksIds;
    private ArrayList<Project> projects;
    private ArrayList<String> projectsIds;

    public Register() {
        this.setTasks(new ArrayList<>());
        this.setTasksIds(new ArrayList<>());                            // List of existing Ids speeds up search
        this.setProjects(new ArrayList<>());
        this.setProjectsIds(new ArrayList<>());                         // List of existing Ids speeds up search
    }

    public ArrayList<Task> getTasks() { return tasks; }
    public ArrayList<String> getTasksIds() {return tasksIds; }
    public ArrayList<Project> getProjects() { return projects; }
    public ArrayList<String> getProjectsIds() {return projectsIds; }

    public void setTasks(ArrayList<Task> tasks) { this.tasks = tasks; }
    public void setTasksIds(ArrayList<String> tasksIds) { this.tasksIds = tasksIds; }
    public void setProjects(ArrayList<Project> projects) { this.projects = projects; }
    public void setProjectsIds(ArrayList<String> projectsIds) { this.projectsIds = projectsIds; }

    /** =================    =================    Register of projects and tasks    =================   ================= */

    // Adding new task to the list
    public void addTask(Task task) {
        task.setId("task" + randomId(getTasksIds()));
        getTasks().add(task);
        getTasksIds().add(task.getId());
    }

    // Adding new project to the list
    public void addProject(Project project) {
        project.setId("proj" + randomId(getProjectsIds()));
        getProjects().add(project);
        getProjectsIds().add(project.getId());
    }

    // Creating unique Id for new task or project
    private String randomId(ArrayList<String> listOfIds) {
        Random random = new Random();
        String tempId = String.format("%03d", random.nextInt(1000));
        if (listOfIds.size() != 0)
            while (listOfIds.contains(tempId))
                tempId = String.format("%03d", random.nextInt(1000));
        return tempId;
    }

    // Mark task as finished
    public void markTaskAsDone(String id) { findTask(id).setDone(true); }

    // Find task in register
    public Task findTask(String id) {
        for (Task task: getTasks())
            if (task.getId().equals(id))
                return task;                                                    // Return task
        return null;                                                            // Return null if task was not found
    }

    // Mark project as finished if dependent tasks are finished
    public void markProjectAsDoneDependent(String id) {
        boolean check = true;
        for (String taskId: findProject(id).getAssignedTasks()) {               // Go through tasks
            if (!findTask(taskId).ifDone())
                check = false;                                                  // if any dependent task is unfinished
        }
        if (check)
            findProject(id).setDone(true);                                      // Mark project as finished
        else
            System.out.println("Mark all dependent tasks as finished first");   // Ask to correct tasks statuses
    }

    // Mark project as finished together with all dependent tasks
    public void markProjectAsDoneAlways(String id) {
        findProject(id).getAssignedTasks().forEach(this::markTaskAsDone);       // Mark task as finished
        findProject(id).setDone(true);                                          // Mark project as finished
    }

    // Find project in register
    public Project findProject(String id) {
        for (Project project: getProjects())
            if (project.getId().equals(id))
                return project;                                                 // Return project
        return null;                                                            // Return null if project was not found
    }

    // Add task to project
    public void addTaskToProject(String taskId, String projectId) {
        findTask(taskId).setAssignedToProject(projectId);                       // Set project assignation in task
        findProject(projectId).getAssignedTasks().add(taskId);                  // List task in project as assigned
    }

    // Remove single task assignation to project
    public void removeTaskFromProject(String taskId) {
        if (findTask(taskId).getAssignedToProject() != "") {                    // If task is assigned
                                                                                // Remove it from the list in project
            findProject(findTask(taskId).getAssignedToProject()).getAssignedTasks().remove(taskId);
            findTask(taskId).setAssignedToProject("");                          // Remove project assignation in task
        }
    }

    // Remove all tasks assigned to the project
    public void removeAllTasksFromProject(String projectId) {
        ArrayList<String> assignedTasks = findProject(projectId).getAssignedTasks();
        while (assignedTasks.size() > 0) {                                      // While there are tasks assigned
            findTask(assignedTasks.get(0)).setAssignedToProject("");            // Remove project assignation in  first task
                                                                                // Remove first task from the list in project
            findProject(projectId).getAssignedTasks().remove(assignedTasks.get(0));
        }
    }

    // Remove task from register
    public void removeTask(String taskId) {
        if (!findTask(taskId).getAssignedToProject().equals(""))                // If task is assigned to any project
                                                                                // Remove task from the list in project
            findProject(findTask(taskId).getAssignedToProject()).getAssignedTasks().remove(taskId);
        getTasks().remove(findTask(taskId));                                    // Remove task from register
        getTasksIds().remove(taskId);                                           // Remove task Id form list
    }

    // Remove project from register together with all dependent tasks
    public void removeProjectAlways(String projectId) {
        for (String taskId: findProject(projectId).getAssignedTasks()) {        // For all dependent tasks
            getTasksIds().remove(taskId);                                       // Remove task from register
            getTasks().remove(findTask(taskId));                                // Remove task Id form list
        }
        getProjectsIds().remove(projectId);                                     // Remove project from register
        getProjects().remove(findProject(projectId));                           // Remove project Id form list
    }

    // Remove project from register if it does not have dependent tasks
    public void removeProjectDependent(String projectId) {
        if (findProject(projectId).getAssignedTasks().size() == 0) {            // If there are no dependent tasks
            getProjectsIds().remove(projectId);                                 // Remove project from register
            getProjects().remove(findProject(projectId));                       // Remove project Id form list
        } else
            System.out.println("Remove or delete all dependent tasks first");   // Ask to remove tasks first
    }

    // Set status of chosen task
    public void setTaskStatus(String chosenTask, int chosenStatus) {
        if (chosenStatus == 0)
            findTask(chosenTask).setDone(false);                                // Set as unfinished
        else if (chosenStatus == 1)
            findTask(chosenTask).setDone(true);                                 // Set as finished
    }

    // Set status of chosen project
    public void setProjectStatus(String chosenProject, int chosenStatus) {
        if (chosenStatus == 0)
            findProject(chosenProject).setDone(false);                         // Set as unfinished
        else if (chosenStatus == 1)
            markProjectAsDoneAlways(chosenProject);                             // Set as finished together with dependent tasks
    }

    // Printout to the console to check if data was imported correctly
    public void printStatus() {
        StringBuilder statusMessage = new StringBuilder();
        for (Project project: getProjects()) {                                  // Add project to the printout
            if (project.ifDone())
                statusMessage.append("(+)");
            else
                statusMessage.append("(-)");
            statusMessage.append("  ").append(project.getId())
                    .append(": ").append(project.getTitle())
                    .append(" with due date ").append(project.getDueDate()).append("\n");
            for (String taskId : project.getAssignedTasks()) {
                statusMessage.append(taskAppendix(findTask(taskId)));          // Add assigned to project tasks to the printout
            }
        }
        for (Task task: getTasks()) {
            if (task.getAssignedToProject() == "") {
                statusMessage.append(taskAppendix(task));                      // Add unassigned tasks to the printout
            }
        }
        System.out.print(statusMessage);                                       // Printout to the console
        System.out.println("==============  =-_-=  ================");
    }

    // Prepare appendix for task to the printout after data import
    private Appendable taskAppendix(Task taskToAppend) {
        StringBuilder taskAppendix = new StringBuilder();
        if (taskToAppend.ifDone())
            taskAppendix.append("(+)");
        else
            taskAppendix.append("(-)");
        taskAppendix.append("        ").append(taskToAppend.getId())
                .append(": ").append(taskToAppend.getTitle())
                .append(" with due date ").append(taskToAppend.getDueDate()).append("\n");
        return taskAppendix;
    }
}
