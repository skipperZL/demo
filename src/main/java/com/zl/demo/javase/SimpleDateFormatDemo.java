package com.zl.demo.javase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static com.zl.demo.javase.Printer.print;

public class SimpleDateFormatDemo {
	public static final String FORMAT24 = "yyyy-MM-dd HH:mm:ss";
	
	public static final String FORMAT12 = "yyyy-MM-dd hh:mm:ss";
	
	private void test(String formatStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		print(sdf.format(new Date()));
		print(sdf.parse("1998-12-12 22:00:15"));
	}
	
	public static void main(String[] args) throws ParseException {
		new SimpleDateFormatDemo().test(FORMAT12);
		new SimpleDateFormatDemo().test(FORMAT24);
	}
}
