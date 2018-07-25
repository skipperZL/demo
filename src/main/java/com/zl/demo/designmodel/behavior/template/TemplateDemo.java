package com.zl.demo.designmodel.behavior.template;

public class TemplateDemo {

	public static void main(String[] args) {
		Super objA = new ChildA();
		Super objB = new ChildB();
		objA.show("eggplant");
		objB.show("nectarine");
	}
}
