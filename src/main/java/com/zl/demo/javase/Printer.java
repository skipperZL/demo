package com.zl.demo.javase;

public class Printer {

	public static void print(String str) {
		System.out.println(str);
	}
	
	public static void print(Object obj) {
		System.out.println(obj.toString());
	}
}
