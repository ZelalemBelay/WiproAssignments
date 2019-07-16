package assignment_3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class MainClass {

	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		Date date1 = new Date();
		date1.setMonth(date1.getMonth()+1); //month index is at 0 changing to natural counting.
		Date date2 = new Date(112, 4, 5);
		date2.setMonth(date2.getMonth()+1); //month index is at 0 changing to natural counting.
		
		
		int yearDiff = Math.abs((date2.getYear() - date1.getYear()));
		System.out.println("Year Between date1 and date2 : "+ yearDiff);
		System.out.println("Month Diffrence Between date1 and date2 : "+ (yearDiff*12 + Math.abs((date2.getMonth() - date1.getMonth()))));
		System.out.println();
		System.out.println("JAVA 8: YEAR Diffrence Between date1 and date2 : "+ Math.abs(ChronoUnit.YEARS.between(LocalDate.now(), LocalDate.of(2012, 5, 5))));
		System.out.println("JAVA 8: Month Diffrence Between date1 and date2 : "+ Math.abs(ChronoUnit.MONTHS.between(LocalDate.now(), LocalDate.of(2012, 5, 5))));
	}
}
