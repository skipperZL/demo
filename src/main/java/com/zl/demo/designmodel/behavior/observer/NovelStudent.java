package com.zl.demo.designmodel.behavior.observer;

public class NovelStudent extends Student {

	public NovelStudent(String name) {
		super(name);
	}

	@Override
	public void update() {
		System.out.println(getName() + " is reading a novel, get message, stop reading a novel, start to study!");
	}

}
