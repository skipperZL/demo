package com.zl.demo.designmodel.structure.facade;

public class FacadeMain {
	
	public static void main(String[] args) {
		Facade facade = new Facade(new PrinterA(), new PrinterB(), new PrinterC());
		facade.print();
	}
}
