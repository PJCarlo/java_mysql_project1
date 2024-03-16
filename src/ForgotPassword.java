import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import BusinessModel.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ForgotPassword extends JFrame {

	private JPanel contentPane;
	private JPasswordField newPassword;
	private JPasswordField reEnterPassword;
	private JTextField confirmUser;
	private JTextField mobileNumber;
	
	
	LogIn login = new LogIn();
	User newUser = new User();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword frame = new ForgotPassword();
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
	public ForgotPassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel forgotLogos = new JLabel();
		forgotLogos.setBounds(10, 11, 234, 104);
		forgotLogos.setBackground(Color.BLACK);
		ImageIcon forgotlogos = new ImageIcon(this.getClass().getResource("/logindesign.png"));
		contentPane.setLayout(null);
		forgotLogos.setIcon(forgotlogos);
		contentPane.add(forgotLogos);

		// User G-mail
		confirmUser = new JTextField();
		confirmUser.setBounds(112, 88, 209, 31);
		String defaultTextUser = " User ID";
		contentPane.add(confirmUser);
		confirmUser.setColumns(10);
		confirmUser.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (confirmUser.getText().equals(defaultTextUser)) {
					confirmUser.setText("");
				}
			}

			public void focusLost(FocusEvent e) {
				if (confirmUser.getText().isEmpty()) {
					confirmUser.setText(defaultTextUser);
				}
			}
		});
		confirmUser.setText(defaultTextUser);
		
		
		// Mobile Number
		mobileNumber = new JTextField();
		mobileNumber.setBounds(112, 143, 209, 31);
		String defaultTextUserNo = " Mobile No#";
		contentPane.add(mobileNumber);
		mobileNumber.setColumns(10);
		mobileNumber.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (mobileNumber.getText().equals(defaultTextUserNo)) {
					mobileNumber.setText("");
				}
			}

			public void focusLost(FocusEvent e) {
				if (mobileNumber.getText().isEmpty()) {
					mobileNumber.setText(defaultTextUserNo);
				}
			}
		});
		mobileNumber.setText(defaultTextUserNo);


		// New Password
		newPassword = new JPasswordField();
		newPassword.setBounds(112, 197, 210, 31);
		contentPane.add(newPassword);
		String defaultTextNewPass = " Enter New Password";
		newPassword.setText(defaultTextNewPass);
		newPassword.selectAll();
		newPassword.setEchoChar((char) 0);
		newPassword.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (newPassword.getText().equals(defaultTextNewPass)) {
					newPassword.setText("");
					newPassword.setEchoChar('*');
				}
			}

			public void focusLost(FocusEvent e) {
				if (newPassword.getText().isEmpty()) {
					newPassword.setText(defaultTextNewPass);
					newPassword.setEchoChar((char) 0);
				}
			}
		});
		
		// Show Password
		JButton btnShowNewPass = new JButton("\uD83D\uDC41");
		btnShowNewPass.addActionListener(new ActionListener() {
			private boolean isHidden;

			public void actionPerformed(ActionEvent e) {
				// Validates whether the password is hidden or not
				if (isHidden) {
					// Shows the characters
					newPassword.setEchoChar((char) 0);
					// Changes the text in the button from show to hide
					btnShowNewPass.setText("\uD83D\uDC41");
					// Informs the program the the password is not hidden
					isHidden = false;
				} else {
					// Hides the characters
					newPassword.setEchoChar('\u25cf');
					// Changes the text in the button from show to hide
					btnShowNewPass.setText("\uD83D\uDC41");
					// Informs the program the the password is not hidden
					isHidden = true;
				}
			}
		});
		btnShowNewPass.setForeground(Color.LIGHT_GRAY);
		btnShowNewPass.setBackground(Color.DARK_GRAY);
		btnShowNewPass.setBounds(323, 197, 47, 31);
		contentPane.add(btnShowNewPass);

		
		// Re-Enter Password
		reEnterPassword = new JPasswordField();
		reEnterPassword.setBounds(113, 250, 210, 31);
		contentPane.add(reEnterPassword);
		String defaultTextReEnterPass = " Re-Enter New Password";
		reEnterPassword.setText(defaultTextReEnterPass);
		reEnterPassword.selectAll();
		reEnterPassword.setEchoChar((char) 0);
		reEnterPassword.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (reEnterPassword.getText().equals(defaultTextReEnterPass)) {
					reEnterPassword.setText("");
					reEnterPassword.setEchoChar('*');
				}
			}

			public void focusLost(FocusEvent e) {
				if (reEnterPassword.getText().isEmpty()) {
					reEnterPassword.setText(defaultTextReEnterPass);
					reEnterPassword.setEchoChar((char) 0);
				}
			}
		});
		
		// Show Password
		JButton btnShowreEnterNewPass = new JButton("\uD83D\uDC41");
		btnShowreEnterNewPass.addActionListener(new ActionListener() {
			private boolean isHidden;

			public void actionPerformed(ActionEvent e) {
				// Validates whether the password is hidden or not
				if (isHidden) {
					// Shows the characters
					reEnterPassword.setEchoChar((char) 0);
					// Changes the text in the button from show to hide
					btnShowreEnterNewPass.setText("\uD83D\uDC41");
					// Informs the program the the password is not hidden
					isHidden = false;
				} else {
					// Hides the characters
					reEnterPassword.setEchoChar('\u25cf');
					// Changes the text in the button from show to hide
					btnShowreEnterNewPass.setText("\uD83D\uDC41");
					// Informs the program the the password is not hidden
					isHidden = true;
				}
			}
		});
		btnShowreEnterNewPass.setForeground(Color.LIGHT_GRAY);
		btnShowreEnterNewPass.setBackground(Color.DARK_GRAY);
		btnShowreEnterNewPass.setBounds(323, 250, 47, 31);
		contentPane.add(btnShowreEnterNewPass);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!(confirmUser.getText().equals(null) && mobileNumber.getText().equals(null))){
					newUser.setMNo(mobileNumber.getText().trim());
					
					if(newUser.verifyEmail(confirmUser.getText().trim())) {
						if (Arrays.equals(newPassword.getPassword(),reEnterPassword.getPassword())) {
							newUser.setPassword(newPassword.getText().trim());
							if(newUser.changePassword()) {
								JOptionPane.showMessageDialog(null, "Password reset successful.");
							} else {
								JOptionPane.showMessageDialog(null, "Password reset successful.");
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Email not found.");
					}
					
//					if(newUser.forgotPass()) {
//						if (!(newPassword.getText().equals(reEnterPassword.getText()))) {
//							JOptionPane.showMessageDialog(null, "password missmatch");
//							
//						} else {
//							JOptionPane.showMessageDialog(null, "Password reset successful.");
//						}
//							
//					} else {
//		                // Password reset failed
//			            JOptionPane.showMessageDialog(null, "Failed to reset password. Please check your email and old password.");
//		            }
					
		        } else {
		            // Email or old password is empty
		            JOptionPane.showMessageDialog(null, "Please enter your email and old password.");
				}
				
				login.setVisible(true);
				
			}
			
		});
		btnConfirm.setBounds(112, 320, 89, 23);
		contentPane.add(btnConfirm);

		
		// -----------------------------------------------------------------------------------------------------------
		// Cancel Button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearControls();
				login.setVisible(true);
			}
		});
		btnCancel.setBounds(233, 320, 89, 23);
		contentPane.add(btnCancel);

		
		// ---------------------------------------------------------------------------------------------------------
		// BackGround Design
		JLabel forgotBg = new JLabel();
		forgotBg.setBounds(0, 0, 450, 389);
		ImageIcon ImgforgotBg = new ImageIcon(this.getClass().getResource(("/ToolandDieshopLoginbg.jpg")));
		contentPane.setLayout(null);
		forgotBg.setIcon(ImgforgotBg);
		contentPane.add(forgotBg);

	}

	public void clearControls() {
		confirmUser.setText(null);
		mobileNumber.setText(null);
		newPassword.setText(null);
		reEnterPassword.setText(null);
		dispose();
	}
	
}
