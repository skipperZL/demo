package com.zl.demo.designmodel.behavior.visitor;

public class GameVisitor implements Visitor{

	@Override
	public void husbandConclusion(Person person) {
		System.out.println("Husband: " + person.name + "  says \"I like action game\"!");
	}

	@Override
	public void wifeConclusion(Person person) {
		System.out.println("Wife: " + person.name + "  says \"I hate game\"!");
	}

}
