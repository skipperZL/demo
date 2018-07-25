package com.zl.demo.designmodel.behavior.observer;

public class MathTeacher extends Teacher {

	public MathTeacher(String subject, String name) {
		super(subject, name);
	}

	@Override
	public void notifeStudents() {
		System.out.println(getSubject() + ":" + getName() + " is coming!");
		for (Observer observer : observers) {
			observer.update();
		}
	}

}
