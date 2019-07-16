package assignment_2;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String args[]) {
		
		List<Number> numberList = new ArrayList<>();
		
		numberList.add(6);
		numberList.add(6.6);
		numberList.add(3.3232312324324);
		
		//Creates compiler issue.
//		numberList.add("String");
//		numberList.add(new Date());
		
		System.out.println(numberList);
	}
}
