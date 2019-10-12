package PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.View;

import PF04_IndividualProject.IP_01_MySQLVersionWithRegister_JDBC.Controller.Controller;

import javax.swing.*;

public class Print {
    private final String TITLE = "ToDoLy    =-_-=";

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run();
    }

    public int showOptionDialog(JFrame frame, String message, Object[] list) {
        return JOptionPane.showOptionDialog(frame, message, TITLE, JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,null, list, list[0]);
    }

    public String showInputDialog(JFrame frame, String message, Object[] list) {
        return (String) JOptionPane.showInputDialog(frame, message, TITLE,
                JOptionPane.PLAIN_MESSAGE, null, list, list[0]);
    }

    public String inputLine(JFrame frame, String message) {
        return JOptionPane.showInputDialog(frame, message, TITLE, JOptionPane.PLAIN_MESSAGE);
    }

    public void showMessage(JFrame frame, String message) {
        JOptionPane.showMessageDialog(frame, message, TITLE, JOptionPane.PLAIN_MESSAGE);
    }
}
