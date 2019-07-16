package assignment_2;

public class FinalizeClass {

	public FinalizeClass() {
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalize Method Called");
		super.finalize();
	}
}
