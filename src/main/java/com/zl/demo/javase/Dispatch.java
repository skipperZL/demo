package com.zl.demo.javase;

public class Dispatch {
	
	public void test(DispatchSuper ds) {
		System.out.println("super method!");
		ds.foo();
	}
	
	public void test(DispatchChildA ds) {
		System.out.println("childA method!");
		ds.foo();
	}
	
	public void test(DispatchChildB ds) {
		System.out.println("childB method!");
		ds.foo();
	}
	
	
	public static void main(String[] args) {
		
		Dispatch obj = new Dispatch();
		DispatchSuper ds = new DispatchSuper();
		DispatchSuper da = new DispatchChildA();
		DispatchSuper db = new DispatchChildB();
		DispatchChildA da1 = new DispatchChildA();
		obj.test(da);
		obj.test(db);
		obj.test(da1);
		
		
	}
}
