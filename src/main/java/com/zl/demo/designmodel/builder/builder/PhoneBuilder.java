package com.zl.demo.designmodel.builder.builder;

public interface PhoneBuilder {
	
	void builderScreen();
	
	void builderCpu();
	
	void builderBattery();
	
	Phone getPhone();
}
