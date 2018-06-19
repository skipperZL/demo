package com.zl.demo.designmodel.structure.decorator;

public class Bedroom implements Room{

	@Override
	public void show() {
		System.out.println("This is my bedroom.");
	}

	@Override
	public String list() {
		return "Bedroom";
	}

}
