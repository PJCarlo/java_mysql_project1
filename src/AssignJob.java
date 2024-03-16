
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class AssignJob extends JFrame {

	private JPanel contentPane;
	private JTextField textJobNumber;
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
	public AssignJob() {
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
		
		textJobNumber = new JTextField();
		textJobNumber.setBounds(132, 122, 220, 29);
		contentPane.add(textJobNumber);
		textJobNumber.setColumns(10);
		
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
	}

}
