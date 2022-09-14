package Assignment204and1;



public class InvalidSequenceException extends Exception{
	
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same characters in sequence");
	}
}

