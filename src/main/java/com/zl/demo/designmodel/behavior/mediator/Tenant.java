package com.zl.demo.designmodel.behavior.mediator;

public class Tenant extends Person {

	public Tenant(Mediator mediator, String name) {
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
