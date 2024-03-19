package EntityModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.sql.Date;

public class Timecard {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement prepStmt = null;
	ResultSet rs = null;

	public static String DB_URI = "jdbc:mysql://localhost:3306/accounts";
    public static String DB_USER = "root";
    public static String DB_PASS = "";
    
    public Timecard() {
		try {
			conn = DriverManager.getConnection(DB_URI, DB_USER, DB_PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    private int timecard_id;
    private int user_id;
    private int workorder_id;
    private String start_time;
    private String end_time;
    private String start_date;
    private String end_date;
    
    public int getTimecardID() {
    	return this.timecard_id;
    }
    public int getUserID() {
    	return this.user_id;
    }
    public int getWorkorderID() {
    	return this.workorder_id;
    }
    public String getStartTime() {
    	return this.start_time;
    }
    public String getEndTime() {
    	return this.end_time;
    }
    public String getStartDate() {
    	return this.start_date;
    }
    public String getEndDate() {
    	return this.end_date;
    }
    
    public void setTimecardID(int val) {
    	this.timecard_id = val;
    }
    public void setUserID(int val) {
    	this.user_id = val;
    }
    public void setWorkorderID(int val) {
    	this.workorder_id = val;
    }
    public void setStartTime(String val) {
    	this.start_time = val;
    }
    public void setEndTime(String val) {
    	this.end_time = val;
    }
    public void setStartDate(String val) {
    	this.start_date = val;
    }
    public void setEndDate(String val) {
    	this.end_date = val;
    }
    
    
    // SQL TRANSACTIONS
    
    public int CreateTimecard() {
    	int affected_row = 0;
    	String query = "INSERT INTO timecard (user_id,workorder_id,start_time,end_time,start_date,end_date) VALUES(?,?,?,?,?,?)";
    	
    	try {
    		prepStmt = conn.prepareStatement(query);
    		prepStmt.setInt(1, this.getUserID());
    		prepStmt.setInt(2, this.getWorkorderID());
    		prepStmt.setString(3, this.getStartTime());
    		prepStmt.setString(4, this.getEndTime());
    		prepStmt.setString(5, this.getStartDate());
    		prepStmt.setString(6, this.getEndDate());
    		affected_row = prepStmt.executeUpdate();
    		return affected_row;
    	} catch(SQLException ex) {
    		ex.printStackTrace();
    	}
    	
    	return affected_row;
    }
    
    
    public Vector<Object[]> getWorkorderTimeline(int workorder_id) {
		Vector<Object[]> rows = new Vector<Object[]>();
		String query = "SELECT workorder.id, CONCAT(users.first_name, \" \", users.last_name) AS 'Name', timecard.start_date, timecard.start_time, timecard.end_date, timecard.end_time FROM timecard, workorder, users WHERE timecard.workorder_id = workorder.id AND timecard.user_id = users.user_id AND workorder.id = ?";
		try {
			prepStmt = conn.prepareStatement(query);
			prepStmt.setInt(1, workorder_id);
			prepStmt.execute();
			rs = prepStmt.getResultSet();
			int r = 0;
			while(rs.next()) {
				rows.add(r, new Object[] {
						rs.getString("Name").toString(), 
						rs.getInt("id") + "", 
						rs.getDate("start_date").toString(), 
						rs.getString("start_time").toString(), 
						rs.getDate("end_date"), 
						rs.getString("end_time"), 
					});
				r++;
			}
			System.out.print(rows);
			return rows;
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
		return rows;
	}
    
}
