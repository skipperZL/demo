package com.zl.demo.designmodel.behavior.observer;

public abstract class Student implements Observer {
	
	private String name;
	
	public Student(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	@Override
	public abstract void update();

}
