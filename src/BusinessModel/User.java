package BusinessModel;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.UUID;

import javax.swing.JOptionPane;

import java.sql.ResultSet;


public class User {

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement prepStmt = null;
	ResultSet rs = null;

	public static String DB_URI = "jdbc:mysql://localhost:3306/accounts";
    public static String DB_USER = "root";
    public static String DB_PASS = "";
    
	public User() {
		try {
			conn = DriverManager.getConnection(DB_URI, DB_USER, DB_PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String user_id = "";
	private String fname = "";
	private String lname = "";
	private String email = "";
	private String password = "";
	private String mobile_no = "";
	private int type = 0; // 0 = customer, 1 = employee, 2 = supervisor
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setEmail(String val) {
		this.email = val;
	}
	
	public void setPassword(String val) {
		this.password = val;
	}
	
	
	public String getFirstName() {
		return this.fname;
	}
	
	public String getLastName() {
		return this.lname;
	}
	
	public String getMNo() {
		return this.mobile_no;
	}
	
	public void setFName(String val) {
		this.fname = val;
	}
	
	public void setLName(String val) {
		this.lname = val;
	}
	
	public void setMNo(String val) {
		this.mobile_no = val;
	}
	
	public int getType() {
		return this.type;
	}
	
	public String getUserType() {
		switch(this.getType()) {
		case 0:
			return "Customer";
		case 1:
			return "Employee";
		case 2: 
			return "Supervisor";
		default:
			return "Admin";
		}
	}
	
	public void setType(int val) {
		this.type = val;
	}
	
	public boolean loginUser() {
		try {
			stmt = conn.createStatement();
			 if (stmt.execute("SELECT * FROM users WHERE email = '" + this.getEmail() + "'")) {
				 rs = stmt.getResultSet();
				 if(rs.first()) {
					 this.setFName(rs.getString("first_name"));
					 this.setLName(rs.getString("last_name"));
					 this.setType(Integer.parseInt(rs.getString("type")));
					 this.setMNo(rs.getString("mobile_no"));
					 return rs.getString("password").trim().equals(this.getPassword().trim());
				 } else {
					 return false;
				 }
		    }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}
	
	
	public void signUp() {
		try {
			String ins_qry = "INSERT INTO users(first_name, last_name, email, mobile_no, password,type) VALUES (?,?,?,?,?,?)";
			prepStmt = conn.prepareStatement(ins_qry);
			prepStmt.setString(1, this.getFirstName());
			prepStmt.setString(2, this.getLastName());
			prepStmt.setString(3, this.getEmail());
			prepStmt.setString(4, this.getMNo());
			prepStmt.setString(5, this.getPassword());
			prepStmt.setInt(6, this.getType());
		
			if(prepStmt.executeUpdate() > 0) {
				System.out.print("Row inserted!");
			}
		} catch(SQLException e2) {
			e2.printStackTrace();
		}
	}
	
	public boolean verifyEmail(String email) {
		boolean return_val = false;
		try {
	        stmt = conn.createStatement();
	        if (stmt.execute("SELECT email FROM users")) {
	            rs = stmt.getResultSet();
	            while(rs.next()) {
	            	if(rs.getString("email").equals(email)) {
	            		setEmail(email);
	            		return_val = true;
	            		return return_val;
	            	}
	            }
	        }
	    } catch (SQLException e3) {
	        e3.printStackTrace();
	    }
		return return_val;
	}
	
	public boolean changePassword() {
		boolean return_val = false;
		try {
			 String qry =  "UPDATE users SET password=? where email =?";
			 prepStmt = conn.prepareStatement(qry);
			 prepStmt.setString(1, getPassword());
			 prepStmt.setString(2, getEmail());
			 int r = prepStmt.executeUpdate();
			 if(r > 0) {
				 return true;
			 }
	    } catch (SQLException e3) {
	        e3.printStackTrace();
	    }
		return return_val;
	}

	public boolean forgotPass() {
	    try {
	        stmt = conn.createStatement();
	        if (stmt.execute("SELECT * FROM users WHERE email = '" + this.getEmail() + "'")) {
	            rs = stmt.getResultSet();
	            if (rs.first()) {
	            	
	                // Generate a temporary password
	                String temporaryPassword = UUID.randomUUID().toString().substring(0, 8);
	                
	                // Update the database with the temporary password
	                int rowsUpdate = stmt.executeUpdate("UPDATE users SET password = '" + temporaryPassword + "' WHERE email = '" + this.getEmail() + "'");
	                
	                if (rowsUpdate > 0) {
	                    // Send the temporary password to the user's
	                    JOptionPane.showMessageDialog(null, "Your Temporary Password is: " + temporaryPassword);
	                    System.out.println("Temporary password sent to your email.");
	                } else {
	                    System.out.println("Failed to update password.");
	                }
	            } else {
	                System.out.println("User with this email doesn't exist.");
	            }
	        }
	    } catch (SQLException e3) {
	        e3.printStackTrace();
	    }
	    return false;
	}

}
