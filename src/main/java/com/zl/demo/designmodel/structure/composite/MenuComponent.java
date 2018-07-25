package com.zl.demo.designmodel.structure.composite;

public abstract class MenuComponent {
	String name;
	
	public void add(MenuComponent menu) {
		System.out.println("Default add method!");
	}
	
	public void remove(MenuComponent menu) {
		System.out.println("Default remove method!");
	}
	
	public abstract void print(int level);
	
}
