
public class InvalidHTNOException extends RuntimeException{
	
	public InvalidHTNOException(int htno) {
		super(htno + " is invalid");
		
	}

}
