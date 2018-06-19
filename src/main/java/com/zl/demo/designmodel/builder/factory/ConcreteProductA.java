package com.zl.demo.designmodel.builder.factory;

public class ConcreteProductA implements IProduct {

	@Override
	public void operation() {
		System.out.println(this.getClass().getSimpleName());
	}

}
