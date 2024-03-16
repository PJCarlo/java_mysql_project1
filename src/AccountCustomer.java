
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class AccountCustomer extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountCustomer frame = new AccountCustomer();
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
	public AccountCustomer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 477);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerAccProfile = new JLabel();
		lblCustomerAccProfile.setBackground(Color.DARK_GRAY);
		lblCustomerAccProfile.setBounds(23, 51, 158, 158);
		ImageIcon userProfile = new ImageIcon(this.getClass().getResource("/Profile.png"));
		contentPane.setLayout(null);
		lblCustomerAccProfile.setIcon(userProfile);
		lblCustomerAccProfile.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCustomerAccProfile);

		JLabel lblCustomerUserName = new JLabel("C U S T O M E R");
		lblCustomerUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerUserName.setForeground(Color.LIGHT_GRAY);
		lblCustomerUserName.setBackground(Color.DARK_GRAY);
		lblCustomerUserName.setBounds(10, 234, 189, 29);
		lblCustomerUserName.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCustomerUserName);

		JLabel lblAccCustomerBgDsgn = new JLabel();
		lblAccCustomerBgDsgn.setBackground(Color.BLACK);
		lblAccCustomerBgDsgn.setBounds(209, 11, 498, 417);
		ImageIcon accBgDsgn = new ImageIcon(this.getClass().getResource("/Profilebgdsgn.jpg"));
		contentPane.setLayout(null);
		lblAccCustomerBgDsgn.setIcon(accBgDsgn);
		lblAccCustomerBgDsgn.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAccCustomerBgDsgn);
		
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
		
		JLabel lblCustomerName = new JLabel("");
		lblCustomerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerName.setForeground(Color.LIGHT_GRAY);
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCustomerName.setBackground(Color.DARK_GRAY);
		lblCustomerName.setBounds(10, 263, 189, 29);
		contentPane.add(lblCustomerName);
	}
}
