package com.zl.demo.designmodel.behavior.interpreter;

public class InterpreterDemo {
	
	public static void main(String[] args) {
		Interpreter a = new Variable(33.33);
		Interpreter b = new Variable(23);
		Interpreter c = new Variable(123);
		
		Interpreter add = new AddInterpreter(a, b);
		Interpreter minus = new MinusInterpreter(add, c);
		
		System.out.println(minus.interpret());
	}
	
}
