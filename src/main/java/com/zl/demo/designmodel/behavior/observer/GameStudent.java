package com.zl.demo.designmodel.behavior.observer;

public class GameStudent extends Student {

	
	public GameStudent(String name) {
		super(name);
	}

	@Override
	public void update() {
		System.out.println(getName() + " is playing game, get message, stop playing game, start to study!");
	}

}
