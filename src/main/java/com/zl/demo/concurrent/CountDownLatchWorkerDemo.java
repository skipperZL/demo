package com.zl.demo.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchWorkerDemo implements Runnable{
	private CountDownLatch start;
	private CountDownLatch end;
	
	public CountDownLatchWorkerDemo(CountDownLatch start, CountDownLatch end) {
		this.start = start;
		this.end = end;
	}
	
	public void run() {
		try {
			before();
			start.await();
			doWork();
			end.countDown();
			finish();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void before() {
		System.out.println("Before Start!");
	}
	
	private void doWork() {
		System.out.println("Do work!");
	}
	
	private void finish() {
		System.out.println("Finished!");
	}
}
