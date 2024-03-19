package EntityModel;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
	
	public User (String fname,String lname,String email,String num,String password,int type) {
		this.fname =fname;
		this.lname =lname;
		this.email =email;
		this.password =password;
		this.mobile_no =num;
	}
	
	public User (int user_id, String fname,String lname,String email,String num,String password,int type) {
		this.user_id = user_id;
		this.fname =fname;
		this.lname =lname;
		this.email =email;
		this.password =password;
		this.mobile_no =num;
	}
	
	private int user_id = 0;
	private String fname = "";
	private String lname = "";
	private String email = "";
	private String password = "";
	private String mobile_no = "";
	private int type = 0; // 0 = customer, 1 = employee, 2 = supervisor

	
	public int getUserID() {
		return this.user_id;
	}
	public void setUserID(int val) {
		this.user_id = val;
	}
	
	
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
			 int row = prepStmt.executeUpdate();
			 if(row > 0) {
				 return true;
			 }
	    } catch (SQLException e3) {
	        e3.printStackTrace();
	    }
		return return_val;
	}


	public User[] getAllEmployee() {
		User[] users = null;
		try {
	        stmt = conn.createStatement();
	        if(stmt.execute("SELECT COUNT(*) as rowCount FROM users WHERE type = 1")) {
	        	rs = stmt.getResultSet();
	        	if(rs.first()) {
	        		users = new User[rs.getInt("rowCount")];
			        if (stmt.execute("SELECT * FROM users WHERE type = 1")) {
			            rs = stmt.getResultSet();
			            while(rs.next()) {
			            		users[rs.getRow() - 1] = new User(
			            			rs.getInt("user_id"),
			            			rs.getString("first_name"),
			            			rs.getString("last_name"),
			            			rs.getString("email"),
			            			rs.getString("password"),
			            			rs.getString("mobile_no"),
			            			rs.getInt("type")
			            		);
			            }
			        }
	        	}
	        	
	        }
	        return users;
	    } catch (SQLException e3) {
	        e3.getMessage();
	    }
		return null;
	}

}
