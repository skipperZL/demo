package com.zl.demo.designmodel.structure.proxy;

public class ProxyMain {
	public static void main(String[] args) {
		Proxy proxy = new Proxy(new Person());
		proxy.speak();
	}
}
