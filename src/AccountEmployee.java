import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AccountEmployee extends JFrame {

	private JPanel contentPane;

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

	/**
	 * Create the frame.
	 */
	public AccountEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 477);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEmployeeAccProfile = new JLabel();
		lblEmployeeAccProfile.setBackground(Color.DARK_GRAY);
		lblEmployeeAccProfile.setBounds(23, 51, 158, 158);
		ImageIcon userProfile = new ImageIcon(this.getClass().getResource("/Profile.png"));
		contentPane.setLayout(null);
		lblEmployeeAccProfile.setIcon(userProfile);
		lblEmployeeAccProfile.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblEmployeeAccProfile);

		JLabel lblEmployeeUserName = new JLabel("E M P L O Y E E");
		lblEmployeeUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmployeeUserName.setForeground(Color.LIGHT_GRAY);
		lblEmployeeUserName.setBackground(Color.DARK_GRAY);
		lblEmployeeUserName.setBounds(10, 234, 189, 29);
		lblEmployeeUserName.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblEmployeeUserName);

		JLabel lblAccEmployeeBgDsgn = new JLabel();
		lblAccEmployeeBgDsgn.setBackground(Color.BLACK);
		lblAccEmployeeBgDsgn.setBounds(209, 11, 498, 417);
		ImageIcon accBgDsgn = new ImageIcon(this.getClass().getResource("/Profilebgdsgn.jpg"));
		contentPane.setLayout(null);
		lblAccEmployeeBgDsgn.setIcon(accBgDsgn);
		lblAccEmployeeBgDsgn.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAccEmployeeBgDsgn);
		
		JButton btnBackPage = new JButton("<");
		btnBackPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupervisorAccount supervisor = new SupervisorAccount();
				supervisor.setVisible(true);
				dispose();
			}
		});
		btnBackPage.setBounds(10, 11, 41, 23);
		contentPane.add(btnBackPage);
		
		JLabel lblEmployeeName = new JLabel("uts, uts");
		lblEmployeeName.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeName.setForeground(Color.LIGHT_GRAY);
		lblEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmployeeName.setBackground(Color.DARK_GRAY);
		lblEmployeeName.setBounds(10, 263, 189, 29);
		contentPane.add(lblEmployeeName);

	}
}
