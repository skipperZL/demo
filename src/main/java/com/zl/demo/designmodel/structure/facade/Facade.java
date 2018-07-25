package com.zl.demo.designmodel.structure.facade;

public class Facade {

	private PrinterA printerA;
	private PrinterB printerB;
	private PrinterC printerC;
	
	public Facade(PrinterA a, PrinterB b, PrinterC c) {
		this.printerA = a;
		this.printerB = b;
		this.printerC = c;
	}
	
	public void print() {
		printerA.print1();
		printerB.print2();
		printerC.print3();
	}
	
	
	
	
}
