package com.zl.demo.designmodel.structure.decorator;

public class LivingRoom implements Room {

	@Override
	public void show() {
		System.out.println("This is my living room.");
	}

	@Override
	public String list() {
		// TODO Auto-generated method stub
		return "Living room ";
	}

}
