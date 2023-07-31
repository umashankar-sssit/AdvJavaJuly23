import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
	
	
	public boolean insertStudent(StudentPojo student) {
		
		Connection con = null;
		Statement stmt = null;				
		
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
			stmt = con.createStatement();
			
			// Step 4: Execute Query
			final String SQL_QUERY = "insert into student values("+
					student.getHtno() + ",'"+student.getsName() + "',"+
					student.getM1()+","+student.getM2()+","+
					getTotalMarks(student) + ","+getAverageMarks(student)
					+",'"+ getResult(student)+"')";
			
			
			int effectedRows = stmt.executeUpdate(SQL_QUERY);
			
			
			
			if(effectedRows>0)
				return true;
			
			
			
		} catch (SQLException e) {
			System.out.println("Failed to Estd. Connection");
		}
		
		// Step 6: Closing all the connections in reverse order
		finally {
			try {
				if(stmt!=null)
					stmt.close();
				if(con!=null)
					con.close();
				
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		
		return false;
		
	}
	
public List<StudentPojo> RetrieveStudent() {
		
		Connection con = null;
		Statement stmt = null;	
		ResultSet rs = null;
		List<StudentPojo> studentList = new ArrayList<>();
		
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
			stmt = con.createStatement();
			
			// Step 4: Execute Query
			final String SQL_QUERY = "select * from student";
			rs = stmt.executeQuery(SQL_QUERY);			
			
			while(rs.next()) {
				StudentPojo stud = new StudentPojo();
				stud.setHtno(rs.getInt("htno"));
				stud.setsName(rs.getString("sname"));
				stud.setM1(rs.getInt("m1"));
				stud.setM2(rs.getInt("m2"));
				stud.setTotal(rs.getInt("tot"));
				stud.setAverage(rs.getDouble("average"));
				stud.setRes(rs.getString("res"));
				studentList.add(stud);
			}
			
			
			
			
		} catch (SQLException e) {
			System.out.println("Failed to Estd. Connection");
		}
		
		// Step 6: Closing all the connections in reverse order
		finally {
			try {
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(con!=null)
					con.close();
				
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		
		return studentList;
		
	}


	public boolean deleteStudent(int h) {
		
		Connection con = null;
		Statement stmt = null;				
		
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
			stmt = con.createStatement();
			
			// Step 4: Execute Query
			final String SQL_QUERY = "delete from student where htno=" + h;
			
			
			int effectedRows = stmt.executeUpdate(SQL_QUERY);
			
			
			
			if(effectedRows>0)
				return true;
			
			
			
		} catch (SQLException e) {
			System.out.println("Failed to Estd. Connection");
		}
		
		// Step 6: Closing all the connections in reverse order
		finally {
			try {
				if(stmt!=null)
					stmt.close();
				if(con!=null)
					con.close();
				
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		
		return false;
		
	}
	
	
	public boolean updateStudentNameById(int htno,String name) {
		
		Connection con = null;
		Statement stmt = null;				
		
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
			stmt = con.createStatement();
			
			// Step 4: Execute Query
			final String SQL_QUERY = "update student set sname='"+name+"'"
					+ "where htno="+htno;
			
			
			int effectedRows = stmt.executeUpdate(SQL_QUERY);
			
			
			
			if(effectedRows>0)
				return true;
			
			
			
		} catch (SQLException e) {
			System.out.println("Failed to Estd. Connection");
		}
		
		// Step 6: Closing all the connections in reverse order
		finally {
			try {
				if(stmt!=null)
					stmt.close();
				if(con!=null)
					con.close();
				
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		
		return false;
		
	}
	
	
	private int getTotalMarks(StudentPojo stud) {
		return stud.getM1()+stud.getM2();
		
	}
	
	private double getAverageMarks(StudentPojo stud) {
		return (stud.getM1()+stud.getM2())/2;
	}
	
	private String getResult(StudentPojo stud) {
		return (stud.getM1()>35 && stud.getM2()>35)?"pass":"fail";
	}

}
