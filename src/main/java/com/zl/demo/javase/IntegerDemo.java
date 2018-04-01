package com.zl.demo.javase;

import static com.zl.demo.javase.Printer.print;

public class IntegerDemo {
	
	public static void main(String[] args) throws InterruptedException {
		// Integer 预缓存 -128 至 127
		print(Integer.valueOf("123") == Integer.valueOf("123"));
		print(Integer.valueOf("128") == Integer.valueOf("128"));
		Thread.sleep(60000);
	}
}
