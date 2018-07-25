package com.zl.demo.designmodel.behavior.chain;

public class Manager extends Employee {

	public Manager(String name) {
		super(name);
	}

	@Override
	public void handle(Request request) {
		if (request.money > 5000) {
			System.out.println(name + "　is handling!");
		} else {
			toSuccessor(request);
		}
	}

}
