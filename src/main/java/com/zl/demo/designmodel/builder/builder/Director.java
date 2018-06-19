package com.zl.demo.designmodel.builder.builder;

public class Director {
	
	public void createPhone(PhoneBuilder builder) {
		builder.builderScreen();
		builder.builderCpu();
		builder.builderBattery();
	}
}
