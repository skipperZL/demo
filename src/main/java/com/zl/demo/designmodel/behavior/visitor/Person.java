package com.zl.demo.designmodel.behavior.visitor;

public abstract class Person {

	String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public abstract void say(Visitor visitor);
	
}
