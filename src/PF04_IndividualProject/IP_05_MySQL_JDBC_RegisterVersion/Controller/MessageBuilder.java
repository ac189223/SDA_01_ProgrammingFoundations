package PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Controller;

import PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Model.Project;
import PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Model.Register;
import PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Model.Task;

public class MessageBuilder {

    /** =================    =================    Messages    =================   ================= */

    // Message for main menu
    public String chooseMain(Register register) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("You have ").
                append(amountOfTasks(register)).append(" task");                // Amount of tasks
        if ((amountOfTasks(register)) != 1)
            builtMessage.append("s");
        builtMessage.append(" and ").
                append(amountOfProjects(register)).append(" project");          // Amount of projects
        if ((amountOfProjects(register)) != 1)
            builtMessage.append("s")
                    .append("\n\nChoose an option")                             // Main choice
                    .append("\n\n(1) Print all tasks and projects")
                    .append("\n(2) Work with tasks")
                    .append("\n(3) Work with projects")
                    .append("\n(4) Save and quit");
        return String.valueOf(builtMessage);
    }

    // Choices
    public String chooseTask() { return "Choose a task from a list"; }

    public String chooseProject() { return "Choose project from a list"; }

    public String chooseStatus() { return "Choose status from below \n\n(1) Finished \n(2) Unfinished"; }

    public String chooseDueDate() { return "Enter new due date (yyyyMMdd)"; }

    public String chooseTitle() { return "Enter new title"; }

    public String enterDueDate() { return "Enter due date (yyyyMMdd)"; }

    public String chooseFiltering() { return "Print \n\n(1) Assigned \n(2) Not assigned \n(3) Finished \n(4) Unfinished"; }

    // Confirmations
    public String saveDataConfirmation() { return "Your data was saved"; }

    public String addedTaskToProjectConfirmation(String chosenTask, String chosenProject) {
        return "Task " + chosenTask + " was added to project " + chosenProject;
    }

    // Information
    public String taskAlreadyInProjectInfo(String chosenTask, String chosenProject) {
        return "Task " + chosenTask + " was already added to project " + chosenProject;
    }

    public String noProjectsInfo() { return "There are no projects stored"; }

    public String noTasksInfo() { return "There are no tasks stored"; }


    public String noTasksNoProjects() { return "There are no tasks and no projects stored"; }

    // Print out from main menu
    public String listForMain(Register register) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("Projects and assigned tasks\n");
        for (Project project: register.getProjects()) {                                         // For every project
            builtMessage.append("\n")
                    .append(String.valueOf(addProjectToListForMain(project)).substring(5));     // Add project
            for (String taskId : project.getAssignedTasks())                                    // For all dependent tasks
                builtMessage.append(addTaskToListForMain(register.findTask(taskId)));           // Add tasks
        }
        builtMessage.append("\n\nNot assigned tasks\n");
        for (Task task: register.getTasks()) {
            if (task.getAssignedToProject().equals("")) {                                       // Filter unassigned tasks
                builtMessage.append("\n")
                        .append(String.valueOf(addTaskToListForMain(task)).substring(5));       // Add them also
            }
        }
        return String.valueOf(builtMessage);
    }

    // Add projects to list printed from main menu
    public Appendable addProjectToListForMain(Project project) {
        StringBuilder appendix = new StringBuilder();
        appendix.append("\n    ").append(project.getId());
        if (project.getAssignedTasks().size() != 0)  {
            appendix.append(" with ").append(project.getAssignedTasks().size()).append(" task");
            if (project.getAssignedTasks().size() != 1)
                appendix.append("s");
        }
        appendix.append(" - named \"").append(project.getTitle())
                .append("\", with due date ").append(project.getDueDate());
        if (project.ifDone())
            appendix.append(" - finished");
        else
            appendix.append(" - unfinished");
        return appendix;
    }

    // Add tasks to list printed from main menu
    public Appendable addTaskToListForMain(Task task) {
        StringBuilder appendix = new StringBuilder();
        appendix.append("\n    ").append(task.getId());
        if (!task.getAssignedToProject().equals(""))
            appendix.append(" assigned to ").append(task.getAssignedToProject());
        appendix.append(" - named \"").append(task.getTitle())
                .append("\", with due date ").append(task.getDueDate());
        if (task.ifDone())
            appendix.append(" - finished");
        else
            appendix.append(" - unfinished");
        return appendix;
    }

    // Counters
    int amountOfTasks(Register register) { return amountOfTasksDone(register) + amountOfTasksToDo(register); }

    int amountOfTasksDone(Register register) { return (int) register.getTasks().stream().filter(Task::ifDone).count(); }

    int amountOfTasksToDo(Register register) { return (int) register.getTasks().stream().filter(task -> !task.ifDone()).count(); }

    int amountOfProjects(Register register) { return amountOfProjectsDone(register) + amountOfProjectsToDo(register); }

    int amountOfProjectsDone(Register register) { return (int) register.getProjects().stream().filter(Project::ifDone).count(); }

    int amountOfProjectsToDo(Register register) { return (int) register.getProjects().stream().filter(project -> !project.ifDone()).count(); }
}
