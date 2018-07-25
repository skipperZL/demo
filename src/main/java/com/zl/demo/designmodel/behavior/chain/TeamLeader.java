package com.zl.demo.designmodel.behavior.chain;

public class TeamLeader extends Employee {

	public TeamLeader(String name) {
		super(name);
	}

	@Override
	public void handle(Request request) {
		if (request.money <= 500) {
			System.out.println(name + "　is handling!");
		} else {
			toSuccessor(request);
		}
	}

}
