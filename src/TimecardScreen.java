import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Panel;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.sql.Date;

import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import EntityModel.Timecard;
import EntityModel.User;
import EntityModel.WorkOrder;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class TimecardScreen extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	
	private String[] table_columns = { "Name", "Work Order ID", "Start Date", "Start Time", "End Date", "End Time" };
	private DefaultTableModel table_model = new DefaultTableModel();
	private JTextField txtStartTime;
	private JTextField txtEndTime;
	private int workorder_id = 0;
	private int selected_userid = 0;
	private int timecard = 0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimecardScreen frame = new TimecardScreen(0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public String convertToDate(java.util.Date date) {
		return new SimpleDateFormat("yy-MM-dd").format(date.getDate());
	}
	
	/**
	 * Create the frame.
	 */
	public TimecardScreen(int wo_id) {
		
		User users = new User();
		User[] array_users = users.getAllEmployee();
		String[] user_names = new String[array_users.length];
		for(int i = 0; i<array_users.length;i++) {
			user_names[i] = array_users[i].getFirstName() + " " + array_users[i].getLastName();
		}
		
		table_model.setColumnIdentifiers(table_columns);
		

		this.workorder_id = wo_id;
		Timecard tc = new Timecard();
		Vector<Object[]> wo_timelines = tc.getWorkorderTimeline(wo_id);
		
		if(wo_timelines.size() > 0) {
			for(int i=0;i<wo_timelines.size();i++) {
				table_model.addRow(wo_timelines.get(i));
			}
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(10, 10, 602, 213);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(table_model);
		scrollPane.setViewportView(table);
		scrollPane.setViewportView(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selected_userid = array_users[comboBox.getSelectedIndex()].getUserID();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(user_names));
		comboBox.setBounds(11, 276, 355, 33);
		contentPane.add(comboBox);
		

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(427, 276, 185, 33);
		contentPane.add(dateChooser);
		
		txtStartTime = new JTextField();
		txtStartTime.setBounds(11, 352, 279, 30);
		contentPane.add(txtStartTime);
		txtStartTime.setColumns(10);
		
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setBounds(10, 320, 185, 33);
		contentPane.add(lblStartTime);
		
		JLabel lblStartTime_1 = new JLabel("End Time");
		lblStartTime_1.setBounds(333, 320, 185, 33);
		contentPane.add(lblStartTime_1);
		
		txtEndTime = new JTextField();
		txtEndTime.setColumns(10);
		txtEndTime.setBounds(333, 352, 279, 30);
		contentPane.add(txtEndTime);
		
		JButton btnAssign = new JButton("Assign");
		btnAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Timecard tc = new Timecard();
				tc.setUserID(selected_userid);
				tc.setWorkorderID(workorder_id);
				tc.setStartTime(txtStartTime.getText());
				tc.setEndTime(txtEndTime.getText());
				tc.setStartDate(convertToDate(dateChooser.getDate()));
				tc.setEndDate(null);
				if(tc.CreateTimecard() > 0) {
					JOptionPane.showMessageDialog(null, "Timecard has been added.");
					dispose();
				}
			}
		});
		btnAssign.setBounds(10, 413, 150, 33);
		contentPane.add(btnAssign);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(467, 413, 145, 33);
		contentPane.add(btnCancel);
		
		JLabel lblUser = new JLabel("Select User");
		lblUser.setBounds(11, 242, 185, 33);
		contentPane.add(lblUser);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(427, 242, 185, 33);
		contentPane.add(lblDate);
		
		
		
		
		
	}
}
