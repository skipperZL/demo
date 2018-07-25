package com.zl.demo.designmodel.behavior.observer;

public class SleepStudent extends Student {

	public SleepStudent(String name) {
		super(name);
	}

	@Override
	public void update() {
		System.out.println(getName() + " is dozing, get message, stop dozing, start to study!");
	}

}
