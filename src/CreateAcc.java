import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import EntityModel.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CreateAcc extends JFrame {
    
    private static String EmailRegex =  "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static Pattern pattern = Pattern.compile(EmailRegex);

	private JPanel contentPane;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldGMail;
	private JPasswordField passwordField;
	private JPasswordField confirmpasswordField;
	private JTextField textFieldMobileNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAcc frame = new CreateAcc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param conn 
	 */
	public CreateAcc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 598);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon signinlogos = new ImageIcon(this.getClass().getResource("/logindesign.png"));
		contentPane.setLayout(null);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setBackground(Color.DARK_GRAY);
		lblFirstName.setBounds(141, 82, 136, 22);
		contentPane.add(lblFirstName);

		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(141, 105, 237, 27);
		contentPane.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLastName.setBackground(Color.DARK_GRAY);
		lblLastName.setBounds(141, 143, 136, 22);
		contentPane.add(lblLastName);

		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);
		textFieldLastName.setBounds(141, 166, 237, 27);
		contentPane.add(textFieldLastName);

		JLabel lblMobileNumber = new JLabel("Mobile No#");
		lblMobileNumber.setForeground(Color.WHITE);
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMobileNumber.setBackground(Color.DARK_GRAY);
		lblMobileNumber.setBounds(141, 206, 136, 22);
		contentPane.add(lblMobileNumber);

		textFieldMobileNumber = new JTextField();
		textFieldMobileNumber.setColumns(10);
		textFieldMobileNumber.setBounds(141, 228, 237, 27);
		contentPane.add(textFieldMobileNumber);

		JLabel lblGMail = new JLabel("E-mail");
		lblGMail.setForeground(Color.WHITE);
		lblGMail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGMail.setBackground(Color.DARK_GRAY);
		lblGMail.setBounds(141, 266, 136, 22);
		contentPane.add(lblGMail);

		textFieldGMail = new JTextField();
		textFieldGMail.setBounds(141, 288, 237, 27);
		contentPane.add(textFieldGMail);
		textFieldGMail.setColumns(10);

		JLabel lblPass = new JLabel("Password");
		lblPass.setForeground(Color.WHITE);
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPass.setBackground(Color.DARK_GRAY);
		lblPass.setBounds(141, 386, 136, 22);
		contentPane.add(lblPass);

		passwordField = new JPasswordField();
		passwordField.setBounds(141, 408, 237, 27);
		contentPane.add(passwordField);

		JLabel lblConfirmPass = new JLabel("Confirm Password");
		lblConfirmPass.setForeground(Color.WHITE);
		lblConfirmPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConfirmPass.setBackground(Color.DARK_GRAY);
		lblConfirmPass.setBounds(141, 446, 136, 22);
		contentPane.add(lblConfirmPass);
		

		JComboBox cbUserType = new JComboBox();
		cbUserType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cbUserType.setModel(new DefaultComboBoxModel(new String[] {"Customer", "Employee", "Supervisor"}));
		cbUserType.setBounds(143, 350, 236, 27);
		contentPane.add(cbUserType);

		confirmpasswordField = new JPasswordField();
		confirmpasswordField.setBounds(141, 469, 237, 27);
		contentPane.add(confirmpasswordField);

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Arrays.equals(confirmpasswordField.getPassword(),passwordField.getPassword())) {
					if(isValid(textFieldGMail.getText().trim())) {
						User newUser = new User();
						newUser.setFName(textFieldFirstName.getText().trim());
						newUser.setLName(textFieldLastName.getText().trim());
						newUser.setEmail(textFieldGMail.getText().trim());
						newUser.setMNo(textFieldMobileNumber.getText().trim());
						newUser.setPassword(passwordField.getText().trim());
						newUser.setType(cbUserType.getSelectedIndex());
						newUser.signUp();
					} else {
						JOptionPane.showMessageDialog(null,"Invalid email address!");
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Password mismatch!");
				}
			}
		});
		btnCreate.setBounds(98, 525, 89, 23);
		contentPane.add(btnCreate);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(337, 525, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblAccountType = new JLabel("Account Type");
		lblAccountType.setForeground(Color.WHITE);
		lblAccountType.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAccountType.setBackground(Color.DARK_GRAY);
		lblAccountType.setBounds(141, 325, 136, 22);
		contentPane.add(lblAccountType);
		
		
				JLabel lblCreateAccLogo = new JLabel("");
				lblCreateAccLogo.setBackground(Color.DARK_GRAY);
				lblCreateAccLogo.setBounds(10, 11, 249, 104);
				lblCreateAccLogo.setIcon(signinlogos);
				lblCreateAccLogo.setHorizontalAlignment(SwingConstants.CENTER);
				contentPane.add(lblCreateAccLogo);

	}
	
	public boolean isValid(String textFieldGmail) {	
		// Regular expression for email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(textFieldGMail.getText());
        return matcher.matches();
	}
}
