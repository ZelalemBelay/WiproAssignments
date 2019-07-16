package assignment_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;

public class MainClass {

	public static void main(String args[]) throws IOException {

		BufferedWriter writer = new BufferedWriter(new FileWriter("the_Numbers", true));
		int x;
		for (int i = 0; i < 30; i++) {
			x = new Random().nextInt(30);
			writer.append("" + x);
			writer.append('\n');
		}
		writer.close();
		System.out.println("Writing Done!");
		
		BufferedReader reader = new BufferedReader(new FileReader("the_Numbers"));
		List<Integer> ints1 = new ArrayList<>();
		List<Integer> ints2 = new ArrayList<>();
		List<Integer> ints3 = new ArrayList<>();
		
			String line = reader.readLine();
			Integer intVal;
			int lineCount = 1;
			while (line != null) {
				if(lineCount>30)
					break;
				intVal = Integer.parseInt(line.trim());
				if(lineCount<=10)
					ints1.add(intVal);
				else if(lineCount>20)
					ints3.add(intVal);
				else 
					ints2.add(intVal);
				// read next line
				line = reader.readLine();
				++lineCount;
			}
		
		System.out.println("Reading Done!\n");
		System.out.println("Batch 1: "+ints1 + " : AVERAGE : " + getAverage(ints1).getAsDouble() + " : SUM : "+ getSum(ints1));
		System.out.println("Batch 2: "+ints2 + " : AVERAGE : " + getAverage(ints2).getAsDouble() + " : SUM : "+ getSum(ints2));
		System.out.println("Batch 3: "+ints3 + " : AVERAGE : " + getAverage(ints3).getAsDouble() + " : SUM : "+ getSum(ints3));
		
		
			reader.close();
	}
	
	private static OptionalDouble getAverage(List<Integer> ints1) {
		return ints1.stream().mapToInt(Integer::intValue).average();
	}
	
	private static int getSum(List<Integer> list) {
		return list.stream().mapToInt(Integer::intValue).sum();
	}
}
