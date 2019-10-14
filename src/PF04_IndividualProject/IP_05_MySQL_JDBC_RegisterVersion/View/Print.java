package PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.View;

import PF04_IndividualProject.IP_05_MySQL_JDBC_RegisterVersion.Controller.Controller;

import javax.swing.*;

public class Print {
    private final String TITLE = "ToDoLy    =-_-=";

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();
    }

    /** =================    =================    Print popups    =================   ================= */

    // Popup with choices and buttons to choose them
    public int showOptionDialog(JFrame frame, String message, Object[] list) {
        return JOptionPane.showOptionDialog(frame, message, TITLE, JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,null, list, list[0]);
    }

    // Popup with dropdown list of choices to choose from
    public String showInputDialog(JFrame frame, String message, Object[] list) {
        return (String) JOptionPane.showInputDialog(frame, message, TITLE,
                JOptionPane.PLAIN_MESSAGE, null, list, list[0]);
    }

    // Popup with input field
    public String inputLine(JFrame frame, String message) {
        return JOptionPane.showInputDialog(frame, message, TITLE, JOptionPane.PLAIN_MESSAGE);
    }

    // Popup with message/info
    public void showMessage(JFrame frame, String message) {
        JOptionPane.showMessageDialog(frame, message, TITLE, JOptionPane.PLAIN_MESSAGE);
    }
}
