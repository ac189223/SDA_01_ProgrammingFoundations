package PF04_IndividualProject.IP_01;

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

    public String chooseOption(Register register) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("You have ").append(amountOfTasksToDo(register)).append(" task");
        if (amountOfTasksToDo(register) != 1)
            builtMessage.append("s");
        builtMessage.append(" to do and ").append(amountOfTasksDone(register)).append(" task");
        if (amountOfTasksDone(register) != 1)
            builtMessage.append("s");
        builtMessage.append(" finished")
                .append("\n\nChoose an option")
                .append("\n\n(1) Filter tasks (by assignment or status)")
                .append("\n(2) Show tasks (sorted by project, due date, Id or title)")
                .append("\n(3) Add new task")
                .append("\n(4) Edit task (update, mark as finished, remove)")
                .append("\n(5) Save and quit");
        return String.valueOf(builtMessage);
    }

    public String saveData() {
        return  "Your data was saved to file";
    }

    public String chooseTask() {
        return "Choose a task from a list";
    }

    public String chooseActivity(Register register, String chosenTask) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("Choose activity for ").append(chosenTask).append(" (")
                .append(register.findTask(chosenTask).getTitle()).append(")")
                .append("\n\n(1) Update (title, due date, project assignment, status)")
                .append("\n(2) Mark as finished")
                .append("\n(3) Remove")
                .append("\n(4) Back to main menu");
        return String.valueOf(builtMessage);
    }

    public String removeTask() {
        return "Task was removed from the register";
    }

    public String markTaskAsDone() {
        return "Task was marked as finished";
    }

    public String chooseField(Register register, String chosenTask) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("Choose field to update for ").append(chosenTask)
                .append("\n\n(1) Title (").append(register.findTask(chosenTask).getTitle()).append(")")
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

    public String fixStatus() {
        return "Task status was fixed";
    }

    public String chooseProject() {
        return "Choose project from a list";
    }

    public String reassignedTask() {
        return "Task was reassigned";
    }

    public String noProjects() {
        return "There are no projects stored";
    }

    public String chooseDueDate() {
        return "Enter new due date (yyyyMMdd)";
    }

    public String changedDueDate() {
        return "Tasks due date was changed";
    }

    public String chooseTitle() {
        return "Enter new title";
    }

    public String changedTitle() {
        return "Tasks title was changed";
    }

    public String noTasks() {
        return "There are no tasks stored";
    }

    public String enterTitle() {
        return "Enter task title";
    }

    public String enterDueDate() {
        return "Enter due date (yyyyMMdd)";
    }

    public String addedTask(Register register) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("New tasks was added as ").
                append(register.getTasks().get(register.getTasks().size() - 1).getId());
        return String.valueOf(builtMessage);
    }

    public String chooseSorting() {
        String builtMessage = "Print tasks sorted by" +
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

    public String list(List<Task> sortedList) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("Tasks\n");
        sortedList.forEach(task -> {        // Add tasks to string
            builtMessage.append("\n").append(task.getId()).append(" - ");
            if (task.getAssignedToProject() != "")
                builtMessage.append(task.getAssignedToProject()).append(" - ");
            builtMessage.append(task.getTitle()).append(" with due date ").append(task.getDueDate());
            if (task.ifDone())
                builtMessage.append(" - finished");
            else
                builtMessage.append(" - unfinished");
        });
        return String.valueOf(builtMessage);
    }

    public String noTasksNoProjects() {
        return "There are no tasks and no projects stored";
    }

    public String listForMain(Register register) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("Projects and tasks\n");
        for (Project project: register.getProjects()) {             // Add projects
            builtMessage.append("\n").append(project.getId()).append(" - ")
                    .append(project.getTitle()).append(" with due date ").append(project.getDueDate());
            if (project.ifDone())
                builtMessage.append(" - finished");
            else
                builtMessage.append(" - unfinished");

            for (String taskId : project.getAssignedTasks()) {
                builtMessage.append("\n    ").append(taskId).append(" - ");
                if (register.findTask(taskId).getAssignedToProject() != "")
                    builtMessage.append(register.findTask(taskId).getAssignedToProject()).append(" - ");
                builtMessage.append(register.findTask(taskId).getTitle())
                        .append(" with due date ").append(register.findTask(taskId).getDueDate());
                if (register.findTask(taskId).ifDone())
                    builtMessage.append(" - finished");
                else
                    builtMessage.append(" - unfinished");
            }
        }
        for (Task task: register.getTasks()) {
            if (task.getAssignedToProject() == "") {
                builtMessage.append("\n").append(task.getId()).append(" - ");
                if (task.getAssignedToProject() != "")
                    builtMessage.append(task.getAssignedToProject()).append(" - ");
                builtMessage.append(task.getTitle()).append(" with due date ").append(task.getDueDate());
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
    }}
