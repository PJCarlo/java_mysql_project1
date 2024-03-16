
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import EntityModel.Job;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class CreateJob extends JFrame {

	private JPanel contentPane;
	private JTextField txtJobTitle;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateJob frame = new CreateJob();
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
	public CreateJob() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAssignJob = new JLabel("Create a Job");
		lblAssignJob.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAssignJob.setBounds(19, 24, 215, 29);
		contentPane.add(lblAssignJob);
		
		JLabel lblJobNumber = new JLabel("Job Title");
		lblJobNumber.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblJobNumber.setBounds(24, 69, 394, 29);
		contentPane.add(lblJobNumber);
		
		txtJobTitle = new JTextField();
		txtJobTitle.setBounds(24, 98, 394, 29);
		contentPane.add(txtJobTitle);
		txtJobTitle.setColumns(10);
		
		JLabel lblJobDescription = new JLabel("Job Description");
		lblJobDescription.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblJobDescription.setBounds(24, 143, 394, 29);
		contentPane.add(lblJobDescription);
		


		JTextArea txtJobDescr = new JTextArea();
		txtJobDescr.setBounds(24, 173, 394, 81);
		contentPane.add(txtJobDescr);

		
		JButton btnAssign = new JButton("Assign");
        btnAssign.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
               Job newJob = new Job();
                newJob.setTitle(txtJobTitle.getText());
                newJob.setDesc(txtJobDescr.getText());
                if(newJob.createJob() > 0) {
                	JOptionPane.showMessageDialog(null, "Job has been created!");
                }
            }
        });
        
//		User users = new User();
//		User users_array[] = users.getAllEmployee();
//	
//		
//		String user_names[] = new String[users_array.length];
//		for(int i = 0;i<users_array.length;i++) {
//			user_names[i] = users_array[i].getFirstName() +" "+ users_array[i].getLastName();
//		}
		
		
		btnAssign.setBounds(27, 318, 96, 23);
		contentPane.add(btnAssign);
	
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(326, 317, 96, 23);
		contentPane.add(btnCancel);
		
		
	}
}
