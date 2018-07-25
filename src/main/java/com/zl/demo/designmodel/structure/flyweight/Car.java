package com.zl.demo.designmodel.structure.flyweight;

public class Car extends Drive{
	
	public Car(String type) {
		this.type = type;
	}
	
	@Override
	public void go(Person person) {
		System.out.println(person.getName() + " is  driving! The car is " + type + "!");
	}
	
}
