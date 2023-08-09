import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ScrollableAndUpdatableResultSet2 {

	public static void main(String[] args) {

		Connection con = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;

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
			/*
			 * stmt = con.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE,
			 * ResultSet.CONCUR_UPDATABLE);
			 */
			final String SQL_QUERY = "select * from student";
			pstmt = con.prepareStatement(SQL_QUERY,
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_UPDATABLE);
			// Step 4: Execute Query
			//final String SQL_QUERY = "select * from student";
			rs = pstmt.executeQuery();

			// retriving all the records from table
			while (rs.next()) {
				System.out.printf("%10d%10s\n ",rs.getInt("htno"),rs.getString("sname"));				
			}
			System.out.println("\n ----------------------------------");

			// retrive first record from the table
			rs.first();
			System.out.println("\n First Record.......");
			System.out.printf("%10d%10s",rs.getInt("htno"),rs.getString("sname"));

			System.out.println("\n ----------------------------------");
			
			// retrive last record from the table
			rs.last();
			System.out.println("\n Last Record.......");
			System.out.printf("%10d%10s",rs.getInt("htno"),rs.getString("sname"));
			
			System.out.println("\n ----------------------------------");

			// get the record from specific position
			rs.absolute(10);
			System.out.println("\n 10th Record.......");
			System.out.printf("%10d%10s",rs.getInt("htno"),rs.getString("sname"));
			
			System.out.println("\n ----------------------------------");

			// get the record from specific position
			rs.relative(-3);
			System.out.println("\n -3 from current position.......");
			System.out.printf("%10d%10s",rs.getInt("htno"),rs.getString("sname"));
			
			System.out.println("\n ----------------------------------");

			rs.relative(+2);
			System.out.println("\n +5 from current position.......");
			System.out.printf("%10d%10s",rs.getInt("htno"),rs.getString("sname"));

			System.out.println("\n ----------------------------------");
			
			System.out.println("\n Current Position is...." + rs.getRow());

			System.out.println("\n ----------------------------------");
			
			// display the list in reverse order
			rs.afterLast();
			System.out.println("\n Records in Reverse order.....");
			while (rs.previous()) {
				System.out.printf("%10d%10s\n ",rs.getInt("htno"),rs.getString("sname"));

			}

		} catch (SQLException e) {
			System.out.println("Failed to Estd. Connection");
		}

		// Step 6: Closing all the connections in reverse order
		finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				System.out.println(e);
			}
		}

	}

}
