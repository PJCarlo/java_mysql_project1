import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
//import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BusinessModel.User;
import java.awt.Component;


public class LogIn extends JFrame {
	private JPanel contentPane;
	private JTextField userText;
	private JPasswordField passText;
	
//	Connection conn = null;
	
	User newUser = new User();
	
	
	

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();

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
	public LogIn() {
		setTitle("User Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 316);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);

		JLabel loginLogos = new JLabel();
		loginLogos.setBounds(10, 11, 234, 104);
		loginLogos.setBackground(Color.BLACK);
		ImageIcon loginlogos = new ImageIcon(this.getClass().getResource("/logindesign.png"));
		contentPane.setLayout(null);
		loginLogos.setIcon(loginlogos);
		contentPane.add(loginLogos);
		
		//-------------------------------------------------------------------------------------------------

		/*
		 * TextField in this code using text field i add default text for the text
		 * field, that asking for user Id this Text field has function of focus gained
		 * and focus lost in focus gained if the user click the text field the default
		 * text are disappearing and replace new as user Id to login in focus lost if
		 * the user click the other field the default text will appear again and asking
		 * to fill the text field for User Id.
		 */
		userText = new JTextField();
		userText.setForeground(Color.BLACK);
		userText.setBackground(Color.WHITE);
		userText.setBounds(111, 84, 210, 31);
		String defaultTextUser = " User ID";
		contentPane.add(userText);
		userText.setColumns(10);
		userText.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (userText.getText().equals(defaultTextUser)) {
					userText.setText("");
				}
			}

			public void focusLost(FocusEvent e) {
				if (userText.getText().isEmpty()) {
					userText.setText(defaultTextUser);
				}
			}
		});
		userText.setText(defaultTextUser);
		
		//-------------------------------------------------------------------------------------------------

		/*
		 * JPasswordField in this code using password field i add default text for the
		 * password field, this Password field has function of focus gained and focus
		 * lost in focus gained if the user click the password field the default text
		 * are disappearing and replace new as password to login in focus lost if the
		 * user click the other field the default text will appear again and asking to
		 * fill the password field.
		 */
		passText = new JPasswordField();
		passText.setBounds(111, 126, 210, 31);
		contentPane.add(passText);
		String defaultTextPass = " Password";
		passText.setText(defaultTextPass);
		passText.selectAll();
		passText.setEchoChar((char) 0);
		passText.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (passText.getText().equals(defaultTextPass)) {
					passText.setText("");
					passText.setEchoChar('*');
				}
			}

			public void focusLost(FocusEvent e) {
				if (passText.getText().isEmpty()) {
					passText.setText(defaultTextPass);
					passText.setEchoChar((char) 0);
				}
			}
		});
		
		//-------------------------------------------------------------------------------------------------

		JButton btnShowPass = new JButton("\uD83D\uDC41");
		btnShowPass.addActionListener(new ActionListener() {
			private boolean isHidden;
			public void actionPerformed(ActionEvent e) {
				// Validates whether the password is hidden or not
				if (isHidden) {
					// Shows the characters
					passText.setEchoChar((char) 0);
					// Changes the text in the button from show to hide
					btnShowPass.setText("\uD83D\uDC41");
					// Informs the program the the password is not hidden
					isHidden = false;
				} else {
					// Hides the characters
					passText.setEchoChar('\u25cf');
					// Changes the text in the button from show to hide
					btnShowPass.setText("\uD83D\uDC41");
					// Informs the program the the password is not hidden
					isHidden = true;
				}
			}
		});
		btnShowPass.setForeground(Color.LIGHT_GRAY);
		btnShowPass.setBackground(Color.DARK_GRAY);
		btnShowPass.setBounds(321, 126, 47, 31);
		contentPane.add(btnShowPass);
		
		//--------------------------------------------------------------------------------------------------
		
		JButton btnForgotPass = new JButton("forgot password?");
		btnForgotPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean forgot = true;
				if (forgot == true) {
					ForgotPassword forgotPass = new ForgotPassword();
					forgotPass.setVisible(true);
					dispose();
				}
			}
		});
		btnForgotPass.setForeground(Color.LIGHT_GRAY);
		btnForgotPass.setBackground(Color.DARK_GRAY);
		btnForgotPass.setBounds(183, 157, 138, 23);
		contentPane.add(btnForgotPass);
		
		
		//--------------------------------------------------------------------------------------------------

		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		            
					if(!(userText.getText().equals(null) && (passText.getText().equals(null)))) {
						
						newUser.setEmail(userText.getText().trim());
						newUser.setPassword(passText.getText().trim());
						
						if(newUser.loginUser()) {
							JOptionPane.showMessageDialog(null,"Welcome!" + " " + newUser.getFirstName());
							
							if(newUser.getType() == 2) {
								SupervisorAccount supervisorAccount = new SupervisorAccount();
								supervisorAccount.setVisible(true);
								dispose();
								
							} else if(newUser.getType() == 1) {
								EmployeeAccount employeeAccount = new EmployeeAccount();
								employeeAccount.setVisible(true);
								dispose();
							}
						} else {
							JOptionPane.showMessageDialog(null,"Login failed!");
						}
						
					}
				
				userText.setText(null);
				passText.setText(null);
				userText.requestFocus();
			}
		});
		btnLogIn.setBounds(111, 218, 89, 23);
		contentPane.add(btnLogIn);
		
		
		//---------------------------------------------------------------------------------------------------

		JButton btnSignIn = new JButton("Sign Up");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAcc createacc = new CreateAcc();
				createacc.setVisible(true);
			}
		});
		btnSignIn.setBounds(232, 218, 89, 23);
		contentPane.add(btnSignIn);

		JLabel loginBg = new JLabel();
		loginBg.setOpaque(true);
		loginBg.setAlignmentX(Component.CENTER_ALIGNMENT);
		loginBg.setBounds(0, 0, 405, 277);
		ImageIcon loginImgBg = new ImageIcon(this.getClass().getResource("/ToolandDieshopLoginbg.jpg"));
		contentPane.setLayout(null);
		loginBg.setIcon(loginImgBg);
		contentPane.add(loginBg);

	}

}
