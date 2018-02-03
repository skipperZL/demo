package com.zl.demo.javase;

public class InterfaceDemo implements InterfaceDemoI1,InterfaceDemoI2{
	
	public String f() {
		System.out.println("Test.");
		return null;
	}
	
	public int f1() {
		System.out.println("Test1.");
		return 0;
	}
	
	public static void main(String[] args) {
		InterfaceDemo ifd = new InterfaceDemo();
		ifd.f();
	}
}
