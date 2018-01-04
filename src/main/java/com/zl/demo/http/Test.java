package com.zl.demo.http;

import java.util.Map.Entry;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		final CountDownLatch start = new CountDownLatch(1);
		final CountDownLatch end = new CountDownLatch(10);
		//final String url = "http://168.168.190.98:8900/gdsclsoa";
		final String url = "http://59.42.21.149:8900/gdsclsoa";
		for (int i = 0; i < 100; i++) {
			new Thread(new PostConcurrent(start, end, url)).start();
		}
		end.await();
		start.countDown();	
		Thread.sleep(2000);
		System.out.println("OVER!");
		for (Entry<String, Integer> e : Http.map.entrySet()) {
			System.out.println(e.getKey() + ":" + e.getValue());
		}
		
	}

}
