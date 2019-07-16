package assignment_4;

public class MyOwnNegativeValueEnteredException extends ArithmeticException {
	
	private static final long serialVersionUID = 1L;

	public MyOwnNegativeValueEnteredException(int value) {
		System.out.println("The Entered Value is: " + value);
		System.out.println("Exception Root cause is" + this.getStackTrace());
	}
	
	
}
