package assignment_4;

import java.util.Scanner;

public class MainClass {

	public static void main(String args[]) {
		
		/*Used
		javac MainClass.java
		java –enableassertions MainClass
		AND 
		java –disableassertions MainClass
		
		to run program*/
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of Rows : ");
		int n = sc.nextInt();
		
		assert n > 0 : new MyOwnNegativeValueEnteredException(n);
		
		char c = '*';
		int i = 1;
		int j;
		do {
			j = 1;
			do {
				System.out.print(" ");

			} while (++j <= n - i + 1);
			j = 1;
			do {
				System.out.print(c);

			} while (++j <= i * 2 - 1);
			System.out.println();
		} while (++i <= n);
		i = n - 1;
		do {
			j = 1;
			do {
				System.out.print(" ");

			} while (++j <= n - i + 1);
			j = 1;
			do {
				System.out.print(c);

			} while (++j <= i * 2 - 1);

			System.out.println();

		} while (--i > 0);
	}
}
