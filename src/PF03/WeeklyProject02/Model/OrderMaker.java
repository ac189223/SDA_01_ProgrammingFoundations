package PF03.WeeklyProject02.Model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import PF03.WeeklyProject02.Controller;

import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class OrderMaker {

	private JFrame frameOrderMaker;
	private JRadioButton rdbtnAlreadyAClient;
	private JRadioButton rdbtnNotYet;
	private JTextField txtCustomerId;
	private JTextField txtCustomerName;
	private JTextField txtCustomerAddress;
	private JTextField txtCustomerPhone;
	private JButton btnCustomerEdit;
	private JButton btnCustomerDelete;
	private JRadioButton rdbtnCustomerPrivate;
	private JRadioButton rdbtnCustomerCorporate;
	private JTextField txtCustomerIdIn;
	private final ButtonGroup buttonGroupIsCustomer = new ButtonGroup();
	private final ButtonGroup buttonGroupPrivateCorporate = new ButtonGroup();

	private Controller controller;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderMaker window = new OrderMaker();
					window.frameOrderMaker.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	private OrderMaker() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameOrderMaker = new JFrame();
		frameOrderMaker.getContentPane().setBackground(new Color(135, 206, 235));
		frameOrderMaker.getContentPane().setLayout(null);
		frameOrderMaker.setBackground(new Color(135, 206, 235));
		frameOrderMaker.setTitle("ORM                        =-_-=                        ORM");
		frameOrderMaker.setBounds(100, 100, 450, 525);
		frameOrderMaker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		rdbtnAlreadyAClient = new JRadioButton("Already a client ?");
		rdbtnAlreadyAClient.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnAlreadyAClient.isSelected()) {
					enableUpperPartOfCustomer();
					disableDownPartOfCustomer();
				}
			}
		});
		buttonGroupIsCustomer.add(rdbtnAlreadyAClient);
		rdbtnAlreadyAClient.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		rdbtnAlreadyAClient.setBounds(21, 24, 263, 23);
		frameOrderMaker.getContentPane().add(rdbtnAlreadyAClient);
		
		txtCustomerId = new JTextField();
		txtCustomerId.setForeground(new Color(169, 169, 169));
		txtCustomerId.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCustomerId.setColumns(10);
		txtCustomerId.setBounds(49, 59, 190, 26);
		txtCustomerId.setEnabled(false);
		frameOrderMaker.getContentPane().add(txtCustomerId);
		
		btnCustomerEdit = new JButton("");
		btnCustomerEdit.setBounds(251, 59, 80, 29);
		btnCustomerEdit.setEnabled(false);
		frameOrderMaker.getContentPane().add(btnCustomerEdit);
		
		btnCustomerDelete = new JButton("");
		btnCustomerDelete.setBounds(343, 59, 80, 29);
		btnCustomerDelete.setEnabled(false);
		frameOrderMaker.getContentPane().add(btnCustomerDelete);

		rdbtnNotYet = new JRadioButton("Not yet ? Create an account !");
		rdbtnNotYet.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnNotYet.isSelected()) {
					disableUpperPartOfCustomer();
					enableDownPartOfCustomer();
				}
			}
		});
		buttonGroupIsCustomer.add(rdbtnNotYet);
		rdbtnNotYet.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		rdbtnNotYet.setBounds(21, 97, 263, 23);
		frameOrderMaker.getContentPane().add(rdbtnNotYet);
	
		txtCustomerName = new JTextField();
		txtCustomerName.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCustomerName.setForeground(new Color(169, 169, 169));
		txtCustomerName.setColumns(10);
		txtCustomerName.setBounds(49, 132, 190, 26);
		txtCustomerName.setEnabled(false);
		frameOrderMaker.getContentPane().add(txtCustomerName);
		
		txtCustomerAddress = new JTextField();
		txtCustomerAddress.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCustomerAddress.setForeground(new Color(169, 169, 169));
		txtCustomerAddress.setColumns(10);
		txtCustomerAddress.setBounds(49, 170, 190, 26);
		txtCustomerAddress.setEnabled(false);
		frameOrderMaker.getContentPane().add(txtCustomerAddress);
		
		txtCustomerPhone = new JTextField();
		txtCustomerPhone.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCustomerPhone.setForeground(new Color(169, 169, 169));
		txtCustomerPhone.setColumns(10);
		txtCustomerPhone.setBounds(49, 208, 190, 26);
		txtCustomerPhone.setEnabled(false);
		frameOrderMaker.getContentPane().add(txtCustomerPhone);
		
		rdbtnCustomerPrivate = new JRadioButton("");
		rdbtnCustomerPrivate.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnCustomerPrivate.isSelected()) {
					txtCustomerIdIn.setText("Enter social security number");
					txtCustomerIdIn.setEnabled(true);
				}
			}
		});
		buttonGroupPrivateCorporate.add(rdbtnCustomerPrivate);
		rdbtnCustomerPrivate.setText("Private");
		rdbtnCustomerPrivate.setBounds(81, 246, 141, 23);
		rdbtnCustomerPrivate.setEnabled(false);
		frameOrderMaker.getContentPane().add(rdbtnCustomerPrivate);
		
		rdbtnCustomerCorporate = new JRadioButton("");
		rdbtnCustomerCorporate.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnCustomerCorporate.isSelected()) {
					txtCustomerIdIn.setText("Enter corporate Id");
					txtCustomerIdIn.setEnabled(true);
				}
			}
		});
		buttonGroupPrivateCorporate.add(rdbtnCustomerCorporate);
		rdbtnCustomerCorporate.setText("Corporate");
		rdbtnCustomerCorporate.setBounds(81, 281, 141, 23);
		rdbtnCustomerCorporate.setEnabled(false);
		frameOrderMaker.getContentPane().add(rdbtnCustomerCorporate);
		
		txtCustomerIdIn = new JTextField();
		txtCustomerIdIn.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCustomerIdIn.setForeground(new Color(169, 169, 169));
		txtCustomerIdIn.setColumns(10);
		txtCustomerIdIn.setBounds(49, 316, 190, 26);
		txtCustomerIdIn.setEnabled(false);
		frameOrderMaker.getContentPane().add(txtCustomerIdIn);
		
		controller = new Controller(frameOrderMaker);
	}
	
	private void disableDownPartOfCustomer() {
		txtCustomerName.setText("");
		txtCustomerName.setEnabled(false);
		txtCustomerAddress.setText("");
		txtCustomerAddress.setEnabled(false);
		txtCustomerPhone.setText("");
		txtCustomerPhone.setEnabled(false);
		buttonGroupPrivateCorporate.clearSelection();
		rdbtnCustomerPrivate.setEnabled(false);
		rdbtnCustomerCorporate.setEnabled(false);
		txtCustomerIdIn.setText("");
		txtCustomerIdIn.setEnabled(false);
	}
	
	private void enableDownPartOfCustomer() {
		txtCustomerName.setText("Enter name");
		txtCustomerName.setEnabled(true);
		txtCustomerAddress.setText("Enter address");
		txtCustomerAddress.setEnabled(true);
		txtCustomerPhone.setText("Enter phone number");
		txtCustomerPhone.setEnabled(true);
		rdbtnCustomerPrivate.setEnabled(true);
		rdbtnCustomerCorporate.setEnabled(true);
	}
	
	private void disableUpperPartOfCustomer() {
		txtCustomerId.setText("");
		txtCustomerId.setEnabled(false);
		btnCustomerEdit.setText("");
		btnCustomerEdit.setEnabled(false);
		btnCustomerDelete.setText("");
		btnCustomerDelete.setEnabled(false);
	}
	
	private void enableUpperPartOfCustomer() {
		txtCustomerId.setText("Enter customer Id");
		txtCustomerId.setEnabled(true);
		btnCustomerEdit.setText("Edit");
		btnCustomerEdit.setEnabled(true);
		btnCustomerDelete.setText("Delete");
		btnCustomerDelete.setEnabled(true);
	}
}
