
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class CustomerAccount extends JFrame {

	private JPanel contentPane;
	private JMenuItem mnItmLogOut;
	private JMenuItem mnItmCustomerAccount;
	private JTable tableAssignJob;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerAccount frame = new CustomerAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomerAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 559);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnAccount = new JMenu("=");
		menuBar.add(mnAccount);

		mnItmCustomerAccount = new JMenuItem("Account");
		mnItmCustomerAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean accountcustome = true;
				if (accountcustome == true) {
					AccountSupervisor supervisor = new AccountSupervisor();
					supervisor.setVisible(true);
					dispose();

					mnItmCustomerAccount = new JMenuItem();
					mnItmCustomerAccount.setFont(new Font("Monospaced", Font.PLAIN, 13));
					mnItmCustomerAccount.setFocusable(true);
					//scrollPane.setViewportView(txAOrderSummary);

				}
			}
		});
		mnAccount.add(mnItmCustomerAccount);

		mnItmLogOut = new JMenuItem("LogOut");
		mnItmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(null, "Log out?");
				if (response == JOptionPane.YES_OPTION) {
					LogIn login = new LogIn();
					login.setVisible(true);
					dispose();
				}
			}
		});
		mnAccount.add(mnItmLogOut);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 783, 498);
		contentPane.add(tabbedPane);
		
		JPanel panelToUsedMaterial = new JPanel();
		tabbedPane.addTab("Request Material", null, panelToUsedMaterial, null);
		panelToUsedMaterial.setLayout(null);
		
		JLabel lblMaterial1 = new JLabel("New label");
		lblMaterial1.setBounds(10, 11, 208, 124);
		panelToUsedMaterial.add(lblMaterial1);
		
		JLabel lblMaterial2 = new JLabel("New label");
		lblMaterial2.setBounds(288, 11, 208, 124);
		panelToUsedMaterial.add(lblMaterial2);

		JLabel lblMaterial3 = new JLabel("New label");
		lblMaterial3.setBounds(564, 11, 208, 124);
		panelToUsedMaterial.add(lblMaterial3);

		JLabel lblMaterial4 = new JLabel("New label");
		lblMaterial4.setBounds(10, 292, 208, 124);
		panelToUsedMaterial.add(lblMaterial4);

		JLabel lblMaterial5 = new JLabel("New label");
		lblMaterial5.setBounds(288, 292, 208, 124);
		panelToUsedMaterial.add(lblMaterial5);

		JLabel lblMaterial6 = new JLabel("New label");
		lblMaterial6.setBounds(564, 292, 208, 124);
		panelToUsedMaterial.add(lblMaterial6);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(10, 142, 109, 23);
		panelToUsedMaterial.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBounds(288, 142, 109, 23);
		panelToUsedMaterial.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_2.setBounds(564, 142, 109, 23);
		panelToUsedMaterial.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_3.setBounds(10, 423, 109, 23);
		panelToUsedMaterial.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_4.setBounds(288, 423, 109, 23);
		panelToUsedMaterial.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_5.setBounds(564, 423, 109, 23);
		panelToUsedMaterial.add(rdbtnNewRadioButton_5);
		

		JPanel panelddOrder = new JPanel();
		tabbedPane.addTab("Pending Request Material", null, panelddOrder, null);
		panelddOrder.setLayout(null);

		JPanel panelOrderInfo = new JPanel();
		tabbedPane.addTab("Order Information", null, panelOrderInfo, null);
		panelOrderInfo.setLayout(null);

	}

}
