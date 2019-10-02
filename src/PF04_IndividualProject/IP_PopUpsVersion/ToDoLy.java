package PF04_IndividualProject.IP_PopUpsVersion;

import javax.swing.*;
import java.text.DecimalFormat;

public class ToDoLy {
    static TaskRep taskRep = new TaskRep();
    static ProjectRep projectRep = new ProjectRep();

    public static void main(String[] args) {
        int[] results = {-1, -1, -1};
        int optionChosen;
        int scoreEntered;
        int idEntered;
        int index;
        int sum;
        StringBuilder lineToPrint;
        JFrame frame = new JFrame("=-_-=");
        DecimalFormat df = new DecimalFormat("###.#");
    //    UIManager.put("OptionPane.minimumSize",new Dimension(300,300));

        taskRep.addTask(new Task("do shopping", "1904"));
        taskRep.addTask(new Task("do cleaning", "1906"));
        taskRep.addTask(new Task("do clipping", "1908"));

        optionChosen = -1;
        while (true) {
            Object[] options = {4, 3, 2, 1};
            while (optionChosen < 0 || optionChosen > 6)
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
                    if (taskRep.getTasks().size() != 0) {
                        String chosenTask;
                        do {
                            Object[] choices = taskRep.getTasks().stream().map(task -> task.getId()).toArray();
                            chosenTask = (String) JOptionPane.showInputDialog(frame,
                                    "Choose a task to edit from a list",
                                    "ToDoLy    =-_-=",
                                    JOptionPane.QUESTION_MESSAGE,
                                    null,
                                    choices,
                                    choices[0]);
                        } while (!taskRep.notContains(chosenTask));
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

    private static String amountDone() {
        return null;
    }

    private static String amountToDo() {
        return null;
    }
}