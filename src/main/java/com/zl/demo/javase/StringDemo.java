package com.zl.demo.javase;

import static com.zl.demo.javase.Printer.print;

public class StringDemo {
	
	public void update(String str) {
		str = str + "Update.";
	}
	
	public void update(StringBuffer str) {
		str.append("UpdateBuffer.");
	}
	
	private void test() {
		String str = "Java";
		update(str);
		StringBuffer buf = new StringBuffer("Buffer");
		update(buf);
		print(str);
		print(buf);
	}
	
	private void test1() {
		String str1 = "java";
		String str2 = "java";
		String str3 = new String("java");
		String str4 = str1 + "";
		print("str1 equals str2 ? " + (str1 == str2) + ".");
		print("str1 equals str3 ? " + (str1 == str3) + ".");
		print("str1 equals str4 ? " + (str1 == str4) + ".");
	}
	
	
	public static void main(String[] args) {
		StringDemo demo = new StringDemo();
		demo.test();
		demo.test1();
	}
}
