package com.zl.demo.designmodel.structure.bridge;

public class UserBridge extends DriverBridge {

	@Override
	public void queryData() {
		System.out.println("User Query Data!");
		getDriver().query();
	}
	
}
