package Assignment204and1;

public class LengthException extends Exception{
	
	public LengthException() {
		super("The password must be at least 6 characters long");
	}
}
