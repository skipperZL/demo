package com.zl.demo.designmodel.behavior.iterator;

public class MyIterator implements Iterator{
	private ConcreteAggregate aggregate;
	private int count = 0;
	
	public MyIterator(ConcreteAggregate aggregate) {
		this.aggregate = aggregate;
	}

	@Override
	public Object next() {
		if (count < aggregate.list.size()) {
			return aggregate.list.get(count++);
		} else {
			throw new RuntimeException("Out of Index!");
		}
	}

	@Override
	public boolean hasNext() {
		if (count < aggregate.list.size()) {
			return true;
		} else {
			return false;
		}
	}

}
