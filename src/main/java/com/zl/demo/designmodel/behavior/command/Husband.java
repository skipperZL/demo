package com.zl.demo.designmodel.behavior.command;

public class Husband {
	String name;
	
	public Husband(String name) {
		this.name = name;
	}
	
	public void doTheDishes() {
		System.out.println(name + " is doing the dishes!");
	}
	
	public void mop() {
		System.out.println(name + " is mopping!");
	}
	
	public void cook() {
		System.out.println(name + " is cooking!");
	}
}
