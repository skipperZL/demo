package com.zl.demo.designmodel.behavior.iterator;

import java.util.Arrays;
import java.util.List;

public class IteratorDemo {
	
	public static void main(String[] args) {
		ConcreteAggregate obj = new ConcreteAggregate();
		List<Object> list = Arrays.asList(new String[] {"a", "b", "v", "e"});
		obj.list = list;
		
		Iterator it = obj.createIterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
	
}
