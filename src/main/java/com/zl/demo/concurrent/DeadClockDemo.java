package com.zl.demo.concurrent;

public class DeadClockDemo {
	public Object lockA = new Object();
	public Object lockB = new Object();

	public void testDeadLock() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (lockA) {
					System.out.println(Thread.currentThread().getName() + " Get Lock A.");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (lockB) {
						System.out.println(Thread.currentThread().getName() + " Get Lock B.");
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lockB) {
					System.out.println(Thread.currentThread().getName() + " Get Lock B.");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (lockA) {
						System.out.println(Thread.currentThread().getName() + " Get Lock A.");
					}
				}
			}
		}).start();
	}
	
	public static void main(String[] args) {
		new DeadClockDemo().testDeadLock();
	}
}
