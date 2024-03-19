package EntityModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class WorkOrder {

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement prepStmt = null;
	ResultSet rs = null;

	public static String DB_URI = "jdbc:mysql://localhost:3306/accounts";
    public static String DB_USER = "root";
    public static String DB_PASS = "";
    
	public WorkOrder() {
		try {
			conn = DriverManager.getConnection(DB_URI, DB_USER, DB_PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public WorkOrder(int id, int mat_id, String job_id, int status, String startDate, String endDate, String startTime, String endTime) {
		this.id = id;
		this.mat_id = mat_id;
		this.job_id = job_id;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	private int id;
	private int mat_id;
	private String job_id;
	private int status;
	private String startDate;
	private String endDate;
	private String startTime;
	private String endTime;
	
	
	// GETTER PROPERTIES
	
	public int getID() {
		return this.id;
	}
	
	public int getMaterialID() {
		return this.mat_id;
	}
	
	public String getJobID() {
		return this.job_id;
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public String getStartDate() {
		return this.startDate;
	}
	
	public String getEndDate() {
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
	
	public void setMaterialID(int val) {
		this.mat_id = val;
	}
	
	public void setJobID(String string) {
		this.job_id = string;
	}
	
	public void setStatus(int val) {
		this.status = val;
	}
	
	public void setStartDate(String string) {
		this.startDate = string;
	}
	
	public void setEndDate(String val) {
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
			String query = "INSERT INTO workorder (job_id, mat_id, status, start_date, end_date) VALUES(?,?,?,?,?)";
			prepStmt = conn.prepareStatement(query);
			prepStmt.setString(1, this.getJobID());
			prepStmt.setInt(2, this.getMaterialID());
			prepStmt.setInt(3, this.getStatus());
			prepStmt.setString(4, this.getStartDate());
			prepStmt.setString(5, this.getEndDate());
			int row = prepStmt.executeUpdate();
			return row;
		} catch(SQLException e1) {
			e1.printStackTrace();
		}
		return 0;
	}
	
	public Vector<Object[]> getAllWorkder() {
		Vector<Object[]> rows = new Vector<Object[]>();
		try {
			stmt = conn.createStatement();
			stmt.execute("SELECT `workorder`.`id`, `job`.`title`, `job`.`description`, `materials`.`material_name`, `workorder`.`status`,`workorder`.`start_date`,`workorder`.`end_date` FROM `workorder`,`materials`,`job` WHERE `job`.`id` = `workorder`.`job_id` AND `materials`.`material_id` = `workorder`.`mat_id`");
			rs = stmt.getResultSet();
			int r = 0;
			while(rs.next()) {
				System.out.print(rs.getInt("id"));
				rows.add(r, new Object[] {
						rs.getInt("id") + "", 
						rs.getString("title").toString(), 
						rs.getString("description").toString(), 
						rs.getString("material_name").toString(), 
						rs.getInt("status") == 0 ? "Available" : "Occupied", 
						rs.getString("start_date"),
						rs.getString("end_date")
					});
				r++;
			}
			return rows;
		} catch(SQLException ex) {
			System.out.print(ex.getMessage());
		}
		return rows;
	}
	
//	public WorkOrder[] getAvailableEmployee() {
//           WorkOrder[] employeeData = null;
//           
//           try {
//        	   stmt = conn.createStatement();
//        	   rs = stmt.executeQuery("SELECT user_id FROM workorder WHERE status = 0");
//        	   if(rs.next()) {
//        		   int count = rs.getInt("user_id");
//        	   }
//        	   return employeeData;
//           } catch(SQLException e2) {
//        	   e2.printStackTrace();
//           }
//		
//           	
//    }
	
//	String query = "SELECT user_id FROM workorder WHERE status = 0";
//
//		try {
//			stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(query);
//
//				while (rs.next()) {
//					int id = rs.getInt("user_id");
//					
//				}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//			return employeeData;
	
	
	
	
}
