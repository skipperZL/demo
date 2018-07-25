package com.zl.demo.designmodel.behavior.iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate implements Aggregate{
	List<Object> list = new ArrayList<>();
	
	@Override
	public Iterator createIterator() {
		return new MyIterator(this);
	}

}
