import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmployeeAccount extends JFrame {

	private JPanel contentPane;
	private JMenuItem mnItmLogOut;
	private JMenuItem mnItmEmployeeAccount;
	private JTable tableScheduledJob;
	private JTable tableTimeandDelays;
	private JTable tableTimeCards;
	private String[] columnschedule = { "Job Number", "Description", "Estimated Time", "Estimated Materials", "Schedule Date", "Schedule Time", "Employee Name" };
	private String[] timedelays = { "Job Number", "Employee Name", "Calculated Time", "Time Delay", "Date" };
	private String[] timecards = { "Date", "Start Time", "Total Break Time (Min)", "Final Time", };
	private DefaultTableModel scheduledjob = new DefaultTableModel();
	private DefaultTableModel calctimedelays = new DefaultTableModel();
	private DefaultTableModel timecard = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeAccount frame = new EmployeeAccount();
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
	public EmployeeAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 474);
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

		mnItmEmployeeAccount = new JMenuItem("Account");
		mnItmEmployeeAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean accountemployee = true;
				if (accountemployee == true) {
					AccountEmployee employee = new AccountEmployee();
					employee.setVisible(true);
					dispose();
					
				}
			}
		});
		mnAccount.add(mnItmEmployeeAccount);

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

		
		// -------------------------------------------------------------------------------
		// Panel Schedule

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 680, 413);
		contentPane.add(tabbedPane);

		JPanel panelSchedule = new JPanel();
		tabbedPane.addTab("Assign Job", null, panelSchedule, null);
		panelSchedule.setLayout(null);

		JScrollPane scrollJobScheduled = new JScrollPane();
		scrollJobScheduled.setBounds(10, 11, 655, 363);
		panelSchedule.add(scrollJobScheduled);

		tableScheduledJob = new JTable(scheduledjob) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		tableScheduledJob.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		tableScheduledJob.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableScheduledJob.setFocusable(false);
		scrollJobScheduled.setViewportView(tableScheduledJob);
		scheduledjob.setColumnIdentifiers(columnschedule);

		
		// -------------------------------------------------------------------------------
		// Calculated Time and Delay's

		JPanel panelTimeandDelays = new JPanel();
		tabbedPane.addTab("Calculated Time and Delays", null, panelTimeandDelays, null);
		panelTimeandDelays.setLayout(null);

		JScrollPane scrollTimeandDelays = new JScrollPane();
		scrollTimeandDelays.setBounds(10, 11, 655, 359);
		panelTimeandDelays.add(scrollTimeandDelays);

		tableTimeandDelays = new JTable(calctimedelays) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		tableTimeandDelays.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		tableTimeandDelays.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableTimeandDelays.setFocusable(false);
		scrollTimeandDelays.setViewportView(tableTimeandDelays);
		calctimedelays.setColumnIdentifiers(timedelays);

		
		// -------------------------------------------------------------------------------
		// Calculated Time and Delay's

		JPanel panelTimeCards = new JPanel();
		tabbedPane.addTab("Time Cards", null, panelTimeCards, null);
		panelTimeCards.setLayout(null);

		JScrollPane scrollTimeCards = new JScrollPane();
		scrollTimeCards.setBounds(10, 11, 655, 359);
		panelTimeCards.add(scrollTimeCards);

		tableTimeCards = new JTable(timecard) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		tableTimeCards.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		tableTimeCards.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableTimeCards.setFocusable(false);
		scrollTimeCards.setViewportView(tableTimeCards);
		timecard.setColumnIdentifiers(timecards);

	}

}
