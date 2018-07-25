package com.zl.demo.algorithm;

public class DpDemo {
	
	public int sum(int i) {
		if (i == 0)
			return 0;
		return i + sum(i-1);
	}
	
	public static void main(String[] args) {
		DpDemo dp = new DpDemo();
		System.out.println(dp.sum(100));
	}
}
