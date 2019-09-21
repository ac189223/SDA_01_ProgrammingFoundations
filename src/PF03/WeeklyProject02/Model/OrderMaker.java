package PF03.WeeklyProject02.Model;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class OrderMaker {

	private JFrame frameOrderMaker;
	private JRadioButton rdbtnCustomerAlreadyAClient;
	private JRadioButton rdbtnAdminArticles;
	private JRadioButton rdbtnOrderCreate;
	private JRadioButton rdbtnCustomerNotYet;
	private JRadioButton rdbtnAdminSuppliers;
	private JRadioButton rdbtnOrderAddLine;
	private JTextField txtCustomerId;
	private JTextField comboAdminArticleId;
	private JTextField txtOrderCustId;
	private JTextField txtCustomerAddress;
	private JTextField txtAdminSupplierName;
	private JTextField comboOrderNumberAdd;
	private JTextField txtCustomerPhone;
	private JTextField txtAdminSupplierPhone;
	private JButton btnCustomerEdit;
	private JButton btnCustomerDelete;
	private JButton btnOrderAddLine;
	private JRadioButton rdbtnCustomerPrivate;
	private JRadioButton rdbtnCustomerCorporate;
	private JTextField txtCustomerIdIn;
	private JTextField comboOrderNumberDelete;
	private final ButtonGroup buttonGroupIsCustomer = new ButtonGroup();
	private final ButtonGroup buttonGroupPrivateCorporate = new ButtonGroup();
	private final ButtonGroup buttonGroupOrderActivity = new ButtonGroup();
	private final ButtonGroup buttonGroupAdminActivity = new ButtonGroup();

	private Controller controller;

	private Random random = new Random();

	private JButton btnCustomerAdd;
	private JButton btnAdminAdd;
	private JRadioButton rdbtnCustomerNotSure;
	private JRadioButton rdbtnAdminClients;
	private JRadioButton rdbtnOrderDeleteArticle;
	private JTextField txtCustomerCheckId;
	private JButton btnCustomerCheck;
	private JButton btnAdminDelete;
	private JButton btnOrderDelete;
	private JButton btnOrderProceed;
	private JButton btnCustomerCreateAnOrder;
	private JTabbedPane tabbedPane;
	private JTextField txtCustomerName;
	private JTextField comboAdminSupplierId;
	private JTextField txtOrderDate;
	private JTextField txtCustomerConfirmation;
	private JTextField txtAdminConfirmation;
	private JTextField txtOrderConfirmation;
	private JPanel panel01;
	private JPanel panel02;
	private JPanel panel03;
	
	private String custId;
	private JLabel lblCustomerAdmin;
	private JLabel lblOrderAdmin;
	private JLabel lblOrderCustId;
	private JTextField txtOrderNumberCreate;
	private JButton btnOrderCreate;
	private JTextField comboOrderArticleAdd;
	private JTextField txtOrderQuantity;
	private JTextField txtAdminArticleName;
	private JTextField txtAdminArticlePrice;
	private JTextField comboAdminArticleSupplier;
	private JTextField comboAdminSupplierArticle;
	private JTextField comboAdminClientId;
	private JTextField txtAdminClientAddress;
	private JTextField txtAdminClientName;
	private JTextField txtAdminClientPhone;
	private JTextField comboAdminClientOrder;
	private JButton btnAdminCreate;
	private JButton btnAdminFind;
	
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
		frameOrderMaker.getContentPane().setBackground(new Color(30, 144, 255));
		frameOrderMaker.getContentPane().setLayout(null);
		frameOrderMaker.setBackground(new Color(135, 206, 235));
		frameOrderMaker.setTitle("ORM                        =-_-=                        ORM");
		frameOrderMaker.setBounds(100, 100, 480, 610);
		frameOrderMaker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		tabbedPane.setBackground(new Color(100, 149, 237));
		tabbedPane.setBounds(6, 6, 468, 578);
		frameOrderMaker.getContentPane().add(tabbedPane, BorderLayout.CENTER);
				
		panel01 = new JPanel();
		panel01.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				setCustomerConfirmationBlank();
			}
		});
		panel01.setBorder(new LineBorder(new Color(135, 206, 235), 0, true));
		panel01.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Customer", null, panel01, null);
		tabbedPane.setForegroundAt(0, new Color(0, 0, 128));
		tabbedPane.setBackgroundAt(0, new Color(135, 206, 235));
		panel01.setLayout(null);
		
		panel02 = new JPanel();
		panel02.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				setOrderConfirmationBlank();
			}
		});
		panel02.setBorder(new LineBorder(new Color(135, 206, 235), 0, true));
		panel02.setBackground(new Color(135, 206, 235));
		panel02.setEnabled(false);
		tabbedPane.addTab("Order", null, panel02, null);
		tabbedPane.setEnabledAt(1, false);
		tabbedPane.setForegroundAt(1, new Color(0, 0, 128));
		tabbedPane.setBackgroundAt(1, new Color(135, 206, 235));
		panel02.setLayout(null);
		
		panel03 = new JPanel();
		panel03.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				setAdminConfirmationBlank();
			}
		});
		panel03.setBorder(new LineBorder(new Color(135, 206, 235), 0, true));
		panel03.setBackground(new Color(135, 206, 235));
		panel03.setEnabled(false);
	    tabbedPane.addTab("Admin", null, panel03, null);
		tabbedPane.setForegroundAt(2, new Color(0, 0, 128));
		tabbedPane.setBackgroundAt(2, new Color(135, 206, 235));
		panel03.setLayout(null);

				
// panel01 ==================    CUSTOMER    =========================== panel01

	    rdbtnCustomerAlreadyAClient = new JRadioButton("Already a client ?");
	    rdbtnCustomerAlreadyAClient.addChangeListener(new ChangeListener() {
	    	public void stateChanged(ChangeEvent e) {
	    		if (rdbtnCustomerAlreadyAClient.isSelected()) {
	    			enableUpperPartOfCustomer();
	    			disableMiddlePartOfCustomer();
	    			disableLowerPartOfCustomer();
	    			setCustomerConfirmationBlank();
	    		}
	    	}
	    });
	    buttonGroupIsCustomer.add(rdbtnCustomerAlreadyAClient);
	    rdbtnCustomerAlreadyAClient.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
	    rdbtnCustomerAlreadyAClient.setBounds(21, 35, 263, 23);
	    panel01.add(rdbtnCustomerAlreadyAClient);
	    
	    txtCustomerId = new JTextField();
	    txtCustomerId.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		txtCustomerId.setText("");
	    	}
	    });
	    txtCustomerId.setForeground(new Color(169, 169, 169));
	    txtCustomerId.setHorizontalAlignment(SwingConstants.TRAILING);
	    txtCustomerId.setColumns(10);
	    txtCustomerId.setBounds(49, 70, 190, 26);
	    txtCustomerId.setEnabled(false);
	    panel01.add(txtCustomerId);
	    
	    btnCustomerEdit = new JButton("");
	    btnCustomerEdit.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
// EDIT CustomerData
	    		if (txtCustomerId.getText().equals(""))
	    			custId = txtCustomerIdIn.getText();
	    		else
	    			custId = txtCustomerId.getText();
	    		Customer tmpCustomer = controller.findCustomer(custId);
	    		if (tmpCustomer != null) {
	    			disableUpperPartOfCustomer();
	    			txtCustomerName.setText(tmpCustomer.getName());
	    			txtCustomerName.setEnabled(true);
	    			txtCustomerAddress.setText(tmpCustomer.getAddress());
	    			txtCustomerAddress.setEnabled(true);
	    			txtCustomerPhone.setText(tmpCustomer.getPhoneNr());
	    			txtCustomerPhone.setEnabled(true);
	    			if (tmpCustomer.getClass() == CustomerPrivate.class)
	    				rdbtnCustomerPrivate.setSelected(true);
	    			else if (tmpCustomer.getClass() == CustomerCompany.class)
	    				rdbtnCustomerCorporate.setSelected(true);
	    			txtCustomerIdIn.setText(custId);
	    			btnCustomerAdd.setText("Update");
	    			btnCustomerAdd.setEnabled(true);
	    		} else {
	    			setCustomerConfirmationNo();
	    		}
	    	}
	    });
	    btnCustomerEdit.setBounds(251, 70, 80, 29);
	    btnCustomerEdit.setEnabled(false);
	    panel01.add(btnCustomerEdit);
	    
	    btnCustomerDelete = new JButton("");
	    btnCustomerDelete.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
// DELETE Customer
	    		if (txtCustomerId.getText().equals(""))
	    			custId = txtCustomerIdIn.getText();
	    		else
	    			custId = txtCustomerId.getText();
	    		Customer tmpCustomer = controller.findCustomer(custId);
	    		if (tmpCustomer != null) {
	    			controller.deleteCustomer(custId);
	    			setCustomerConfirmationYes();
	    		} else {
	    			setCustomerConfirmationNo();
	    		}
	    	}
	    });
	    btnCustomerDelete.setBounds(343, 70, 80, 29);
	    btnCustomerDelete.setEnabled(false);
	    panel01.add(btnCustomerDelete);
	    
		rdbtnCustomerNotYet = new JRadioButton("Not yet ? Create an account !");
		rdbtnCustomerNotYet.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnCustomerNotYet.isSelected()) {
					disableUpperPartOfCustomer();
					enableMiddlePartOfCustomer();
					disableLowerPartOfCustomer();
					setCustomerConfirmationBlank();
				}
			}
		});
		buttonGroupIsCustomer.add(rdbtnCustomerNotYet);
		rdbtnCustomerNotYet.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		rdbtnCustomerNotYet.setBounds(21, 108, 263, 23);
		panel01.add(rdbtnCustomerNotYet);
		
		txtCustomerName = new JTextField();
		txtCustomerName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCustomerName.setText("");
			}
		});
		
		txtCustomerName.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCustomerName.setForeground(new Color(169, 169, 169));
		txtCustomerName.setEnabled(false);
		txtCustomerName.setColumns(10);
		txtCustomerName.setBounds(49, 143, 190, 26);
		txtCustomerName.setEnabled(false);
		panel01.add(txtCustomerName);
		
		txtCustomerAddress = new JTextField();
		txtCustomerAddress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCustomerAddress.setText("");
			}
		});
		txtCustomerAddress.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCustomerAddress.setForeground(new Color(169, 169, 169));
		txtCustomerAddress.setColumns(10);
		txtCustomerAddress.setBounds(49, 181, 190, 26);
		txtCustomerAddress.setEnabled(false);
		panel01.add(txtCustomerAddress);
		
		txtCustomerPhone = new JTextField();
		txtCustomerPhone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCustomerPhone.setText("");
			}
		});
		txtCustomerPhone.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCustomerPhone.setForeground(new Color(169, 169, 169));
		txtCustomerPhone.setColumns(10);
		txtCustomerPhone.setBounds(49, 219, 190, 26);
		txtCustomerPhone.setEnabled(false);
		panel01.add(txtCustomerPhone);
	    				
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
		rdbtnCustomerPrivate.setBounds(81, 257, 141, 23);
		rdbtnCustomerPrivate.setEnabled(false);
		panel01.add(rdbtnCustomerPrivate);
		
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
		rdbtnCustomerCorporate.setBounds(81, 292, 141, 23);
		rdbtnCustomerCorporate.setEnabled(false);
		panel01.add(rdbtnCustomerCorporate);
		
		txtCustomerIdIn = new JTextField();
		txtCustomerIdIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCustomerIdIn.setText("");
			}
		});
		txtCustomerIdIn.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCustomerIdIn.setForeground(new Color(169, 169, 169));
		txtCustomerIdIn.setColumns(10);
		txtCustomerIdIn.setBounds(49, 327, 190, 26);
		txtCustomerIdIn.setEnabled(false);
		panel01.add(txtCustomerIdIn);
	    				
		txtCustomerConfirmation = new JTextField();
		txtCustomerConfirmation.setHorizontalAlignment(SwingConstants.CENTER);
		txtCustomerConfirmation.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 99));
		txtCustomerConfirmation.setBackground(new Color(135, 206, 235));
		txtCustomerConfirmation.setBounds(272, 143, 130, 137);
		txtCustomerConfirmation.setColumns(10);
		txtCustomerConfirmation.setEnabled(false);
		panel01.add(txtCustomerConfirmation);
	    				
		btnCustomerAdd = new JButton("");
		btnCustomerAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
// ADD & UPDATE CustomerData
				if (rdbtnCustomerPrivate.isSelected() || rdbtnCustomerCorporate.isSelected()) {
					String custId = txtCustomerIdIn.getText();
					String name = txtCustomerName.getText();
					String address = txtCustomerAddress.getText();
					String phone = txtCustomerPhone.getText();
					if (btnCustomerAdd.getText().equals("Add")) {
						if (rdbtnCustomerPrivate.isSelected())
							controller.addCustomer("P", custId, name, address, phone);
						else if (rdbtnCustomerCorporate.isSelected())
							controller.addCustomer("C", custId, name, address, phone);
						setCustomerConfirmationYes();
					} else if (btnCustomerAdd.getText().equals("Update")) {
						controller.updateCustomerData(custId, name, address, phone);
						setCustomerConfirmationYes();
					}
				}
			}
		});
		btnCustomerAdd.setEnabled(false);
		btnCustomerAdd.setBounds(295, 327, 80, 29);
		btnCustomerAdd.setEnabled(false);
		panel01.add(btnCustomerAdd);
		
		rdbtnCustomerNotSure = new JRadioButton("Not sure ? Check it !");
		rdbtnCustomerNotSure.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnCustomerNotSure.isSelected()) {
					disableUpperPartOfCustomer();
					disableMiddlePartOfCustomer();
					enableLowerPartOfCustomer();
					setCustomerConfirmationBlank();
				}
			}
		});
		buttonGroupIsCustomer.add(rdbtnCustomerNotSure);
		rdbtnCustomerNotSure.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		rdbtnCustomerNotSure.setBounds(21, 365, 263, 23);
		panel01.add(rdbtnCustomerNotSure);
		
		txtCustomerCheckId = new JTextField();
		txtCustomerCheckId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCustomerCheckId.setText("");
			}
		});
		txtCustomerCheckId.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCustomerCheckId.setForeground(new Color(169, 169, 169));
		txtCustomerCheckId.setEnabled(false);
		txtCustomerCheckId.setColumns(10);
		txtCustomerCheckId.setBounds(49, 400, 190, 26);
		txtCustomerCheckId.setEnabled(false);
		panel01.add(txtCustomerCheckId);
		
		btnCustomerCheck = new JButton("");
		btnCustomerCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
// SEARCH for Customer
				String custId = txtCustomerCheckId.getText();
				Customer tmpCustomer = controller.findCustomer(custId);
				if (tmpCustomer != null) {
					txtCustomerName.setText(tmpCustomer.getName());
					txtCustomerAddress.setText(tmpCustomer.getAddress());
					txtCustomerPhone.setText(tmpCustomer.getPhoneNr());
					if (tmpCustomer.getClass() == CustomerPrivate.class)
						rdbtnCustomerPrivate.setSelected(true);
					else if (tmpCustomer.getClass() == CustomerCompany.class)
						rdbtnCustomerCorporate.setSelected(true);
					txtCustomerId.setText(custId);
					txtCustomerIdIn.setText(custId);
					btnCustomerEdit.setText("Edit");
					btnCustomerEdit.setEnabled(true);
					btnCustomerDelete.setText("Delete");
					btnCustomerDelete.setEnabled(true);
					btnCustomerCreateAnOrder.setText("Create an order");
					btnCustomerCreateAnOrder.setEnabled(true);
					disableLowerPartOfCustomer();
					setCustomerConfirmationYes();
				} else {
					setCustomerConfirmationNo();
				}
			}
		});
		btnCustomerCheck.setEnabled(false);
		btnCustomerCheck.setBounds(295, 400, 80, 29);
		btnCustomerCheck.setEnabled(false);
		panel01.add(btnCustomerCheck);
		
		btnCustomerCreateAnOrder = new JButton("");
		btnCustomerCreateAnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
// GO TO ORDER PANEL as Customer
				if (txtCustomerId.getText().equals(""))
					custId = txtCustomerIdIn.getText();
				else
					custId = txtCustomerId.getText();
				Customer tmpCustomer = controller.findCustomer(custId);
				if (tmpCustomer != null) {
					disableUpperPartOfCustomer();
					disableMiddlePartOfCustomer();
					disableLowerPartOfCustomer();
					panel02.setEnabled(true);
					tabbedPane.setSelectedIndex(1);
					txtOrderCustId.setText(custId);
					rdbtnOrderCreate.setEnabled(true);
					rdbtnOrderAddLine.setEnabled(true);
					rdbtnOrderDeleteArticle.setEnabled(true);
				} else {
					setCustomerConfirmationNo();
				}
			}
		});
		btnCustomerCreateAnOrder.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		btnCustomerCreateAnOrder.setBounds(21, 447, 402, 47);
		btnCustomerCreateAnOrder.setEnabled(false);
		panel01.add(btnCustomerCreateAnOrder);
		
		lblCustomerAdmin = new JLabel("Admin");
		lblCustomerAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
// GO TO ADMIN PANEL as Admin
				panel03.setEnabled(true);
				rdbtnAdminArticles.setEnabled(true);
				rdbtnAdminSuppliers.setEnabled(true);
				rdbtnAdminClients.setEnabled(true);
				tabbedPane.setSelectedIndex(2);
			}
		});
		lblCustomerAdmin.setEnabled(false);
		lblCustomerAdmin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustomerAdmin.setBackground(new Color(135, 206, 235));
		lblCustomerAdmin.setForeground(new Color(0, 0, 0));
		lblCustomerAdmin.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblCustomerAdmin.setBounds(406, 512, 35, 14);
		panel01.add(lblCustomerAdmin);

// panel02 ==================    ORDER    =========================== panel02

		txtOrderCustId = new JTextField();
		txtOrderCustId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtOrderCustId.setText("");
			}
		});
		txtOrderCustId.setForeground(new Color(169, 169, 169));
		txtOrderCustId.setHorizontalAlignment(SwingConstants.TRAILING);
		txtOrderCustId.setColumns(10);
		txtOrderCustId.setBounds(49, 39, 190, 26);
		txtOrderCustId.setEnabled(false);
		panel02.add(txtOrderCustId);

		lblOrderCustId = new JLabel("customer Id");
		lblOrderCustId.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderCustId.setEnabled(false);
		lblOrderCustId.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblOrderCustId.setBounds(236, 53, 80, 16);
		panel02.add(lblOrderCustId);

		rdbtnOrderCreate = new JRadioButton("Create a new order ?");
		rdbtnOrderCreate.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnOrderCreate.isSelected()) {
					enableUpperPartOfOrder();
					disableMiddlePartOfOrder();
					disableLowerPartOfOrder();
					setOrderConfirmationBlank();
				}
			}
		});
		buttonGroupOrderActivity.add(rdbtnOrderCreate);
		rdbtnOrderCreate.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		rdbtnOrderCreate.setBounds(21, 77, 263, 23);
		rdbtnOrderCreate.setEnabled(false);
		panel02.add(rdbtnOrderCreate);

		txtOrderNumberCreate = new JTextField();
		txtOrderNumberCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtOrderNumberCreate.setText("");
			}
		});
		txtOrderNumberCreate.setHorizontalAlignment(SwingConstants.TRAILING);
		txtOrderNumberCreate.setForeground(new Color(169, 169, 169));
		txtOrderNumberCreate.setEnabled(false);
		txtOrderNumberCreate.setColumns(10);
		txtOrderNumberCreate.setBounds(49, 112, 190, 26);
		panel02.add(txtOrderNumberCreate);

		txtOrderDate = new JTextField();
		txtOrderDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtOrderDate.setText("");
			}
		});
		txtOrderDate.setHorizontalAlignment(SwingConstants.TRAILING);
		txtOrderDate.setForeground(new Color(169, 169, 169));
		txtOrderDate.setEnabled(false);
		txtOrderDate.setColumns(10);
		txtOrderDate.setBounds(49, 150, 190, 26);
		txtOrderDate.setEnabled(false);
		panel02.add(txtOrderDate);

		btnOrderCreate = new JButton("");
		btnOrderCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
// ADD new Order as Client
				String custId = txtOrderCustId.getText();
				Customer tmpCustomer = controller.findCustomer(custId);
				if (tmpCustomer != null) {
					String orderNumber = txtOrderNumberCreate.getText();
					String orderDate = txtOrderDate.getText();
					controller.addOrder(custId, orderNumber, orderDate);
					disableUpperPartOfOrder();
					enableMiddlePartOfOrder();
					rdbtnOrderAddLine.setSelected(true);
					comboOrderNumberAdd.setText(orderNumber);
					comboOrderNumberAdd.setEnabled(false);
					setOrderConfirmationYes();
				} else {
					setOrderConfirmationNo();
				}
			}
		});
		btnOrderCreate.setEnabled(false);
		btnOrderCreate.setBounds(295, 81, 80, 29);
		panel02.add(btnOrderCreate);

		txtOrderConfirmation = new JTextField();
		txtOrderConfirmation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtOrderConfirmation.setText("");
			}
		});
		txtOrderConfirmation.setHorizontalAlignment(SwingConstants.CENTER);
		txtOrderConfirmation.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 99));
		txtOrderConfirmation.setBackground(new Color(135, 206, 235));
		txtOrderConfirmation.setBounds(272, 132, 130, 137);
		txtOrderConfirmation.setColumns(10);
		txtOrderConfirmation.setEnabled(false);
		panel02.add(txtOrderConfirmation);

		rdbtnOrderAddLine = new JRadioButton("Add a new line ?");
		rdbtnOrderAddLine.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnOrderAddLine.isSelected()) {
					disableUpperPartOfOrder();
					enableMiddlePartOfOrder();
					disableLowerPartOfOrder();
					setOrderConfirmationBlank();
				}
			}
		});
		buttonGroupOrderActivity.add(rdbtnOrderAddLine);
		rdbtnOrderAddLine.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		rdbtnOrderAddLine.setBounds(21, 188, 263, 23);
		rdbtnOrderAddLine.setEnabled(false);
		panel02.add(rdbtnOrderAddLine);

		comboOrderNumberAdd = new JTextField();
		comboOrderNumberAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboOrderNumberAdd.setText("");
			}
		});
		comboOrderNumberAdd.setHorizontalAlignment(SwingConstants.TRAILING);
		comboOrderNumberAdd.setForeground(new Color(169, 169, 169));
		comboOrderNumberAdd.setBounds(49, 223, 190, 26);
		comboOrderNumberAdd.setEnabled(false);
		panel02.add(comboOrderNumberAdd);

		txtOrderQuantity = new JTextField();
		txtOrderQuantity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtOrderQuantity.setText("");
			}
		});
		txtOrderQuantity.setHorizontalAlignment(SwingConstants.TRAILING);
		txtOrderQuantity.setForeground(new Color(169, 169, 169));
		txtOrderQuantity.setEnabled(false);
		txtOrderQuantity.setColumns(10);
		txtOrderQuantity.setBounds(49, 258, 190, 26);
		panel02.add(txtOrderQuantity);

		comboOrderArticleAdd = new JTextField();
		comboOrderArticleAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboOrderArticleAdd.setText("");
			}
		});
		comboOrderArticleAdd.setHorizontalAlignment(SwingConstants.TRAILING);
		comboOrderArticleAdd.setForeground(new Color(169, 169, 169));
		comboOrderArticleAdd.setBounds(49, 296, 190, 27);
		comboOrderArticleAdd.setEnabled(false);
		panel02.add(comboOrderArticleAdd);

		btnOrderAddLine = new JButton("");
		btnOrderAddLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
// ADD new OrderLine to Order as Client
				String custId = txtOrderCustId.getText();
				Customer tmpCustomer = controller.findCustomer(custId);
				if (tmpCustomer != null) {
					String orderNumber = comboOrderNumberAdd.getText();
					String quantity = txtOrderQuantity.getText();
					String articleId = comboOrderArticleAdd.getText();
					try {
						controller.addOrderLine(custId, orderNumber, quantity, articleId);
						enableMiddlePartOfOrder();
						comboOrderNumberAdd.setText(orderNumber);
						comboOrderNumberAdd.setEnabled(false);
						setOrderConfirmationYes();
					} catch (Exception err) {
						setOrderConfirmationNo();
					}	
				} else {
					setOrderConfirmationNo();
				}
			}
		});
		btnOrderAddLine.setBounds(295, 294, 80, 29);
		btnOrderAddLine.setEnabled(false);
		panel02.add(btnOrderAddLine);

		rdbtnOrderDeleteArticle = new JRadioButton("Delete an order ?");
		rdbtnOrderDeleteArticle.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnOrderDeleteArticle.isSelected()) {
					disableUpperPartOfOrder();
					disableMiddlePartOfOrder();
					enableLowerPartOfOrder();
					setOrderConfirmationBlank();
				}
			}
		});
		buttonGroupOrderActivity.add(rdbtnOrderDeleteArticle);
		rdbtnOrderDeleteArticle.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		rdbtnOrderDeleteArticle.setBounds(21, 338, 263, 23);
		rdbtnOrderDeleteArticle.setEnabled(false);
		panel02.add(rdbtnOrderDeleteArticle);

		comboOrderNumberDelete = new JTextField();
		comboOrderNumberDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboOrderNumberDelete.setText("");
			}
		});
		comboOrderNumberDelete.setHorizontalAlignment(SwingConstants.TRAILING);
		comboOrderNumberDelete.setForeground(new Color(169, 169, 169));
		comboOrderNumberDelete.setBounds(49, 373, 190, 26);
		comboOrderNumberDelete.setEnabled(false);
		panel02.add(comboOrderNumberDelete);

		btnOrderDelete = new JButton("");
		btnOrderDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
// DELETE whole order or single article
				String custId = txtOrderCustId.getText();
				Customer tmpCustomer = controller.findCustomer(custId);
				if (tmpCustomer != null) {
					String orderNumber = comboOrderNumberDelete.getText();
					controller.deleteOrder(custId, orderNumber);
					enableLowerPartOfOrder();
					setOrderConfirmationYes();
				} else {
					setOrderConfirmationNo();
				}
			}
		});
		btnOrderDelete.setEnabled(false);
		btnOrderDelete.setBounds(295, 373, 80, 29);
		btnOrderDelete.setEnabled(false);
		panel02.add(btnOrderDelete);

		btnOrderProceed = new JButton("");
		btnOrderProceed.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		btnOrderProceed.setBounds(21, 447, 402, 47);
		btnOrderProceed.setEnabled(false);
		panel02.add(btnOrderProceed);
		
		lblOrderAdmin = new JLabel("Admin");
		lblOrderAdmin.addMouseListener(new MouseAdapter() {
			@Override
							public void mouseClicked(MouseEvent e) {
// GO TO ADMIN
				panel03.setEnabled(true);
				tabbedPane.setSelectedIndex(2);
			}
		});
		lblOrderAdmin.setEnabled(false);
		lblOrderAdmin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrderAdmin.setBackground(new Color(135, 206, 235));
		lblOrderAdmin.setForeground(new Color(0, 0, 0));
		lblOrderAdmin.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblOrderAdmin.setBounds(406, 512, 35, 14);
		panel02.add(lblOrderAdmin);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(272, 285, 80, 16);
		panel02.add(textArea);

// panel03 ============================================= panel03

		rdbtnAdminArticles = new JRadioButton("Items management ");
		rdbtnAdminArticles.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnAdminArticles.isSelected()) {
					enableUpperPartOfAdmin();
					disableMiddlePartOfAdmin();
					disableLowerPartOfAdmin();
					enableButtonsOfAdmin();
					setAdminConfirmationBlank();
				}
			}
		});
		buttonGroupAdminActivity.add(rdbtnAdminArticles);
		rdbtnAdminArticles.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		rdbtnAdminArticles.setBounds(21, 6, 263, 23);
		rdbtnAdminArticles.setEnabled(false);
		panel03.add(rdbtnAdminArticles);

		comboAdminArticleId = new JTextField();
		comboAdminArticleId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboAdminArticleId.setText("");
			}
		});
		comboAdminArticleId.setHorizontalAlignment(SwingConstants.TRAILING);
		comboAdminArticleId.setForeground(new Color(169, 169, 169));
		comboAdminArticleId.setBounds(21, 41, 190, 26);
		comboAdminArticleId.setEnabled(false);
		panel03.add(comboAdminArticleId);

		txtAdminArticleName = new JTextField();
		txtAdminArticleName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtAdminArticleName.setText("");
			}
		});
		txtAdminArticleName.setHorizontalAlignment(SwingConstants.TRAILING);
		txtAdminArticleName.setForeground(new Color(169, 169, 169));
		txtAdminArticleName.setEnabled(false);
		txtAdminArticleName.setColumns(10);
		txtAdminArticleName.setBounds(21, 79, 190, 26);
		txtAdminArticleName.setEnabled(false);
		panel03.add(txtAdminArticleName);

		txtAdminArticlePrice = new JTextField();
		txtAdminArticlePrice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtAdminArticlePrice.setText("");
			}
		});
		txtAdminArticlePrice.setHorizontalAlignment(SwingConstants.TRAILING);
		txtAdminArticlePrice.setForeground(new Color(169, 169, 169));
		txtAdminArticlePrice.setEnabled(false);
		txtAdminArticlePrice.setColumns(10);
		txtAdminArticlePrice.setBounds(233, 41, 190, 26);
		txtAdminArticlePrice.setEnabled(false);
		panel03.add(txtAdminArticlePrice);

		comboAdminArticleSupplier = new JTextField();
		comboAdminArticleSupplier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboAdminArticleSupplier.setText("");
			}
		});
		comboAdminArticleSupplier.setHorizontalAlignment(SwingConstants.TRAILING);
		comboAdminArticleSupplier.setForeground(new Color(169, 169, 169));
		comboAdminArticleSupplier.setBounds(232, 80, 191, 27);
		comboAdminArticleSupplier.setEnabled(false);
		panel03.add(comboAdminArticleSupplier);

		rdbtnAdminSuppliers = new JRadioButton("Suppliers management");
		rdbtnAdminSuppliers.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnAdminSuppliers.isSelected()) {
					disableUpperPartOfAdmin();
					enableMiddlePartOfAdmin();
					disableLowerPartOfAdmin();
					enableButtonsOfAdmin();
					setAdminConfirmationBlank();
				}
			}
		});
		buttonGroupAdminActivity.add(rdbtnAdminSuppliers);
		rdbtnAdminSuppliers.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		rdbtnAdminSuppliers.setBounds(21, 119, 263, 23);
		rdbtnAdminSuppliers.setEnabled(false);
		panel03.add(rdbtnAdminSuppliers);

		comboAdminSupplierId = new JTextField();
		comboAdminSupplierId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboAdminSupplierId.setText("");
			}
		});
		comboAdminSupplierId.setHorizontalAlignment(SwingConstants.TRAILING);
		comboAdminSupplierId.setForeground(new Color(169, 169, 169));
		comboAdminSupplierId.setEnabled(false);
		comboAdminSupplierId.setBounds(21, 154, 190, 26);
		comboAdminSupplierId.setEnabled(false);
		panel03.add(comboAdminSupplierId);

		txtAdminSupplierName = new JTextField();
		txtAdminSupplierName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtAdminSupplierName.setText("");
			}
		});
		txtAdminSupplierName.setHorizontalAlignment(SwingConstants.TRAILING);
		txtAdminSupplierName.setForeground(new Color(169, 169, 169));
		txtAdminSupplierName.setColumns(10);
		txtAdminSupplierName.setBounds(21, 192, 190, 26);
		txtAdminSupplierName.setEnabled(false);
		panel03.add(txtAdminSupplierName);

		txtAdminSupplierPhone = new JTextField();
		txtAdminSupplierPhone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtAdminSupplierPhone.setText("");
			}
		});
		txtAdminSupplierPhone.setHorizontalAlignment(SwingConstants.TRAILING);
		txtAdminSupplierPhone.setForeground(new Color(169, 169, 169));
		txtAdminSupplierPhone.setColumns(10);
		txtAdminSupplierPhone.setBounds(233, 154, 190, 26);
		txtAdminSupplierPhone.setEnabled(false);
		panel03.add(txtAdminSupplierPhone);

		comboAdminSupplierArticle = new JTextField();
		comboAdminSupplierArticle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboAdminSupplierArticle.setText("");
			}
		});
		comboAdminSupplierArticle.setHorizontalAlignment(SwingConstants.TRAILING);
		comboAdminSupplierArticle.setForeground(new Color(169, 169, 169));
		comboAdminSupplierArticle.setBounds(232, 193, 191, 27);
		comboAdminSupplierArticle.setEnabled(false);
		panel03.add(comboAdminSupplierArticle);

		rdbtnAdminClients = new JRadioButton("Clients management");
		rdbtnAdminClients.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnAdminClients.isSelected()) {
					disableUpperPartOfAdmin();
					disableMiddlePartOfAdmin();
					enableLowerPartOfAdmin();
					enableButtonsOfAdmin();
					setAdminConfirmationBlank();
				}
			}
		});
		buttonGroupAdminActivity.add(rdbtnAdminClients);
		rdbtnAdminClients.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		rdbtnAdminClients.setBounds(21, 230, 263, 23);
		rdbtnAdminClients.setEnabled(false);
		panel03.add(rdbtnAdminClients);

		comboAdminClientId = new JTextField();
		comboAdminClientId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboAdminClientId.setText("");
			}
		});
		comboAdminClientId.setHorizontalAlignment(SwingConstants.TRAILING);
		comboAdminClientId.setForeground(new Color(169, 169, 169));
		comboAdminClientId.setEnabled(false);
		comboAdminClientId.setBounds(21, 265, 190, 26);
		comboAdminClientId.setEnabled(false);
		panel03.add(comboAdminClientId);

		txtAdminClientAddress = new JTextField();
		txtAdminClientAddress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtAdminClientAddress.setText("");
			}
		});
		txtAdminClientAddress.setHorizontalAlignment(SwingConstants.TRAILING);
		txtAdminClientAddress.setForeground(new Color(169, 169, 169));
		txtAdminClientAddress.setEnabled(false);
		txtAdminClientAddress.setColumns(10);
		txtAdminClientAddress.setBounds(233, 265, 190, 26);
		txtAdminClientAddress.setEnabled(false);
		panel03.add(txtAdminClientAddress);

		txtAdminClientName = new JTextField();
		txtAdminClientName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtAdminClientName.setText("");
			}
		});
		txtAdminClientName.setHorizontalAlignment(SwingConstants.TRAILING);
		txtAdminClientName.setForeground(new Color(169, 169, 169));
		txtAdminClientName.setEnabled(false);
		txtAdminClientName.setColumns(10);
		txtAdminClientName.setBounds(21, 303, 190, 26);
		txtAdminClientName.setEnabled(false);
		panel03.add(txtAdminClientName);

		txtAdminClientPhone = new JTextField();
		txtAdminClientPhone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtAdminClientPhone.setText("");
			}
		});
		txtAdminClientPhone.setHorizontalAlignment(SwingConstants.TRAILING);
		txtAdminClientPhone.setForeground(new Color(169, 169, 169));
		txtAdminClientPhone.setEnabled(false);
		txtAdminClientPhone.setColumns(10);
		txtAdminClientPhone.setBounds(233, 303, 190, 26);
		txtAdminClientPhone.setEnabled(false);
		panel03.add(txtAdminClientPhone);

		comboAdminClientOrder = new JTextField();
		comboAdminClientOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboAdminClientOrder.setText("");
			}
		});
		comboAdminClientOrder.setHorizontalAlignment(SwingConstants.TRAILING);
		comboAdminClientOrder.setForeground(new Color(169, 169, 169));
		comboAdminClientOrder.setBounds(21, 341, 191, 27);
		comboAdminClientOrder.setEnabled(false);
		panel03.add(comboAdminClientOrder);

		txtAdminConfirmation = new JTextField();
		txtAdminConfirmation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtAdminConfirmation.setText("");
			}
		});
		txtAdminConfirmation.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdminConfirmation.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 99));
		txtAdminConfirmation.setBackground(new Color(135, 206, 235));
		txtAdminConfirmation.setBounds(48, 376, 130, 137);
		txtAdminConfirmation.setColumns(10);
		txtAdminConfirmation.setEnabled(false);
		panel03.add(txtAdminConfirmation);

		btnAdminAdd = new JButton("");
		btnAdminAdd.setEnabled(false);
		btnAdminAdd.setBounds(233, 400, 80, 29);
		btnAdminAdd.setEnabled(false);
		panel03.add(btnAdminAdd);

		btnAdminDelete = new JButton("");
		btnAdminDelete.setEnabled(false);
		btnAdminDelete.setBounds(343, 400, 80, 29);
		btnAdminDelete.setEnabled(false);
		panel03.add(btnAdminDelete);
		
		btnAdminCreate = new JButton("");
		btnAdminCreate.setEnabled(false);
		btnAdminCreate.setBounds(233, 456, 80, 29);
		panel03.add(btnAdminCreate);
		
		btnAdminFind = new JButton("");
		btnAdminFind.setEnabled(false);
		btnAdminFind.setBounds(343, 456, 80, 29);
		panel03.add(btnAdminFind);

		controller = new Controller(frameOrderMaker);
	}
	
	private void disableUpperPartOfCustomer() {
		txtCustomerId.setText("");
		txtCustomerId.setEnabled(false);
		btnCustomerEdit.setText("");
		btnCustomerEdit.setEnabled(false);
		btnCustomerDelete.setText("");
		btnCustomerDelete.setEnabled(false);
		btnCustomerCreateAnOrder.setText("");
		btnCustomerCreateAnOrder.setEnabled(false);
	}
	private void enableUpperPartOfCustomer() {
		txtCustomerId.setText("Enter customer Id");
		txtCustomerId.setEnabled(true);
		btnCustomerEdit.setText("Edit");
		btnCustomerEdit.setEnabled(true);
		btnCustomerDelete.setText("Delete");
		btnCustomerDelete.setEnabled(true);
		btnCustomerCreateAnOrder.setText("Create an order");
		btnCustomerCreateAnOrder.setEnabled(true);
	}
	private void disableMiddlePartOfCustomer() {
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
		btnCustomerAdd.setText("");
		btnCustomerAdd.setEnabled(false);
	}
	private void enableMiddlePartOfCustomer() {
		txtCustomerName.setText("Enter name");
		txtCustomerName.setEnabled(true);
		txtCustomerAddress.setText("Enter address");
		txtCustomerAddress.setEnabled(true);
		txtCustomerPhone.setText("Enter phone number");
		txtCustomerPhone.setEnabled(true);
		rdbtnCustomerPrivate.setEnabled(true);
		rdbtnCustomerCorporate.setEnabled(true);
		btnCustomerAdd.setText("Add");
		btnCustomerAdd.setEnabled(true);
	}
	
	private void disableLowerPartOfCustomer() {
		txtCustomerCheckId.setText("");
		txtCustomerCheckId.setEnabled(false);
		btnCustomerCheck.setText("");
		btnCustomerCheck.setEnabled(false);
	}
	private void enableLowerPartOfCustomer() {
		txtCustomerCheckId.setText("Enter personal/customer Id");
		txtCustomerCheckId.setEnabled(true);
		btnCustomerCheck.setText("Check");
		btnCustomerCheck.setEnabled(true);
	}
	
	private void setCustomerConfirmationYes() { txtCustomerConfirmation.setText("V"); }
	private void setCustomerConfirmationNo() { txtCustomerConfirmation.setText("X"); }
	private void setCustomerConfirmationBlank() { txtCustomerConfirmation.setText(""); }

	private void enableUpperPartOfOrder() {
		String orderIdInt = String.valueOf(random.nextInt(10000));
		String orderId = "o" + "0".repeat(4 - orderIdInt.length()) + orderIdInt;
		txtOrderNumberCreate.setText(orderId);
		String timeStamp = new SimpleDateFormat("yyyyMMdd").format(new Date());
		txtOrderDate.setText(timeStamp);
		btnOrderCreate.setText("Create");
		btnOrderCreate.setEnabled(true);
	}
	private void disableUpperPartOfOrder() {
		txtOrderNumberCreate.setText("");
		txtOrderDate.setText("");
		btnOrderCreate.setText("");
		btnOrderCreate.setEnabled(false);
	}
	private void enableMiddlePartOfOrder() {
		comboOrderNumberAdd.setText("Enter order Id");
		comboOrderNumberAdd.setEnabled(true);
		txtOrderQuantity.setText("Enter quantity");
		txtOrderQuantity.setEnabled(true);
		comboOrderArticleAdd.setText("Enter item Id");
		comboOrderArticleAdd.setEnabled(true);
		btnOrderAddLine.setText("Append");
		btnOrderAddLine.setEnabled(true);
	}
	private void disableMiddlePartOfOrder() {
		comboOrderNumberAdd.setText("");
		comboOrderNumberAdd.setEnabled(false);
		txtOrderQuantity.setText("");
		txtOrderQuantity.setEnabled(false);
		comboOrderArticleAdd.setText("");
		comboOrderArticleAdd.setEnabled(false);
		btnOrderAddLine.setText("");
		btnOrderAddLine.setEnabled(false);
	}
	private void enableLowerPartOfOrder() {
		comboOrderNumberDelete.setText("Enter order Id");
		comboOrderNumberDelete.setEnabled(true);
		btnOrderDelete.setText("Delete");
		btnOrderDelete.setEnabled(true);
	}
	private void disableLowerPartOfOrder() {
		comboOrderNumberDelete.setText("");
		comboOrderNumberDelete.setEnabled(false);
		btnOrderDelete.setText("");
		btnOrderDelete.setEnabled(false);
	}
	
	private void setOrderConfirmationYes() { txtOrderConfirmation.setText("V"); }
	private void setOrderConfirmationNo() { txtOrderConfirmation.setText("X"); }
	private void setOrderConfirmationBlank() { txtOrderConfirmation.setText(""); }

	private void enableUpperPartOfAdmin() {
		comboAdminArticleId.setText("Enter item Id");
		comboAdminArticleId.setEnabled(true);
		txtAdminArticleName.setText("Enter name");
		txtAdminArticleName.setEnabled(true);
		txtAdminArticlePrice.setText("Enter price");
		txtAdminArticlePrice.setEnabled(true);
		comboAdminArticleSupplier.setText("Enter supplier Id");
		comboAdminArticleSupplier.setEnabled(true);
	}
	private void disableUpperPartOfAdmin() {
		comboAdminArticleId.setText("");
		comboAdminArticleId.setEnabled(false);
		txtAdminArticleName.setText("");
		txtAdminArticleName.setEnabled(false);
		txtAdminArticlePrice.setText("");
		txtAdminArticlePrice.setEnabled(false);
		comboAdminArticleSupplier.setText("");
		comboAdminArticleSupplier.setEnabled(false);
	}
	private void enableMiddlePartOfAdmin() {
		comboAdminSupplierId.setText("Enter supplier Id");
		comboAdminSupplierId.setEnabled(true);
		txtAdminSupplierName.setText("Enter name");
		txtAdminSupplierName.setEnabled(true);
		txtAdminSupplierPhone.setText("Enter price");
		txtAdminSupplierPhone.setEnabled(true);
		comboAdminSupplierArticle.setText("Enter item Id");
		comboAdminSupplierArticle.setEnabled(true);
	}
	private void disableMiddlePartOfAdmin() {
		comboAdminSupplierId.setText("");
		comboAdminSupplierId.setEnabled(false);
		txtAdminSupplierName.setText("");
		txtAdminSupplierName.setEnabled(false);
		txtAdminSupplierPhone.setText("");
		txtAdminSupplierPhone.setEnabled(false);
		comboAdminSupplierArticle.setText("");
		comboAdminSupplierArticle.setEnabled(false);
	}
	private void enableLowerPartOfAdmin() {
		comboAdminClientId.setText("Enter client Id");
		comboAdminClientId.setEnabled(true);
		txtAdminClientName.setText("Enter name");
		txtAdminClientName.setEnabled(true);
		txtAdminClientAddress.setText("Enter address");
		txtAdminClientAddress.setEnabled(true);
		txtAdminClientPhone.setText("Enter phone");
		txtAdminClientPhone.setEnabled(true);
		comboAdminClientOrder.setText("Enter order Id");
		comboAdminClientOrder.setEnabled(true);
	}
	private void disableLowerPartOfAdmin() {
		comboAdminClientId.setText("");
		comboAdminClientId.setEnabled(false);
		txtAdminClientName.setText("");
		txtAdminClientName.setEnabled(false);
		txtAdminClientAddress.setText("");
		txtAdminClientAddress.setEnabled(false);
		txtAdminClientPhone.setText("");
		txtAdminClientPhone.setEnabled(false);
		comboAdminClientOrder.setText("");
		comboAdminClientOrder.setEnabled(false);
	}

	private void enableButtonsOfAdmin() {
		btnAdminAdd.setText("Add");
		btnAdminAdd.setEnabled(true);
		btnAdminCreate.setText("Create");
		btnAdminCreate.setEnabled(true);
		btnAdminDelete.setText("Delete");
		btnAdminDelete.setEnabled(true);
		btnAdminFind.setText("Find");
		btnAdminFind.setEnabled(true);
	}
	private void disableButtonsOfAdmin() {
		btnAdminAdd.setText("");
		btnAdminAdd.setEnabled(false);
		btnAdminCreate.setText("");
		btnAdminCreate.setEnabled(false);
		btnAdminDelete.setText("");
		btnAdminDelete.setEnabled(false);
		btnAdminFind.setText("");
		btnAdminFind.setEnabled(false);
	}

	private void setAdminConfirmationYes() { txtAdminConfirmation.setText("V"); }
	private void setAdminConfirmationNo() { txtAdminConfirmation.setText("X"); }
	private void setAdminConfirmationBlank() { txtAdminConfirmation.setText(""); }
}
