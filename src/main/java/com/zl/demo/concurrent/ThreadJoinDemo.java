package com.zl.demo.concurrent;

public class ThreadJoinDemo {
	
	public static void main(String[] args) throws InterruptedException {
		PrintA t1 = new PrintA();
		PrintA t2 = new PrintA();
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t2);
		thread1.start();
		thread1.join();
		thread2.start();
		
	}
	
}

class PrintA implements Runnable {
	
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
	}
}
