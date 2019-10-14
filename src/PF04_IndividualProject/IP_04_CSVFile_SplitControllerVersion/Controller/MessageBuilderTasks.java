package PF04_IndividualProject.IP_04_CSVFile_SplitControllerVersion.Controller;

import PF04_IndividualProject.IP_04_CSVFile_SplitControllerVersion.Model.Register;
import PF04_IndividualProject.IP_04_CSVFile_SplitControllerVersion.Model.Task;

import java.util.List;

public class MessageBuilderTasks extends MessageBuilder{

    /** =================    =================    Tasks messages    =================   ================= */

    public String chooseOptionForTask(Register register) {
        StringBuilder builtMessage = new StringBuilder();
        builtMessage.append("You have ").append(amountOfTasksToDo(register)).append(" task");
        if (amountOfTasksToDo(register) != 1)
            builtMessage.append("s");
        builtMessage.append(" to do and ").append(amountOfTasksDone(register)).append(" task");
        if (amountOfTasksDone(register) != 1)
            builtMessage.append("s");
        builtMessage.append(" finished").append("\n\nChoose an option")
                .append("\n\n(1) Filter tasks (by assignment or status)")
                .append("\n(2) Show tasks (sorted by title, Id, due date, project)")
                .append("\n(3) Add new task")
                .append("\n(4) Edit task (update, mark as finished, remove)")
                .append("\n(5) Back to main menu");
        return String.valueOf(builtMessage);
    }

    public String chooseActivityForTask(Register register, String chosenTask) {
        String builtMessage = "Choose activity for " + chosenTask + " (" +
                register.findTask(chosenTask).getTitle() + ")" +
                "\n\n(1) Update (title, due date, project assignment, status)" +
                "\n(2) Mark as finished" +
                "\n(3) Remove" +
                "\n(4) Back to main menu";
        return builtMessage;
    }

    public String removeTask() { return "Task was removed from the register"; }

    public String markTaskAsDone() { return "Task was marked as finished"; }

    public String chooseTaskField(Register register, String chosenTask) {
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

    public String fixTaskStatus() { return  "Task status was fixed"; }

    public String reassignedTask() { return "Task was reassigned"; }

    public String changedTaskDueDate() { return  "Task due date was changed"; }

    public String changedTaskTitle() { return  "Task title was changed"; }

    public String enterTaskTitle() { return  "Enter task title"; }

    public String addedTask(Register register) {
        return "New task was added as " + register.getTasks().get(register.getTasks().size() - 1).getId();
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
}
