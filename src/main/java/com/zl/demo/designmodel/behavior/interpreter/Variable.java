package com.zl.demo.designmodel.behavior.interpreter;

public class Variable implements Interpreter{
	double num;
	
	public Variable(double num) {
		this.num = num;
	}
	
	@Override
	public double interpret() {
		return num;
	}

}
