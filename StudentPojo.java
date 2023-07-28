

// this class is called POJO class
// POJO --> Plain Old Java Object
// used to transfer the data from one layer to another layer

public class StudentPojo {
	
	int htno;
	String sName;
	int m1;
	int m2;
	int total;
	double average;
	String res;
	
	// define No Argument constructor
	public StudentPojo() {
		// TODO Auto-generated constructor stub
	}

	// define Argumented Constructor
	// Right click any in the editor --> source 
	// --> Generate Constructor using Fields
	
	public StudentPojo(int htno, String sName, 
			int m1, int m2, int total, double average, String res) {
		super();
		this.htno = htno;
		this.sName = sName;
		this.m1 = m1;
		this.m2 = m2;
		this.total = total;
		this.average = average;
		this.res = res;
	}
	
	// Generate Setter and Getter methods to every property
		// setter method is used to save the data in an object
		// getter method is used to retreive the data from an object
		
		// Right click --> source --> Generate Setter and Getter methods

	public int getHtno() {
		return htno;
	}

	public void setHtno(int htno) {
		this.htno = htno;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getM1() {
		return m1;
	}

	public void setM1(int m1) {
		this.m1 = m1;
	}

	public int getM2() {
		return m2;
	}

	public void setM2(int m2) {
		this.m2 = m2;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}

	// Override toString method
		// Right click --> source --> Generate toString()
		
	@Override
	public String toString() {
		return "StudentPojo [htno=" + htno + ", sName=" + sName + ", m1=" + m1 + ", m2=" + m2 + ", total=" + total
				+ ", average=" + average + ", res=" + res + "]";
	}
	
	
	
	
	
	

}
