package com.zl.demo;

/**
 * Hello world!
 *
 */
public class App {
	private String name;
	private String age;
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}


	public void show() {
		System.out.println("I am " + name + ". I am " + age + ".");
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}
