package com.zl.demo.designmodel.behavior.mediator;

public class Mediator {
	Person renter;
	Person tenant;
	
	public void send(String message, Person person) {
		if (person == tenant) {
			renter.getMessage(message, person);
		} else if (person == renter) {
			tenant.getMessage(message, person);
		}
	}
}
