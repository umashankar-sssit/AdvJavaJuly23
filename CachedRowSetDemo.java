package rowsetdemo;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetDemo {

public static void main(String[] args) {
		
		
		try {
			
		
		RowSetFactory rsf = RowSetProvider.newFactory();		
		CachedRowSet rset = rsf.createCachedRowSet();
		rset.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		rset.setUsername("advjava3");
		rset.setPassword("advjava3");
		rset.setCommand("select studid,sname,sphnum from student order by studid");
		
		rset.execute();
		
		while(rset.next()) {
			System.out.printf("%10d %20s %10d\n",
					rset.getInt("studid"),
					rset.getString("sname"),
					rset.getInt("sphnum"));
		}
		
		System.out.println("List in Reverse Order");
		rset.afterLast();
		while(rset.previous()) {
			System.out.printf("%10d %20s %10d\n",
					rset.getInt("studid"),
					rset.getString("sname"),
					rset.getInt("sphnum"));
		}
		
		System.out.println("5th record........");
		rset.absolute(5);
		System.out.printf("%10d %20s %10d\n",
				rset.getInt("studid"),
				rset.getString("sname"),
				rset.getInt("sphnum"));

		
		
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		

	}

}
