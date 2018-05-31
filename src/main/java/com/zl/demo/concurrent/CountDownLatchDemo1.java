package com.zl.demo.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo1 {
	
	public static void main(String[] args) throws InterruptedException {
		int count = 10;
		CountDownLatch start = new CountDownLatch(1);
		CountDownLatch end = new CountDownLatch(count);
		for (int i = 0; i < count; i++) {
			new Thread(new CountDownLatchWorkerDemo(start, end)).start();
		}
		
		Thread.sleep(3000);
		
		start.countDown();
		end.await();
		System.out.println("Game Over!");
	}

}
