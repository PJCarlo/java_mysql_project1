
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class CustomerAccount extends JFrame {
	
	//private String pending = {};

	private JPanel contentPane;
	private JMenuItem mnItmLogOut;
	private JMenuItem mnItmCustomerAccount;
	private JTable tableSchedule;
	private JTable tableInfo;
	
	private String[] columnSchedule = { "Customer ID", "Customer Name", "Customer Request Materil", "Date", "Schedule Time", "Cost" };
	private DefaultTableModel Schedule = new DefaultTableModel();
	
	
	ScheduleMaterial schedule = new ScheduleMaterial();
	

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
		lblMaterial4.setBounds(10, 267, 208, 124);
		panelToUsedMaterial.add(lblMaterial4);

		JLabel lblMaterial5 = new JLabel("New label");
		lblMaterial5.setBounds(288, 267, 208, 124);
		panelToUsedMaterial.add(lblMaterial5);

		JLabel lblMaterial6 = new JLabel("New label");
		lblMaterial6.setBounds(564, 267, 208, 124);
		panelToUsedMaterial.add(lblMaterial6);
		
		
		
		ButtonGroup rdoMaterials = new ButtonGroup();
		
		
		JRadioButton rdbtnMaterial1 = new JRadioButton("New radio button");
		rdbtnMaterial1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				schedule.setVisible(true);
			}
		});
		rdbtnMaterial1.setBounds(10, 142, 109, 23);
		panelToUsedMaterial.add(rdbtnMaterial1);
		
		JRadioButton rdbtnMaterial2 = new JRadioButton("New radio button");
		rdbtnMaterial2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				schedule.setVisible(true);
			}
		});
		rdbtnMaterial2.setBounds(288, 142, 109, 23);
		panelToUsedMaterial.add(rdbtnMaterial2);
		
		JRadioButton rdbtnMaterial3 = new JRadioButton("New radio button");
		rdbtnMaterial3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				schedule.setVisible(true);
			}
		});
		rdbtnMaterial3.setBounds(564, 142, 109, 23);
		panelToUsedMaterial.add(rdbtnMaterial3);
		
		JRadioButton rdbtnMaterial4 = new JRadioButton("New radio button");
		rdbtnMaterial4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				schedule.setVisible(true);
			}
		});
		rdbtnMaterial4.setBounds(10, 398, 109, 23);
		panelToUsedMaterial.add(rdbtnMaterial4);
		
		JRadioButton rdbtnMaterial5 = new JRadioButton("New radio button");
		rdbtnMaterial5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				schedule.setVisible(true);
			}
		});
		rdbtnMaterial5.setBounds(288, 398, 109, 23);
		panelToUsedMaterial.add(rdbtnMaterial5);
		
		JRadioButton rdbtnMaterial6 = new JRadioButton("New radio button");
		rdbtnMaterial6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				schedule.setVisible(true);
			}
		});
		rdbtnMaterial6.setBounds(564, 398, 109, 23);
		panelToUsedMaterial.add(rdbtnMaterial6);
		
		
		rdoMaterials.add(rdbtnMaterial1);
		rdoMaterials.add(rdbtnMaterial2);
		rdoMaterials.add(rdbtnMaterial3);
		rdoMaterials.add(rdbtnMaterial4);
		rdoMaterials.add(rdbtnMaterial5);
		rdoMaterials.add(rdbtnMaterial6);
		
		
		//---------------------------------------------------------------------------------------------------------------------
		

		JPanel panelSchedule = new JPanel();
		tabbedPane.addTab("Pending Request Material", null, panelSchedule, null);
		panelSchedule.setLayout(null);
		
		JScrollPane scrollSchedule = new JScrollPane();
		scrollSchedule.setBounds(10, 11, 758, 388);
		panelSchedule.add(scrollSchedule);

		tableSchedule = new JTable(Schedule) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		tableSchedule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		tableSchedule.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableSchedule.setFocusable(false);
		scrollSchedule.setViewportView(tableSchedule);
		Schedule.setColumnIdentifiers(columnSchedule);
		
		
		//--------------------------------------------------------------------------------------------------------------------
		

		JPanel panelInfo = new JPanel();
		tabbedPane.addTab("Order Information", null, panelInfo, null);
		panelInfo.setLayout(null);
		
		JScrollPane scrollCustomerInfo = new JScrollPane();
		scrollCustomerInfo.setBounds(10, 11, 758, 388);
		panelInfo.add(scrollCustomerInfo);

		tableInfo = new JTable(Schedule) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		tableInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		tableInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableInfo.setFocusable(false);
		scrollCustomerInfo.setViewportView(tableInfo);
		Schedule.setColumnIdentifiers(columnSchedule);

	}

}
