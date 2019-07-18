package assignment_3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {

	public static void main(String args[]) {
		
		List<String> stringList = Arrays.asList(new String[]{"This", "is", "a", "", "Sample", "Strings", "", "Array", "to", "", "counting", "occurances", "of", "diffrent"});
		System.out.println("No of words with length > 5 : "+ stringList.stream().filter(w -> w.length()>5).count());
		System.out.println("No of empty words : "+ stringList.stream().filter(w -> w.trim().length()==0).count());
		List<String> newListForEmpties = stringList.stream().filter(w -> w.trim().length()==0).collect(Collectors.toList());
		
 		System.out.println("New List after adding empty strings : "+ newListForEmpties);
	}
}
