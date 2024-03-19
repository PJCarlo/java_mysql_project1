import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import EntityModel.WorkOrder;

import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WorkOrderList extends JFrame {

	private JPanel contentPane;

	private String[] wo_table_columns = { "Work order ID", "Job Title", "Job Description", "Materials", "Status", "Start Date", "End Date" };
	private DefaultTableModel wo_table_model = new DefaultTableModel();
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;
	private JButton btnNewButton;
	public int selectedWO_ID = 0;
	private JButton btnViewButton;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkOrderList frame = new WorkOrderList();
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
	public WorkOrderList() {
		
		wo_table_model.setColumnIdentifiers(wo_table_columns);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(wo_table_model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRow() > -1) {
					btnNewButton.setEnabled(true);
					btnViewButton.setEnabled(true);
					selectedWO_ID =  Integer.parseInt(wo_table_model.getValueAt(table.getSelectedRow(), 0).toString());
					
				}
			}
		});
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("Add Timecard");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimecardScreen tcscreen = new TimecardScreen(selectedWO_ID);
				tcscreen.setVisible(true);
			}
		});
		btnNewButton.setEnabled(false);
		panel.add(btnNewButton);
		
		btnViewButton = new JButton("View Timecard");
		btnViewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimecardScreen tcscreen = new TimecardScreen(selectedWO_ID);
				tcscreen.setVisible(true);
			}
		});
		btnViewButton.setEnabled(false);
		panel.add(btnViewButton);
		
		WorkOrder wo = new WorkOrder();
		Vector<Object[]> wo_row = wo.getAllWorkder();
		for(int i=0;i<wo_row.size();i++) {
			wo_table_model.addRow(wo_row.get(i));
		}
	}

}
