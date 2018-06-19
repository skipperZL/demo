package com.zl.demo.designmodel.structure.bridge;

public class OracleDriver implements Driver{

	@Override
	public void query() {
		System.out.println("Oracle Query!");
	}
	
	
}
