package PF04_IndividualProject.IP_01.Controller;

import PF04_IndividualProject.IP_01.Model.Project;
import PF04_IndividualProject.IP_01.Model.Register;
import PF04_IndividualProject.IP_01.Model.Task;

import java.util.List;

public class MessageBuilder {

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

    public String chooseOption(Register register, int mainChosen) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("You have ");
        if (mainChosen == 1) {
            builtMessage.append(amountOfProjectsToDo(register)).append(" project");
            if (amountOfProjectsToDo(register) != 1)
                builtMessage.append("s");
        } else if (mainChosen == 2) {
            builtMessage.append(amountOfTasksToDo(register)).append(" task");
            if (amountOfTasksToDo(register) != 1)
                builtMessage.append("s");
        }
        builtMessage.append(" to do and ");
        if (mainChosen == 1) {
            builtMessage.append(amountOfProjectsDone(register)).append(" project");
            if (amountOfProjectsDone(register) != 1)
                builtMessage.append("s");
        } else if (mainChosen == 2) {
            builtMessage.append(amountOfTasksDone(register)).append(" task");
            if (amountOfTasksDone(register) != 1)
                builtMessage.append("s");
        }
        builtMessage.append(" finished").append("\n\nChoose an option");
        if (mainChosen == 1)
            builtMessage.append("\n\n(1) Filter projects (by assignment or status)")
                    .append("\n(2) Show projects (sorted by title, Id, due date, amount of tasks)")
                    .append("\n(3) Add new project")
                    .append("\n(4) Edit project (update, mark as finished, remove)");
        else if (mainChosen == 2)
            builtMessage.append("\n\n(1) Filter tasks (by assignment or status)")
                    .append("\n(2) Show tasks (sorted by title, Id, due date, project)")
                    .append("\n(3) Add new task")
                    .append("\n(4) Edit task (update, mark as finished, remove)");
        builtMessage.append("\n(5) Back to main menu");
        return String.valueOf(builtMessage);
    }

    public String saveData() { return  "Your data was saved to file"; }

    public String chooseTask() { return "Choose a task from a list"; }

    public String chooseActivityForProject(Register register, String chosenTask) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("Choose activity for ").append(chosenTask).append(" (");
            builtMessage.append(register.findProject(chosenTask).getTitle()).append(")")
                    .append("\n\n(1) Update (title, due date, status)");
        builtMessage.append("\n(2) Mark as finished")
                .append("\n(3) Remove")
                .append("\n(4) Back to main menu");
        return String.valueOf(builtMessage);
    }

    public String chooseActivityForTask(Register register, String chosenTask) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("Choose activity for ").append(chosenTask).append(" (");
            builtMessage.append(register.findTask(chosenTask).getTitle()).append(")")
                    .append("\n\n(1) Update (title, due date, project assignment, status)");
        builtMessage.append("\n(2) Mark as finished")
                .append("\n(3) Remove")
                .append("\n(4) Back to main menu");
        return String.valueOf(builtMessage);
    }

    public String removeProject() { return "Project was removed from the register"; }

    public String removeTask() { return "Task was removed from the register"; }

    public String markProjectAsDone() { return "Project was marked as finished"; }

    public String markTaskAsDone() { return "Task was marked as finished"; }

    public String chooseProjectField(Register register, String chosenTask) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("Choose field to update for ").append(chosenTask);
            builtMessage.append("\n\n(1) Title (").append(register.findProject(chosenTask).getTitle()).append(")")
                    .append("\n(2) Due date (").append(register.findProject(chosenTask).getDueDate()).append(")")
                    .append("\n(3) Assign tasks");
        builtMessage.append("\n(4) Status");
            if (register.findProject(chosenTask).ifDone())
                builtMessage.append(" (finished)");
            else
                builtMessage.append(" (unfinished)");
        builtMessage.append("\n(5) Back to main menu");
        return String.valueOf(builtMessage);
    }

    public String chooseTaskField(Register register, String chosenTask) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("Choose field to update for ").append(chosenTask);
            builtMessage.append("\n\n(1) Title (").append(register.findTask(chosenTask).getTitle()).append(")")
                    .append("\n(2) Due date (").append(register.findTask(chosenTask).getDueDate()).append(")")
                    .append("\n(3) Project assignment");
            if (!register.findTask(chosenTask).getAssignedToProject().equals(""))
                builtMessage.append(" (").append(register.findTask(chosenTask).getAssignedToProject()).append(")");
        builtMessage.append("\n(4) Status");
            if (register.findTask(chosenTask).ifDone())
                builtMessage.append(" (finished)");
            else
                builtMessage.append(" (unfinished)");
        builtMessage.append("\n(5) Back to main menu");
        return String.valueOf(builtMessage);
    }

    public String chooseStatus() {
        String builtMessage = "Choose status from below" +
                "\n\n(1) Finished" +
                "\n(2) Unfinished";
        return builtMessage;
    }

    public String fixProjectStatus() { return  "Project status was fixed"; }

    public String fixTaskStatus() { return  "Task status was fixed"; }

    public String addedTaskToProject(String chosenTask, String chosenProject) {
        return "Task " + chosenTask + " was added to project " + chosenProject;
    }

    public String taskAlreadyInProject(String chosenTask, String chosenProject) {
        return "Task " + chosenTask + " was already added to project " + chosenProject;
    }

    public String ifAddNext() {
        String builtMessage = "Choose an option" +
                "\n\n(1) Add next task" +
                "\n(2) Go to main menu";
        return builtMessage;
    }

    public String chooseProject() { return "Choose project from a list"; }

    public String reassignedTask() { return "Task was reassigned"; }

    public String noProjects() { return "There are no projects stored"; }

    public String chooseDueDate() { return "Enter new due date (yyyyMMdd)"; }

    public String changedProjectDueDate() { return  "Project due date was changed"; }

    public String changedTaskDueDate() { return  "Task due date was changed"; }

    public String chooseTitle() { return "Enter new title"; }

    public String changedProjectTitle() { return  "Project title was changed"; }

    public String changedTaskTitle() { return  "Task title was changed"; }

    public String noTasks() { return "There are no tasks stored"; }

    public String enterProjectTitle() { return  "Enter project title"; }

    public String enterTaskTitle() { return  "Enter task title"; }

    public String enterDueDate() { return "Enter due date (yyyyMMdd)"; }

    public String addedTask(Register register) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("New task was added as ").
                append(register.getTasks().get(register.getTasks().size() - 1).getId());
        return String.valueOf(builtMessage);
    }

    public String addedProject(Register register) {
        StringBuilder builtMessage = new StringBuilder();
            builtMessage.append("New project was added as ").
                    append(register.getProjects().get(register.getProjects().size() - 1).getId());
        return String.valueOf(builtMessage);
    }

    public String chooseProjectsSorting() {
        String builtMessage = "";
        builtMessage = "Print projects sorted by" +
                "\n\n(1) Title" +
                "\n(2) Id" +
                "\n(3) Due date" +
                "\n(4) Amount of tasks";
        return builtMessage;
    }

    public String chooseTasksSorting() {
        String builtMessage = "";
        builtMessage = "Print tasks sorted by" +
                "\n\n(1) Title" +
                "\n(2) Id" +
                "\n(3) Due date" +
                "\n(4) Project";
        return builtMessage;
    }

    public String chooseFiltering() {
        String builtMessage = "Print" +
                "\n\n(1) Assigned" +
                "\n(2) Not assigned" +
                "\n(3) Finished" +
                "\n(4) Unfinished";
        return builtMessage;
    }

    public String listOfProjects(List<Project> sortedProjects) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("Projects\n");
        sortedProjects.forEach(project -> {        // Add tasks to string
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
        });
        return String.valueOf(builtMessage);
    }

    public String listOfTasks(List<Task> sortedTasks) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("Tasks\n");
        sortedTasks.forEach(task -> {        // Add tasks to string
            builtMessage.append("\n").append(task.getId());
            if (!task.getAssignedToProject().equals(""))
                builtMessage.append(" assigned to ").append(task.getAssignedToProject());
            builtMessage.append(" - named \"").append(task.getTitle()).append("\", with due date ").append(task.getDueDate());
            if (task.ifDone())
                builtMessage.append(" - finished");
            else
                builtMessage.append(" - unfinished");
        });
        return String.valueOf(builtMessage);
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

    private int amountOfTasksDone(Register register) {
        return (int) register.getTasks().stream().filter(task -> task.ifDone()).count();
    }

    private int amountOfTasksToDo(Register register) {
        return (int) register.getTasks().stream().filter(task -> !task.ifDone()).count();
    }

    private int amountOfProjectsDone(Register register) {
        return (int) register.getProjects().stream().filter(project -> project.ifDone()).count();
    }

    private int amountOfProjectsToDo(Register register) {
        return (int) register.getProjects().stream().filter(project -> !project.ifDone()).count();
    }

}
