package com.zl.demo.designmodel.behavior.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Teacher {
	
	private String subject;
	
	private String name;
	
	protected List<Observer> observers = new ArrayList<>();
	
	
	public Teacher(String subject, String name) {
		this.subject = subject;
		this.name = name;
	}
	
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void add(Observer ob) {
		observers.add(ob);
	}
	
	public void remove(Observer ob) {
		observers.remove(ob);
	}
	
	public void clear() {
		observers.clear();
	}
	
	public abstract void notifeStudents();
}
