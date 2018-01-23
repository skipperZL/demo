package com.zl.demo.javase;

import java.util.Calendar;
import static com.zl.demo.javase.Printer.print;

public class CalendarDemo {
	
	private static void test() {
/*		For the date fields:

			 YEAR + MONTH + DAY_OF_MONTH
			 YEAR + MONTH + WEEK_OF_MONTH + DAY_OF_WEEK
			 YEAR + MONTH + DAY_OF_WEEK_IN_MONTH + DAY_OF_WEEK
			 YEAR + DAY_OF_YEAR
			 YEAR + DAY_OF_WEEK + WEEK_OF_YEAR
			 
			For the time of day fields:
			 HOUR_OF_DAY
			 AM_PM + HOUR*/
		Calendar cl = Calendar.getInstance();
		print(cl.getTime());
		print(cl.get(Calendar.YEAR));
		print(cl.get(Calendar.MONTH) + 1);
		print(cl.get(Calendar.DAY_OF_WEEK));
		print(cl.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		print(cl.get(Calendar.WEEK_OF_YEAR));
		print(cl.get(Calendar.HOUR_OF_DAY));
		print(cl.get(Calendar.AM_PM));
		print(cl.get(Calendar.HOUR));
		
	}

	public static void main(String[] args) {
		test();
	}

}
