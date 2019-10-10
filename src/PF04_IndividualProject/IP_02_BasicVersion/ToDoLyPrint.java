package PF04_IndividualProject.IP_02_BasicVersion;

import javax.swing.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ToDoLyPrint {
    private static final String FILE_NAME = "src/PF04_IndividualProject/Resources/IPData.csv";
    private static final String TITLE = "ToDoLy    =-_-=";
    private static Register register = new Register();

    public static void main(String[] args) {
        JFrame frame = new JFrame("=-_-=");

        /** Create data and take a look on it */
        register.uploadData(FILE_NAME);
        register.printStatus();

        int optionChosen = -1;               // Main choice what to do
        while (true) {
            Object[] options = {5, 4, 3, 2, 1};
            while (optionChosen < 0 || optionChosen > 4)
                optionChosen = showOptionDialog(frame, buildMessage("chooseOption"), options);

            switch (optionChosen) {
                case 0:     // Save and quit
                    register.saveData(FILE_NAME);
                    showMessage(frame, buildMessage("saveData"));
                    System.exit(0);

                case 1:     // Edit task
                    if (register.getTasks().size() != 0) {
                        String chosenTask;
                        do {
                            Object[] choices = register.getTasksIds().toArray();
                            chosenTask = showInputDialog(frame, buildMessage("chooseTask"), choices);
                        } while (!register.getTasksIds().contains(chosenTask));

                        int chosenActivity = -1;
                        while (chosenActivity < 0 || chosenActivity > 3) {
                            Object[] activities = {4, 3, 2, 1};
                            chosenActivity = showOptionDialog(frame, buildMessage("chooseActivity", chosenTask), activities);
                        }

                        switch (chosenActivity) {
                            case 0:     // Back to main menu
                                break;

                            case 1:     // Remove task
                                register.removeTask(chosenTask);
                                showMessage(frame, buildMessage("removeTask"));
                                break;

                            case 2:     // Mark as done
                                register.markTaskAsDone(chosenTask);
                                showMessage(frame, buildMessage("markTaskAsDone"));
                                break;

                            case 3:     // Edit fields
                                int chosenField = -1;
                                while (chosenField < 0 || chosenField > 4) {
                                    Object[] fields = {5, 4, 3, 2, 1};
                                    chosenField = showOptionDialog(frame, buildMessage("chooseField", chosenTask), fields);

                                    switch (chosenField) {
                                        case 0:     // Back to main menu
                                            break;

                                        case 1:     // Set status
                                            int chosenStatus = -1;
                                            while (chosenStatus < 0 || chosenStatus > 1) {
                                                Object[] statusChoices = {"Done", "Not done"};
                                                chosenStatus = showOptionDialog(frame, buildMessage("chooseStatus"), statusChoices);
                                            }
                                            register.setTaskStatus(chosenTask, chosenStatus);
                                            showMessage(frame, buildMessage("fixStatus"));
                                            break;

                                        case 2:     // Reassign to project
                                            if (register.getProjects().size() != 0) {
                                                String chosenProject;
                                                do {
                                                    do {
                                                        Object[] projectChoices = register.getProjectsIds().toArray();
                                                        chosenProject = showInputDialog(frame,
                                                                buildMessage("chooseProject"), projectChoices);
                                                    } while (chosenProject == null);
                                                } while (!register.getProjectsIds().contains(chosenProject));

                                                register.removeTaskFromProject(chosenTask);
                                                register.addTaskToProject(chosenTask, chosenProject);
                                                showMessage(frame, buildMessage("reassignedTask"));
                                                break;

                                            } else {
                                                showMessage(frame, buildMessage("noProjects"));
                                                break;
                                            }

                                        case 3:     // Change due date
                                            String chosenDueDate = "";
                                            DateValidator dateValidator = new DateValidator();
                                            do {
                                                do {
                                                    do {
                                                        chosenDueDate = inputLine(frame, buildMessage("chooseDueDate"));    // Ask for due date
                                                    } while (chosenDueDate == null);
                                                } while (chosenDueDate.equals(""));
                                            } while (!dateValidator.isThisDateValid(chosenDueDate, "yyyyMMdd"));

                                            register.findTask(chosenTask).setDueDate(chosenDueDate);
                                            showMessage(frame, buildMessage("changedDueDate"));
                                            break;

                                        case 4:
                                            String chosenTitle = "";
                                            do {
                                                do {
                                                    chosenTitle = inputLine(frame, buildMessage("chooseTitle"));     // Ask for title
                                                } while (chosenTitle == null);
                                            } while (chosenTitle.equals(""));

                                            register.findTask(chosenTask).setTitle(chosenTitle);
                                            showMessage(frame, buildMessage("changedTitle"));
                                            break;
                                    }
                                }
                        }
                    } else {
                        showMessage(frame, buildMessage("noTasks"));
                        break;
                    }
                    break;

                case 2:     // Add new task
                    String newTitle = "";
                    do {
                        do {
                            newTitle = inputLine(frame, buildMessage("enterTitle"));        // Ask for title
                        } while (newTitle == null);
                    } while (newTitle.equals(""));

                    String newDueDate = "";
                    DateValidator dateValidator = new DateValidator();
                    do {
                        do {
                            do {
                                newDueDate = inputLine(frame, buildMessage("enterDueDate"));        // Ask for due date
                            } while (newDueDate == null);
                        } while (newDueDate.equals(""));
                    } while (!dateValidator.isThisDateValid(newDueDate, "yyyyMMdd"));

                    register.addTask(new Task(newTitle, newDueDate));
                    showMessage(frame, buildMessage("addedTask"));
                    break;

                case 3:     // Print out sorted
                    if (register.getTasks().size() == 0) {
                        showMessage(frame, buildMessage("noTasks"));

                    } else {
                        int chosenSorting = -1;
                        while (chosenSorting < 0 || chosenSorting > 3) {
                            Object[] sortingChoices = {"project", "due date", "Id", "title"};
                            chosenSorting = showOptionDialog(frame, buildMessage("chooseSorting"), sortingChoices);
                        }

                        List<Task> sortedList = null;
                        switch (chosenSorting) {
                            case 0:
                                sortedList = register.getTasks().stream()        // Sort by project
                                        .filter(task -> !task.getAssignedToProject().equals(""))
                                        .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList())
                                        .stream()
                                        .sorted(Comparator.comparing(Task::getAssignedToProject)).collect(Collectors.toList());
                                break;

                            case 1:
                                sortedList = register.getTasks().stream()        // Sort by due date
                                        .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList())
                                        .stream()
                                        .sorted(Comparator.comparing(Task::getDueDate)).collect(Collectors.toList());
                                break;

                            case 2:
                                sortedList = register.getTasks().stream()        // Sort by Id
                                        .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                                break;

                            case 3:
                                sortedList = register.getTasks().stream()        // Sort by title
                                        .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList())
                                        .stream()
                                        .sorted(Comparator.comparing(Task::getTitle)).collect(Collectors.toList());
                                break;
                        }
                        showMessage(frame, buildMessage("list", sortedList));
                    }
                    break;

                case 4:     // Print out filtered
                    if (register.getTasks().size() == 0) {
                        showMessage(frame, buildMessage("noTasks"));

                    } else {
                        int chosenFiltering = -1;
                        while (chosenFiltering < 0 || chosenFiltering > 3) {
                            Object[] filteringChoices = {"not done", "done", "not assigned", "assigned"};
                            chosenFiltering = showOptionDialog(frame, buildMessage("chooseFiltering"), filteringChoices);
                        }

                        List<Task> filteredList = null;
                        switch (chosenFiltering) {
                            case 0:
                                filteredList = register.getTasks().stream()        // Filter not done
                                        .filter(task -> !task.ifDone())
                                        .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                                break;

                            case 1:
                                filteredList = register.getTasks().stream()        // Filter done
                                        .filter(task -> task.ifDone())
                                        .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                                break;

                            case 2:
                                filteredList = register.getTasks().stream()        // Filter not assigned
                                        .filter(task -> task.getAssignedToProject().equals(""))
                                        .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                                break;

                            case 3:
                                String chosenProject = "";        // Choose project
                                if (register.getProjects().size() != 0) {
                                    do {
                                        do {
                                            Object[] projectChoices = register.getProjectsIds().toArray();
                                            chosenProject = showInputDialog(frame,
                                                    buildMessage("chooseProject"), projectChoices);
                                        } while (chosenProject == null);
                                    } while (!register.getProjectsIds().contains(chosenProject));

                                } else {
                                    showMessage(frame, buildMessage("noProjects"));
                                }

                                String finalChosenProject = chosenProject;
                                filteredList = register.getTasks().stream()        // Filter by project assignment
                                        .filter(task -> task.getAssignedToProject().equals(finalChosenProject))
                                        .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                                break;

                        }
                        showMessage(frame, buildMessage("list", filteredList));
                    }
                    break;
            }
            // Reset to be able to print initial screen
            optionChosen = -1;
        }
    }

    private static int showOptionDialog(JFrame frame, String message, Object[] list) {
        return JOptionPane.showOptionDialog(frame, message, TITLE, JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,null, list, list[0]);
    }

    private static String showInputDialog(JFrame frame, String message, Object[] list) {
        return (String) JOptionPane.showInputDialog(frame, message, TITLE,
                JOptionPane.PLAIN_MESSAGE, null, list, list[0]);
    }

    private static String inputLine(JFrame frame, String message) {
        return JOptionPane.showInputDialog(frame, message, TITLE, JOptionPane.PLAIN_MESSAGE);
    }

    private static void showMessage(JFrame frame, String message) {
        JOptionPane.showMessageDialog(frame, message, TITLE, JOptionPane.PLAIN_MESSAGE);
    }

    private static String buildMessage(String popUpIdentifier) {
        return buildMessage(popUpIdentifier, "", null);
    }

    private static String buildMessage(String popUpIdentifier, String chosenTask) {
        return buildMessage(popUpIdentifier, chosenTask, null);
    }

    private static String buildMessage(String popUpIdentifier, List<Task> sortedList) {
        return buildMessage(popUpIdentifier, "", sortedList);
    }

    private static String buildMessage(String popUpIdentifier, String chosenTask, List<Task> sortedList) {
        StringBuilder builtMessage = new StringBuilder();

        if (popUpIdentifier.equals("chooseOption")) {
            builtMessage.append("You have ").append(amountToDo()).append(" tasks todo and ")
                    .append(amountDone()).append(" tasks done")
                    .append("\n\nChoose an option")
                    .append("\n\n(1) Filter tasks (by assignment or status)")
                    .append("\n(2) Show tasks (sorted by project, due date, Id or title)")
                    .append("\n(3) Add new task")
                    .append("\n(4) Edit task (update, mark as done, remove)")
                    .append("\n(5) Save and quit");
        } else if (popUpIdentifier.equals("saveData")) {
            builtMessage.append("Your data was saved to file");
        } else if (popUpIdentifier.equals("chooseTask")) {
            builtMessage.append("Choose a task from a list");
        } else if (popUpIdentifier.equals("chooseActivity")) {
            builtMessage.append("Choose activity for ").append(chosenTask).append(" (")
                    .append(register.findTask(chosenTask).getTitle()).append(")")
                    .append("\n\n(1) Update (title, due date, project assignment, status)")
                    .append("\n(2) Mark as done")
                    .append("\n(3) Remove")
                    .append("\n(4) Back to main menu");
        } else if (popUpIdentifier.equals("removeTask")) {
            builtMessage.append("Task was removed from the register");
        } else if (popUpIdentifier.equals("markTaskAsDone")) {
            builtMessage.append("Task was marked as done");
        } else if (popUpIdentifier.equals("chooseField")) {
            builtMessage.append("Choose field to update for ").append(chosenTask)
                    .append("\n\n(1) Title (").append(register.findTask(chosenTask).getTitle()).append(")")
                    .append("\n(2) Due date (").append(register.findTask(chosenTask).getDueDate()).append(")")
                    .append("\n(3) Project assignment");
            if (!register.findTask(chosenTask).getAssignedToProject().equals(""))
                builtMessage.append(" (").append(register.findTask(chosenTask).getAssignedToProject()).append(")");
            builtMessage.append("\n(4) Status");
            if (register.findTask(chosenTask).ifDone() == true)
                builtMessage.append(" (done)");
            else
                builtMessage.append(" (not done)");
            builtMessage.append("\n(5) Back to main menu");
            return String.valueOf(builtMessage);
        } else if (popUpIdentifier.equals("chooseStatus")) {
            builtMessage.append("Choose status");
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
            builtMessage.append("Print tasks sorted by");
        } else if (popUpIdentifier.equals("chooseFiltering")) {
            builtMessage.append("Print tasks that are");
        } else if (popUpIdentifier.equals("list")) {
            builtMessage.append("Tasks");
            sortedList.forEach(task -> {        // Add tasks to string
                builtMessage.append("\n").append(task.getId()).append(" - ");
                if (task.getAssignedToProject() != "")
                    builtMessage.append(task.getAssignedToProject()).append(" - ");
                builtMessage.append(task.getTitle()).append(" with due date ").append(task.getDueDate());
                if (task.ifDone())
                    builtMessage.append(" - done");
                else
                    builtMessage.append(" - not done");
            });
        }
        return String.valueOf(builtMessage);
    }

    private static String amountDone() {
        return String.valueOf(register.getTasks().stream().filter(task -> task.ifDone()).count());
    }

    private static String amountToDo() {
        return String.valueOf(register.getTasks().stream().filter(task -> !task.ifDone()).count());
    }
}
