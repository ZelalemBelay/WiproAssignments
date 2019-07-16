package assignment_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainClass {

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		FileOutputStream fout = new FileOutputStream("productList.txt");
		ObjectOutputStream out = new ObjectOutputStream(fout);

		Scanner sc = new Scanner(System.in);
		
		for(int i=1; i<=6; i++) {
			System.out.println("---- Adding Prodcuct "+ i+" ----");
			System.out.println();
			System.out.println("Enter Product Id : ");
			String id = sc.nextLine();
			
			System.out.println("Enter Product Cost : ");
			float cost = sc.nextFloat();
			
			System.out.println("Enter No of Items available : ");
			int noOfItems = sc.nextInt();
			
			Product product = new Product(id, cost, noOfItems);
			out.writeObject(product);
		}
		
		out.flush();
		out.close();
		System.out.println("Success");

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("productList.txt"));
		List<Product> ps = (List<Product>) in.readObject();
		
		Double totalCost = ps
			    .stream()
			    .mapToDouble(Product::getCost)
			    .sum();
		
		System.out.println("Total Cost for all Products is: "+ totalCost);
		System.out.println("Total Number of Products is: "+ ps.size());

	}
}