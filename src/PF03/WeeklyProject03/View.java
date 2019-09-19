package PF03.WeeklyProject03;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class View {

	private JFrame frameOrderMaker;
	private JTabbedPane tabbedPane;
	private JPanel panel01;
	private JPanel panel02;
	private JPanel panel03;

	private JLabel lblCustomerAdmin;
	private JLabel lblOrderAdmin;
	private JLabel lblOrderCustId;
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
	private JTextField txtCustomerName;
	private JTextField txtCustomerCheckId;
	private JTextField txtCustomerConfirmation;
	private JTextField txtCustomerAddress;
	private JTextField txtCustomerIdIn;
	private JTextField txtCustomerId;
	private JTextField txtCustomerPhone;
	private JTextField txtOrderCustId;
	private JTextField txtOrderDate;
	private JTextField txtOrderConfirmation;
	private JTextField txtAdminConfirmation;
	private JTextField txtAdminSupplierPhone;
	private JTextField txtAdminSupplierName;
	private JTextField comboOrderNumberAdd;
	private JTextField comboOrderNumberDelete;
	private JTextField comboOrderArticleAdd;
	private JTextField txtOrderNumberCreate;
	private JTextField txtOrderQuantity;
	private JTextField txtAdminArticleName;
	private JTextField txtAdminArticlePrice;
	private JTextField txtAdminClientAddress;
	private JTextField txtAdminClientName;
	private JTextField txtAdminClientPhone;
	private JTextField comboAdminArticleSupplier;
	private JTextField comboAdminSupplierArticle;
	private JTextField comboAdminClientOrder;
	private JTextField comboAdminClientId;
	private JTextField comboAdminSupplierId;
	private JTextField comboAdminArticleId;
	private JButton btnCustomerEdit;
	private JButton btnCustomerDelete;
	private JButton btnCustomerCheck;
	private JButton btnCustomerAdd;
	private JButton btnCustomerCreateAnOrder;
	private JButton btnOrderAddLine;
	private JButton btnOrderDelete;
	private JButton btnOrderProceed;
	private JButton btnOrderCreate;
	private JButton btnAdminCreate;
	private JButton btnAdminFind;
	private JButton btnAdminAdd;
	private JButton btnAdminDelete;
	private final ButtonGroup buttonGroupIsCustomer = new ButtonGroup();
	private final ButtonGroup buttonGroupPrivateCorporate = new ButtonGroup();
	private final ButtonGroup buttonGroupOrderActivity = new ButtonGroup();
	private final ButtonGroup buttonGroupAdminActivity = new ButtonGroup();

	private Controller controller;

	private Random random = new Random();

	private String custId;

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
	private View() {
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
		panel01.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Customer", null, panel01, null);
		tabbedPane.setForegroundAt(0, new Color(0, 0, 128));
		tabbedPane.setBackgroundAt(0, new Color(135, 206, 235));
		panel01.setLayout(null);
		
		panel02 = new JPanel();
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
		tabbedPane.setForegroundAt(1, new Color(0, 0, 128));
		tabbedPane.setBackgroundAt(1, new Color(135, 206, 235));
		panel02.setLayout(null);
		
		panel03 = new JPanel();
		panel03.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				controller.setAdminConfirmationBlank();
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
	    		controller.enableCustomerUpper();
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
	    
		rdbtnCustomerNotYet = new JRadioButton("Not yet ? Create an account !");
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
				controller.updateCustomerTypeSelection();
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
				controller.updateCustomerTypeSelection();
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
				controller.addCustomerUpdateData();
			}
		});
		btnCustomerAdd.setEnabled(false);
		btnCustomerAdd.setBounds(295, 327, 80, 29);
		btnCustomerAdd.setEnabled(false);
		panel01.add(btnCustomerAdd);
		
		rdbtnCustomerNotSure = new JRadioButton("Not sure ? Check it !");
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
		btnCustomerCreateAnOrder.setBounds(21, 447, 402, 47);
		btnCustomerCreateAnOrder.setEnabled(false);
		panel01.add(btnCustomerCreateAnOrder);
		
		lblCustomerAdmin = new JLabel("Admin");
		lblCustomerAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.goToAdminTab();
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
				controller.enableOrderUpper();
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
				controller.addNewOrderAsClient();
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
				controller.enableOrderMiddle();
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
				controller.addNewOrderLineAsClient();
			}
		});
		btnOrderAddLine.setBounds(295, 294, 80, 29);
		btnOrderAddLine.setEnabled(false);
		panel02.add(btnOrderAddLine);

		rdbtnOrderDeleteArticle = new JRadioButton("Delete an order ?");
		rdbtnOrderDeleteArticle.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				controller.enableOrderLower();
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
				controller.deleteOrderAsClient();
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
				controller.goToAdminTab();
			}
		});
		lblOrderAdmin.setEnabled(false);
		lblOrderAdmin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrderAdmin.setBackground(new Color(135, 206, 235));
		lblOrderAdmin.setForeground(new Color(0, 0, 0));
		lblOrderAdmin.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblOrderAdmin.setBounds(406, 512, 35, 14);
		panel02.add(lblOrderAdmin);

// panel03 ============================================= panel03

		rdbtnAdminArticles = new JRadioButton("Items management ");
		rdbtnAdminArticles.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				controller.enableAdminUpper();
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
				controller.enableAdminMiddle();
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
				controller.enableAdminLower();
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

	public JTextField getTxtCustomerId() { return txtCustomerId; }
	public void setTxtCustomerId(JTextField txtCustomerId) { this.txtCustomerId = txtCustomerId; }

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

	public JTextField getComboOrderNumberAdd() { return comboOrderNumberAdd; }
	public void setComboOrderNumberAdd(JTextField comboOrderNumberAdd) { this.comboOrderNumberAdd = comboOrderNumberAdd; }

	public JTextField getComboOrderNumberDelete() { return comboOrderNumberDelete; }
	public void setComboOrderNumberDelete(JTextField comboOrderNumberDelete) { this.comboOrderNumberDelete = comboOrderNumberDelete; }

	public JTextField getComboOrderArticleAdd() { return comboOrderArticleAdd; }
	public void setComboOrderArticleAdd(JTextField comboOrderArticleAdd) { this.comboOrderArticleAdd = comboOrderArticleAdd; }

	public JTextField getTxtOrderNumberCreate() { return txtOrderNumberCreate; }
	public void setTxtOrderNumberCreate(JTextField txtOrderNumberCreate) { this.txtOrderNumberCreate = txtOrderNumberCreate; }

	public JTextField getTxtOrderQuantity() { return txtOrderQuantity; }
	public void setTxtOrderQuantity(JTextField txtOrderQuantity) { this.txtOrderQuantity = txtOrderQuantity; }

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

	public JTextField getComboAdminArticleSupplier() { return comboAdminArticleSupplier; }
	public void setComboAdminArticleSupplier(JTextField comboAdminArticleSupplier) { this.comboAdminArticleSupplier = comboAdminArticleSupplier; }

	public JTextField getComboAdminSupplierArticle() { return comboAdminSupplierArticle; }
	public void setComboAdminSupplierArticle(JTextField comboAdminSupplierArticle) { this.comboAdminSupplierArticle = comboAdminSupplierArticle; }

	public JTextField getComboAdminClientOrder() { return comboAdminClientOrder; }
	public void setComboAdminClientOrder(JTextField comboAdminClientOrder) { this.comboAdminClientOrder = comboAdminClientOrder; }

	public JTextField getComboAdminClientId() { return comboAdminClientId; }
	public void setComboAdminClientId(JTextField comboAdminClientId) { this.comboAdminClientId = comboAdminClientId; }

	public JTextField getComboAdminSupplierId() { return comboAdminSupplierId; }
	public void setComboAdminSupplierId(JTextField comboAdminSupplierId) { this.comboAdminSupplierId = comboAdminSupplierId; }

	public JTextField getComboAdminArticleId() { return comboAdminArticleId; }
	public void setComboAdminArticleId(JTextField comboAdminArticleId) { this.comboAdminArticleId = comboAdminArticleId; }

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

	public JButton getBtnOrderCreate() { return btnOrderCreate; }
	public void setBtnOrderCreate(JButton btnOrderCreate) { this.btnOrderCreate = btnOrderCreate; }

	public JButton getBtnAdminCreate() { return btnAdminCreate; }
	public void setBtnAdminCreate(JButton btnAdminCreate) { this.btnAdminCreate = btnAdminCreate; }

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

	public Random getRandom() { return random; }
	public void setRandom(Random random) { this.random = random; }

	public String getCustId() { return custId; }
	public void setCustId(String custId) { this.custId = custId; }
}
