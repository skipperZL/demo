package com.zl.demo.designmodel.structure.proxy;

public class Proxy implements Say{
	private Say say;
	
	public Proxy(Say say) {
		this.say = say;
	}
	
	@Override
	public void speak() {
		System.out.println("Begin!");
		say.speak();
		System.out.println("End");
	}

}
