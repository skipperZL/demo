package com.zl.demo.designmodel.behavior.interpreter;

public class AddInterpreter implements Interpreter{
	
	private Interpreter left;
	private Interpreter right;
	
	public AddInterpreter(Interpreter e1, Interpreter e2) {
		this.left = e1;
		this.right = e2;
	}

	@Override
	public double interpret() {
		return left.interpret() + right.interpret();
	}

}
