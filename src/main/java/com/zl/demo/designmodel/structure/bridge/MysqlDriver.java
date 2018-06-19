package com.zl.demo.designmodel.structure.bridge;

public class MysqlDriver implements Driver{

	@Override
	public void query() {
		System.out.println("Mysql Query!");
	}
	
	
}
