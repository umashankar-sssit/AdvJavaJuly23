import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		StudentPojo stud = new StudentPojo();
		
		StudentRepository repo = new StudentRepository();
		
		System.out.println("Enter Htno:");
		int htno = ip.nextInt();
		stud.setHtno(htno);
		
		System.out.println("Enter Student name");
		String name = ip.next();
		stud.setsName(name);
		
		System.out.println("Enter Mark1");
		int m1 = ip.nextInt();
		stud.setM1(m1);
		
		System.out.println("Enter Mark2");
		int m2 = ip.nextInt();
		stud.setM2(m2);
		
		boolean status = repo.insertStudent(stud);
		if(status)
			System.out.println("Record inserted successfully");
		else
			System.out.println("Insertio failed....");
		
		
		
		

	}

}
