package com.zl.demo;

import java.util.regex.Pattern;

public class TestDome {

	public static void main(String[] args) {
		   double x= 300000.00000000003;//double比较，小数点后有效位
	        double y= 300000.0000000003;//主要注意的是double类型直接==/>=/<=的比较，涉及到有效位
	        System.out.println(x<=300000);
	        System.out.println(y<=300000);
	        System.out.println(Pattern.matches("\\d{4}-\\d{2}-\\d{2}\\s{1}\\d{2}:\\d{2}", "2017-08-08 12:12"));
	        System.out.println(Pattern.matches("\\d{4}-\\d{2}-\\d{2}\\S{1}\\d{2}:\\d{2}}", "2017-08-08 12:12"));

	}

}
