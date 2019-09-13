package PF02.Exs.Bonus02_ExamResults;

import javax.swing.*;
import java.text.DecimalFormat;

public class ExamResults {
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

        optionChosen = -1;
        while (true) {
            Object[] options = {6, 5, 4, 3, 2, 1, 0};
            while (optionChosen < 0 || optionChosen > 6)
                optionChosen = JOptionPane.showOptionDialog(frame,
                        "Please choose from below options: " +
                                "\n0: Exit the program" +
                                "\n1: Add exam score" +
                                "\n2: Edit exam score" +
                                "\n3: Remove exam score" +
                                "\n4: Print score" +
                                "\n5: Print all scores" +
                                "\n6: Print average",
                        "ERM    =-_-=",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        options,
                        options[6]);

            switch (optionChosen) {
                case 6:     // Exit program
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    JOptionPane.showMessageDialog(frame,
                            "Thank you for visiting us - come again in the future !",
                            "ERM    =-_-=",
                            JOptionPane.PLAIN_MESSAGE);
                    System.exit(0);

                case 5:     // Add score
                    scoreEntered = -1;
                    do {
                        if (scoreEntered < -1 || scoreEntered > 100)        // Input out of scope
                            JOptionPane.showMessageDialog(frame,
                                    "This value is not allowed !",
                                    "ERM    =-_-=",
                                    JOptionPane.PLAIN_MESSAGE);
                        try {
                            scoreEntered = Integer.parseInt(JOptionPane.showInputDialog(frame,        // Ask for score
                                    "Enter \"-1\" to get back to main menu" +
                                            "\n\nEnter an exam score within 0-100 to add",
                                    "ERM    =-_-=",
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

                case 4:     // Edit score
                case 3:     // Remove score
                case 2:     // Print score
                    idEntered = 0;
                    if (results[0] != -1) {
                        do {
                            do {
                                if (idEntered < -1 || idEntered > (results.length -1))        // Input out of scope
                                    JOptionPane.showMessageDialog(frame,
                                            "This value is not allowed !",
                                            "ERM    =-_-=",
                                            JOptionPane.PLAIN_MESSAGE);
                                else if (results[idEntered] == -1)     // Input within scope but empty
                                    JOptionPane.showMessageDialog(frame,
                                            "There is no exam result stored in that field !",
                                            "ERM    =-_-=",
                                            JOptionPane.PLAIN_MESSAGE);
                                try {
                                    idEntered = Integer.parseInt(JOptionPane.showInputDialog(frame,        // Ask for location ID
                                            "Enter \"-1\" to get back to main menu" +
                                                    "\n\nEnter an ID-number of an exam to proceed",
                                            "ERM    =-_-=",
                                            JOptionPane.PLAIN_MESSAGE));
                                } catch (NumberFormatException e) {
                                    idEntered = results.length;
                                }
                            } while (idEntered < -1 || idEntered > (results.length -1));        // Must be within scope

                            if (idEntered == -1)       // GoTo initial screen on -1
                                break;

                        } while (results[idEntered] == -1);        // Until input within scope and not empty
                    } else {
                        JOptionPane.showMessageDialog(frame,        // No input yet
                                "There are no exam results stored !",
                                "ERM    =-_-=",
                                JOptionPane.PLAIN_MESSAGE);
                        break;
                    }

                    switch (optionChosen) {
                        case 4:     // Edit score
                            if (idEntered == -1)       // GoTo initial screen on -1
                                break;
                            scoreEntered = -1;
                            do {
                                if (scoreEntered < -1 || scoreEntered > 100)        // Input out of scope
                                    JOptionPane.showMessageDialog(frame,
                                            "This value is not allowed !",
                                            "ERM    =-_-=",
                                            JOptionPane.PLAIN_MESSAGE);
                                try {
                                    scoreEntered = Integer.parseInt(JOptionPane.showInputDialog(frame,        // Ask for correct score
                                            "Enter \"-1\" to get back to main menu" +
                                                    "\n\nEnter a correct exam score within 0-100 for ID " + idEntered,
                                            "ERM    =-_-=",
                                            JOptionPane.PLAIN_MESSAGE));
                                } catch (NumberFormatException e) {
                                    scoreEntered = -2;
                                }
                            } while (scoreEntered < -1 || scoreEntered > 100);      // Must be within scope

                            if (scoreEntered == -1)       // GoTo initial screen on -1
                                break;

                            results[idEntered] = scoreEntered;      // Correct old result in array
                            break;

                        case 3:     // Remove score
                            if (idEntered == -1)       // GoTo initial screen on -1
                                break;
                            if (idEntered == (results.length -1))      // Remove last result from array
                                results[idEntered] = -1;
                            else {       // Remove middle element and move all
                                while (idEntered < results.length - 1 && results[idEntered + 1] != -1) {
                                    results[idEntered] = results[idEntered + 1];
                                    idEntered++;
                                }
                                results[idEntered] = -1;
                            }
                            break;

                        case 2:     // Print score
                            if (idEntered == -1)       // GoTo initial screen on -1
                                break;
                            JOptionPane.showMessageDialog(frame,        // Print score
                                    "ID " + idEntered + " - score " + results[idEntered],
                                    "ERM    =-_-=",
                                    JOptionPane.PLAIN_MESSAGE);
                            break;
                    }
                    break;

                case 1:     // Print all scores
                    if (results[0] == -1) {
                        JOptionPane.showMessageDialog(frame,        // No input yet
                                "There are no exam results stored !",
                                "ERM    =-_-=",
                                JOptionPane.PLAIN_MESSAGE);
                        break;
                    }

                    lineToPrint = new StringBuilder();
                    index = 0;
                    while (index < results.length && results[index] != -1) {        // Add scores to string
                        lineToPrint.append("\n").append(index);
                        lineToPrint.append(" ".repeat(4 - String.valueOf(index).length()));
                        lineToPrint.append("- ").append(results[index]);
                        index++;
                    }
                    JOptionPane.showMessageDialog(frame,        // Print all scores
                            "ID  - Score " + lineToPrint,
                            "ERM    =-_-=",
                            JOptionPane.PLAIN_MESSAGE);
                    break;

                case 0:     // Print average
                    if (results[0] == -1) {
                        JOptionPane.showMessageDialog(frame,        // No input yet
                                "There are no exam results stored !",
                                "ERM    =-_-=",
                                JOptionPane.PLAIN_MESSAGE);
                        break;
                    }

                    index = 0;
                    sum = 0;
                    while (index < results.length && results[index] != -1) {      // Add scores to sum
                        sum += results[index];
                        index++;
                    }
                    JOptionPane.showMessageDialog(frame,        // Print average
                            "Average: " + df.format((double)sum /index),
                            "ERM    =-_-=",
                            JOptionPane.PLAIN_MESSAGE);
                    break;
            }
            // Reset to be able to print initial screen
            optionChosen = -1;
        }
    }
}