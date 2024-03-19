package EntityModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Materials {
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement prepStmt = null;
	ResultSet rs = null;

	public static String DB_URI = "jdbc:mysql://localhost:3306/accounts";
    public static String DB_USER = "root";
    public static String DB_PASS = "";
    
	public Materials() {
		try {
			conn = DriverManager.getConnection(DB_URI, DB_USER, DB_PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Materials(int material_id, String material_name, String material_description,int status, int cost) {
		this.material_id = material_id;
		this.material_name = material_name;
		this.material_description = material_description;
		this.status = status;
		this.cost = cost;
	}
	
	private int material_id;
	private String material_name;
	private String material_description;
	private int status;
	private int cost;
	
	
	// GETTER PROPPERTIES
	
	public int getID() {
		return this.material_id;
	}
	
	public String getMatName() {
		return this.material_name;
	}
	
	public String getMatDesc() {
		return this.material_description;
	}

	public int getStatus() {
		return this.status;
	}
	public int getCost() {
		return this.cost;
	}
	
	
	// SETTER PROPPERTIES
	
	public void setID(int val) {
		this.material_id = val;
	}
	
	public void setMatName(String val) {
		this.material_name = val;
	}
	
	public void setMatDesc(String val) {
		this.material_description = val;
	}
	public void setStatus(int val) {
		this.status = val;
	}
	
	public void setCost(int val) {
		this.cost = val;
	}
	
	
	
	
	
	public int productsControl() {
		try {
			String query = "INSERT INTO materials (user_id, job_id, status) VALUES(?,?,?)";
			prepStmt = conn.prepareStatement(query);
			prepStmt.setInt(1, this.getID());
			prepStmt.setString(2, this.getMatName());
			prepStmt.setString(3, this.getMatDesc());
			prepStmt.setInt(4, this.getCost());
			int row = prepStmt.executeUpdate();
			return row;
		} catch(SQLException e1) {
			
		}
		return 0;
	}
	
	
//	public Materials[] getAvailableMaterials() {
//		Materials material[] = null;
//		try {
//	        stmt = conn.createStatement();
//	        if(stmt.execute("SELECT COUNT(*) as rowCount FROM products")) {
//	        	rs = stmt.getResultSet();
//	        	if(rs.first()) {
//	        		material = new Materials[rs.getInt("rowCount")];
//			        if (stmt.execute("SELECT * FROM products")) {
//			            rs = stmt.getResultSet();
//			            while(rs.next()) {
//			            	material[rs.getRow() - 1] = new Materials(
//			            			rs.getInt("material_id"),
//			            			rs.getString("material_name"),
//			            			rs.getString("material_description"),
//			            			rs.getInt("cost")
//			            		);
//			            }
//			        }
//	        	}
//	        	
//	        }
//	        System.out.print(rs.getFetchSize());
//	        return material;
//	    } catch (SQLException e2) {
//	        e2.getMessage();
//	    }
//		return null;
//	}
	
	
	
	 public Materials[] getAvailableMaterials() {
	        Materials[] material = null;
	        try {
	            stmt = conn.createStatement();
	            rs = stmt.executeQuery("SELECT COUNT(*) as rowCount FROM materials WHERE status = 0");
	            if (rs.next()) {
	                int count = rs.getInt("rowCount");
	                material = new Materials[count];
	                rs = stmt.executeQuery("SELECT * FROM materials WHERE status = 0");
	                int i = 0;
	                while (rs.next()) {
	                    material[i] = new Materials(
	                            rs.getInt("material_id"),
	                            rs.getString("material_name"),
	                            rs.getString("material_description"),
	                            rs.getInt("status"),
	                            rs.getInt("cost")
	                    );
	                    i++;
	                }
	            }
	        } catch (SQLException e2) {
	            e2.printStackTrace();
	        }
	        return material;
	    }
	
	
}
