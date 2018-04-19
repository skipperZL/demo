package com.zl.demo.jvm;

public class A005MinorGCDemo {
	private static final int _1M = 1024 * 1024;
	
	// VM args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
	// test2 -XX:PretenureSizeThreshold
	// -XX:+UseParNewGC
	// -XX:+UseConcMarkSweepGC
	// test3 -XX:+PrintTenuringDistribution -XX:MaxTenuringThreshold=1
	public static void main(String[] args) {
		//test1();
		test3();

	}
	
	private static void test1() {
		byte[] b1,b2,b3,b4;
		b1 = new byte[2 * _1M];
		b2 = new byte[2 * _1M];
		b3 = new byte[2 * _1M];
		b4 = new byte[4 * _1M];
		}
	
	private static void test2() {
		byte[] b1;
		b1 = new byte[4 * _1M];
	}
	
	private static void test3() {
		byte[] b1, b2, b3;
		b1 = new byte[_1M / 4];
		b2 = new byte[4 * _1M];
		b3 = new byte[4 * _1M];
		b3 = null;
		b3 = new byte[4 * _1M];
	}
	
	private static void test4() {
		byte[] b1, b2, b3, b4;
		b1 = new byte[_1M / 4];
		b2 = new byte[4 * _1M];
		b3 = new byte[4 * _1M];

		b4 = new byte[4 * _1M];
		b4 = null;
		b4 = new byte[4 * _1M];
	}
	
}
