package EntityModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Job {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement prepStmt = null;
	ResultSet rs = null;

	public static String DB_URI = "jdbc:mysql://localhost:3306/accounts";
    public static String DB_USER = "root";
    public static String DB_PASS = "";
    
	public Job() {
		try {
			conn = DriverManager.getConnection(DB_URI, DB_USER, DB_PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Job(String id, String title, String descr) {
		this.id = id;
		this.title = title;
		this.description = descr;
	}
	
	private String id;
	private String title;
	private String description;
	
	//GETTER PROPERTIES
	public String getID() {
		return this.id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getDesc() {
		return this.description;
	}
	
	//SETTER PROPERTIES
	
	public void setID(String val) {
		this.id = val;
	}
	
	public void setTitle(String val) {
		this.title = val;
	}
	
	public void setDesc(String val) {
		this.description = val;
	}
	
	// SQL TRANSACTIONS
	
	public int createJob() {
		try {
			String query = "INSERT INTO job (id, title, description) VALUES(?,?,?)";
			prepStmt = conn.prepareStatement(query);
			prepStmt.setString(1, this.getID());
			prepStmt.setString(2, this.getTitle());
			prepStmt.setString(3, this.getDesc());
			int row = prepStmt.executeUpdate();
			return row;
		} catch (SQLException e1) {
			
		}
		return 0;
	}
	
	
	public Job[] getAllJobs() {
		Job jobs[] = null;
		try {
	        stmt = conn.createStatement();
	        if(stmt.execute("SELECT COUNT(*) as rowCount FROM job")) {
	        	rs = stmt.getResultSet();
	        	if(rs.first()) {
	        		jobs = new Job[rs.getInt("rowCount")];
			        if (stmt.execute("SELECT * FROM job")) {
			            rs = stmt.getResultSet();
			            while(rs.next()) {
			            	jobs[rs.getRow() - 1] = new Job(
			            			rs.getString("id"),
			            			rs.getString("title"),
			            			rs.getString("description")
			            		);
			            }
			        }
	        	}
	        	
	        }
	        System.out.print(rs.getFetchSize());
	        return jobs;
	    } catch (SQLException e2) {
	        e2.getMessage();
	    }
		return null;
	}
}
