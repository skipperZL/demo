package com.zl.demo.designmodel.structure.adapter;

public class AdapterMain {
	
	public static void main(String[] args) {
		
		JapanesePrinter jp = new JapanesePrinter();
		jp.apply110v();
		
		PowerAdapter pa = new PowerAdapter(new ChinesePower());
		pa.apply110v();
		
	}
}
