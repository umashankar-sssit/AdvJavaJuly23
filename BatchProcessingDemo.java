import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchProcessingDemo {

	public static void main(String[] args) {
		Connection con = null;
		//Statement stmt = null;
		PreparedStatement pstmt=null;
		
		// Step 1: Loading the oracle driver into JVM		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded successfully");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load driver");
		}
		
		
		try {
			// Step 2: Establish the connection with Oracle DB
			con = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:orcl",
					"AdvJavaJuly23", "AdvJavaJuly23");
			System.out.println("Connection Estd. successfully");
			
			
			// Step 3: Create a Statement
			//stmt = con.createStatement();
			final String SQL_Query = "insert into student "
					+ "values(?,?,?,?,?,?,?)";
			
			pstmt=con.prepareStatement(SQL_Query);
			
			// Step 4: Execute Query			
			
			pstmt.setInt(1,17);
			pstmt.setString(2, "S17");
			pstmt.setInt(3, 50);
			pstmt.setInt(4, 45);
			pstmt.setInt(5, 95);
			pstmt.setDouble(6, 45);
			pstmt.setString(7, "Pass");
			
			
			//int effectedRows = stmt.executeUpdate(SQL_QUERY);
			//int effectedRows = pstmt.executeUpdate();
			pstmt.addBatch();
			
			pstmt.setInt(1,18);
			pstmt.setString(2, "S18");
			pstmt.setInt(3, 99);
			pstmt.setInt(4, 32);
			pstmt.setInt(5, 122);
			pstmt.setDouble(6, 60);
			pstmt.setString(7, "Fail");
			
			
			//int effectedRows = stmt.executeUpdate(SQL_QUERY);
			//effectedRows = pstmt.executeUpdate();
			pstmt.addBatch();
			
			pstmt.executeBatch();
			
			
			
			
			
			
			
		} catch (SQLException e) {
			System.out.println("Failed to Estd. Connection");
		}
		
		// Step 6: Closing all the connections in reverse order
		finally {
			try {
				if(pstmt!=null)
					pstmt.close();
				if(con!=null)
					con.close();
				
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}

	}

}
