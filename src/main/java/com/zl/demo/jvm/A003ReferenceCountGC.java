package com.zl.demo.jvm;

public class A003ReferenceCountGC {
	public Object instance = null;
	private static final int _1M = 1024 * 1024;
	private byte[] bytes = new byte[2 * _1M];

	public static void main(String[] args) {
		A003ReferenceCountGC objA = new A003ReferenceCountGC();
		A003ReferenceCountGC objB = new A003ReferenceCountGC();
		objA.instance = objB;
		objB.instance = objA;
		objA = null;
		objB = null;
		System.gc();

	}

}
