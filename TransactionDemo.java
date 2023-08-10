import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TransactionDemo {

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
			
			con.setAutoCommit(false);
			
			// Step 3: Create a Statement
			//stmt = con.createStatement();
			final String SQL_Query = "insert into student "
					+ "values(?,?,?,?,?,?,?)";
			
			pstmt=con.prepareStatement(SQL_Query);
			
			// Step 4: Execute Query			
			
			pstmt.setInt(1,14);
			pstmt.setString(2, "S14");
			pstmt.setInt(3, 99);
			pstmt.setInt(4, 99);
			pstmt.setInt(5, 198);
			pstmt.setDouble(6, 99);
			pstmt.setString(7, "Pass");
			
			
			//int effectedRows = stmt.executeUpdate(SQL_QUERY);
			int effectedRows = pstmt.executeUpdate();
			
			Scanner ip = new Scanner(System.in);
			System.out.println("Do you want to save the record?");
			char choice = ip.next().charAt(0);
			
			if(choice=='y')
			{
				con.commit();
				System.out.println("Inserted successfully");
			} else {
				con.rollback();
				System.out.println("Insertion Failed....");
			}
			
			
			
			
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
