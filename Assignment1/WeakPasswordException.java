package Assignment204and1;

public class WeakPasswordException extends Exception{
	
	public WeakPasswordException() {
		super("The password is OK but weak - it contains fewer than 10 characters");
	}
}
