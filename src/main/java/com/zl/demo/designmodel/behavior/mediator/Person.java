package com.zl.demo.designmodel.behavior.mediator;

public abstract class Person {
	protected String name;
	
	protected Mediator mediator;
	
	public Person(Mediator mediator, String name) {
		this.mediator = mediator;
		this.name = name;
	}
	
	public abstract void send(String message);
	
	public abstract void getMessage(String message, Person person);
}
