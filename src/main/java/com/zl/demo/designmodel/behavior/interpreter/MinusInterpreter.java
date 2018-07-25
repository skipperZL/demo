package com.zl.demo.designmodel.behavior.interpreter;

public class MinusInterpreter implements Interpreter{
	private Interpreter left;
	private Interpreter right;
	
	public MinusInterpreter(Interpreter left, Interpreter right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public double interpret() {
		return left.interpret() - right.interpret();
	}

}
