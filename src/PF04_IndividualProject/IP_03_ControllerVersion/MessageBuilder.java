package PF04_IndividualProject.IP_03_ControllerVersion;

import java.util.List;

public class MessageBuilder {

    public String buildMessage(Register register, String popUpIdentifier) {
        return buildMessage(register ,popUpIdentifier, "", null);
    }

    public String buildMessage(Register register, String popUpIdentifier, List<Task> sortedList) {
        return buildMessage(register ,popUpIdentifier, "", sortedList);
    }

    public String buildMessage(Register register, String popUpIdentifier, String chosenTask, List<Task> sortedList) {
        StringBuilder builtMessage = new StringBuilder();

        if (popUpIdentifier.equals("chooseOption")) {
            builtMessage.append("You have ").append(amountToDo(register)).append(" task");
            if (!amountToDo(register).equals("1"))
                builtMessage.append("s");
            builtMessage.append(" to do and ").append(amountDone(register)).append(" task");
            if (!amountDone(register).equals("1"))
                builtMessage.append("s");
            builtMessage.append(" finished")
                    .append("\n\nChoose an option")
                    .append("\n\n(1) Filter tasks (by assignment or status)")
                    .append("\n(2) Show tasks (sorted by project, due date, Id or title)")
                    .append("\n(3) Add new task")
                    .append("\n(4) Edit task (update, mark as finished, remove)")
                    .append("\n(5) Save and quit");
        } else if (popUpIdentifier.equals("saveData")) {
            builtMessage.append("Your data was saved to file");
        } else if (popUpIdentifier.equals("chooseTask")) {
            builtMessage.append("Choose a task from a list");
        } else if (popUpIdentifier.equals("chooseActivity")) {
            builtMessage.append("Choose activity for ").append(chosenTask).append(" (")
                    .append(register.findTask(chosenTask).getTitle()).append(")")
                    .append("\n\n(1) Update (title, due date, project assignment, status)")
                    .append("\n(2) Mark as finished")
                    .append("\n(3) Remove")
                    .append("\n(4) Back to main menu");
        } else if (popUpIdentifier.equals("removeTask")) {
            builtMessage.append("Task was removed from the register");
        } else if (popUpIdentifier.equals("markTaskAsDone")) {
            builtMessage.append("Task was marked as finished");
        } else if (popUpIdentifier.equals("chooseField")) {
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
        } else if (popUpIdentifier.equals("chooseStatus")) {
            builtMessage.append("Choose status from below")
                    .append("\n(1) Finished")
                    .append("\n(2) Unfinished");
        } else if (popUpIdentifier.equals("fixStatus")) {
            builtMessage.append("Task status was fixed");
        } else if (popUpIdentifier.equals("chooseProject")) {
            builtMessage.append("Choose project from a list");
        } else if (popUpIdentifier.equals("reassignedTask")) {
            builtMessage.append("Task was reassigned");
        } else if (popUpIdentifier.equals("noProjects")) {
            builtMessage.append("There are no projects stored");
        } else if (popUpIdentifier.equals("chooseDueDate")) {
            builtMessage.append("Enter new due date (yyyyMMdd)");
        } else if (popUpIdentifier.equals("changedDueDate")) {
            builtMessage.append("Tasks due date was changed");
        } else if (popUpIdentifier.equals("chooseTitle")) {
            builtMessage.append("Enter new title");
        } else if (popUpIdentifier.equals("changedTitle")) {
            builtMessage.append("Tasks title was changed");
        } else if (popUpIdentifier.equals("noTasks")) {
            builtMessage.append("There are no tasks stored");
        } else if (popUpIdentifier.equals("enterTitle")) {
            builtMessage.append("Enter task title");
        } else if (popUpIdentifier.equals("enterDueDate")) {
            builtMessage.append("Enter due date (yyyyMMdd)");
        } else if (popUpIdentifier.equals("addedTask")) {
            builtMessage.append("New tasks was added as ")
                    .append(register.getTasks().get(register.getTasks().size() - 1).getId());
        } else if (popUpIdentifier.equals("chooseSorting")) {
            builtMessage.append("Print tasks sorted by")
                    .append("\n(1) Title")
                    .append("\n(2) Id")
                    .append("\n(3) Due date")
                    .append("\n(4) Project");
        } else if (popUpIdentifier.equals("chooseFiltering")) {
            builtMessage.append("Print")
                    .append("\n(1) Assigned")
                    .append("\n(2) Not assigned")
                    .append("\n(3) Finished")
                    .append("\n(4) Unfinished");
        } else if (popUpIdentifier.equals("list")) {
            builtMessage.append("Tasks");
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
        }
        return String.valueOf(builtMessage);
    }

    private String amountDone(Register register) {
        return String.valueOf(register.getTasks().stream().filter(task -> task.ifDone()).count());
    }

    private String amountToDo(Register register) {
        return String.valueOf(register.getTasks().stream().filter(task -> !task.ifDone()).count());
    }
}
