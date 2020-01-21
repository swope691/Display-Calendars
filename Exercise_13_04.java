/**
 * Display Calendars 
 * 1/21/2020
 * @author Phillip Swope
 */

import java.util.*;

public class Exercise_13_04 {
	
	
	public static void main(String[] args) {
		
		// Command Line Usage
		if (args.length != 2) {
			System.out.println("Usage: java Exercise_13_04 month year");
			System.exit(1);
		}


		// Crate a calendar object
		Calendar calendar = new GregorianCalendar(Integer.valueOf(args[1]), 
			Integer.valueOf(args[0]) - 1, 1);
		int days = calendar.getActualMaximum(Calendar.DATE);

		// Display calendar header
		printHeader(calendar); 
		

		// Format for padding 
		for (int i = 1; i < calendar.get(Calendar.DAY_OF_WEEK); i++) 
			System.out.print("    ");

		// Print days in month
		while (calendar.get(Calendar.DATE) <
			calendar.getActualMaximum(Calendar.DATE)) {

			if (calendar.get(Calendar.DAY_OF_WEEK) == 7)
				System.out.printf("%4d\n", calendar.get(Calendar.DATE));
			else
				System.out.printf("%4d", calendar.get(Calendar.DATE));

			// Add a day
			calendar.add(Calendar.DATE, 1);
		}
		System.out.printf("%4d\n", calendar.get(Calendar.DATE));
		System.out.println("-----------------------------");
		System.out.println("   " + getMonths()[calendar.get(Calendar.MONTH)] + ", " + calendar.get(Calendar.YEAR) + " Contains " + days + " days");
		
		
	}

	//Returns an String array of month names
	public static String[] getMonths() {
		String[] months = {"January", "February", "March", "April", "May", "June", 
			"July", "August", "September", "October", "November", "December"};
		return months;
	}

	//Calendar Header
	public static void printHeader(Calendar calendar) {
		//Array for the Month names
		String[] months = getMonths();

		// Format for year and month
		int length = 29 / 2 - (months[calendar.get(Calendar.MONTH)].length() / 2 + 3);
		System.out.println();
		for (int i = 0; i < length; i++)
			System.out.print(" ");
		System.out.println(months[calendar.get(Calendar.MONTH)] + ", " + 
			calendar.get(Calendar.YEAR));

		// Print week day names
		System.out.println("-----------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		
	}

}