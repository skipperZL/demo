package com.zl.demo.javase;

public class ThreadLocalDemo implements Runnable{
	
	public int count = 1;
	
	public static final ThreadLocal<Integer> local = new ThreadLocal<Integer>();

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Thread(new ThreadLocalDemo()).start();
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 100000; i++) {
			count ++;
		}
		System.out.println(Thread.currentThread().getName() + "  count = " + count);
	}

}
