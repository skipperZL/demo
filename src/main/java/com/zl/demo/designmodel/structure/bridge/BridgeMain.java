package com.zl.demo.designmodel.structure.bridge;

public class BridgeMain {

	public static void main(String[] args) {
		DriverBridge bridge = new UserBridge();
		bridge.setDriver(new OracleDriver());
		bridge.queryData();
		
		bridge.setDriver(new MysqlDriver());
		bridge.queryData();
	}

}
