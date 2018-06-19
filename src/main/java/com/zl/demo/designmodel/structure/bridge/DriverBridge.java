package com.zl.demo.designmodel.structure.bridge;

public abstract class DriverBridge {
	private Driver driver;
	
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	public Driver getDriver() {
		return driver;
	}
	
	public abstract void queryData();
}
