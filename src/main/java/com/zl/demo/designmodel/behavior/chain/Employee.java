package com.zl.demo.designmodel.behavior.chain;

public abstract class Employee {
	
	String name;
	
	Employee successor;
	
	public Employee(String name ) {
		this.name = name;
	}
	
	public abstract void handle(Request request);
	
	public void toSuccessor(Request request) {
		if (successor != null)
			successor.handle(request);
		else
			System.out.println("No sucessor, the end!");
	}
	
}
