
import java.awt.EventQueue;

import java.util.regex.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import EntityModel.Job;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class CreateJob extends JFrame {

	private JPanel contentPane;
	private JTextField txtJobTitle;
	private JTextField textJobNo;
	
	

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
		textJobNo = new JTextField();
		textJobNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textJobNo.setEnabled(false);
		textJobNo.setBounds(19, 64, 391, 42);
		
		textJobNo.setText(System.currentTimeMillis() + "".replaceAll(":", "").replaceAll("-", "").replaceAll(" ",""));
		
		
		contentPane.add(textJobNo);
		textJobNo.setColumns(10);
		
		JLabel lblAssignJob = new JLabel("Create a Job");
		lblAssignJob.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAssignJob.setBounds(19, 24, 215, 29);
		contentPane.add(lblAssignJob);
		
		JPanel panel = new JPanel();
		panel.setBounds(19, 117, 424, 58);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblJobNumber = new JLabel("Job Title");
		lblJobNumber.setBounds(0, 0, 384, 29);
		panel.add(lblJobNumber);
		lblJobNumber.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		txtJobTitle = new JTextField();
		txtJobTitle.setBounds(0, 29, 384, 29);
		panel.add(txtJobTitle);
		txtJobTitle.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(19, 191, 424, 111);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblJobDescription = new JLabel("Job Description");
		lblJobDescription.setBounds(0, 0, 384, 29);
		panel_1.add(lblJobDescription);
		lblJobDescription.setFont(new Font("Times New Roman", Font.BOLD, 15));
		


		JTextArea txtJobDescr = new JTextArea();
		txtJobDescr.setBounds(0, 30, 384, 81);
		panel_1.add(txtJobDescr);

		
		JButton btnAssign = new JButton("Create");
        btnAssign.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
               Job newJob = new Job();
               	newJob.setID(textJobNo.getText());
                newJob.setTitle(txtJobTitle.getText());
                newJob.setDesc(txtJobDescr.getText());
                if(newJob.createJob() > 0) {
                	JOptionPane.showMessageDialog(null, "Job has been created!");
                }
            }
        });
		
		
		btnAssign.setBounds(27, 318, 96, 23);
		contentPane.add(btnAssign);
	
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(326, 317, 96, 23);
		contentPane.add(btnCancel);
		
		
	}
}
