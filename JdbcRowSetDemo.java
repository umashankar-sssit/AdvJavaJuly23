package rowsetdemo;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetDemo {

	public static void main(String[] args) {
		
		
		try {
			
		
		RowSetFactory rsf = RowSetProvider.newFactory();
		JdbcRowSet jdbcRowSet = rsf.createJdbcRowSet();
		jdbcRowSet.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		jdbcRowSet.setUsername("AdvJavaJuly23");
		jdbcRowSet.setPassword("AdvJavaJuly23");
		jdbcRowSet.setCommand("select * from student");
		
		jdbcRowSet.execute();
		
		while(jdbcRowSet.next()) {
			System.out.printf("%10d %20s %10d %10s\n",
					jdbcRowSet.getInt("htno"),
					jdbcRowSet.getString("sname"),
					jdbcRowSet.getInt("tot"),
					jdbcRowSet.getString("res"));
		}
		
		System.out.println("List in Reverse Order");
		jdbcRowSet.afterLast();
		while(jdbcRowSet.previous()) {
			System.out.printf("%10d %20s %10d %10s\n",
					jdbcRowSet.getInt("htno"),
					jdbcRowSet.getString("sname"),
					jdbcRowSet.getInt("tot"),
					jdbcRowSet.getString("res"));
		}
		
		System.out.println("5th record........");
		jdbcRowSet.absolute(5);
		System.out.printf("%10d %20s %10d %10s\n",
				jdbcRowSet.getInt("htno"),
				jdbcRowSet.getString("sname"),
				jdbcRowSet.getInt("tot"),
				jdbcRowSet.getString("res"));
		System.out.println("previous record........");
		
		jdbcRowSet.relative(-1);
		System.out.printf("%10d %20s %10d %10s\n",
				jdbcRowSet.getInt("htno"),
				jdbcRowSet.getString("sname"),
				jdbcRowSet.getInt("tot"),
				jdbcRowSet.getString("res"));
		
		
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		

	}

}
