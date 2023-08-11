package rowsetdemo;

import java.io.FileOutputStream;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebRowSetDemo {
	
public static void main(String[] args) {
		
		
		try {
			
		
		RowSetFactory rsf = RowSetProvider.newFactory();		
		WebRowSet rset = rsf.createWebRowSet();
		rset.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		rset.setUsername("AdvJavaJuly23");
		rset.setPassword("AdvJavaJuly23");
		rset.setCommand("select * from student");
		
		rset.execute();
		
		while(rset.next()) {
			System.out.printf("%10d %20s %10d %10s\n",
					rset.getInt("htno"),
					rset.getString("sname"),
					rset.getInt("tot"),
					rset.getString("res"));
		}
		
		System.out.println("List in Reverse Order");
		rset.afterLast();
		while(rset.previous()) {
			System.out.printf("%10d %20s %10d %10s\n",
					rset.getInt("htno"),
					rset.getString("sname"),
					rset.getInt("tot"),
					rset.getString("res"));
		}
		
		System.out.println("5th record........");
		rset.absolute(5);
		System.out.printf("%10d %20s %10d %10s\n",
				rset.getInt("htno"),
				rset.getString("sname"),
				rset.getInt("tot"),
				rset.getString("res"));
		System.out.println("previous record........");
		
		rset.relative(-1);
		System.out.printf("%10d %20s %10d %10s\n",
				rset.getInt("htno"),
				rset.getString("sname"),
				rset.getInt("tot"),
				rset.getString("res"));
		
		
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
		

	}

}
