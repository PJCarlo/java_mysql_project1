import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;
import java.awt.Font;

public class SupervisorAccount extends JFrame {

	private JPanel contentPane;
	private JMenuItem mnItmLogOut;
	private JMenuItem mnItmSupervisorAccount;
	private JTable tableAssignJob;
	private JTable tableMaterialUsed;
	private JTable tablePendingRequestMaterial;
	
	private String[] columnassign = { "Job Number", "Description", "Estimated Time", "Estimated Materials", "Schedule Date", "Schedule Time", "Employee Name" };
	private DefaultTableModel jobSchedule = new DefaultTableModel();
	
	
	private String[] columnSchedule = { "Customer ID", "Customer Name", "Customer Request Materil", "Date", "Schedule Time", "Cost" };
	private DefaultTableModel Schedule = new DefaultTableModel(columnSchedule, 0);
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupervisorAccount frame = new SupervisorAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * This frame is supervisor.
	 * 
	 */
	public SupervisorAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 559);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// Menu Bar

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnAccount = new JMenu("=");
		menuBar.add(mnAccount);

		mnItmSupervisorAccount = new JMenuItem("Account");
		mnItmSupervisorAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean accountsupervisor = true;
				if (accountsupervisor == true) {
					AccountSupervisor accountSupervisor = new AccountSupervisor();
					accountSupervisor.setVisible(true);
					dispose();
				}
			}
		});
		mnAccount.add(mnItmSupervisorAccount);

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

		
		// ------------------------------------------------------------------------------------------------------------------
		// TabbedPane and panel Material Used
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 783, 498);
		contentPane.add(tabbedPane);
		
		
	    //--------------------------------------------------------------------------------------------------------------------   
	    // Line Chart
		
	    JPanel panelSales = new JPanel();
	    panelSales.setBackground(Color.LIGHT_GRAY);
	    tabbedPane.addTab("Sales", null, panelSales, null);
	    panelSales.setLayout(null);
	    
	    
	    //--------------------------------------------------------------------------------------------------------------------

		JPanel panelMaterialUsed = new JPanel();
		panelMaterialUsed.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Material Used", null, panelMaterialUsed, null);
		panelMaterialUsed.setLayout(null);

		JScrollPane scrollMaterialUsed = new JScrollPane();
		scrollMaterialUsed.setBounds(10, 11, 758, 388);
		panelMaterialUsed.add(scrollMaterialUsed);

		tableMaterialUsed = new JTable(jobSchedule) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		tableMaterialUsed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				

			}
		});
		tableMaterialUsed.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableMaterialUsed.setFocusable(false);
		scrollMaterialUsed.setViewportView(tableMaterialUsed);
		jobSchedule.setColumnIdentifiers(columnassign);

		
		// ------------------------------------------------------------------------------------------------------------------
		// Panel Assign Job

		JPanel panelAssignJob = new JPanel();
		panelAssignJob.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Assign Job", null, panelAssignJob, null);
		panelAssignJob.setLayout(null);

		JScrollPane scrollAssignJob = new JScrollPane();
		scrollAssignJob.setBounds(10, 11, 758, 388);
		panelAssignJob.add(scrollAssignJob);

		tableAssignJob = new JTable(jobSchedule) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		tableAssignJob.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				User users = new User();
//		        User[] usersArray = users.getAllEmployee();
//		        for (User user : usersArray) {
//		        	jobSchedule.addRow(new Object[]{user.getFirstName(), user.getLastName(), user.getEmail()});
//		        }
				
			}
		});
		tableAssignJob.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableAssignJob.setFocusable(false);
		scrollAssignJob.setViewportView(tableAssignJob);
		jobSchedule.setColumnIdentifiers(columnassign);
		
		JButton btnAssign = new JButton("Assign");
		btnAssign.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkOrderScreen assign = new WorkOrderScreen();
				assign.setVisible(true);
					
	            }
	        });
	        btnAssign.setBounds(347, 424, 89, 23);
	        panelAssignJob.add(btnAssign);
	        jobSchedule.setColumnIdentifiers(columnassign);
	        
	        
	        
	        
	    //--------------------------------------------------------------------------------------------------------------------
	    
	        JPanel panelScheduleMonitoring = new JPanel();
	        panelScheduleMonitoring.setBackground(Color.LIGHT_GRAY);
			tabbedPane.addTab("Pending Request Material", null, panelScheduleMonitoring, null);
			panelScheduleMonitoring.setLayout(null);
			
			JScrollPane scrollMonitoring = new JScrollPane();
			scrollMonitoring.setBounds(10, 11, 758, 327);
			panelScheduleMonitoring.add(scrollMonitoring);
			
			
			// Add default values to the table model
			Object[] defaultRow1 = {"J31F5", "adsasd", "SAMPLE", "3/20/2024", "8:30 AM", "13,000"};
			Object[] defaultRow2 = {"J1TF5", "qweqwe", "SAMPLE", "3/21/2024", "7:30 AM", "11,700"};

			tablePendingRequestMaterial = new JTable(Schedule) {
			    public boolean editCellAt(int row, int column, java.util.EventObject e) {
			        return false;
			    }
			};

			// Add this line to set the table model
			tablePendingRequestMaterial.setModel(Schedule);

			Schedule.addRow(defaultRow1);
			Schedule.addRow(defaultRow2);

			tablePendingRequestMaterial.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {

			    }
			});
			tablePendingRequestMaterial.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tablePendingRequestMaterial.setFocusable(false);
			scrollMonitoring.setViewportView(tablePendingRequestMaterial);
			Schedule.setColumnIdentifiers(columnSchedule);
			
			
			
			
			
			
			
			
//			
//			 // Add default values to the table model
//	        Object[] defaultRow1 = {"J31F5", "adsasd", "SAMPLE", "3/20/2024", "8:30 AM", "13,000"};
//	        Object[] defaultRow2 = {"J1TF5", "qweqwe", "SAMPLE", "3/21/2024", "7:30 AM", "11,700"};
//			
//
//			tablePendingRequestMaterial = new JTable(Schedule) {
//				public boolean editCellAt(int row, int column, java.util.EventObject e) {
//					return false;
//				}
//			};
//			
//			
//			Schedule.addRow(defaultRow1);
//			Schedule.addRow(defaultRow2);
//			
//			
//			
//			tablePendingRequestMaterial.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					        
//					
//				        
//				}
//			});
//			tablePendingRequestMaterial.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//			tablePendingRequestMaterial.setFocusable(false);
//			scrollMonitoring.setViewportView(tablePendingRequestMaterial);
//			Schedule.setColumnIdentifiers(columnSchedule);
		    
	    }
	
}
