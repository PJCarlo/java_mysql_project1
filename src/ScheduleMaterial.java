
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
//import java.util.ArrayList;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

//import EntityModel.TryCustomers;

import javax.swing.SwingConstants;
import java.awt.Font;

public class ScheduleMaterial extends JFrame {
	
	//private ArrayList<TryCustomers> customerList = new ArrayList<>();

	private JPanel contentPane;
	private JTextField textFieldCustomerID;
	private JTextField textFieldCustomerName;
	private JTextField textFieldScheduleTime;
	private JDateChooser dateChooser;
	//private TryCustomers tryCustom;	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScheduleMaterial frame = new ScheduleMaterial();
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
	public ScheduleMaterial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMaterialName = new JLabel("\"Printing\"");
		lblMaterialName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaterialName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaterialName.setBounds(21, 51, 117, 28);
		contentPane.add(lblMaterialName);
		
		JLabel lblCustomerID = new JLabel("Customer ID");
		lblCustomerID.setBounds(21, 115, 192, 28);
		contentPane.add(lblCustomerID);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(256, 115, 192, 28);
		contentPane.add(lblCustomerName);
		
		textFieldCustomerID = new JTextField();
		textFieldCustomerID.setBounds(21, 143, 192, 28);
		contentPane.add(textFieldCustomerID);
		textFieldCustomerID.setColumns(10);
		
		textFieldCustomerName = new JTextField();
		textFieldCustomerName.setColumns(10);
		textFieldCustomerName.setBounds(256, 143, 192, 28);
		contentPane.add(textFieldCustomerName);
		
		JLabel lblMaterialCost = new JLabel("\"13,000\"");
		lblMaterialCost.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaterialCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaterialCost.setBounds(331, 51, 117, 28);
		contentPane.add(lblMaterialCost);
		
		JLabel lblScheduleDate = new JLabel("Schedule Date");
		lblScheduleDate.setBounds(21, 207, 192, 28);
		contentPane.add(lblScheduleDate);
		
		JLabel lblScheduleTime = new JLabel("Schedule Time");
		lblScheduleTime.setBounds(256, 207, 192, 28);
		contentPane.add(lblScheduleTime);
		
		textFieldScheduleTime = new JTextField();
		textFieldScheduleTime.setColumns(10);
		textFieldScheduleTime.setBounds(256, 236, 192, 28);
		contentPane.add(textFieldScheduleTime);
		
		JButton btnSchedule = new JButton("Schedule");
		btnSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!(textFieldCustomerID.getText().equals(null) && (textFieldCustomerName.getText().equals(null)))) {
					
					JOptionPane.showMessageDialog(null, "Your request is now Pending PLease wait to schedule");
					
					clearControls();
					
				} else {
					JOptionPane.showMessageDialog(null, "Request Failed!");
				}
			
			textFieldCustomerID.setText(null);
			textFieldCustomerName.setText(null);
			textFieldScheduleTime.requestFocus();
			
			
				
			}
		});
		btnSchedule.setBounds(74, 323, 89, 23);
		contentPane.add(btnSchedule);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearControls();
			}
		});
		btnCancel.setBounds(310, 323, 89, 23);
		contentPane.add(btnCancel);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(21, 236, 192, 28);
		contentPane.add(dateChooser);
		
		JLabel lblMaterialID = new JLabel("\"3DKAI1912\"");
		lblMaterialID.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaterialID.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaterialID.setBounds(174, 51, 117, 28);
		contentPane.add(lblMaterialID);
		
		JLabel lblMatrialTitle = new JLabel("Material Name");
		lblMatrialTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatrialTitle.setBounds(21, 21, 117, 28);
		contentPane.add(lblMatrialTitle);
		
		JLabel lblMatrialTitleID = new JLabel("Material ID");
		lblMatrialTitleID.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatrialTitleID.setBounds(174, 21, 117, 28);
		contentPane.add(lblMatrialTitleID);
		
		JLabel lblMatrialTitleID_1 = new JLabel("Material ID");
		lblMatrialTitleID_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatrialTitleID_1.setBounds(331, 21, 117, 28);
		contentPane.add(lblMatrialTitleID_1);
	}
	
	public void clearControls() {
		textFieldCustomerID.setText(null);
		textFieldCustomerName.setText(null);
		textFieldScheduleTime.setText(null);
		dispose();
	}
	
//	private void addCustomer() {
//		TryCustomers newCustom = new TryCustomers();
//		newCustom.setCustomID(Integer.parseInt(textFieldCustomerID.getText()));
//		newCustom.setCustomerName(textFieldCustomerName.getText());
//		newCustom.setDate(dateChooser.getDate().toString());
//		newCustom.setStartTime(textFieldScheduleTime.getText());
//        customerList.add(newCustom);
//
//        JOptionPane.showMessageDialog(this, "Customer Added Successfully!");
//        clearControls();
//    }

	
}