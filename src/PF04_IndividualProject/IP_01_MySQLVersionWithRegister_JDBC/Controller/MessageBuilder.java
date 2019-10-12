package PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Controller;

import PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Model.Project;
import PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Model.Register;
import PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Model.Task;

public class MessageBuilder {

    /** =================    =================    Messages    =================   ================= */

    // Message for main menu
    public String chooseMain(Register register) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("You have ").append(amountOfTasks(register)).append(" task");
        if ((amountOfTasks(register)) != 1)
            builtMessage.append("s");
        builtMessage.append(" and ").append(amountOfProjects(register)).append(" project");
        if ((amountOfProjects(register)) != 1)
            builtMessage.append("s")
                    .append("\n\nChoose an option")
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

    //Informations
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
        for (Project project: register.getProjects()) {                    // Loop through projects
            builtMessage.append(addProjectToList(builtMessage, project));

            for (String taskId : project.getAssignedTasks()) {
                builtMessage.append("\n    ").append(taskId);
                if (!register.findTask(taskId).getAssignedToProject().equals(""))
                    builtMessage.append(" assigned to ").append(register.findTask(taskId).getAssignedToProject());
                builtMessage.append(" - named \"").append(register.findTask(taskId).getTitle())
                        .append("\", with due date ").append(register.findTask(taskId).getDueDate());
                if (register.findTask(taskId).ifDone())
                    builtMessage.append(" - finished");
                else
                    builtMessage.append(" - unfinished");
            }
        }
        builtMessage.append("\n\nNot assigned tasks\n");
        for (Task task: register.getTasks()) {
            if (task.getAssignedToProject().equals("")) {
                builtMessage.append("\n").append(task.getId())
                        .append(" - named \"").append(task.getTitle())
                        .append("\", with due date ").append(task.getDueDate());
                if (task.ifDone())
                    builtMessage.append(" - finished");
                else
                    builtMessage.append(" - unfinished");
            }
        }
        return String.valueOf(builtMessage);
    }

    // Add projects to list
    private Appendable addProjectToList(StringBuilder builtMessage, Project project) {
        builtMessage.append("\n").append(project.getId());
        if (project.getAssignedTasks().size() != 0)  {
            builtMessage.append(" with ").append(project.getAssignedTasks().size()).append(" task");
            if (project.getAssignedTasks().size() != 1)
                builtMessage.append("s");
        }
        builtMessage.append(" - named \"").append(project.getTitle())
                .append("\", with due date ").append(project.getDueDate());
        if (project.ifDone())
            builtMessage.append(" - finished");
        else
            builtMessage.append(" - unfinished");
        return builtMessage;
    }

    // Counters
    int amountOfTasks(Register register) { return amountOfTasksDone(register) + amountOfTasksToDo(register); }
    int amountOfTasksDone(Register register) { return (int) register.getTasks().stream().filter(Task::ifDone).count(); }
    int amountOfTasksToDo(Register register) { return (int) register.getTasks().stream().filter(task -> !task.ifDone()).count(); }

    int amountOfProjects(Register register) { return amountOfProjectsDone(register) + amountOfProjectsToDo(register); }
    int amountOfProjectsDone(Register register) { return (int) register.getProjects().stream().filter(Project::ifDone).count(); }
    int amountOfProjectsToDo(Register register) { return (int) register.getProjects().stream().filter(project -> !project.ifDone()).count(); }
}
