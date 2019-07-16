package assignment_3;

public enum DaysOfWeek {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
	
	void printDaysOfWeek() {
		switch (this) {
		case MONDAY:
			System.out.println("MONDAY");
			break;

		case TUESDAY:
			System.out.println("TUESDAY");
			break;

		case WEDNESDAY:
			System.out.println("WEDNESDAY");
			break;

		case THURSDAY:
			System.out.println("THURDSDAY");
			break;

		case FRIDAY:
			System.out.println("FRIDAY");
			break;

		case SATURDAY:
			System.out.println("SATUDAY");
			break;

		case SUNDAY:
			System.out.println("SUNDAY");
			break;

		default:
			break;
		}
	}
	
}
