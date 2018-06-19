package com.zl.demo.designmodel.builder.prototype;

public class PrototypeMain {

	public static void main(String[] args) {
		Prototype proto = new ConcretePrototype("01", new StringBuffer("Li"));
		Prototype proto1 = proto.clone();
		proto.getName().append("Ming");
		
		System.out.println(proto.getName());
		System.out.println(proto1.getName());
	}

}
