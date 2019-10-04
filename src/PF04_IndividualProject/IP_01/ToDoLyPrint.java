package PF04_IndividualProject.IP_01;

import javax.swing.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ToDoLyPrint {
    private static ToDoLyPrint t = new ToDoLyPrint();
    private Register reg = new Register();

    public static void main(String[] args) {
        JFrame frame = new JFrame("=-_-=");

        /** Create data and take a look on it */
        t.reg.uploadData("src/PF04_IndividualProject/Resources/IPData.csv");
        t.reg.printStatus();

        int optionChosen = -1;               // Main choice what to do
        while (true) {
            Object[] options = {4, 3, 2, 1};
            while (optionChosen < 0 || optionChosen > 3)
                optionChosen = JOptionPane.showOptionDialog(frame,
                        "You have " + amountToDo() + " tasks todo and " + amountDone() + " tasks are done" +
                                "\n\nChoose an option" +
                                "\n\n(1) Show tasks (sorted by project, due date, Id or title)" +
                                "\n(2) Add new task" +
                                "\n(3) Edit task (update, mark as done, remove)" +
                                "\n(4) Save and quit",
                        "ToDoLy    =-_-=",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        options,
                        options[0]);

            switch (optionChosen) {
                case 0:     // Save and quit
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    t.reg.saveData("src/PF04_IndividualProject/Resources/IPData.csv");
                    showMessage(frame, "Your data was saved to file" +
                            "\nThank you for visiting us - come again in the future");
                    System.exit(0);

                case 1:     // Edit task
                    if (t.reg.getTasks().size() != 0) {
                        String chosenTask;
                        do {
                            Object[] choices = t.reg.getTasksIds().toArray();
                            chosenTask = (String) JOptionPane.showInputDialog(frame,
                                    "Choose a task from a list",
                                    "ToDoLy    =-_-=",
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    choices,
                                    choices[0]);
                        } while (!t.reg.getTasksIds().contains(chosenTask));
                        int chosenActivity = -1;
                        while (chosenActivity < 0 || chosenActivity > 3) {
                            Object[] activities = {4, 3, 2, 1};
                            chosenActivity = JOptionPane.showOptionDialog(frame,
                                    "Choose activity for " + chosenTask +
                                            "\n\n(1) Update (title, due date, project assignment, status)" +
                                            "\n(2) Mark as done" +
                                            "\n(3) Remove" +
                                            "\n(4) Back to main menu",
                                        "ToDoLy    =-_-=",
                                            JOptionPane.YES_NO_CANCEL_OPTION,
                                            JOptionPane.PLAIN_MESSAGE,
                                        null,
                                            activities,
                                            activities[0]);
                        }
                        switch (chosenActivity) {
                            case 0:     // Back to main menu
                                break;

                            case 1:     // Remove task
                                t.reg.removeTask(chosenTask);
                                showMessage(frame, "Task was removed from the register");
                                break;

                            case 2:     // Mark as done
                                t.reg.markTaskAsDone(chosenTask);
                                showMessage(frame, "Task was marked as done");
                                break;

                            case 3:     // Edit fields
                                int chosenField = -1;
                                while (chosenField < 0 || chosenField > 4) {
                                    Object[] fields = {5, 4, 3, 2, 1};
                                    chosenField = JOptionPane.showOptionDialog(frame,
                                            "Choose field to update for " + chosenTask +
                                                    "\n\n(1) Title" +
                                                    "\n(2) Due date" +
                                                    "\n(3) Project assignment" +
                                                    "\n(4) Status" +
                                                    "\n(5) Back to main menu",
                                            "ToDoLy    =-_-=",
                                            JOptionPane.YES_NO_CANCEL_OPTION,
                                            JOptionPane.PLAIN_MESSAGE,
                                            null,
                                            fields,
                                            fields[0]);

                                    switch (chosenField) {
                                        case 0:     // Back to main menu
                                            break;

                                        case 1:     // Set status
                                            int chosenStatus = -1;
                                            while (chosenStatus < 0 || chosenStatus > 1) {
                                                Object[] statusChoices = {"Done", "Not done"};
                                                chosenStatus = JOptionPane.showOptionDialog(frame,
                                                        "Choose status",
                                                        "ToDoLy    =-_-=",
                                                        JOptionPane.YES_NO_CANCEL_OPTION,
                                                        JOptionPane.PLAIN_MESSAGE,
                                                        null,
                                                        statusChoices,
                                                        statusChoices[0]);
                                            }

                                            if (chosenStatus == 0)
                                                t.reg.findTask(chosenTask).setDone(true);
                                            else
                                                t.reg.findTask(chosenTask).setDone(false);
                                            showMessage(frame, "Task status was fixed");
                                            break;

                                        case 2:     // Reassign to project
                                            if (t.reg.getProjects().size() != 0) {
                                                String chosenProject;
                                                do {
                                                    Object[] projectChoices = t.reg.getTasksIds().toArray();
                                                    chosenProject = (String) JOptionPane.showInputDialog(frame,
                                                            "Choose a project from a list",
                                                            "ToDoLy    =-_-=",
                                                            JOptionPane.PLAIN_MESSAGE,
                                                            null,
                                                            projectChoices,
                                                            projectChoices[0]);
                                                } while (!t.reg.getTasksIds().contains(chosenTask));

                                                t.reg.removeTaskFromProject(chosenTask);
                                                t.reg.addTaskToProject(chosenTask, chosenProject);
                                                showMessage(frame, "Task was reassigned");
                                                break;

                                            } else {
                                                showMessage(frame, "There are no projects stored");
                                                break;
                                            }

                                        case 3:     // Change due date
                                            String chosenDueDate = "";
                                            DateValidator dateValidator = new DateValidator();
                                            do {
                                                do {
                                                    do {
                                                        chosenDueDate = inputLine(frame, "Enter new due date (yyyyMMdd)");    // Ask for due date
                                                    } while (chosenDueDate == null);
                                                } while (chosenDueDate.equals(""));
                                            } while (!dateValidator.isThisDateValid(chosenDueDate, "yyyyMMdd"));

                                            t.reg.findTask(chosenTask).setDueDate(chosenDueDate);
                                            showMessage(frame, "Tasks due date was changed");
                                            break;

                                        case 4:
                                            String chosenTitle = "";
                                            do {
                                                do {
                                                chosenTitle = inputLine(frame, "Enter new title");     // Ask for title
                                                } while (chosenTitle == null);
                                            } while (chosenTitle.equals(""));

                                            t.reg.findTask(chosenTask).setTitle(chosenTitle);
                                            showMessage(frame, "Tasks title was changed");
                                            break;
                                    }
                                }
                        }
                    } else {
                        showMessage(frame, "There are no tasks stored");
                        break;
                    }
                break;

                case 2:     // Add new task
                    String newTitle = "";
                    do {
                        do {
                            newTitle = inputLine(frame, "Enter task title");        // Ask for title
                        } while (newTitle == null);
                    } while (newTitle.equals(""));

                    String newDueDate = "";
                    DateValidator dateValidator = new DateValidator();
                    do {
                        do {
                            do {
                                newDueDate = inputLine(frame, "Enter due date (yyyyMMdd)");        // Ask for due date
                            } while (newDueDate == null);
                        } while (newDueDate.equals(""));
                    } while (!dateValidator.isThisDateValid(newDueDate, "yyyyMMdd"));t.reg.addTask(new Task(newTitle, newDueDate));

                    showMessage(frame, "New tasks was added as " + t.reg.getTasks().get(t.reg.getTasks().size() - 1).getId());
                    break;

                case 3:     // Print out
                    if (t.reg.getTasks().size() == 0) {
                        showMessage(frame, "There are no tasks stored");

                    } else {
                        int chosenSorting = -1;
                        while (chosenSorting < 0 || chosenSorting > 3) {
                            Object[] sortingChoices = {"project", "due date", "Id", "title"};
                            chosenSorting = JOptionPane.showOptionDialog(frame,
                                    "Print tasks sorted by",
                                    "ToDoLy    =-_-=",
                                    JOptionPane.YES_NO_CANCEL_OPTION,
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,
                                    sortingChoices,
                                    sortingChoices[0]);
                        }

                        StringBuilder lineToPrint = new StringBuilder();
                        List<Task> sortedList = null;
                        switch (chosenSorting) {
                            case 0:
                                sortedList = t.reg.getTasks().stream()        // Sort by project
                                        .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList())
                                        .stream()
                                        .sorted(Comparator.comparing(Task::getAssignedToProject)).collect(Collectors.toList());
                                break;

                            case 1:
                                sortedList = t.reg.getTasks().stream()        // Sort by due date
                                        .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList())
                                        .stream()
                                        .sorted(Comparator.comparing(Task::getDueDate)).collect(Collectors.toList());
                                break;

                            case 2:
                                sortedList = t.reg.getTasks().stream()        // Sort by Id
                                        .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList());
                                break;

                            case 3:
                                sortedList = t.reg.getTasks().stream()        // Sort by title
                                        .sorted(Comparator.comparing(Task::getId)).collect(Collectors.toList())
                                        .stream()
                                        .sorted(Comparator.comparing(Task::getTitle)).collect(Collectors.toList());
                                break;
                        }
                        sortedList.forEach(task -> lineToPrint        // Add tasks to string
                                    .append("\n").append(task.getId()).append(" - ")
                                    .append(task.getTitle()).append(" with due date ").append(task.getDueDate()));
                        showMessage(frame, "Tasks:" + lineToPrint);
                    }
                    break;
            }
            // Reset to be able to print initial screen
            optionChosen = -1;
        }
    }

    private static void showMessage(JFrame frame, String message) {
        JOptionPane.showMessageDialog(frame,
                message,
                "ToDoLy    =-_-=",
                JOptionPane.PLAIN_MESSAGE);

    }

    private static String inputLine(JFrame frame, String message) {
        return JOptionPane.showInputDialog(frame,
                message,
                "ToDoLy    =-_-=",
                JOptionPane.PLAIN_MESSAGE);
    }

    private static String amountDone() {
        return String.valueOf(t.reg.getTasks().stream().filter(task -> task.ifDone()).count());
    }

    private static String amountToDo() {
        return String.valueOf(t.reg.getTasks().stream().filter(task -> !task.ifDone()).count());
    }

}
