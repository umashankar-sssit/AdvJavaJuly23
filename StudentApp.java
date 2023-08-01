import java.util.List;
import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		
		
		Scanner ip = new Scanner(System.in);
		StudentRepository repo = new StudentRepository();
		
		System.out.println("CURD operations on Student Table");
		System.out.println("1. Insert the student");
		System.out.println("2. Retrieve all Students");
		System.out.println("3. Delete Student By Htno");
		System.out.println("4. Update Name By Id");
		System.out.println("5. Retrieve Student By Htno");
		System.out.println("Enter your choice");
		int choice = ip.nextInt();
		
		switch(choice) {
		
		case 1: 
			insertStudent(ip,repo);
			break;
		case 2:
			retrieveAllStudents(repo);
			break;
		case 3:
			System.out.println("Enter Htno");
			int htno = ip.nextInt();
			boolean status = repo.deleteStudent(htno);
			if(status)
				System.out.println(htno + " is deleted");
			else
				System.out.println(htno + " is failed to delete");
			break;
			
		case 4:
			System.out.println("Enter Htno");
			htno = ip.nextInt();
			
			List<StudentPojo> studList = repo.RetrieveStudentById(htno);
			if(studList.size()==0) {
				throw new InvalidHTNOException(htno);
			} else {
			System.out.println("Existed Name is:" + studList.get(0).getsName());
			System.out.println("Enter New Name:");
			String newName = ip.next();
			
			status = repo.updateStudentNameById(htno,newName);
			if(status)
				System.out.println(htno + " is Updated");
			else
				System.out.println(htno + " is failed to update");
			}
			break;
			
		case 5:
			System.out.println("Enter Htno:");
			htno = ip.nextInt();
			
			List<StudentPojo> studList1 = repo.RetrieveStudentById(htno);
			if(studList1.size()==0)
				throw new InvalidHTNOException(htno);			
			displayStudent(studList1);
			break;
			
			
		}
	}
	
	
	public static void insertStudent(Scanner ip, 
			StudentRepository repo) {
		
		StudentPojo stud = new StudentPojo();
		
		
		
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
	
	public static void retrieveAllStudents(StudentRepository repo) {
		List<StudentPojo> studentList = repo.RetrieveStudent();
		displayStudent(studentList);		
	}
	
	private static void displayStudent(List<StudentPojo> studList) {
		if(studList.size()>0) {
			for(StudentPojo stud : studList) {
				
				System.out.printf("\n %5d%10s%5d%5d%5d%5f%10s",
						stud.getHtno(),
						stud.getsName(),
						stud.getM1(),
						stud.getM2(),
						stud.getTotal(),
						stud.getAverage(),
						stud.getRes());
				
			}
		}
	}

}
