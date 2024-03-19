
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import EntityModel.Job;
import EntityModel.Materials;
import EntityModel.User;
import EntityModel.WorkOrder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.util.Arrays;
//import java.util.Locale;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

public class WorkOrderScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textJobDescription;
	private JComboBox cb_materials;
	private JComboBox cbJobtitle;
	
	
	
	User users = new User();
	User users_array[] = users.getAllEmployee();
	
	
	Job job = new Job();
	Job job_array[] = job.getAllJobs();
	
	WorkOrderList worklist = new WorkOrderList();
	SupervisorAccount supervisor = new SupervisorAccount(); 
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkOrderScreen frame = new WorkOrderScreen();
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
	@SuppressWarnings("unchecked")
	public WorkOrderScreen() {
		

		

		Materials mat = new Materials();
		Materials array_mat[] = mat.getAvailableMaterials();
		String materials_model[] = new String[array_mat.length];
		for(int i = 0; i<array_mat.length; i++) {
			materials_model[i] = array_mat[i].getMatName();
		}

		String job_titles[] = new String[job_array.length];
		for(int i = 0;i<job_array.length;i++) {
			job_titles[i] = job_array[i].getID() +" - "+ job_array[i].getTitle();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAssignJob = new JLabel("Create Work Order");
		lblAssignJob.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAssignJob.setBounds(47, 11, 363, 29);
		contentPane.add(lblAssignJob);
		
		JPanel panel = new JPanel();
		panel.setBounds(47, 74, 363, 58);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblJobNumber = new JLabel("Select Job:");
		lblJobNumber.setBounds(0, 0, 108, 18);
		panel.add(lblJobNumber);
		lblJobNumber.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		
		cbJobtitle = new JComboBox();
		cbJobtitle.setBounds(0, 29, 363, 29);
		panel.add(cbJobtitle);
		cbJobtitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
            	textJobDescription.setText(job_array[cbJobtitle.getSelectedIndex()].getDesc());
			}
		});
		
		cbJobtitle.setModel(new DefaultComboBoxModel<String>(job_titles));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(47, 143, 363, 98);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textJobDescription = new JTextField();
		textJobDescription.setBounds(0, 29, 363, 69);
		panel_1.add(textJobDescription);
		textJobDescription.setColumns(10);
		
		JLabel lblJobDescription = new JLabel("Job Description");
		lblJobDescription.setBounds(0, 0, 203, 29);
		panel_1.add(lblJobDescription);
		lblJobDescription.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JLabel lblEstimatedMaterial = new JLabel("End Date");
		lblEstimatedMaterial.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEstimatedMaterial.setBounds(48, 388, 142, 29);
		contentPane.add(lblEstimatedMaterial);
		
		JLabel lblDateTime = new JLabel("Start Date");
		lblDateTime.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDateTime.setBounds(47, 322, 159, 29);
		contentPane.add(lblDateTime);
		
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supervisor.setVisible(true);
			}
		});
		btnCancel.setBounds(316, 484, 96, 23);
		contentPane.add(btnCancel);
		
		String user_names[] = new String[users_array.length];
		for(int i = 0;i<users_array.length;i++) {
			user_names[i] = users_array[i].getFirstName() +" "+ users_array[i].getLastName();
		}
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(47, 252, 363, 58);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		cb_materials = new JComboBox();
		cb_materials.setBounds(0, 29, 363, 29);
		panel_2.add(cb_materials);
		cb_materials.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		cb_materials.setModel(new DefaultComboBoxModel<String>(materials_model));
		
		JLabel lblJobDescription_1 = new JLabel("Select Materials:");
		lblJobDescription_1.setBounds(0, 0, 363, 29);
		panel_2.add(lblJobDescription_1);
		lblJobDescription_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JDateChooser dd_startDate = new JDateChooser();
		dd_startDate.setBounds(47, 351, 363, 29);
		contentPane.add(dd_startDate);
		
		JDateChooser dd_endDate = new JDateChooser();
		dd_endDate.setBounds(48, 422, 363, 29);
		contentPane.add(dd_endDate);
		
		// SET DEFAULT TEXT OF JOB DESCRIPTION WITH 0 INDEX OF JOB ARRAY

		if(job_array.length > 0) {
	        textJobDescription.setText(job_array[0].getDesc());
		}
		
		 JButton btnAssign = new JButton("Start");
         btnAssign.setBounds(49, 484, 96, 23);
         contentPane.add(btnAssign);
		 btnAssign.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	//Locale loc = new Locale("en", "US");
	            	//DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, loc);
	            	
	            	System.out.print(new SimpleDateFormat("yy-MM-dd").format(dd_startDate.getDate()));
	            	
	            	WorkOrder wo = new WorkOrder();
	            	wo.setMaterialID(array_mat[cb_materials.getSelectedIndex()].getID());
	            	wo.setJobID(job_array[cbJobtitle.getSelectedIndex()].getID());
	            	wo.setStartDate(new SimpleDateFormat("yy-MM-dd").format(dd_startDate.getDate()));
	            	if(wo.createWorkOrder() > 0) {
	                	JOptionPane.showMessageDialog(null, "Work order has been created!");
	                } else {
	                	JOptionPane.showMessageDialog(null, "There is no available Empoyee");
	                }
	            	
	            	worklist.setVisible(true);
	            	
	            }
	        });
	}
}
