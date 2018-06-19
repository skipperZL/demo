package com.zl.demo.designmodel.builder.builder;

import java.util.ArrayList;
import java.util.List;

public class Phone {
	private List<String> product = new ArrayList<>();
	
	public void add(String str) {
		product.add(str);
	}
	
	public void show() {
		for (String part : product) {
			System.out.println(part);
		}
	}
}
