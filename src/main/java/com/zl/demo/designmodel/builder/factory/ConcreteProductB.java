package com.zl.demo.designmodel.builder.factory;

public class ConcreteProductB implements IProduct {

	@Override
	public void operation() {
		System.out.println(this.getClass().getSimpleName());
	}

}
