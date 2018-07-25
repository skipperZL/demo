package com.zl.demo.designmodel.behavior.template;

public class ChildA implements Super {

	@Override
	public void show(String name) {
		System.out.println(this.getClass().getSimpleName() + " " + name);
	}

}
