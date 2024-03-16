
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import BusinessModel.User;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AccountSupervisor extends JFrame {
	
	User newUser = new User();
	LogIn login = new LogIn();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountSupervisor frame = new AccountSupervisor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AccountSupervisor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 477);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSupervisorAccProfile = new JLabel();
		lblSupervisorAccProfile.setBackground(Color.DARK_GRAY);
		lblSupervisorAccProfile.setBounds(23, 51, 158, 158);
		ImageIcon userProfile = new ImageIcon(this.getClass().getResource("/Profile.png"));
		contentPane.setLayout(null);
		lblSupervisorAccProfile.setIcon(userProfile);
		lblSupervisorAccProfile.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSupervisorAccProfile);

		JLabel lblSupervisorUserName = new JLabel("S U P E R V I S O R");
		lblSupervisorUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSupervisorUserName.setForeground(Color.LIGHT_GRAY);
		lblSupervisorUserName.setBackground(Color.DARK_GRAY);
		lblSupervisorUserName.setBounds(10, 234, 189, 29);
		lblSupervisorUserName.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSupervisorUserName);

		JLabel lblAccSupervisorBgDsgn = new JLabel();
		lblAccSupervisorBgDsgn.setBackground(Color.BLACK);
		lblAccSupervisorBgDsgn.setBounds(209, 11, 498, 417);
		ImageIcon accBgDsgn = new ImageIcon(this.getClass().getResource("/Profilebgdsgn.jpg"));
		contentPane.setLayout(null);
		lblAccSupervisorBgDsgn.setIcon(accBgDsgn);
		lblAccSupervisorBgDsgn.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAccSupervisorBgDsgn);
		
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
		
		JLabel lblSupervisorName = new JLabel("pantonia, aeious");
		lblSupervisorName.setHorizontalAlignment(SwingConstants.CENTER);
		lblSupervisorName.setForeground(Color.LIGHT_GRAY);
		lblSupervisorName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSupervisorName.setBackground(Color.DARK_GRAY);
		lblSupervisorName.setBounds(10, 263, 189, 29);
		contentPane.add(lblSupervisorName);

	}
}
