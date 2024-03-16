
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import EntityModel.Job;
import EntityModel.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AssignJob extends JFrame {

	private JPanel contentPane;
	private JTextField textJobDescription;
	private JTextField textEstimatedTime;
	private JTextField textEstimatedMaterial;
	private JTextField textDateSchedule;
	private JTextField textField;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssignJob frame = new AssignJob();
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
	public AssignJob() {
		

		
		Job job = new Job();
		Job job_array[] = job.getAllJobs();

		String job_titles[] = new String[job_array.length];
		for(int i = 0;i<job_array.length;i++) {
			job_titles[i] = job_array[i].getTitle();
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAssignJob = new JLabel("Assign Job");
		lblAssignJob.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAssignJob.setBounds(195, 30, 96, 29);
		contentPane.add(lblAssignJob);
		
		JLabel lblJobNumber = new JLabel("Job Number");
		lblJobNumber.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblJobNumber.setBounds(132, 93, 96, 29);
		contentPane.add(lblJobNumber);
		
		textJobDescription = new JTextField();
		textJobDescription.setColumns(10);
		textJobDescription.setBounds(132, 190, 220, 29);
		contentPane.add(textJobDescription);
		
		JLabel lblJobDescription = new JLabel("Job Description");
		lblJobDescription.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblJobDescription.setBounds(132, 162, 118, 29);
		contentPane.add(lblJobDescription);
		
		JLabel lblEstimatedTime = new JLabel("Estimated Time");
		lblEstimatedTime.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEstimatedTime.setBounds(132, 230, 118, 29);
		contentPane.add(lblEstimatedTime);
		
		textEstimatedTime = new JTextField();
		textEstimatedTime.setColumns(10);
		textEstimatedTime.setBounds(132, 257, 220, 29);
		contentPane.add(textEstimatedTime);
		
		JLabel lblEstimatedMaterial = new JLabel("Estimated Material");
		lblEstimatedMaterial.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblEstimatedMaterial.setBounds(132, 297, 142, 29);
		contentPane.add(lblEstimatedMaterial);
		
		textEstimatedMaterial = new JTextField();
		textEstimatedMaterial.setColumns(10);
		textEstimatedMaterial.setBounds(132, 323, 220, 29);
		contentPane.add(textEstimatedMaterial);
		
		JLabel lblDateTime = new JLabel("Date Schedule");
		lblDateTime.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDateTime.setBounds(132, 363, 159, 29);
		contentPane.add(lblDateTime);
		
		textDateSchedule = new JTextField();
		textDateSchedule.setColumns(10);
		textDateSchedule.setBounds(132, 390, 220, 29);
		contentPane.add(textDateSchedule);
		
		JLabel lblTimeSchedule = new JLabel("Time Schedule");
		lblTimeSchedule.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTimeSchedule.setBounds(132, 430, 159, 29);
		contentPane.add(lblTimeSchedule);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(132, 456, 220, 29);
		contentPane.add(textField);
		
		JButton btnAssign = new JButton("Assign");
        btnAssign.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
                
            }
        });
		
        btnAssign.setBounds(104, 547, 96, 23);
        contentPane.add(btnAssign);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(287, 547, 96, 23);
		contentPane.add(btnCancel);


		User users = new User();
		User users_array[] = users.getAllEmployee();
		JComboBox cb_employee = new JComboBox();
		cb_employee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, users_array[cb_employee.getSelectedIndex()].getEmail());
			}
		});
		cb_employee.setBounds(132, 501, 220, 35);
		String user_names[] = new String[users_array.length];
		for(int i = 0;i<users_array.length;i++) {
			user_names[i] = users_array[i].getFirstName() +" "+ users_array[i].getLastName();
		}
		cb_employee.setModel(new DefaultComboBoxModel<String>(user_names));
		contentPane.add(cb_employee);
		
		
		JComboBox cbJobtitle = new JComboBox();
		cbJobtitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
            	textJobDescription.setText(job_array[cbJobtitle.getSelectedIndex()].getDesc());
			}
		});
		cbJobtitle.setBounds(132, 116, 220, 35);
		
		cbJobtitle.setModel(new DefaultComboBoxModel<String>(job_titles));
		
		contentPane.add(cbJobtitle);
		
		
		
		
	}
}
