package assignment_2;

public class MyClassWithLambda {

	public static void main(String args[]) {
		WordCount wordCounter = (str) -> {
			return str.split("\\W+").length;
		};
		
		System.out.println(wordCounter.count("I want to generate words from the whole String, CharCollection, with Commas"));
	}
}
