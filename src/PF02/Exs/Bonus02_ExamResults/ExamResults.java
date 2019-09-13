package PF02.Exs.Bonus02_ExamResults;

import javax.swing.*;

public class ExamResults {
    public static void main(String[] args) {
        int[] results = {-1, -1, -1};
        int choice = -1;
        JFrame frame = new JFrame("=-_-=");

        while (true) {
            Object[] options = {6, 5, 4, 3, 2, 1, 0};
            while (choice < 0 || choice > 6)
                choice = JOptionPane.showOptionDialog(frame,
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

            switch (choice) {
                case 6:     // Exit program
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    JOptionPane.showMessageDialog(frame,
                            "Thank you for visiting us - come again in the future !",
                            "ERM    =-_-=",
                            JOptionPane.PLAIN_MESSAGE);
                    System.exit(0);

                case 5:     // Add score
                    do {
                        if (choice < -1 || choice > 100)
                            JOptionPane.showMessageDialog(frame,
                                    "This value is not allowed !",
                                    "ERM    =-_-=",
                                    JOptionPane.PLAIN_MESSAGE);
                        choice = Integer.parseInt(JOptionPane.showInputDialog(frame,
                                "Enter \"-1\" to get back to main menu" +
                                "\n\nEnter an exam score within 0-100 to add",
                                "ERM    =-_-=",
                                JOptionPane.PLAIN_MESSAGE));
                    } while (choice < -1 || choice > 100);

                    // GoTo initial screen on -1
                    if (choice == -1)
                        break;

                    // Search for space
                    int index = 0;
                    while (index < results.length) {
                        int tmpIndex = index;
                        if (results[index] != -1)
                            index++;
                        if (tmpIndex == index)
                            break;
                    }
                    // Extend if needed
                    if (index == results.length) {
                        int[] tmp = new int[results.length * 2];
                        System.arraycopy(results,0 ,tmp ,0 ,results.length);
                        results = tmp;
                    }
                    // Write new result
                    results[index] = choice;
                    break;

                case 4:     // Edit score
                    choice = -1;
                    if (results[0] != -1) {
                        do {
                            do {
                                if (choice < -1 || choice > (results.length -1))
                                    JOptionPane.showMessageDialog(frame,
                                            "This value is not allowed !",
                                            "ERM    =-_-=",
                                            JOptionPane.PLAIN_MESSAGE);
                                else if (results[choice] == -1)
                                    JOptionPane.showMessageDialog(frame,
                                            "This value is not allowed !",
                                            "ERM    =-_-=",
                                            JOptionPane.PLAIN_MESSAGE);
                                choice = Integer.parseInt(JOptionPane.showInputDialog(frame,
                                        "Enter \"-1\" to get back to main menu" +
                                                "\n\nEnter an ID-number of an exam to edit",
                                        "ERM    =-_-=",
                                        JOptionPane.PLAIN_MESSAGE));
                            } while (choice < -1 || choice > (results.length -1));
                            if (choice == -1)
                                break;
                        } while (results[choice] == -1);
                    } else {
                        JOptionPane.showMessageDialog(frame,
                                "There are no exam results stored - you cannot edit !",
                                "ERM    =-_-=",
                                JOptionPane.PLAIN_MESSAGE);
                        break;
                    }

                    break;

                case 3:     // Remove score

                    break;

                case 2:     // Print score

                    break;

                case 1:     // Print all scores

                    break;

                case 0:     // Print average

                    break;
            }
            // Reset choice to print initial screen
            choice = -1;
        }
    }
}
