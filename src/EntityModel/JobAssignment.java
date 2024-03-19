package EntityModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class JobAssignment {

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement prepStmt = null;
	ResultSet rs = null;

	public static String DB_URI = "jdbc:mysql://localhost:3306/accounts";
    public static String DB_USER = "root";
    public static String DB_PASS = "";
    
	public JobAssignment() {
		try {
			conn = DriverManager.getConnection(DB_URI, DB_USER, DB_PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JobAssignment(int id, int user_id, int job_id, int status, Date startDate, Date endDate, String startTime, String endTime) {
		this.id = id;
		this.user_id = user_id;
		this.job_id = job_id;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	private int id;
	private int user_id;
	private int job_id;
	private int status;
	private Date startDate;
	private Date endDate;
	private String startTime;
	private String endTime;
	
	
	// GETTER PROPERTIES
	
	public int getID() {
		return this.id;
	}
	
	public int getUserID() {
		return this.user_id;
	}
	
	public int getJobID() {
		return this.job_id;
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public Date getStartDate() {
		return this.startDate;
	}
	
	public Date getEndDate() {
		return this.endDate;
	}
	
	public String getStartTime() {
		return this.startTime;
	}
	
	public String getEndTime() {
		return this.endTime;
	}
	
	
	
	
	// SETTERS PROPERTIES
	
	public void setID(int val) {
		this.id = val;
	}
	
	public void setUserID(int val) {
		this.user_id = val;
	}
	
	public void setJobID(int val) {
		this.job_id = val;
	}
	
	public void setStatus(int val) {
		this.status = val;
	}
	
	public void setStartDate(Date val) {
		this.startDate = val;
	}
	
	public void setEndDate(Date val) {
		this.endDate = val;
	}
	
	public void setStartTime(String val) {
		this.startTime = val;
	}

	public void setEndTime(String val) {
		this.endTime = val;
	}
	
	public int createWorkOrder() {
		try {
			String query = "INSERT INTO workorder (user_id, job_id, status, start_date, start_time, end_date, end_time) VALUES(?,?,?,?,?,?,?)";
			prepStmt = conn.prepareStatement(query);
			prepStmt.setInt(1, this.getUserID());
			prepStmt.setInt(2, this.getJobID());
			prepStmt.setInt(3, this.getStatus());
			prepStmt.setDate(5, this.getStartDate());
			prepStmt.setDate(6, this.getEndDate());
			prepStmt.setString(5, this.getStartTime());
			prepStmt.setString(6, this.getEndTime());
			int row = prepStmt.executeUpdate();
			return row;
		} catch(SQLException e1) {
			
		}
		return 0;
	}
	
}
