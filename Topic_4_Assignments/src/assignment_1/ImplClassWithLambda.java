package assignment_1;

public class ImplClassWithLambda {

	public static void main(String args[])  {
		
		CharacterOccurrence charOccur = (str, c) -> {
			return (int) str.chars().filter(ch -> ch==c).count(); 
		};
		
		int occurance = charOccur.findOccurence("How was your day today", 'a');

		System.out.println("Occurance is: "+ occurance);
	}
}