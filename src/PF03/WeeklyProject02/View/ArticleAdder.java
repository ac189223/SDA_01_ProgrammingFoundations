package PF03.WeeklyProject02.View;

import PF03.WeeklyProject02.Controller;
import PF03.WeeklyProject02.Model.ArticleReg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArticleAdder {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtPrice;
	
	private Controller controller;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArticleAdder window = new ArticleAdder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ArticleAdder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 235));
		frame.setBackground(new Color(135, 206, 235));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMain = new JLabel("Enter a new article:");
		lblMain.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain.setBounds(6, 23, 438, 31);
		frame.getContentPane().add(lblMain);
		
		JLabel lblName = new JLabel("name:");
		lblName.setBounds(91, 83, 61, 16);
		frame.getContentPane().add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(151, 78, 186, 26);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(151, 116, 186, 26);
		frame.getContentPane().add(txtPrice);
		txtPrice.setColumns(10);
		
		String[] suppliers = {"", "supp1", "supp2"};
		JComboBox comboBoxSupplier = new JComboBox(suppliers);
		comboBoxSupplier.setBounds(151, 155, 186, 27);
		frame.getContentPane().add(comboBoxSupplier);
		
		JLabel lblPrice = new JLabel("price:");
		lblPrice.setBounds(91, 121, 61, 16);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblOutput = new JLabel("");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(6, 200, 438, 31);
		frame.getContentPane().add(lblOutput);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String articleName = txtName.getText();
				double articlePrice = Double.parseDouble(txtPrice.getText());
				String articleSupplier = String.valueOf(comboBoxSupplier.getSelectedItem());
				if (articleSupplier.equals(""))
					controller.addArticle(articleName, articlePrice);
				else
					controller.addArticle(articleName, articlePrice);
				lblOutput.setText("Done");
			}
		});
		btnAdd.setBounds(276, 243, 117, 29);
		frame.getContentPane().add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(255, 255, 255));
		btnCancel.setBounds(34, 243, 117, 29);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblSupplier = new JLabel("supplier:");
		lblSupplier.setBounds(91, 159, 61, 16);
		frame.getContentPane().add(lblSupplier);
		
	    controller = new Controller(frame);
	}
}
