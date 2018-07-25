package com.zl.demo.designmodel.behavior.chain;

public class HR extends Employee{

	public HR(String name) {
		super(name);
	}

	@Override
	public void handle(Request request) {
		if (request.money <= 5000 && request.money > 500) {
			System.out.println(name + "　is handling!");
		} else {
			toSuccessor(request);
		}
	}

}
