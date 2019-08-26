package com.zl.demo.http;

import java.util.concurrent.CountDownLatch;

public class PostConcurrent implements Runnable{
	
	private final CountDownLatch start;
	private final CountDownLatch end;
	private final String url;
	
	public PostConcurrent(CountDownLatch start, CountDownLatch end, String url) {
		this.start = start;
		this.end = end;
		this.url = url;
	}
	
	public void run() {
		System.out.println("Be ready to send post.");
		try {
			end.countDown();	
			start.await();			
			Http.sendGet(url, "");	
			System.out.println(Thread.currentThread().getName() + " Sending...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	
	}

}
