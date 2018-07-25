package com.zl.demo.designmodel.behavior.visitor;

public class Wife extends Person{

	public Wife(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void say(Visitor visitor) {
		visitor.husbandConclusion(this);
		
	}

	
}
