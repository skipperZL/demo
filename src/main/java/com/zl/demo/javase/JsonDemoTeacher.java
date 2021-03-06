package com.zl.demo.javase;

import net.sf.json.JSONString;

public class JsonDemoTeacher implements JSONString{
	private String name;
	private String id;
	private int age;
	private int sex;
	
	public JsonDemoTeacher(String name, String id, int age, int sex) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
		this.sex = sex;
	}

	public String getName() {
		System.out.println("The getter of name.");
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	@Override
	public String toJSONString() {
		return "{\"name\":\"" + name + "\",\"sex\":\"" + sex + "\"}";
	}
	
}
