package com.zl.demo.designmodel.builder.abstractfactory;

public class ConcreteProductA1 implements IProductA {

	@Override
	public void operation() {
		System.out.println(this.getClass().getSimpleName());
	}

}
