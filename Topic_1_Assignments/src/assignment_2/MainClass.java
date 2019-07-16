package assignment_2;

public class MainClass {

	public static void main(String args[]) {
		FinalizeClass f = new FinalizeClass();
		f = new FinalizeClass();
		f = new FinalizeClass();
		
		 Runtime.getRuntime().gc();
	}
}
