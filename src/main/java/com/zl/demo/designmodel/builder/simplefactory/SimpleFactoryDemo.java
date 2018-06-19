package com.zl.demo.designmodel.builder.simplefactory;

public class SimpleFactoryDemo {

	public IProduct createProduct(String proStr) {
		IProduct product = null;

		switch (proStr) {
		case "ProductA":
			product = new ProductA();
			break;
		case "ProductB":
			product = new ProductB();
			break;
		}

		return product;
	}
	
}
