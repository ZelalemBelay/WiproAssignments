package assignment_4;

import java.util.Arrays;
import java.util.List;

public class StudentClass {

	static List<Integer> ints = Arrays.asList(new Integer[] {99,98,97,100,92,84,80,89,90});
	
	public static void main(String args[]) {
		System.out.println("Average of Students Marks is: "+ calculateAvg());
     }
	
	 static double calculateAvg(){
		return ints.stream().mapToInt(Integer::intValue).average().getAsDouble();
	 }
}
