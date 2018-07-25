package com.zl.demo.designmodel.behavior.visitor;

public class FoodVisitor implements Visitor{

	@Override
	public void husbandConclusion(Person person) {
		System.out.println("Husband: " + person.name + "  says \"I like hot food\"!");
	}

	@Override
	public void wifeConclusion(Person person) {
		System.out.println("Wife: " + person.name + "  says \"I like sweet food\"!");
	}

}
