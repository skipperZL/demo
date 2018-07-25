package com.zl.demo.designmodel.behavior.mediator;

public class MediatorDemo {
	public static void main(String[] args) {
		
		Mediator mediator = new Mediator();
		
		Person tenant = new Tenant(mediator, "Li Ming");
		Person renter = new Renter(mediator, "Huang Hai");
		
		mediator.renter = renter;
		mediator.tenant = tenant;
		
		tenant.send("I need a house!");
		renter.send("The deposit is 3000 dollars!");
		
		
	}
}
