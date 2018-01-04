package com.zl.demo.concurrent;

import java.util.concurrent.CountDownLatch;

public class Worker implements  Runnable{
	private final CountDownLatch startSignal;
	private final CountDownLatch doneSignal;

	public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
		this.startSignal = startSignal;
		this.doneSignal = doneSignal;
	}

	public void run() {
		try {
			startSignal.await();
			doWork();
			Thread.sleep(3000);
			doneSignal.countDown();
		} catch (InterruptedException ex) {
		}
	}

	void doWork() {
		System.out.println(Thread.currentThread().getName() + "invoke dowork!");
	}
}
