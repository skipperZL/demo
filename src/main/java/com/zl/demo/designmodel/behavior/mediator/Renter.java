package com.zl.demo.designmodel.behavior.mediator;

public class Renter extends Person {

	public Renter(Mediator mediator, String name) {
		super(mediator, name);
	}

	@Override
	public void send(String message) {
		mediator.send(message, this);
	}

	@Override
	public void getMessage(String message, Person person) {
		System.out.println(name + " get a message," + message + " -- by " + person.name + "!");
	}

}
