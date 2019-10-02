package PF04_IndividualProject.IP_01;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    private static Test t = new Test();
    private Register reg = new Register();

    public static void main(String[] args) {
        JFrame frame = new JFrame("=-_-=");
        int optionChosen;                               // Main choice what to do

        //    UIManager.put("OptionPane.minimumSize",new Dimension(300,300));

        /** Create data and take a look on it */
        t.createData();
        t.reg.printStatus();

        optionChosen = -1;
        while (true) {
            Object[] options = {4, 3, 2, 1};
            while (optionChosen < 0 || optionChosen > 3)
                optionChosen = JOptionPane.showOptionDialog(frame,
                        "Welcome to ToDoLy " +
                                "\n\nYou have " + amountToDo() + " tasks todo and " + amountDone() + " tasks are done" +
                                "\nPick an option:" +
                                "\n\n(1) Show Task List (by date or object)" +
                                "\n(2) Add New Task" +
                                "\n(3) Edit Task (update, mark as done, remove)" +
                                "\n(4) Save and Quit",
                        "ToDoLy    =-_-=",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        options,
                        options[0]);

            switch (optionChosen) {
                case 0:     // Save and quit
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    JOptionPane.showMessageDialog(frame,
                            "Your data were saved to file. " +
                                    "\nThank you for visiting us - come again in the future",
                            "ToDoLy    =-_-=",
                            JOptionPane.PLAIN_MESSAGE);
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
                                    "Choose activity for " + chosenTask + ":" +
                                            "\n\n(1) Update" +
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
                                optionChosen = -1;
                                break;

                            case 1:     // Remove task
                                t.reg.removeTask(chosenTask);
                                JOptionPane.showMessageDialog(frame,
                                        "Task was removed from the register",
                                        "ToDoLy    =-_-=",
                                        JOptionPane.PLAIN_MESSAGE);
                                break;

                            case 2:     // Mark as done
                                t.reg.markTaskAsDone(chosenTask);
                                JOptionPane.showMessageDialog(frame,
                                        "Task was marked as done",
                                        "ToDoLy    =-_-=",
                                        JOptionPane.PLAIN_MESSAGE);
                                break;

                            case 3:     // Edit fields
                                int chosenField = -1;
                                while (chosenField < 0 || chosenField > 3) {
                                    Object[] fields = {5, 4, 3, 2, 1};
                                    chosenField = JOptionPane.showOptionDialog(frame,
                                            "Choose activity for " + chosenTask + ":" +
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
                                            optionChosen = -1;
                                            break;

                                        case 1:     // Set status
                                            String chosenStatus;
                                            do {
                                                Object[] statusChoices = {"Done", "In progress", "Not started"};
                                                chosenStatus = (String) JOptionPane.showInputDialog(frame,
                                                        "Choose a status from a list",
                                                        "ToDoLy    =-_-=",
                                                        JOptionPane.PLAIN_MESSAGE,
                                                        null,
                                                        statusChoices,
                                                        statusChoices[0]);
                                            } while (!t.reg.getTasksIds().contains(chosenTask));
                                            if (chosenStatus.equals("Done"))
                                                t.reg.findTask(chosenTask).setDone(true);
                                            else
                                                t.reg.findTask(chosenTask).setDone(false);
                                            JOptionPane.showMessageDialog(frame,
                                                    "Task status was fixed",
                                                    "ToDoLy    =-_-=",
                                                    JOptionPane.PLAIN_MESSAGE);
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
                                                JOptionPane.showMessageDialog(frame,
                                                        "Task was reassigned",
                                                        "ToDoLy    =-_-=",
                                                        JOptionPane.PLAIN_MESSAGE);
                                                break;

                                            } else {
                                                JOptionPane.showMessageDialog(frame,        // No input yet about projects
                                                        "There are no projects stored",
                                                        "ToDoLy    =-_-=",
                                                        JOptionPane.PLAIN_MESSAGE);
                                                break;
                                            }

                                        case 3:     // Change due date
                                            String chosenDueDateMonth = "";
                                            List<String> months = new ArrayList<>(Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"));
                                            do {
                                                Object[] dueDateMonthChoices = months.toArray();
                                                chosenDueDateMonth = (String) JOptionPane.showInputDialog(frame,
                                                        "Choose a month of due date",
                                                            "ToDoLy    =-_-=",
                                                                JOptionPane.PLAIN_MESSAGE,
                                                            null,
                                                                dueDateMonthChoices,
                                                                dueDateMonthChoices[0]);
                                            } while (!months.contains(chosenDueDateMonth));
                                            List<String> days = new ArrayList<>(Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10","11", "12", "13",
                                                    "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"));
                                            if (!chosenDueDateMonth.equals("02")) {
                                                days.add("29");
                                                days.add("30");
                                            } else if (chosenDueDateMonth.equals("01") || chosenDueDateMonth.equals("03") || chosenDueDateMonth.equals("05") ||
                                                    chosenDueDateMonth.equals("07") || chosenDueDateMonth.equals("08") || chosenDueDateMonth.equals("10") ||
                                                    chosenDueDateMonth.equals("12"))
                                                days.add("31");
                                            String chosenDueDateDay = "";
                                            do {
                                                Object[] dueDateDaysChoices = days.toArray();
                                                chosenDueDateDay = (String) JOptionPane.showInputDialog(frame,
                                                        "Choose a day of due date",
                                                        "ToDoLy    =-_-=",
                                                        JOptionPane.PLAIN_MESSAGE,
                                                        null,
                                                        dueDateDaysChoices,
                                                        dueDateDaysChoices[0]);
                                            } while (!days.contains(chosenDueDateDay));
                                            String chosenDueDate = chosenDueDateMonth + chosenDueDateDay;
                                            t.reg.findTask(chosenTask).setDueDate(chosenDueDate);
                                            JOptionPane.showMessageDialog(frame,
                                                    "Tasks due date was changed",
                                                    "ToDoLy    =-_-=",
                                                    JOptionPane.PLAIN_MESSAGE);
                                            break;

                                        case 4:
                                            String chosenTitle = "";
                                            do {
                                                chosenTitle = JOptionPane.showInputDialog(frame,        // Ask for score
                                                        "Enter new title ",
                                                        "ToDoLy    =-_-=",
                                                        JOptionPane.PLAIN_MESSAGE);
                                            } while (chosenTitle.equals(""));
                                            t.reg.findTask(chosenTask).setTitle(chosenTitle);
                                            JOptionPane.showMessageDialog(frame,
                                                    "Tasks title was changed",
                                                    "ToDoLy    =-_-=",
                                                    JOptionPane.PLAIN_MESSAGE);
                                            break;
                                    }
                                }
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame,        // No input yet about tasks
                                "There are no tasks stored",
                                "ToDoLy    =-_-=",
                                JOptionPane.PLAIN_MESSAGE);
                        break;
                    }


                case 2:     // Add new task
                    String newTitle = "";
                    do {
                        newTitle = JOptionPane.showInputDialog(frame,        // Ask for task title
                                "Enter task title ",
                                "ToDoLy    =-_-=",
                                JOptionPane.PLAIN_MESSAGE);
                    } while (newTitle.equals(""));
                    String chosenDueDateMonth = "";
                    List<String> months = new ArrayList<>(Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"));
                    do {
                        Object[] dueDateMonthChoices = months.toArray();
                        chosenDueDateMonth = (String) JOptionPane.showInputDialog(frame,
                                "Choose a month of due date",
                                "ToDoLy    =-_-=",
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                dueDateMonthChoices,
                                dueDateMonthChoices[0]);
                    } while (!months.contains(chosenDueDateMonth));
                    List<String> days = new ArrayList<>(Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10","11", "12", "13",
                            "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"));
                    if (!chosenDueDateMonth.equals("02")) {
                        days.add("29");
                        days.add("30");
                    } else if (chosenDueDateMonth.equals("01") || chosenDueDateMonth.equals("03") || chosenDueDateMonth.equals("05") ||
                            chosenDueDateMonth.equals("07") || chosenDueDateMonth.equals("08") || chosenDueDateMonth.equals("10") ||
                            chosenDueDateMonth.equals("12"))
                        days.add("31");
                    String chosenDueDateDay = "";
                    do {
                        Object[] dueDateDaysChoices = days.toArray();
                        chosenDueDateDay = (String) JOptionPane.showInputDialog(frame,
                                "Choose a day of due date",
                                "ToDoLy    =-_-=",
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                dueDateDaysChoices,
                                dueDateDaysChoices[0]);
                    } while (!days.contains(chosenDueDateDay));
                    String newDueDate = chosenDueDateMonth + chosenDueDateDay;
                    t.reg.addTask(new Task(newTitle, newDueDate));
                    JOptionPane.showMessageDialog(frame,
                            "New tasks was added as " + t.reg.getTasks().get(t.reg.getTasks().size() - 1).getId(),
                            "ToDoLy    =-_-=",
                            JOptionPane.PLAIN_MESSAGE);
                    break;

                case 3:     // Print out
                    if (t.reg.getTasks().size() == 0) {
                        JOptionPane.showMessageDialog(frame,        // No input yet
                                "There are no tasks stored !",
                                "ToDoLy    =-_-=",
                                JOptionPane.PLAIN_MESSAGE);
                        break;
                    }

                    StringBuilder lineToPrint = new StringBuilder();
                    for (Task task: t.reg.getTasks()) {        // Add tasks to string
                        lineToPrint.append("\n").append(task.getId()).append(" - ")
                                .append(task.getTitle()).append(" with due date ").append(task.getDueDate());
                    }
                    JOptionPane.showMessageDialog(frame,        // Print all scores
                            "Tasks:" + lineToPrint,
                            "ToDoLy    =-_-=",
                            JOptionPane.PLAIN_MESSAGE);
                    break;
            }
            // Reset to be able to print initial screen
            optionChosen = -1;
        }
    }

    private void createData() {
        createTasks();
        createProjects();
        connect();
        markDone();
    }

    private void createTasks() {
        reg.addTask(new Task("clean kitchen", "1019"));
        reg.addTask(new Task("wash car", "1006"));
        reg.addTask(new Task("cut grass", "1002"));
        reg.addTask(new Task("fix doors", "1030"));
        reg.addTask(new Task("buy shoes", "1021"));
        reg.addTask(new Task("paint walls", "1014"));
    }

    private void createProjects() {
        reg.addProject(new Project("inside", "1101"));
        reg.addProject(new Project("outside", "1115"));
    }

    private void connect() {
        reg.addTaskToProject(reg.getTasks().get(3).getId(), reg.getProjects().get(0).getId());
        reg.addTaskToProject(reg.getTasks().get(1).getId(), reg.getProjects().get(1).getId());
        reg.addTaskToProject(reg.getTasks().get(5).getId(), reg.getProjects().get(1).getId());
    }

    private void markDone() {
        reg.markTaskAsDone(reg.getTasks().get(2).getId());
        reg.markTaskAsDone(reg.getTasks().get(3).getId());
        reg.markProjectAsDone(reg.getProjects().get(0).getId());
    }

    private static String amountDone() {
        return null;
    }

    private static String amountToDo() {
        return null;
    }

}
