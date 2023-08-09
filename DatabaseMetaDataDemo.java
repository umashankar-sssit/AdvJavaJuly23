import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseMetaDataDemo {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		DatabaseMetaData dsmd = null;
		

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
			
			dsmd = con.getMetaData();
			System.out.println("Driver Name:" + dsmd.getDriverName());
			System.out.println("Select ?" + dsmd.allTablesAreSelectable());
			
			

			

		} catch (SQLException e) {
			System.out.println("Failed to Estd. Connection");
		}

		// Step 6: Closing all the connections in reverse order
		finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				System.out.println(e);
			}
		}

	}

}
