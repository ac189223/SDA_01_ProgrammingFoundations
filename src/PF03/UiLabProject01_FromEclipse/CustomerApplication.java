package PF03.UiLabProject01_FromEclipse;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerApplication {

    private JFrame frmCustomer;
    private JTextField textField_Name;
    private JTextField textField_CNbr;
    private JTextField textField_CardType;
    private JTextField textField_CardNbr;
    private final ButtonGroup buttonGroup = new ButtonGroup();


    private Controller controller;
    private CustomerRegister customerRegister;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerApplication window = new CustomerApplication();
                    window.frmCustomer.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public CustomerApplication() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmCustomer = new JFrame();
        frmCustomer.setBounds(100, 100, 410, 410);
        frmCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCustomer.getContentPane().setLayout(null);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(47, 23, 125, 16);
        frmCustomer.getContentPane().add(lblName);

        JLabel lblCustomerNumber = new JLabel("Customer Number:");
        lblCustomerNumber.setBounds(47, 51, 125, 16);
        frmCustomer.getContentPane().add(lblCustomerNumber);

        textField_Name = new JTextField();
        textField_Name.setBounds(232, 18, 130, 26);
        frmCustomer.getContentPane().add(textField_Name);
        textField_Name.setColumns(10);

        textField_CNbr = new JTextField();
        textField_CNbr.setBounds(232, 46, 130, 26);
        frmCustomer.getContentPane().add(textField_CNbr);
        textField_CNbr.setColumns(10);

        JLabel lblCardType = new JLabel("Card Type:");
        lblCardType.setBounds(47, 169, 130, 16);
        frmCustomer.getContentPane().add(lblCardType);

        JLabel lblCardNumber = new JLabel("Card Number:");
        lblCardNumber.setBounds(47, 200, 125, 16);
        frmCustomer.getContentPane().add(lblCardNumber);

        textField_CardType = new JTextField();
        textField_CardType.setBounds(232, 164, 130, 26);
        frmCustomer.getContentPane().add(textField_CardType);
        textField_CardType.setColumns(10);

        textField_CardNbr = new JTextField();
        textField_CardNbr.setBounds(232, 195, 130, 26);
        frmCustomer.getContentPane().add(textField_CardNbr);
        textField_CardNbr.setColumns(10);

        JLabel lblResponse = new JLabel("");
        lblResponse.setHorizontalAlignment(SwingConstants.CENTER);
        lblResponse.setBounds(47, 259, 315, 16);
        frmCustomer.getContentPane().add(lblResponse);

        JRadioButton rdbtnHasCard = new JRadioButton("Has card");
        buttonGroup.add(rdbtnHasCard);
        rdbtnHasCard.setBounds(123, 94, 141, 23);
        frmCustomer.getContentPane().add(rdbtnHasCard);

        JRadioButton rdbtnNoCard = new JRadioButton("No card");
        buttonGroup.add(rdbtnNoCard);
        rdbtnNoCard.setBounds(123, 129, 141, 23);
        frmCustomer.getContentPane().add(rdbtnNoCard);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cName = textField_Name.getText();
                String cNumber = textField_CNbr.getText();
                if (rdbtnHasCard.isSelected()) {
                    String cardType = textField_CardType.getText();
                    int cardNumber;
                    try {
                        cardNumber = Integer.parseInt(textField_CardNbr.getText());
                        controller.addCustomer(cNumber, cName, cardNumber, cardType);
                        lblResponse.setText("Response:");
                    } catch (Exception e1) {
                        lblResponse.setText("Response: Ogiltigt värde, Card Number.");
                    }
                } else {
                    controller.addCustomer(cNumber, cName);
                    lblResponse.setText("Response:");
                }
            }
        });
        btnAdd.setBounds(232, 332, 117, 29);
        frmCustomer.getContentPane().add(btnAdd);

        JButton btnFind = new JButton("Find");
        btnFind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cNumber = textField_CNbr.getText();
                String[] tmpCustomer = controller.findCustomer(cNumber);
                if (tmpCustomer != null) {
                    lblResponse.setText("Response:");
                    if (tmpCustomer.length == 4) {		//Have creditcard
                        textField_CNbr.setText(tmpCustomer[0]);
                        textField_Name.setText(tmpCustomer[1]);
                        textField_CardType.setText(tmpCustomer[2]);
                        textField_CardNbr.setText(tmpCustomer[3]);
                        rdbtnHasCard.setSelected(true);
                    } else if (tmpCustomer.length == 2) {
                        textField_CNbr.setText(tmpCustomer[0]);
                        textField_Name.setText(tmpCustomer[1]);
                        textField_CardType.setText("");
                        textField_CardNbr.setText("");
                        rdbtnNoCard.setSelected(true);
                    }
                } else {
                    lblResponse.setText("Response: Customer not found");
                }
            }
        });
        btnFind.setBounds(47, 291, 117, 29);
        frmCustomer.getContentPane().add(btnFind);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(47, 332, 117, 29);
        frmCustomer.getContentPane().add(btnDelete);

        JButton btnNewName = new JButton("New name");
        btnNewName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cNumber = textField_CNbr.getText();
                String[] tmpCustomer = controller.findCustomer(cNumber);
                if (tmpCustomer != null) {
                    lblResponse.setText("Response:");
                    String newName = textField_Name.getText();
                    controller.updateCustomerName(cNumber, newName);
                } else {
                    lblResponse.setText("Response: Customer not found");
                }
            }
        });
        btnNewName.setBounds(232, 291, 117, 29);
        frmCustomer.getContentPane().add(btnNewName);

        customerRegister = new CustomerRegister();
        controller = new Controller(customerRegister, frmCustomer);
    }

}
