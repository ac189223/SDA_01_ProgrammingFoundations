package PF03.WeeklyProject03;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class View {

	private JFrame frameOrderMaker;
	private JTabbedPane tabbedPane;
	private JPanel panel01;
	private JPanel panel02;
	private JPanel panel03;
	private JPanel panel04;

	private JLabel lblCustomerAdmin;
	private JLabel lblOrderAdmin;
	private JLabel lblOrderCustId;
	private JLabel lblPreviewOrderNumer;
	private JLabel lblPreviewOrderTotal;
	private JLabel lblPreviewAdmin;
	private JLabel lbl01;
	private JLabel lbl02;
	private JLabel lbl03;
	private JLabel lbl04;
	private JLabel lbl05;
	private JLabel lbl06;
	private JLabel lbl07;
	private JLabel lbl08;
	private JLabel lbl09;
	private JLabel lbl10;
	private JLabel lbl11;
	private JLabel lbl12;
	private JLabel lbl13;
	private JLabel lbl14;
	private JLabel lbl15;
	private JLabel lbl16;
	private JLabel lbl17;
	private JLabel lbl18;
	private JLabel lbl19;
	private JLabel lbl20;
	private JLabel lbl21;
	private JLabel lbl22;
	private JLabel lbl23;
	private JLabel lbl24;
	private JLabel lbl25;
	private JLabel lbl26;
	private JLabel lbl27;
    private JLabel lbl28;
    private JTextArea lblPreviewOrderDetails1;
	private JTextArea lblPreviewOrderDetails2;
	private JTextArea lblPreviewOrderDetails3;
	private JTextArea lblPreviewOrderDetails4;
	private JRadioButton rdbtnCustomerAlreadyAClient;
	private JRadioButton rdbtnCustomerPrivate;
	private JRadioButton rdbtnCustomerNotYet;
	private JRadioButton rdbtnCustomerCorporate;
	private JRadioButton rdbtnCustomerNotSure;
	private JRadioButton rdbtnOrderDeleteArticle;
	private JRadioButton rdbtnOrderAddLine;
	private JRadioButton rdbtnOrderCreate;
	private JRadioButton rdbtnAdminArticles;
	private JRadioButton rdbtnAdminSuppliers;
	private JRadioButton rdbtnAdminClients;
	private JComboBox txtCustomerId;
	private JComboBox comboOrderNumberAdd;
	private JComboBox comboOrderNumberDelete;
	private JComboBox comboOrderArticleDelete;
	private JComboBox comboOrderArticleAdd;
	private JComboBox txtOrderQuantityAdd;
	private JComboBox txtOrderQuantityDelete;
	private JComboBox comboAdminArticleSupplier;
	private JComboBox comboAdminArticleId;
	private JComboBox comboAdminSupplierId;
	private JComboBox comboAdminSupplierArticle;
	private JComboBox comboAdminClientId;
	private JComboBox comboAdminClientType;
	private JPasswordField txtCustomerAdminPassword;
	private JPasswordField txtOrderAdminPassword;
	private JPasswordField txtPreviewAdminPassword;
	private JTextField txtCustomerName;
	private JTextField txtCustomerCheckId;
	private JTextField txtCustomerConfirmation;
	private JTextField txtCustomerAddress;
	private JTextField txtCustomerIdIn;
	private JTextField txtCustomerIdOld;
	private JTextField txtCustomerPhone;
	private JTextField txtOrderCustId;
	private JTextField txtOrderCustIdDuplicate;
	private JTextField txtOrderDate;
	private JTextField txtOrderConfirmation;
	private JTextField txtAdminConfirmation;
	private JTextField txtOrderNumberCreate;
	private JTextField txtAdminArticleName;
	private JTextField txtAdminArticlePrice;
	private JTextField txtAdminClientAddress;
	private JTextField txtAdminClientName;
	private JTextField txtAdminClientPhone;
	private JTextField txtAdminSupplierPhone;
	private JTextField txtAdminSupplierName;
	private JButton btnCustomerEdit;
	private JButton btnCustomerDelete;
	private JButton btnCustomerCheck;
	private JButton btnCustomerAdd;
	private JButton btnCustomerCreateAnOrder;
	private JButton btnCustomerPasswordCheck;
	private JButton btnOrderAddLine;
	private JButton btnOrderDelete;
	private JButton btnOrderProceed;
    private JButton btnOrderProceedDuplicate;
    private JButton btnOrderCreate;
	private JButton btnOrderPasswordCheck;
	private JButton btnPrevievPasswordCheck;
	private JButton btnPreviewBackToOrder;
	private JButton btnAdminUpdate;
	private JButton btnAdminFind;
	private JButton btnAdminAdd;
	private JButton btnAdminDelete;
	private final ButtonGroup buttonGroupIsCustomer = new ButtonGroup();
	private final ButtonGroup buttonGroupPrivateCorporate = new ButtonGroup();
	private final ButtonGroup buttonGroupOrderActivity = new ButtonGroup();
	private final ButtonGroup buttonGroupAdminActivity = new ButtonGroup();

	private Controller controller;

	private String[] listCustomersForCombo = {""};
	private String[] listArticlesForCombo = {""};
	private String[] listSuppliersForCombo = {""};
	private String[] listOrdersForCombo = {""};
	private String[] listOrdersForCustomerForCombo = {""};
	private String[] listQuantityForCombo = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	private String[] listCustomersTypeForCombo = {"", "Private", "Corporate"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
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
	View() {
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

		controller = new Controller(frameOrderMaker, this);

		tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		tabbedPane.setBackground(new Color(100, 149, 237));
		tabbedPane.setBounds(6, 6, 468, 578);
		frameOrderMaker.getContentPane().add(tabbedPane, BorderLayout.CENTER);
				
		panel01 = new JPanel();
		panel01.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				controller.setCustomerConfirmationBlank();
			}
		});
		panel01.setBorder(new LineBorder(new Color(135, 206, 235), 0, true));
		panel01.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				controller.clearTabCustomer();
			}
		});
		panel01.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Customer", null, panel01, null);
		tabbedPane.setForegroundAt(0, new Color(0, 0, 128));
		tabbedPane.setBackgroundAt(0, new Color(135, 206, 235));
		panel01.setLayout(null);
		
		panel02 = new JPanel();
		panel02.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				controller.clearTabOrder();
			}
		});
		panel02.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				controller.setOrderConfirmationBlank();
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
		panel03.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				controller.clearTabPreview();
			}
		});
		panel03.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				controller.setAdminConfirmationBlank();
			}
		});
		panel03.setBorder(new LineBorder(new Color(135, 206, 235), 0, true));
		panel03.setBackground(new Color(135, 206, 235));
		panel03.setEnabled(false);
		tabbedPane.addTab("Preview", null, panel03, null);
		tabbedPane.setEnabledAt(2, false);
		tabbedPane.setForegroundAt(2, new Color(0, 0, 128));
		tabbedPane.setBackgroundAt(2, new Color(135, 206, 235));
		panel03.setLayout(null);

		panel04 = new JPanel();
		panel04.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				controller.clearTabAdmin();
			}
		});
		panel04.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				controller.setAdminConfirmationBlank();
			}
		});
		panel04.setBorder(new LineBorder(new Color(135, 206, 235), 0, true));
		panel04.setBackground(new Color(135, 206, 235));
		panel04.setEnabled(false);
	    tabbedPane.addTab("Admin", null, panel04, null);
		tabbedPane.setEnabledAt(3, false);
		tabbedPane.setForegroundAt(3, new Color(0, 0, 128));
		tabbedPane.setBackgroundAt(3, new Color(135, 206, 235));
		panel04.setLayout(null);

// panel01 ==================    CUSTOMER    =========================== panel01

	    rdbtnCustomerAlreadyAClient = new JRadioButton("Already a client");
	    rdbtnCustomerAlreadyAClient.addChangeListener(new ChangeListener() {
	    	public void stateChanged(ChangeEvent e) {
	    		controller.enableCustomerUpper();
	    	}
	    });
	    buttonGroupIsCustomer.add(rdbtnCustomerAlreadyAClient);
	    rdbtnCustomerAlreadyAClient.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
	    rdbtnCustomerAlreadyAClient.setBounds(21, 35, 263, 23);
	    panel01.add(rdbtnCustomerAlreadyAClient);

		txtCustomerId = new JComboBox(listCustomersForCombo);
	    txtCustomerId.setForeground(new Color(169, 169, 169));
	    txtCustomerId.setBounds(49, 70, 190, 26);
	    txtCustomerId.setEnabled(false);
	    panel01.add(txtCustomerId);

		lbl01 = new JLabel("Customer Id");
		lbl01.setEnabled(false);
		lbl01.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl01.setBackground(new Color(135, 206, 235));
		lbl01.setForeground(new Color(0, 0, 0));
		lbl01.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl01.setBounds(txtCustomerId.getX() + txtCustomerId.getWidth() - 110, txtCustomerId.getY() + txtCustomerId.getHeight() - 2, 100, 11);
		panel01.add(lbl01);

		btnCustomerEdit = new JButton("");
	    btnCustomerEdit.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		controller.editCustomerData();
	    	}
	    });
	    btnCustomerEdit.setBounds(251, 70, 80, 29);
	    btnCustomerEdit.setEnabled(false);
	    panel01.add(btnCustomerEdit);
	    
	    btnCustomerDelete = new JButton("");
	    btnCustomerDelete.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		controller.deleteCustomer();
	    	}
	    });
	    btnCustomerDelete.setBounds(343, 70, 80, 29);
	    btnCustomerDelete.setEnabled(false);
	    panel01.add(btnCustomerDelete);

		rdbtnCustomerNotYet = new JRadioButton("Create an account");
		rdbtnCustomerNotYet.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				controller.enableCustomerMiddle();
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
		txtCustomerName.setToolTipText("Enter Id");
		txtCustomerName.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCustomerName.setForeground(new Color(169, 169, 169));
		txtCustomerName.setEnabled(false);
		txtCustomerName.setColumns(10);
		txtCustomerName.setBounds(49, 143, 190, 26);
		txtCustomerName.setEnabled(false);
		panel01.add(txtCustomerName);

		lbl02 = new JLabel("Customer name");
		lbl02.setEnabled(false);
		lbl02.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl02.setBackground(new Color(135, 206, 235));
		lbl02.setForeground(new Color(0, 0, 0));
		lbl02.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl02.setBounds(txtCustomerName.getX() + txtCustomerName.getWidth() - 110, txtCustomerName.getY() + txtCustomerName.getHeight() - 2, 100, 11);
		panel01.add(lbl02);

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

		lbl03 = new JLabel("Customer address");
		lbl03.setEnabled(false);
		lbl03.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl03.setBackground(new Color(135, 206, 235));
		lbl03.setForeground(new Color(0, 0, 0));
		lbl03.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl03.setBounds(txtCustomerAddress.getX() + txtCustomerAddress.getWidth() - 110, txtCustomerAddress.getY() + txtCustomerAddress.getHeight() - 2, 100, 11);
		panel01.add(lbl03);

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

		lbl04 = new JLabel("Customer phone");
		lbl04.setEnabled(false);
		lbl04.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl04.setBackground(new Color(135, 206, 235));
		lbl04.setForeground(new Color(0, 0, 0));
		lbl04.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl04.setBounds(txtCustomerPhone.getX() + txtCustomerPhone.getWidth() - 110, txtCustomerPhone.getY() + txtCustomerPhone.getHeight() - 2, 100, 11);
		panel01.add(lbl04);

		rdbtnCustomerPrivate = new JRadioButton("");
		rdbtnCustomerPrivate.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				controller.updateCustomerTypeSelection();
			}
		});
		buttonGroupPrivateCorporate.add(rdbtnCustomerPrivate);
		rdbtnCustomerPrivate.setText("Private");
		rdbtnCustomerPrivate.setBounds(61, 257, 141, 23);
		rdbtnCustomerPrivate.setEnabled(false);
		panel01.add(rdbtnCustomerPrivate);
		
		rdbtnCustomerCorporate = new JRadioButton("");
		rdbtnCustomerCorporate.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				controller.updateCustomerTypeSelection();
			}
		});
		buttonGroupPrivateCorporate.add(rdbtnCustomerCorporate);
		rdbtnCustomerCorporate.setText("Corporate");
		rdbtnCustomerCorporate.setBounds(61, 292, 141, 23);
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

		lbl05 = new JLabel("Customer Id");
		lbl05.setEnabled(false);
		lbl05.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl05.setBackground(new Color(135, 206, 235));
		lbl05.setForeground(new Color(0, 0, 0));
		lbl05.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl05.setBounds(txtCustomerIdIn.getX() + txtCustomerIdIn.getWidth() - 110, txtCustomerIdIn.getY() + txtCustomerIdIn.getHeight() - 2, 100, 11);
		panel01.add(lbl05);

		txtCustomerIdOld = new JTextField();
		txtCustomerIdOld.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCustomerIdOld.setForeground(new Color(169, 169, 169));
		txtCustomerIdOld.setColumns(10);
		txtCustomerIdOld.setBounds(49, 327, 190, 26);
		txtCustomerIdOld.setVisible(false);
		txtCustomerIdOld.setEnabled(false);
		panel01.add(txtCustomerIdOld);

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
				controller.addCustomerUpdateData();
			}
		});
		btnCustomerAdd.setEnabled(false);
		btnCustomerAdd.setBounds(295, 327, 80, 29);
		btnCustomerAdd.setEnabled(false);
		panel01.add(btnCustomerAdd);
		
		rdbtnCustomerNotSure = new JRadioButton("Check id number");
		rdbtnCustomerNotSure.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				controller.enableCustomerLower();
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

		lbl06 = new JLabel("Customer Id");
		lbl06.setEnabled(false);
		lbl06.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl06.setBackground(new Color(135, 206, 235));
		lbl06.setForeground(new Color(0, 0, 0));
		lbl06.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl06.setBounds(txtCustomerCheckId.getX() + txtCustomerCheckId.getWidth() - 110, txtCustomerCheckId.getY() + txtCustomerCheckId.getHeight() - 2, 100, 11);
		panel01.add(lbl06);

		btnCustomerCheck = new JButton("");
		btnCustomerCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.searchForCustomer();
			}
		});
		btnCustomerCheck.setEnabled(false);
		btnCustomerCheck.setBounds(295, 400, 80, 29);
		btnCustomerCheck.setEnabled(false);
		panel01.add(btnCustomerCheck);

		btnCustomerCreateAnOrder = new JButton("");
		btnCustomerCreateAnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.goToOrderTabAsCustomer();
			}
		});
		btnCustomerCreateAnOrder.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		btnCustomerCreateAnOrder.setBounds(21, 455, 402, 47);
		btnCustomerCreateAnOrder.setEnabled(false);
		panel01.add(btnCustomerCreateAnOrder);

		txtCustomerAdminPassword = new JPasswordField();
		txtCustomerAdminPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCustomerAdminPassword.setEchoChar('*');
				txtCustomerAdminPassword.setText("");
			}
		});
		txtCustomerAdminPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		txtCustomerAdminPassword.setForeground(new Color(169, 169, 169));
		txtCustomerAdminPassword.setVisible(false);
		txtCustomerAdminPassword.setEnabled(false);
		txtCustomerAdminPassword.setColumns(10);
		txtCustomerAdminPassword.setBounds(89, 500, 150, 26);
		txtCustomerAdminPassword.setEnabled(false);
		panel01.add(txtCustomerAdminPassword);

		btnCustomerPasswordCheck = new JButton("");
		btnCustomerPasswordCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.actionAfterPasswordEntered();
			}
		});
		btnCustomerPasswordCheck.setVisible(false);
		btnCustomerPasswordCheck.setEnabled(false);
		btnCustomerPasswordCheck.setBounds(295, 500, 80, 29);
		btnCustomerPasswordCheck.setEnabled(false);
		panel01.add(btnCustomerPasswordCheck);

		lblCustomerAdmin = new JLabel("Admin");
		lblCustomerAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.adminLinkPressed();
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
		txtOrderCustId.setHorizontalAlignment(SwingConstants.TRAILING);
		txtOrderCustId.setColumns(10);
		txtOrderCustId.setForeground(new Color(169, 169, 169));
		txtOrderCustId.setBounds(233, 20, 190, 26);
		txtOrderCustId.setVisible(false);
		txtOrderCustId.setEnabled(false);
		panel02.add(txtOrderCustId);

		txtOrderCustIdDuplicate = new JTextField();
		txtOrderCustIdDuplicate.setHorizontalAlignment(SwingConstants.TRAILING);
		txtOrderCustIdDuplicate.setColumns(10);
		txtOrderCustIdDuplicate.setForeground(new Color(169, 169, 169));
		txtOrderCustIdDuplicate.setBounds(233, 20, 190, 26);
		txtOrderCustIdDuplicate.setEnabled(false);
		panel02.add(txtOrderCustIdDuplicate);

		lbl26 = new JLabel("Customer Id");
		lbl26.setEnabled(false);
		lbl26.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl26.setBackground(new Color(135, 206, 235));
		lbl26.setForeground(new Color(0, 0, 0));
		lbl26.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl26.setBounds(txtOrderCustId.getX() + txtOrderCustId.getWidth() - 110, txtOrderCustId.getY() + txtOrderCustId.getHeight() - 2, 100, 11);
		panel02.add(lbl26);

		rdbtnOrderCreate = new JRadioButton("Create new order");
		rdbtnOrderCreate.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				controller.enableOrderUpper();
			}
		});
		buttonGroupOrderActivity.add(rdbtnOrderCreate);
		rdbtnOrderCreate.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		rdbtnOrderCreate.setBounds(21, 33, 263, 23);
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
		txtOrderNumberCreate.setBounds(49, 68, 190, 26);
		panel02.add(txtOrderNumberCreate);

		lbl07 = new JLabel("Order Id");
		lbl07.setEnabled(false);
		lbl07.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl07.setBackground(new Color(135, 206, 235));
		lbl07.setForeground(new Color(0, 0, 0));
		lbl07.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl07.setBounds(txtOrderNumberCreate.getX() + txtOrderNumberCreate.getWidth() - 110, txtOrderNumberCreate.getY() + txtOrderNumberCreate.getHeight() - 2, 100, 11);
		panel02.add(lbl07);

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
		txtOrderDate.setBounds(49, 106, 190, 26);
		txtOrderDate.setEnabled(false);
		panel02.add(txtOrderDate);

		lbl08 = new JLabel("Order date");
		lbl08.setEnabled(false);
		lbl08.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl08.setBackground(new Color(135, 206, 235));
		lbl08.setForeground(new Color(0, 0, 0));
		lbl08.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl08.setBounds(txtOrderDate.getX() + txtOrderDate.getWidth() - 110, txtOrderDate.getY() + txtOrderDate.getHeight() - 2, 100, 11);
		panel02.add(lbl08);

		btnOrderCreate = new JButton("");
		btnOrderCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.addNewOrderAsClient();
			}
		});
		btnOrderCreate.setEnabled(false);
		btnOrderCreate.setBounds(295, 104, 80, 29);
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
		txtOrderConfirmation.setBounds(272, 229, 130, 137);
		txtOrderConfirmation.setColumns(10);
		txtOrderConfirmation.setEnabled(false);
		panel02.add(txtOrderConfirmation);

		rdbtnOrderAddLine = new JRadioButton("Add new item");
		rdbtnOrderAddLine.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				controller.enableOrderMiddle();
			}
		});
		buttonGroupOrderActivity.add(rdbtnOrderAddLine);
		rdbtnOrderAddLine.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		rdbtnOrderAddLine.setBounds(21, 144, 263, 23);
		rdbtnOrderAddLine.setEnabled(false);
		panel02.add(rdbtnOrderAddLine);

		comboOrderNumberAdd = new JComboBox(listOrdersForCustomerForCombo);
		comboOrderNumberAdd.setForeground(new Color(169, 169, 169));
		comboOrderNumberAdd.setBounds(49, 179, 190, 26);
		comboOrderNumberAdd.setEnabled(false);
		panel02.add(comboOrderNumberAdd);

		lbl09 = new JLabel("Order Id");
		lbl09.setEnabled(false);
		lbl09.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl09.setBackground(new Color(135, 206, 235));
		lbl09.setForeground(new Color(0, 0, 0));
		lbl09.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl09.setBounds(comboOrderNumberAdd.getX() + comboOrderNumberAdd.getWidth() - 110, comboOrderNumberAdd.getY() + comboOrderNumberAdd.getHeight() - 2, 100, 11);
		panel02.add(lbl09);

		comboOrderArticleAdd = new JComboBox(listArticlesForCombo);
		comboOrderArticleAdd.setForeground(new Color(169, 169, 169));
		comboOrderArticleAdd.setBounds(49, 214, 190, 27);
		comboOrderArticleAdd.setEnabled(false);
		panel02.add(comboOrderArticleAdd);

		lbl11 = new JLabel("Item Id");
		lbl11.setEnabled(false);
		lbl11.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl11.setBackground(new Color(135, 206, 235));
		lbl11.setForeground(new Color(0, 0, 0));
		lbl11.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl11.setBounds(comboOrderArticleAdd.getX() + comboOrderArticleAdd.getWidth() - 110, comboOrderArticleAdd.getY() + comboOrderArticleAdd.getHeight() - 2, 100, 11);
		panel02.add(lbl11);

		txtOrderQuantityAdd = new JComboBox(listQuantityForCombo);
		txtOrderQuantityAdd.setForeground(new Color(169, 169, 169));
		txtOrderQuantityAdd.setEnabled(false);
		txtOrderQuantityAdd.setBounds(49, 252, 190, 26);
		panel02.add(txtOrderQuantityAdd);

		lbl10 = new JLabel("Quantity");
		lbl10.setEnabled(false);
		lbl10.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl10.setBackground(new Color(135, 206, 235));
		lbl10.setForeground(new Color(0, 0, 0));
		lbl10.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl10.setBounds(txtOrderQuantityAdd.getX() + txtOrderQuantityAdd.getWidth() - 110, txtOrderQuantityAdd.getY() + txtOrderQuantityAdd.getHeight() - 2, 100, 11);
		panel02.add(lbl10);

		btnOrderAddLine = new JButton("");
		btnOrderAddLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.addNewOrderLineAsClient();
			}
		});
		btnOrderAddLine.setBounds(295, 177, 80, 29);
		btnOrderAddLine.setEnabled(false);
		panel02.add(btnOrderAddLine);

		rdbtnOrderDeleteArticle = new JRadioButton("Delete whole order or item");
		rdbtnOrderDeleteArticle.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				controller.enableOrderLower();
			}
		});
		buttonGroupOrderActivity.add(rdbtnOrderDeleteArticle);
		rdbtnOrderDeleteArticle.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		rdbtnOrderDeleteArticle.setBounds(21, 294, 263, 23);
		rdbtnOrderDeleteArticle.setEnabled(false);
		panel02.add(rdbtnOrderDeleteArticle);

		comboOrderNumberDelete = new JComboBox(listOrdersForCustomerForCombo);
		comboOrderNumberDelete.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				controller.customizeArticleToComboBoxesList();
			}
		});
		comboOrderNumberDelete.setForeground(new Color(169, 169, 169));
		comboOrderNumberDelete.setBounds(49, 332, 190, 26);
		comboOrderNumberDelete.setEnabled(false);
		panel02.add(comboOrderNumberDelete);

		lbl12 = new JLabel("Order Id");
		lbl12.setEnabled(false);
		lbl12.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl12.setBackground(new Color(135, 206, 235));
		lbl12.setForeground(new Color(0, 0, 0));
		lbl12.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl12.setBounds(comboOrderNumberDelete.getX() + comboOrderNumberDelete.getWidth() - 110, comboOrderNumberDelete.getY() + comboOrderNumberDelete.getHeight() - 2, 100, 11);
		panel02.add(lbl12);

		comboOrderArticleDelete = new JComboBox(listArticlesForCombo);
		comboOrderArticleDelete.setForeground(new Color(169, 169, 169));
		comboOrderArticleDelete.setBounds(49, 370, 190, 26);
		comboOrderArticleDelete.setEnabled(false);
		panel02.add(comboOrderArticleDelete);

		lbl13 = new JLabel("Item Id");
		lbl13.setEnabled(false);
		lbl13.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl13.setBackground(new Color(135, 206, 235));
		lbl13.setForeground(new Color(0, 0, 0));
		lbl13.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl13.setBounds(comboOrderArticleDelete.getX() + comboOrderArticleDelete.getWidth() - 110, comboOrderArticleDelete.getY() + comboOrderArticleDelete.getHeight() - 2, 100, 11);
		panel02.add(lbl13);

		btnOrderDelete = new JButton("");
		btnOrderDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.deleteOrderAsClient();
			}
		});
		btnOrderDelete.setEnabled(false);
		btnOrderDelete.setBounds(295, 408, 80, 29);
		btnOrderDelete.setEnabled(false);
		panel02.add(btnOrderDelete);

		txtOrderQuantityDelete = new JComboBox(listQuantityForCombo);
		txtOrderQuantityDelete.addItem("all");
		txtOrderQuantityDelete.setForeground(new Color(169, 169, 169));
		txtOrderQuantityDelete.setEnabled(false);
		txtOrderQuantityDelete.setBounds(49, 408, 190, 26);
		panel02.add(txtOrderQuantityDelete);

		lbl27 = new JLabel("Quantity");
		lbl27.setEnabled(false);
		lbl27.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl27.setBackground(new Color(135, 206, 235));
		lbl27.setForeground(new Color(0, 0, 0));
		lbl27.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl27.setBounds(txtOrderQuantityDelete.getX() + txtOrderQuantityDelete.getWidth() - 110, txtOrderQuantityDelete.getY() + txtOrderQuantityDelete.getHeight() - 2, 100, 11);
		panel02.add(lbl27);

		btnOrderProceed = new JButton("");
		btnOrderProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.goToPreview();
			}
		});
		btnOrderProceed.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		btnOrderProceed.setBounds(21, 455, 402, 47);
		btnOrderProceed.setEnabled(false);
        btnOrderProceed.setVisible(false);
        panel02.add(btnOrderProceed);

        btnOrderProceedDuplicate = new JButton("");
        btnOrderProceedDuplicate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.goToPreview();
            }
        });
        btnOrderProceedDuplicate.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
        btnOrderProceedDuplicate.setBounds(21, 455, 402, 47);
        btnOrderProceedDuplicate.setEnabled(false);
        panel02.add(btnOrderProceedDuplicate);

        txtOrderAdminPassword = new JPasswordField();
		txtOrderAdminPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtOrderAdminPassword.setEchoChar('*');
				txtOrderAdminPassword.setText("");
			}
		});
		txtOrderAdminPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		txtOrderAdminPassword.setForeground(new Color(169, 169, 169));
		txtOrderAdminPassword.setVisible(false);
		txtOrderAdminPassword.setEnabled(false);
		txtOrderAdminPassword.setColumns(10);
		txtOrderAdminPassword.setBounds(89, 500, 150, 26);
		txtOrderAdminPassword.setEnabled(false);
		panel02.add(txtOrderAdminPassword);

		btnOrderPasswordCheck = new JButton("");
		btnOrderPasswordCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.actionAfterPasswordEntered();
			}
		});
		btnOrderPasswordCheck.setVisible(false);
		btnOrderPasswordCheck.setEnabled(false);
		btnOrderPasswordCheck.setBounds(295, 500, 80, 29);
		btnOrderPasswordCheck.setEnabled(false);
		panel02.add(btnOrderPasswordCheck);

		lblOrderAdmin = new JLabel("Admin");
		lblOrderAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.adminLinkPressed();
			}
		});
		lblOrderAdmin.setEnabled(false);
		lblOrderAdmin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrderAdmin.setBackground(new Color(135, 206, 235));
		lblOrderAdmin.setForeground(new Color(0, 0, 0));
		lblOrderAdmin.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblOrderAdmin.setBounds(406, 512, 35, 14);
		panel02.add(lblOrderAdmin);

// panel03 ==================    PREVIEW    =========================== panel03


		lblPreviewOrderNumer = new JLabel("");
		lblPreviewOrderNumer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreviewOrderNumer.setEnabled(false);
		lblPreviewOrderNumer.setForeground(new Color(0, 0, 128));
		lblPreviewOrderNumer.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		lblPreviewOrderNumer.setBounds(21, 40, 402, 23);
		panel03.add(lblPreviewOrderNumer);

		lblPreviewOrderDetails1 = new JTextArea("");
		lblPreviewOrderDetails1.setEnabled(false);
		lblPreviewOrderDetails1.setForeground(new Color(0, 0, 128));
		lblPreviewOrderDetails1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblPreviewOrderDetails1.setBounds(21, 90, 85, 290);
		panel03.add(lblPreviewOrderDetails1);

		lblPreviewOrderDetails2 = new JTextArea("");
		lblPreviewOrderDetails2.setEnabled(false);
		lblPreviewOrderDetails2.setForeground(new Color(0, 0, 128));
		lblPreviewOrderDetails2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblPreviewOrderDetails2.setBounds(126, 90, 85, 290);
		panel03.add(lblPreviewOrderDetails2);

		lblPreviewOrderDetails3 = new JTextArea("");
		lblPreviewOrderDetails3.setEnabled(false);
		lblPreviewOrderDetails3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblPreviewOrderDetails3.setForeground(new Color(0, 0, 128));
		lblPreviewOrderDetails3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblPreviewOrderDetails3.setBounds(231, 90, 85, 290);
		panel03.add(lblPreviewOrderDetails3);

		lblPreviewOrderDetails4 = new JTextArea("");
		lblPreviewOrderDetails4.setEnabled(false);
		lblPreviewOrderDetails4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblPreviewOrderDetails4.setForeground(new Color(0, 0, 128));
		lblPreviewOrderDetails4.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblPreviewOrderDetails4.setBounds(336, 90, 85, 290);
		panel03.add(lblPreviewOrderDetails4);

		lblPreviewOrderTotal = new JLabel("");
		lblPreviewOrderTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreviewOrderTotal.setEnabled(false);
		lblPreviewOrderTotal.setForeground(new Color(0, 0, 128));
		lblPreviewOrderTotal.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblPreviewOrderTotal.setBounds(21, 400, 402, 40);
		panel03.add(lblPreviewOrderTotal);

		btnPreviewBackToOrder = new JButton("");
		btnPreviewBackToOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.goToOrderFromPreview();
			}
		});
		btnPreviewBackToOrder.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		btnPreviewBackToOrder.setBounds(21, 455, 402, 47);
		btnPreviewBackToOrder.setEnabled(false);
		panel03.add(btnPreviewBackToOrder);

		txtPreviewAdminPassword = new JPasswordField();
		txtPreviewAdminPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPreviewAdminPassword.setEchoChar('*');
				txtPreviewAdminPassword.setText("");
			}
		});
		txtPreviewAdminPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		txtPreviewAdminPassword.setForeground(new Color(169, 169, 169));
		txtPreviewAdminPassword.setVisible(false);
		txtPreviewAdminPassword.setEnabled(false);
		txtPreviewAdminPassword.setColumns(10);
		txtPreviewAdminPassword.setBounds(89, 500, 150, 26);
		txtPreviewAdminPassword.setEnabled(false);
		panel03.add(txtPreviewAdminPassword);

		btnPrevievPasswordCheck = new JButton("");
		btnPrevievPasswordCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.actionAfterPasswordEntered();
			}
		});
		btnPrevievPasswordCheck.setVisible(false);
		btnPrevievPasswordCheck.setEnabled(false);
		btnPrevievPasswordCheck.setBounds(295, 500, 80, 29);
		btnPrevievPasswordCheck.setEnabled(false);
		panel03.add(btnPrevievPasswordCheck);

		lblPreviewAdmin = new JLabel("Admin");
		lblPreviewAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.adminLinkPressed();
			}
		});
		lblPreviewAdmin.setEnabled(false);
		//lblPreviewAdmin.setVisible(false);
		lblPreviewAdmin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreviewAdmin.setBackground(new Color(135, 206, 235));
		lblPreviewAdmin.setForeground(new Color(0, 0, 0));
		lblPreviewAdmin.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblPreviewAdmin.setBounds(406, 512, 35, 14);
		panel03.add(lblPreviewAdmin);

// panel04 ========================        ADMIN        ===================== panel04

		rdbtnAdminArticles = new JRadioButton("Items management ");
		rdbtnAdminArticles.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				controller.enableAdminUpper();
			}
		});
		buttonGroupAdminActivity.add(rdbtnAdminArticles);
		rdbtnAdminArticles.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		rdbtnAdminArticles.setBounds(21, 16, 263, 23);
		rdbtnAdminArticles.setEnabled(false);
		panel04.add(rdbtnAdminArticles);

		comboAdminArticleId = new JComboBox(listArticlesForCombo);
		comboAdminArticleId.setEditable(true);
		comboAdminArticleId.setForeground(new Color(169, 169, 169));
		comboAdminArticleId.setBounds(21, 51, 190, 26);
		comboAdminArticleId.setEnabled(false);
		panel04.add(comboAdminArticleId);

		lbl14 = new JLabel("Item Id");
		lbl14.setEnabled(false);
		lbl14.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl14.setBackground(new Color(135, 206, 235));
		lbl14.setForeground(new Color(0, 0, 0));
		lbl14.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl14.setBounds(comboAdminArticleId.getX() + comboAdminArticleId.getWidth() - 110, comboAdminArticleId.getY() + comboAdminArticleId.getHeight() - 2, 100, 11);
		panel04.add(lbl14);

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
		txtAdminArticleName.setBounds(21, 89, 190, 26);
		txtAdminArticleName.setEnabled(false);
		panel04.add(txtAdminArticleName);

		lbl15 = new JLabel("Item name");
		lbl15.setEnabled(false);
		lbl15.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl15.setBackground(new Color(135, 206, 235));
		lbl15.setForeground(new Color(0, 0, 0));
		lbl15.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl15.setBounds(txtAdminArticleName.getX() + txtAdminArticleName.getWidth() - 110, txtAdminArticleName.getY() + txtAdminArticleName.getHeight() - 2, 100, 11);
		panel04.add(lbl15);

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
		txtAdminArticlePrice.setBounds(233, 51, 190, 26);
		txtAdminArticlePrice.setEnabled(false);
		panel04.add(txtAdminArticlePrice);

		lbl16 = new JLabel("Item price");
		lbl16.setEnabled(false);
		lbl16.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl16.setBackground(new Color(135, 206, 235));
		lbl16.setForeground(new Color(0, 0, 0));
		lbl16.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl16.setBounds(txtAdminArticlePrice.getX() + txtAdminArticlePrice.getWidth() - 110, txtAdminArticlePrice.getY() + txtAdminArticlePrice.getHeight() - 2, 100, 11);
		panel04.add(lbl16);

		comboAdminArticleSupplier = new JComboBox(listSuppliersForCombo);
		comboAdminArticleSupplier.setForeground(new Color(169, 169, 169));
		comboAdminArticleSupplier.setBounds(232, 90, 191, 27);
		comboAdminArticleSupplier.setEnabled(false);
		panel04.add(comboAdminArticleSupplier);

		lbl17 = new JLabel("Supplier Id");
		lbl17.setEnabled(false);
		lbl17.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl17.setBackground(new Color(135, 206, 235));
		lbl17.setForeground(new Color(0, 0, 0));
		lbl17.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl17.setBounds(comboAdminArticleSupplier.getX() + comboAdminArticleSupplier.getWidth() - 110, comboAdminArticleSupplier.getY() + comboAdminArticleSupplier.getHeight() - 2, 100, 11);
		panel04.add(lbl17);

		rdbtnAdminSuppliers = new JRadioButton("Suppliers management");
		rdbtnAdminSuppliers.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				controller.enableAdminMiddle();
			}
		});
		buttonGroupAdminActivity.add(rdbtnAdminSuppliers);
		rdbtnAdminSuppliers.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		rdbtnAdminSuppliers.setBounds(21, 129, 263, 23);
		rdbtnAdminSuppliers.setEnabled(false);
		panel04.add(rdbtnAdminSuppliers);

		comboAdminSupplierId = new JComboBox(listSuppliersForCombo);
		comboAdminSupplierId.setEditable(true);
		comboAdminSupplierId.setForeground(new Color(169, 169, 169));
		comboAdminSupplierId.setEnabled(false);
		comboAdminSupplierId.setBounds(21, 164, 190, 26);
		comboAdminSupplierId.setEnabled(false);
		panel04.add(comboAdminSupplierId);

		lbl18 = new JLabel("Supplier Id");
		lbl18.setEnabled(false);
		lbl18.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl18.setBackground(new Color(135, 206, 235));
		lbl18.setForeground(new Color(0, 0, 0));
		lbl18.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl18.setBounds(comboAdminSupplierId.getX() + comboAdminSupplierId.getWidth() - 110, comboAdminSupplierId.getY() + comboAdminSupplierId.getHeight() - 2, 100, 11);
		panel04.add(lbl18);

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
		txtAdminSupplierName.setBounds(21, 202, 190, 26);
		txtAdminSupplierName.setEnabled(false);
		panel04.add(txtAdminSupplierName);

		lbl19 = new JLabel("Supplier name");
		lbl19.setEnabled(false);
		lbl19.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl19.setBackground(new Color(135, 206, 235));
		lbl19.setForeground(new Color(0, 0, 0));
		lbl19.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl19.setBounds(txtAdminSupplierName.getX() + txtAdminSupplierName.getWidth() - 110, txtAdminSupplierName.getY() + txtAdminSupplierName.getHeight() - 2, 100, 11);
		panel04.add(lbl19);

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
		txtAdminSupplierPhone.setBounds(233, 164, 190, 26);
		txtAdminSupplierPhone.setEnabled(false);
		panel04.add(txtAdminSupplierPhone);

		lbl20 = new JLabel("Supplier phone");
		lbl20.setEnabled(false);
		lbl20.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl20.setBackground(new Color(135, 206, 235));
		lbl20.setForeground(new Color(0, 0, 0));
		lbl20.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl20.setBounds(txtAdminSupplierPhone.getX() + txtAdminSupplierPhone.getWidth() - 110, txtAdminSupplierPhone.getY() + txtAdminSupplierPhone.getHeight() - 2, 100, 11);
		panel04.add(lbl20);

		comboAdminSupplierArticle = new JComboBox(listArticlesForCombo);
		comboAdminSupplierArticle.setForeground(new Color(169, 169, 169));
		comboAdminSupplierArticle.setBounds(232, 203, 191, 27);
		comboAdminSupplierArticle.setEnabled(false);
		panel04.add(comboAdminSupplierArticle);

		lbl21 = new JLabel("Item Id");
		lbl21.setEnabled(false);
		lbl21.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl21.setBackground(new Color(135, 206, 235));
		lbl21.setForeground(new Color(0, 0, 0));
		lbl21.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl21.setBounds(comboAdminSupplierArticle.getX() + comboAdminSupplierArticle.getWidth() - 110, comboAdminSupplierArticle.getY() + comboAdminSupplierArticle.getHeight() - 2, 100, 11);
		panel04.add(lbl21);

		rdbtnAdminClients = new JRadioButton("Clients management");
		rdbtnAdminClients.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				controller.enableAdminLower();
			}
		});
		buttonGroupAdminActivity.add(rdbtnAdminClients);
		rdbtnAdminClients.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		rdbtnAdminClients.setBounds(21, 240, 263, 23);
		rdbtnAdminClients.setEnabled(false);
		panel04.add(rdbtnAdminClients);

		comboAdminClientId = new JComboBox(listCustomersForCombo);
		comboAdminClientId.setEditable(true);
		comboAdminClientId.setForeground(new Color(169, 169, 169));
		comboAdminClientId.setEnabled(false);
		comboAdminClientId.setBounds(21, 275, 190, 26);
		comboAdminClientId.setEnabled(false);
		panel04.add(comboAdminClientId);

		lbl22 = new JLabel("Client Id");
		lbl22.setEnabled(false);
		lbl22.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl22.setBackground(new Color(135, 206, 235));
		lbl22.setForeground(new Color(0, 0, 0));
		lbl22.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl22.setBounds(comboAdminClientId.getX() + comboAdminClientId.getWidth() - 110, comboAdminClientId.getY() + comboAdminClientId.getHeight() - 2, 100, 11);
		panel04.add(lbl22);

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
		txtAdminClientAddress.setBounds(233, 275, 190, 26);
		txtAdminClientAddress.setEnabled(false);
		panel04.add(txtAdminClientAddress);

		lbl23 = new JLabel("Client address");
		lbl23.setEnabled(false);
		lbl23.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl23.setBackground(new Color(135, 206, 235));
		lbl23.setForeground(new Color(0, 0, 0));
		lbl23.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl23.setBounds(txtAdminClientAddress.getX() + txtAdminClientAddress.getWidth() - 110, txtAdminClientAddress.getY() + txtAdminClientAddress.getHeight() - 2, 100, 11);
		panel04.add(lbl23);

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
		txtAdminClientName.setBounds(21, 313, 190, 26);
		txtAdminClientName.setEnabled(false);
		panel04.add(txtAdminClientName);

		lbl24 = new JLabel("Client name");
		lbl24.setEnabled(false);
		lbl24.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl24.setBackground(new Color(135, 206, 235));
		lbl24.setForeground(new Color(0, 0, 0));
		lbl24.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl24.setBounds(txtAdminClientName.getX() + txtAdminClientName.getWidth() - 110, txtAdminClientName.getY() + txtAdminClientName.getHeight() - 2, 100, 11);
		panel04.add(lbl24);

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
		txtAdminClientPhone.setBounds(233, 313, 190, 26);
		txtAdminClientPhone.setEnabled(false);
		panel04.add(txtAdminClientPhone);

		lbl25 = new JLabel("Client phone");
		lbl25.setEnabled(false);
		lbl25.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl25.setBackground(new Color(135, 206, 235));
		lbl25.setForeground(new Color(0, 0, 0));
		lbl25.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lbl25.setBounds(txtAdminClientPhone.getX() + txtAdminClientPhone.getWidth() - 110, txtAdminClientPhone.getY() + txtAdminClientPhone.getHeight() - 2, 100, 11);
		panel04.add(lbl25);

        comboAdminClientType = new JComboBox(listCustomersTypeForCombo);
        comboAdminClientType.setEditable(false);
        comboAdminClientType.setForeground(new Color(169, 169, 169));
        comboAdminClientType.setEnabled(false);
        comboAdminClientType.setBounds(233, 351, 190, 26);
        comboAdminClientType.setEnabled(false);
        panel04.add(comboAdminClientType);

        lbl28 = new JLabel("Client type");
        lbl28.setEnabled(false);
        lbl28.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl28.setBackground(new Color(135, 206, 235));
        lbl28.setForeground(new Color(0, 0, 0));
        lbl28.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
        lbl28.setBounds(comboAdminClientType.getX() + comboAdminClientType.getWidth() - 110, comboAdminClientType.getY() + comboAdminClientType.getHeight() - 2, 100, 11);
        panel04.add(lbl28);

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
		txtAdminConfirmation.setBounds(48, 371, 130, 137);
		txtAdminConfirmation.setColumns(10);
		txtAdminConfirmation.setEnabled(false);
		panel04.add(txtAdminConfirmation);

		btnAdminAdd = new JButton("");
        btnAdminAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.addAsAdmin();
            }
        });
        btnAdminAdd.setEnabled(false);
		btnAdminAdd.setBounds(233, 423, 80, 29);
		btnAdminAdd.setEnabled(false);
		panel04.add(btnAdminAdd);

		btnAdminDelete = new JButton("");
        btnAdminDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.deleteAsAdmin();
            }
        });
        btnAdminDelete.setEnabled(false);
		btnAdminDelete.setBounds(343, 423, 80, 29);
		btnAdminDelete.setEnabled(false);
		panel04.add(btnAdminDelete);
		
		btnAdminUpdate = new JButton("");
        btnAdminUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.updateAsAdmin();
            }
        });
        btnAdminUpdate.setEnabled(false);
		btnAdminUpdate.setBounds(233, 479, 80, 29);
		panel04.add(btnAdminUpdate);
		
		btnAdminFind = new JButton("");
        btnAdminFind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.findAsAdmin();
            }
        });
        btnAdminFind.setEnabled(false);
		btnAdminFind.setBounds(343, 479, 80, 29);
		panel04.add(btnAdminFind);

		controller.initializeData();
	}

	public JFrame getFrameOrderMaker() { return frameOrderMaker; }
	public void setFrameOrderMaker(JFrame frameOrderMaker) { this.frameOrderMaker = frameOrderMaker; }

	public JTabbedPane getTabbedPane() { return tabbedPane; }
	public void setTabbedPane(JTabbedPane tabbedPane) { this.tabbedPane = tabbedPane; }

	public JPanel getPanel01() { return panel01; }
	public void setPanel01(JPanel panel01) { this.panel01 = panel01; }

	public JPanel getPanel02() { return panel02; }
	public void setPanel02(JPanel panel02) { this.panel02 = panel02; }

	public JPanel getPanel03() { return panel03; }
	public void setPanel03(JPanel panel03) { this.panel03 = panel03; }

	public JPanel getPanel04() { return panel04; }
	public void setPanel04(JPanel panel04) { this.panel04 = panel04; }

	public JLabel getLblCustomerAdmin() { return lblCustomerAdmin; }
	public void setLblCustomerAdmin(JLabel lblCustomerAdmin) { this.lblCustomerAdmin = lblCustomerAdmin; }

	public JLabel getLblOrderAdmin() { return lblOrderAdmin; }
	public void setLblOrderAdmin(JLabel lblOrderAdmin) { this.lblOrderAdmin = lblOrderAdmin; }

	public JLabel getLblOrderCustId() { return lblOrderCustId; }
	public void setLblOrderCustId(JLabel lblOrderCustId) { this.lblOrderCustId = lblOrderCustId; }

	public JRadioButton getRdbtnCustomerAlreadyAClient() { return rdbtnCustomerAlreadyAClient; }
	public void setRdbtnCustomerAlreadyAClient(JRadioButton rdbtnCustomerAlreadyAClient) { this.rdbtnCustomerAlreadyAClient = rdbtnCustomerAlreadyAClient; }

	public JRadioButton getRdbtnCustomerPrivate() { return rdbtnCustomerPrivate; }
	public void setRdbtnCustomerPrivate(JRadioButton rdbtnCustomerPrivate) { this.rdbtnCustomerPrivate = rdbtnCustomerPrivate; }

	public JRadioButton getRdbtnCustomerNotYet() { return rdbtnCustomerNotYet; }
	public void setRdbtnCustomerNotYet(JRadioButton rdbtnCustomerNotYet) { this.rdbtnCustomerNotYet = rdbtnCustomerNotYet; }

	public JRadioButton getRdbtnCustomerCorporate() { return rdbtnCustomerCorporate; }
	public void setRdbtnCustomerCorporate(JRadioButton rdbtnCustomerCorporate) { this.rdbtnCustomerCorporate = rdbtnCustomerCorporate; }

	public JRadioButton getRdbtnCustomerNotSure() { return rdbtnCustomerNotSure; }
	public void setRdbtnCustomerNotSure(JRadioButton rdbtnCustomerNotSure) { this.rdbtnCustomerNotSure = rdbtnCustomerNotSure; }

	public JRadioButton getRdbtnOrderDeleteArticle() { return rdbtnOrderDeleteArticle; }
	public void setRdbtnOrderDeleteArticle(JRadioButton rdbtnOrderDeleteArticle) { this.rdbtnOrderDeleteArticle = rdbtnOrderDeleteArticle; }

	public JRadioButton getRdbtnOrderAddLine() { return rdbtnOrderAddLine; }
	public void setRdbtnOrderAddLine(JRadioButton rdbtnOrderAddLine) { this.rdbtnOrderAddLine = rdbtnOrderAddLine; }

	public JRadioButton getRdbtnOrderCreate() { return rdbtnOrderCreate; }
	public void setRdbtnOrderCreate(JRadioButton rdbtnOrderCreate) { this.rdbtnOrderCreate = rdbtnOrderCreate; }

	public JRadioButton getRdbtnAdminArticles() { return rdbtnAdminArticles; }
	public void setRdbtnAdminArticles(JRadioButton rdbtnAdminArticles) { this.rdbtnAdminArticles = rdbtnAdminArticles; }

	public JRadioButton getRdbtnAdminSuppliers() { return rdbtnAdminSuppliers; }
	public void setRdbtnAdminSuppliers(JRadioButton rdbtnAdminSuppliers) { this.rdbtnAdminSuppliers = rdbtnAdminSuppliers; }

	public JRadioButton getRdbtnAdminClients() { return rdbtnAdminClients; }
	public void setRdbtnAdminClients(JRadioButton rdbtnAdminClients) { this.rdbtnAdminClients = rdbtnAdminClients; }

	public JTextField getTxtCustomerName() { return txtCustomerName; }
	public void setTxtCustomerName(JTextField txtCustomerName) { this.txtCustomerName = txtCustomerName; }

	public JTextField getTxtCustomerCheckId() { return txtCustomerCheckId; }
	public void setTxtCustomerCheckId(JTextField txtCustomerCheckId) { this.txtCustomerCheckId = txtCustomerCheckId; }

	public JTextField getTxtCustomerConfirmation() { return txtCustomerConfirmation; }
	public void setTxtCustomerConfirmation(JTextField txtCustomerConfirmation) { this.txtCustomerConfirmation = txtCustomerConfirmation; }

	public JTextField getTxtCustomerAddress() { return txtCustomerAddress; }
	public void setTxtCustomerAddress(JTextField txtCustomerAddress) { this.txtCustomerAddress = txtCustomerAddress; }

	public JTextField getTxtCustomerIdIn() { return txtCustomerIdIn; }
	public void setTxtCustomerIdIn(JTextField txtCustomerIdIn) { this.txtCustomerIdIn = txtCustomerIdIn; }

	public JTextField getTxtCustomerIdOld() { return txtCustomerIdOld; }
	public void setTxtCustomerIdOld(JTextField txtCustomerIdOld) { this.txtCustomerIdOld = txtCustomerIdOld; }

	public JComboBox getTxtCustomerId() { return txtCustomerId; }
	public void setTxtCustomerId(JComboBox txtCustomerId) { this.txtCustomerId = txtCustomerId; }

	public JTextField getTxtCustomerPhone() { return txtCustomerPhone; }
	public void setTxtCustomerPhone(JTextField txtCustomerPhone) { this.txtCustomerPhone = txtCustomerPhone; }

	public JTextField getTxtOrderCustId() { return txtOrderCustId; }
	public void setTxtOrderCustId(JTextField txtOrderCustId) { this.txtOrderCustId = txtOrderCustId; }

	public JTextField getTxtOrderDate() { return txtOrderDate; }
	public void setTxtOrderDate(JTextField txtOrderDate) { this.txtOrderDate = txtOrderDate; }

	public JTextField getTxtOrderConfirmation() { return txtOrderConfirmation; }
	public void setTxtOrderConfirmation(JTextField txtOrderConfirmation) { this.txtOrderConfirmation = txtOrderConfirmation; }

	public JTextField getTxtAdminConfirmation() { return txtAdminConfirmation; }
	public void setTxtAdminConfirmation(JTextField txtAdminConfirmation) { this.txtAdminConfirmation = txtAdminConfirmation; }

	public JTextField getTxtAdminSupplierPhone() { return txtAdminSupplierPhone; }
	public void setTxtAdminSupplierPhone(JTextField txtAdminSupplierPhone) { this.txtAdminSupplierPhone = txtAdminSupplierPhone; }

	public JTextField getTxtAdminSupplierName() { return txtAdminSupplierName; }
	public void setTxtAdminSupplierName(JTextField txtAdminSupplierName) { this.txtAdminSupplierName = txtAdminSupplierName; }

	public JComboBox getComboOrderNumberAdd() { return comboOrderNumberAdd; }
	public void setComboOrderNumberAdd(JComboBox comboOrderNumberAdd) { this.comboOrderNumberAdd = comboOrderNumberAdd; }

	public JComboBox getComboOrderNumberDelete() { return comboOrderNumberDelete; }
	public void setComboOrderNumberDelete(JComboBox comboOrderNumberDelete) { this.comboOrderNumberDelete = comboOrderNumberDelete; }

	public JComboBox getComboOrderArticleDelete() { return comboOrderArticleDelete; }
	public void setComboOrderArticleDelete(JComboBox comboOrderArticleDelete) { this.comboOrderArticleDelete = comboOrderArticleDelete; }

	public JComboBox getComboOrderArticleAdd() { return comboOrderArticleAdd; }
	public void setComboOrderArticleAdd(JComboBox comboOrderArticleAdd) { this.comboOrderArticleAdd = comboOrderArticleAdd; }

	public JTextField getTxtOrderNumberCreate() { return txtOrderNumberCreate; }
	public void setTxtOrderNumberCreate(JTextField txtOrderNumberCreate) { this.txtOrderNumberCreate = txtOrderNumberCreate; }

	public JComboBox getTxtOrderQuantityAdd() { return txtOrderQuantityAdd; }
	public void setTxtOrderQuantityAdd(JComboBox txtOrderQuantityAdd) { this.txtOrderQuantityAdd = txtOrderQuantityAdd; }

	public JTextField getTxtAdminArticleName() { return txtAdminArticleName; }
	public void setTxtAdminArticleName(JTextField txtAdminArticleName) { this.txtAdminArticleName = txtAdminArticleName; }

	public JTextField getTxtAdminArticlePrice() { return txtAdminArticlePrice; }
	public void setTxtAdminArticlePrice(JTextField txtAdminArticlePrice) { this.txtAdminArticlePrice = txtAdminArticlePrice; }

	public JTextField getTxtAdminClientAddress() { return txtAdminClientAddress; }
	public void setTxtAdminClientAddress(JTextField txtAdminClientAddress) { this.txtAdminClientAddress = txtAdminClientAddress; }

	public JTextField getTxtAdminClientName() { return txtAdminClientName; }
	public void setTxtAdminClientName(JTextField txtAdminClientName) { this.txtAdminClientName = txtAdminClientName; }

	public JTextField getTxtAdminClientPhone() { return txtAdminClientPhone; }
	public void setTxtAdminClientPhone(JTextField txtAdminClientPhone) { this.txtAdminClientPhone = txtAdminClientPhone; }

	public JComboBox getComboAdminArticleSupplier() { return comboAdminArticleSupplier; }
	public void setComboAdminArticleSupplier(JComboBox comboAdminArticleSupplier) { this.comboAdminArticleSupplier = comboAdminArticleSupplier; }

	public JComboBox getComboAdminSupplierArticle() { return comboAdminSupplierArticle; }
	public void setComboAdminSupplierArticle(JComboBox comboAdminSupplierArticle) { this.comboAdminSupplierArticle = comboAdminSupplierArticle; }

	public JComboBox getComboAdminClientId() { return comboAdminClientId; }
	public void setComboAdminClientId(JComboBox comboAdminClientId) { this.comboAdminClientId = comboAdminClientId; }

	public JComboBox getComboAdminSupplierId() { return comboAdminSupplierId; }
	public void setComboAdminSupplierId(JComboBox comboAdminSupplierId) { this.comboAdminSupplierId = comboAdminSupplierId; }

	public JComboBox getComboAdminArticleId() { return comboAdminArticleId; }
	public void setComboAdminArticleId(JComboBox comboAdminArticleId) { this.comboAdminArticleId = comboAdminArticleId; }

	public JButton getBtnCustomerEdit() { return btnCustomerEdit; }
	public void setBtnCustomerEdit(JButton btnCustomerEdit) { this.btnCustomerEdit = btnCustomerEdit; }

	public JButton getBtnCustomerDelete() { return btnCustomerDelete; }
	public void setBtnCustomerDelete(JButton btnCustomerDelete) { this.btnCustomerDelete = btnCustomerDelete; }

	public JButton getBtnCustomerCheck() { return btnCustomerCheck; }
	public void setBtnCustomerCheck(JButton btnCustomerCheck) { this.btnCustomerCheck = btnCustomerCheck; }

	public JButton getBtnCustomerAdd() { return btnCustomerAdd; }
	public void setBtnCustomerAdd(JButton btnCustomerAdd) { this.btnCustomerAdd = btnCustomerAdd; }

	public JButton getBtnCustomerCreateAnOrder() { return btnCustomerCreateAnOrder; }
	public void setBtnCustomerCreateAnOrder(JButton btnCustomerCreateAnOrder) { this.btnCustomerCreateAnOrder = btnCustomerCreateAnOrder; }

	public JButton getBtnOrderAddLine() { return btnOrderAddLine; }
	public void setBtnOrderAddLine(JButton btnOrderAddLine) { this.btnOrderAddLine = btnOrderAddLine; }

	public JButton getBtnOrderDelete() { return btnOrderDelete; }
	public void setBtnOrderDelete(JButton btnOrderDelete) { this.btnOrderDelete = btnOrderDelete; }

	public JButton getBtnOrderProceed() { return btnOrderProceed; }
    public void setBtnOrderProceed(JButton btnOrderProceed) { this.btnOrderProceed = btnOrderProceed; }

    public JButton getBtnOrderProceedDuplicate() { return btnOrderProceedDuplicate; }
    public void setBtnOrderProceedDuplicate(JButton btnOrderProceedDuplicate) { this.btnOrderProceedDuplicate = btnOrderProceedDuplicate; }

    public JButton getBtnOrderCreate() { return btnOrderCreate; }
	public void setBtnOrderCreate(JButton btnOrderCreate) { this.btnOrderCreate = btnOrderCreate; }

	public JButton getBtnAdminUpdate() { return btnAdminUpdate; }
	public void setBtnAdminUpdate(JButton btnAdminUpdate) { this.btnAdminUpdate = btnAdminUpdate; }

	public JButton getBtnAdminFind() { return btnAdminFind; }
	public void setBtnAdminFind(JButton btnAdminFind) { this.btnAdminFind = btnAdminFind; }

	public JButton getBtnAdminAdd() { return btnAdminAdd; }
	public void setBtnAdminAdd(JButton btnAdminAdd) { this.btnAdminAdd = btnAdminAdd; }

	public JButton getBtnAdminDelete() { return btnAdminDelete; }
	public void setBtnAdminDelete(JButton btnAdminDelete) { this.btnAdminDelete = btnAdminDelete; }

	public ButtonGroup getButtonGroupIsCustomer() { return buttonGroupIsCustomer; }
	public ButtonGroup getButtonGroupPrivateCorporate() { return buttonGroupPrivateCorporate; }

	public ButtonGroup getButtonGroupOrderActivity() { return buttonGroupOrderActivity; }
	public ButtonGroup getButtonGroupAdminActivity() { return buttonGroupAdminActivity; }

	public Controller getController() { return controller; }
	public void setController(Controller controller) { this.controller = controller; }

	public JLabel getLblPreviewOrderNumer() { return lblPreviewOrderNumer; }
	public void setLblPreviewOrderNumer(JLabel lblPreviewOrderNumer) { this.lblPreviewOrderNumer = lblPreviewOrderNumer; }

	public JLabel getLblPreviewAdmin() { return lblPreviewAdmin; }
	public void setLblPreviewAdmin(JLabel lblPreviewAdmin) { this.lblPreviewAdmin = lblPreviewAdmin; }

	public JTextArea getLblPreviewOrderDetails() { return lblPreviewOrderDetails1; }
	public void setLblPreviewOrderDetails(JTextArea lblPreviewOrderDetails) { this.lblPreviewOrderDetails1 = lblPreviewOrderDetails; }

	public JButton getBtnPreviewBackToOrder() { return btnPreviewBackToOrder; }
	public void setBtnPreviewBackToOrder(JButton btnPreviewBackToOrder) { this.btnPreviewBackToOrder = btnPreviewBackToOrder; }

	public JLabel getLblPreviewOrderTotal() { return lblPreviewOrderTotal; }
	public void setLblPreviewOrderTotal(JLabel lblPreviewOrderTotal) { this.lblPreviewOrderTotal = lblPreviewOrderTotal; }

	public JTextArea getLblPreviewOrderDetails1() { return lblPreviewOrderDetails1; }
	public void setLblPreviewOrderDetails1(JTextArea lblPreviewOrderDetails1) { this.lblPreviewOrderDetails1 = lblPreviewOrderDetails1; }

	public JTextArea getLblPreviewOrderDetails2() { return lblPreviewOrderDetails2; }
	public void setLblPreviewOrderDetails2(JTextArea lblPreviewOrderDetails2) { this.lblPreviewOrderDetails2 = lblPreviewOrderDetails2; }

	public JTextArea getLblPreviewOrderDetails3() { return lblPreviewOrderDetails3; }
	public void setLblPreviewOrderDetails3(JTextArea lblPreviewOrderDetails3) { this.lblPreviewOrderDetails3 = lblPreviewOrderDetails3; }

	public JTextArea getLblPreviewOrderDetails4() { return lblPreviewOrderDetails4; }
	public void setLblPreviewOrderDetails4(JTextArea lblPreviewOrderDetails4) { this.lblPreviewOrderDetails4 = lblPreviewOrderDetails4; }

	public JPasswordField getTxtCustomerAdminPassword() { return txtCustomerAdminPassword; }
	public void setTxtCustomerAdminPassword(JPasswordField txtCustomerAdminPassword) { this.txtCustomerAdminPassword = txtCustomerAdminPassword; }

	public JPasswordField getTxtOrderAdminPassword() { return txtOrderAdminPassword; }
	public void setTxtOrderAdminPassword(JPasswordField txtOrderAdminPassword) { this.txtOrderAdminPassword = txtOrderAdminPassword; }

	public JPasswordField getTxtPreviewAdminPassword() { return txtPreviewAdminPassword; }
	public void setTxtPreviewAdminPassword(JPasswordField txtPreviewAdminPassword) { this.txtPreviewAdminPassword = txtPreviewAdminPassword; }

	public JButton getBtnCustomerPasswordCheck() { return btnCustomerPasswordCheck; }
	public void setBtnCustomerPasswordCheck(JButton btnCustomerPasswordCheck) { this.btnCustomerPasswordCheck = btnCustomerPasswordCheck; }

	public JButton getBtnOrderPasswordCheck() { return btnOrderPasswordCheck; }
	public void setBtnOrderPasswordCheck(JButton btnOrderPasswordCheck) { this.btnOrderPasswordCheck = btnOrderPasswordCheck; }

	public JButton getBtnPrevievPasswordCheck() { return btnPrevievPasswordCheck; }
	public void setBtnPrevievPasswordCheck(JButton btnPrevievPasswordCheck) { this.btnPrevievPasswordCheck = btnPrevievPasswordCheck; }

	public JComboBox getTxtOrderQuantityDelete() { return txtOrderQuantityDelete; }
	public void setTxtOrderQuantityDelete(JComboBox txtOrderQuantityDelete) { this.txtOrderQuantityDelete = txtOrderQuantityDelete; }

	public JTextField getTxtOrderCustIdDuplicate() { return txtOrderCustIdDuplicate; }
	public void setTxtOrderCustIdDuplicate(JTextField txtOrderCustIdDuplicate) { this.txtOrderCustIdDuplicate = txtOrderCustIdDuplicate; }

    public JComboBox getComboAdminClientType() { return comboAdminClientType; }
    public void setComboAdminClientType(JComboBox comboAdminClientType) { this.comboAdminClientType = comboAdminClientType; }
}
