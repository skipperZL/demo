package com.zl.demo.designmodel.builder.prototype;

public abstract class Prototype {
	private String id;
	
	private StringBuffer name;
	
	public Prototype() {
		
	}
	
	public Prototype(String id, StringBuffer name) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public StringBuffer getName() {
		return name;
	}

	public void setName(StringBuffer name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public abstract Prototype clone();
}
