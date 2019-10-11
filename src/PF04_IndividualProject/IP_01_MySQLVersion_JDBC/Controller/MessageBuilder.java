package PF04_IndividualProject.IP_01_MySQLVersion_JDBC.Controller;

import PF04_IndividualProject.IP_04_SplitControllerVersion.Model.Project;
import PF04_IndividualProject.IP_04_SplitControllerVersion.Model.Register;
import PF04_IndividualProject.IP_04_SplitControllerVersion.Model.Task;

public class MessageBuilder {

    /** =================    =================    Main messages    =================   ================= */

    public String chooseMain(Register register) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("You have ").append(amountOfTasksToDo(register) + amountOfTasksDone(register)).append(" task");
        if ((amountOfTasksToDo(register) + amountOfTasksDone(register)) != 1)
            builtMessage.append("s");
        builtMessage.append(" and ").append(amountOfProjectsToDo(register) + amountOfProjectsDone(register)).append(" project");
        if ((amountOfProjectsToDo(register) + amountOfProjectsDone(register)) != 1)
            builtMessage.append("s")
                    .append("\n\nChoose an option")
                    .append("\n\n(1) Print all tasks and projects")
                    .append("\n(2) Work with tasks")
                    .append("\n(3) Work with projects")
                    .append("\n(4) Save and quit");
        return String.valueOf(builtMessage);
    }

    public String saveData() { return  "Your data was saved to file"; }

    public String chooseTask() { return "Choose a task from a list"; }

    public String chooseStatus() {
        return "Choose status from below" + "\n\n(1) Finished" + "\n(2) Unfinished";
    }

    public String chooseProject() { return "Choose project from a list"; }

    public String addedTaskToProject(String chosenTask, String chosenProject) {
        return "Task " + chosenTask + " was added to project " + chosenProject;
    }

    public String taskAlreadyInProject(String chosenTask, String chosenProject) {
        return "Task " + chosenTask + " was already added to project " + chosenProject;
    }

    public String noProjects() { return "There are no projects stored"; }

    public String chooseDueDate() { return "Enter new due date (yyyyMMdd)"; }

    public String chooseTitle() { return "Enter new title"; }

    public String noTasks() { return "There are no tasks stored"; }

    public String enterDueDate() { return "Enter due date (yyyyMMdd)"; }

    public String chooseFiltering() {
        String builtMessage = "Print" +
                "\n\n(1) Assigned" +
                "\n(2) Not assigned" +
                "\n(3) Finished" +
                "\n(4) Unfinished";
        return builtMessage;
    }

    public String noTasksNoProjects() { return "There are no tasks and no projects stored"; }

    public String listForMain(Register register) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("Projects and tasks\n");
        for (Project project: register.getProjects()) {             // Add projects
            builtMessage.append("\n").append(project.getId());
            if (project.getAssignedTasks().size() != 0)  {
                if (project.getAssignedTasks().size() == 1)
                    builtMessage.append(" with ").append(project.getAssignedTasks().size()).append(" task");
                else
                    builtMessage.append(" with ").append(project.getAssignedTasks().size()).append(" tasks");
            }
            builtMessage.append(" - named \"").append(project.getTitle()).append("\", with due date ").append(project.getDueDate());
            if (project.ifDone())
                builtMessage.append(" - finished");
            else
                builtMessage.append(" - unfinished");

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
        for (Task task: register.getTasks()) {
            if (task.getAssignedToProject().equals("")) {
                builtMessage.append("\n").append(task.getId());
                if (task.getAssignedToProject() != "")
                    builtMessage.append(" assigned to ").append(task.getAssignedToProject());
                builtMessage.append(" - named \"").append(task.getTitle()).append("\", with due date ").append(task.getDueDate());
                if (task.ifDone())
                    builtMessage.append(" - finished");
                else
                    builtMessage.append(" - unfinished");
            }
        }
        return String.valueOf(builtMessage);
    }

    int amountOfTasksDone(Register register) { return (int) register.getTasks().stream().filter(Task::ifDone).count(); }

    int amountOfTasksToDo(Register register) { return (int) register.getTasks().stream().filter(task -> !task.ifDone()).count(); }

    int amountOfProjectsDone(Register register) { return (int) register.getProjects().stream().filter(Project::ifDone).count(); }

    int amountOfProjectsToDo(Register register) { return (int) register.getProjects().stream().filter(project -> !project.ifDone()).count(); }
}
