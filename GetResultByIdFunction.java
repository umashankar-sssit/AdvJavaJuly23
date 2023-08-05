import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class GetResultByIdFunction {

	public static void main(String[] args) {
		Connection con = null;
		CallableStatement cstmt=null;
		

		// Step 1: Loading the oracle driver into JVM
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded successfully");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load driver");
		}

		try {
			// Step 2: Establish the connection with Oracle DB
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "AdvJavaJuly23",
					"AdvJavaJuly23");
			System.out.println("Connection Estd. successfully");

			// Step 3: Create a Statement
			
			cstmt = con.prepareCall("{? = call getResultById(?) }");
			
			// Step 4: Execute Query
			cstmt.setInt(2,11);
			cstmt.registerOutParameter(1, Types.VARCHAR);
			
			cstmt.execute();
			
			System.out.println("Result is...." + cstmt.getString(1));
			
			
		} catch (SQLException e) {
			System.out.println("Failed to Estd. Connection");
		}

		// Step 6: Closing all the connections in reverse order
		finally {
			try {
				if (cstmt != null)
					cstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				System.out.println(e);
			}
		}

	}

}
