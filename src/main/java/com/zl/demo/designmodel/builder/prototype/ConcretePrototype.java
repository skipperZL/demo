package com.zl.demo.designmodel.builder.prototype;

public class ConcretePrototype extends Prototype {
 
	public ConcretePrototype() {
		
	}
	
	public ConcretePrototype(String id, StringBuffer name) {
		super(id, name);
	}
	
	@Override
	public Prototype clone() {
		StringBuffer name = new StringBuffer(this.getName().toString());
		Prototype prototype = new ConcretePrototype(this.getId(), name);
		return prototype;
	}

}
