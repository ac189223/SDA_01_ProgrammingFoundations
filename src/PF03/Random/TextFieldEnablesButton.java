package PF03.Random;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextFieldEnablesButton {
    private JPanel mainPanel = new JPanel();
    private JButton okButton = new JButton("OK");
    private JTextField fieldA = new JTextField(10);
    private JTextField fieldB = new JTextField(10);
    private JTextField fieldC = new JTextField(10);
    private List<JTextField> fieldList = new ArrayList<JTextField>();

    public TextFieldEnablesButton() {
        fieldList.add(fieldA);
        fieldList.add(fieldB);
        fieldList.add(fieldC);
        DocumentListener myDocListener = new MyDocListener();
        for (JTextField field : fieldList) {
            mainPanel.add(field);
            field.getDocument().addDocumentListener(myDocListener);
        }

        okButton.setEnabled(false);
        mainPanel.add(okButton);
    }

    public JComponent getComponent() { return mainPanel; }

    private void checkFieldsFull() {
        for (JTextField field : fieldList)
            if (field.getText().trim().isEmpty()) {
                okButton.setEnabled(false);
                return;
            }
        okButton.setEnabled(true);
    }

    private class MyDocListener implements DocumentListener {
        public void changedUpdate(DocumentEvent e) { checkFieldsFull(); }
        public void insertUpdate(DocumentEvent e) { checkFieldsFull(); }
        public void removeUpdate(DocumentEvent e) { checkFieldsFull(); }
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("TextFieldEnablesButton");
        frame.getContentPane().add(new TextFieldEnablesButton().getComponent());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { createAndShowUI(); }
        });
    }
}