package PF04_IndividualProject.IP_01;

import java.util.List;

public class MessageBuilder {
    private StringBuilder builtMessage = new StringBuilder();

    public String chooseMain(Register register) {
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
        builtMessage.append("Your data was saved to file");
        return String.valueOf(builtMessage);
    }

    public String chooseTask() {
        builtMessage.append("Choose a task from a list");
        return String.valueOf(builtMessage);
    }

    public String chooseActivity(Register register, String chosenTask) {
        builtMessage.append("Choose activity for ").append(chosenTask).append(" (")
                .append(register.findTask(chosenTask).getTitle()).append(")")
                .append("\n\n(1) Update (title, due date, project assignment, status)")
                .append("\n(2) Mark as finished")
                .append("\n(3) Remove")
                .append("\n(4) Back to main menu");
        return String.valueOf(builtMessage);
    }

    public String removeTask() {
        builtMessage.append("Task was removed from the register");
        return String.valueOf(builtMessage);
    }

    public String markTaskAsDone() {
        builtMessage.append("Task was marked as finished");
        return String.valueOf(builtMessage);
    }

    public String chooseField(Register register, String chosenTask) {
        builtMessage.append("Choose field to update for ").append(chosenTask)
                .append("\n\n(1) Title (").append(register.findTask(chosenTask).getTitle()).append(")")
                .append("\n(2) Due date (").append(register.findTask(chosenTask).getDueDate()).append(")")
                .append("\n(3) Project assignment");
        if (!register.findTask(chosenTask).getAssignedToProject().equals(""))
            builtMessage.append(" (").append(register.findTask(chosenTask).getAssignedToProject()).append(")");
        builtMessage.append("\n(4) Status");
        if (register.findTask(chosenTask).ifDone() == true)
            builtMessage.append(" (finished)");
        else
            builtMessage.append(" (unfinished)");
        builtMessage.append("\n(5) Back to main menu");
        return String.valueOf(builtMessage);
    }

    public String chooseStatus() {
        builtMessage.append("Choose status from below").append("\n(1) Finished").append("\n(2) Unfinished");
        return String.valueOf(builtMessage);
    }

    public String fixStatus() {
        builtMessage.append("Task status was fixed");
        return String.valueOf(builtMessage);
    }

    public String chooseProject() {
        builtMessage.append("Choose project from a list");
        return String.valueOf(builtMessage);
    }

    public String reassignedTask() {
        builtMessage.append("Task was reassigned");
        return String.valueOf(builtMessage);
    }

    public String noProjects() {
        builtMessage.append("There are no projects stored");
        return String.valueOf(builtMessage);
    }

    public String chooseDueDate() {
        builtMessage.append("Enter new due date (yyyyMMdd)");
        return String.valueOf(builtMessage);
    }

    public String changedDueDate() {
        builtMessage.append("Tasks due date was changed");
        return String.valueOf(builtMessage);
    }

    public String chooseTitle() {
        builtMessage.append("Enter new title");
        return String.valueOf(builtMessage);
    }

    public String changedTitle() {
        builtMessage.append("Tasks title was changed");
        return String.valueOf(builtMessage);
    }

    public String noTasks() {
        builtMessage.append("There are no tasks stored");
        return String.valueOf(builtMessage);
    }

    public String enterTitle() {
        builtMessage.append("Enter task title");
        return String.valueOf(builtMessage);
    }

    public String enterDueDate() {
        builtMessage.append("Enter due date (yyyyMMdd)");
        return String.valueOf(builtMessage);
    }

    public String addedTask(Register register) {
        builtMessage.append("New tasks was added as ").append(register.getTasks().get(register.getTasks().size() - 1).getId());
        return String.valueOf(builtMessage);
    }

    public String chooseSorting() {
        builtMessage.append("Print tasks sorted by")
                .append("\n(1) Title")
                .append("\n(2) Id")
                .append("\n(3) Due date")
                .append("\n(4) Project");
        return String.valueOf(builtMessage);
    }

    public String chooseFiltering() {
        builtMessage.append("Print")
                .append("\n(1) Assigned")
                .append("\n(2) Not assigned")
                .append("\n(3) Finished")
                .append("\n(4) Unfinished");
        return String.valueOf(builtMessage);
    }

    public String list(Register register, List<Task> sortedList) {
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
        builtMessage.append("There are no tasks and no projects stored");
        return String.valueOf(builtMessage);
    }

    public String listForMain(Register register) {
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
