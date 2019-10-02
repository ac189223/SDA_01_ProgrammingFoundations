package PF04_IndividualProject.IP_01;

import javax.swing.*;
import java.text.DecimalFormat;

public class Test {
    static Test t = new Test();
    private Register reg = new Register();

    public static void main(String[] args) {
        JFrame frame = new JFrame("=-_-=");
        int optionChosen;                               // Main choice what to do

        int[] results = {-1, -1, -1};
        int scoreEntered;
        int index;
        //    UIManager.put("OptionPane.minimumSize",new Dimension(300,300));

        /** Create data and take a look on it */
        t.createData();
        t.reg.printStatus();

        optionChosen = -1;
        while (true) {
            Object[] options = {4, 3, 2, 1};
            while (optionChosen < 0 || optionChosen > 3)
                optionChosen = JOptionPane.showOptionDialog(frame,
                        "Welcome to ToDoLy: " +
                                "\n\nYou have " + amountToDo() + " tasks todo and " + amountDone() + " tasks are done!" +
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
                                    "\nThank you for visiting us - come again in the future !",
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
                                t.reg.



                        }


                        } else {
                        JOptionPane.showMessageDialog(frame,        // No input yet
                                "There are no tasks stored !",
                                "ToDoLy    =-_-=",
                                JOptionPane.PLAIN_MESSAGE);
                        break;
                    }


                case 2:     // Add new task
                    scoreEntered = -1;
                    do {
                        if (scoreEntered < -1 || scoreEntered > 100)        // Input out of scope
                            JOptionPane.showMessageDialog(frame,
                                    "This value is not allowed !",
                                    "ToDoLy    =-_-=",
                                    JOptionPane.PLAIN_MESSAGE);
                        try {
                            scoreEntered = Integer.parseInt(JOptionPane.showInputDialog(frame,        // Ask for score
                                    "Enter \"-1\" to get back to main menu" +
                                            "\n\nEnter an exam score within 0-100 to add",
                                    "ToDoLy    =-_-=",
                                    JOptionPane.PLAIN_MESSAGE));
                        } catch (NumberFormatException e) {
                            scoreEntered = -2;       // Set if error, wrong format, trying to close
                        }
                    } while (scoreEntered < -1 || scoreEntered > 100);      // Must be within scope

                    if (scoreEntered == -1)       // GoTo initial screen on -1
                        break;

                    index = 0;      // Search for space
                    while (index < results.length) {
                        int tmpIndex = index;
                        if (results[index] != -1)
                            index++;
                        if (tmpIndex == index)
                            break;
                    }

                    if (index == results.length) {      // Extend if needed
                        int[] tmp = new int[results.length * 2];
                        System.arraycopy(results,0 ,tmp ,0 ,results.length);        // Copy old values
                        results = tmp;
                        for (int i = results.length / 2 ; i < results.length; i++)
                            results[i] = -1;        // Add -1 at the end
                    }

                    results[index] = scoreEntered;        // Write new result into array
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
