package PF04_IndividualProject.IP_01_MySQL_JDBC_OnlineVersion.Model;

import PF04_IndividualProject.IP_01_MySQL_JDBC_OnlineVersion.Interface.MySQLController;

import java.util.ArrayList;
import java.util.Random;

public class Register {
    private ArrayList<Task> tasks;
    private ArrayList<String> tasksIds;
    private ArrayList<Project> projects;
    private ArrayList<String> projectsIds;
    private MySQLController mySQLController;

    public Register() {
        this.setTasks(new ArrayList<>());
        this.setTasksIds(new ArrayList<>());                            // List of existing Ids speeds up search
        this.setProjects(new ArrayList<>());
        this.setProjectsIds(new ArrayList<>());                         // List of existing Ids speeds up search
        this.setMySQLController(new MySQLController());                 // Accessor to update database
    }

    public ArrayList<Task> getTasks() { return tasks; }
    public ArrayList<String> getTasksIds() {return tasksIds; }
    public ArrayList<Project> getProjects() { return projects; }
    public ArrayList<String> getProjectsIds() {return projectsIds; }
    public MySQLController getMySQLController() { return mySQLController; }

    public void setTasks(ArrayList<Task> tasks) { this.tasks = tasks; }
    public void setTasksIds(ArrayList<String> tasksIds) { this.tasksIds = tasksIds; }
    public void setProjects(ArrayList<Project> projects) { this.projects = projects; }
    public void setProjectsIds(ArrayList<String> projectsIds) { this.projectsIds = projectsIds; }
    public void setMySQLController(MySQLController mySQLController) { this.mySQLController = mySQLController; }

    /** =================    =================    Register    =================   ================= */

    // Creating unique Id for new task or project
    private String randomId(ArrayList<String> listOfIds) {
        Random random = new Random();
        String tempId = String.format("%03d", random.nextInt(1000));        // Create new Id
        if (listOfIds.size() != 0)
            while (listOfIds.contains(tempId))                                     // Check if it is unique
                tempId = String.format("%03d", random.nextInt(1000));       // Create next one if not unique
        return tempId;
    }

    // Add task to project
    public void addTaskToProject(String taskId, String projectId) {
        findTask(taskId).setAssignedToProject(projectId);                       // Set project assignation in task in register
        getMySQLController().addTaskToProject(taskId, projectId);               // Set project assignation in task in database
        findProject(projectId).getAssignedTasks().add(taskId);                  // List task in project as assigned
    }

    // Remove single task assignation to project
    public void removeTaskFromProject(String taskId) {
        if (findTask(taskId).getAssignedToProject() != "") {                    // If task is assigned
            // Remove it from the list in project
            findProject(findTask(taskId).getAssignedToProject()).getAssignedTasks().remove(taskId);
            findTask(taskId).setAssignedToProject("");                          // Remove project assignation in task in register
            getMySQLController().setTaskAssignationToNull(taskId);              // Remove project assignation in task in database
        }
    }

    // Remove all tasks assigned to the project
    public void removeAllTasksFromProject(String projectId) {
        ArrayList<String> assignedTasks = findProject(projectId).getAssignedTasks();
        while (assignedTasks.size() > 0) {                                      // While there are tasks assigned
            findTask(assignedTasks.get(0)).setAssignedToProject("");            // Remove project assignation in  first task
            getMySQLController().setTaskAssignationToNull(assignedTasks.get(0));// Remove it also in database
            // Remove first task from the list in project
            findProject(projectId).getAssignedTasks().remove(assignedTasks.get(0));
        }
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

    /** =================    =================    Register for tasks    =================   ================= */

    // Adding new task to the list
    public void addTask(Task task) {
        task.setId("task" + randomId(getTasksIds()));                               // Create unique Id
        getTasks().add(task);                                                       // Add task to the register
        getTasksIds().add(task.getId());                                            // Add task Id to the list
                                                                                    // Add new task to database
        getMySQLController().addNewTask(task.getId(), task.getTitle(), task.getDueDate());
    }

    // Mark task as finished
    public void markTaskAsDone(String id) {
        findTask(id).setDone(true);                                               // Mark task as finished in register
        getMySQLController().markTaskAsDone(id);                                  // Mark task as finished in register
    }

    // Find task in register
    public Task findTask(String id) {
        for (Task task: getTasks())
            if (task.getId().equals(id))
                return task;                                                    // Return task
        return null;                                                            // Return null if task was not found
    }

    // Remove task from register
    public void removeTask(String taskId) {
        if (!findTask(taskId).getAssignedToProject().equals(""))                // If task is assigned to any project
            // Remove task from the list in project
            findProject(findTask(taskId).getAssignedToProject()).getAssignedTasks().remove(taskId);
        getTasks().remove(findTask(taskId));                                    // Remove task from register
        getMySQLController().removeTask(taskId);                                // Remove task from database
        getTasksIds().remove(taskId);                                           // Remove task Id form list
    }

    // Set status of chosen task
    public void setTaskStatus(String chosenTask, int chosenStatus) {
        if (chosenStatus == 0) {
            findTask(chosenTask).setDone(false);                                // Set task as unfinished in register
            getMySQLController().markTaskAsNotDone(chosenTask);                 // Set task as unfinished in database
        } else if (chosenStatus == 1) {
            findTask(chosenTask).setDone(true);                                 // Set task as finished in register
            getMySQLController().markProjectAsDone(chosenTask);                 // Set task as finished in database
        }
    }

    // Set due date of chosen task
    public void setTaskDueDate(String chosenTask, String chosenDueDate) {
        findTask(chosenTask).setDueDate(chosenDueDate);                         // Set task due date in register
        getMySQLController().setTaskDueDate(chosenTask, chosenDueDate);         // Set task due date in database
    }

    // Set title of chosen task
    public void setTaskTitle(String chosenTask, String chosenTitle) {
        findTask(chosenTask).setTitle(chosenTitle);                             // Set task title in register
        getMySQLController().setTaskTitle(chosenTask, chosenTitle);             // Set task title in database
    }

    /** =================    =================    Register for projects    =================   ================= */

    // Adding new project to the list
    public void addProject(Project project) {
        project.setId("proj" + randomId(getProjectsIds()));                         // Create unique Id
        getProjects().add(project);                                                 // Add project to the register
        getProjectsIds().add(project.getId());                                      // Add project Id to the list
                                                                                    // Add new project to database
        getMySQLController().addNewProject(project.getId(), project.getTitle(), project.getDueDate());
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
        findProject(id).getAssignedTasks().forEach(taskId -> {
            markTaskAsDone(taskId);                                             // Mark task as finished
        });
        findProject(id).setDone(true);                                          // Mark project as finished in register
        getMySQLController().markProjectAsDone(id);                             // Mark project as finished in database
    }

    // Find project in register
    public Project findProject(String id) {
        for (Project project: getProjects())
            if (project.getId().equals(id))
                return project;                                                 // Return project
        return null;                                                            // Return null if project was not found
    }

    // Remove project from register together with all dependent tasks
    public void removeProjectAlways(String projectId) {
        for (String taskId: findProject(projectId).getAssignedTasks()) {        // For all dependent tasks
            getTasks().remove(findTask(taskId));                                // Remove task from register
            getMySQLController().removeTask(taskId);                            // Remove task from database
            getTasksIds().remove(taskId);                                       // Remove task Id form list
        }
        getProjects().remove(findProject(projectId));                           // Remove project from register
        getMySQLController().removeProject(projectId);                          // Remove project from database
        getProjectsIds().remove(projectId);                                     // Remove project Id form list
    }

    // Remove project from register if it does not have dependent tasks
    public void removeProjectDependent(String projectId) {
        if (findProject(projectId).getAssignedTasks().size() == 0) {            // If there are no dependent tasks
            getProjects().remove(findProject(projectId));                       // Remove project from register
            getMySQLController().removeProject(projectId);                          // Remove project from database
            getProjectsIds().remove(projectId);                                 // Remove project Id form list
        } else
            System.out.println("Remove or delete all dependent tasks first");   // Ask to remove tasks first
    }

    // Set status of chosen project
    public void setProjectStatus(String chosenProject, int chosenStatus) {
        if (chosenStatus == 0) {
            findProject(chosenProject).setDone(false);                         // Set project as unfinished in register
            getMySQLController().markProjectAsNotDone(chosenProject);          // Set project as unfinished in database
        } else if (chosenStatus == 1)
            markProjectAsDoneAlways(chosenProject);                             // Set as finished together with dependent tasks
    }

    // Set due date of chosen project
    public void setProjectDueDate(String chosenProject, String chosenDueDate) {
        findProject(chosenProject).setDueDate(chosenDueDate);                   // Set project due date in register
        getMySQLController().setProjectDueDate(chosenProject, chosenDueDate);   // Set project due date in database
    }

    // Set title of chosen project
    public void setProjectTitle(String chosenProject, String chosenTitle) {
        findProject(chosenProject).setTitle(chosenTitle);                       // Set project title in register
        getMySQLController().setProjectTitle(chosenProject, chosenTitle);       // Set project title in database
    }
}
