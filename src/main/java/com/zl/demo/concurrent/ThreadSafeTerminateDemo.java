package com.zl.demo.concurrent;

import java.util.concurrent.TimeUnit;

public class ThreadSafeTerminateDemo {

	public static void main(String[] args) throws InterruptedException {
		Say say = new Say();
		new Thread(say).start();
		System.out.println("Running!");
		TimeUnit.SECONDS.sleep(1);
		say.cancel();
	}
	
	private static class Say implements Runnable{
		private boolean flag = true;

		@Override
		public void run() {
			while (flag && !Thread.currentThread().isInterrupted()) {
				System.out.println(System.currentTimeMillis());
			}
			if (!flag)
				System.out.println("Cancel!");
		}
		
		public void cancel() {
			flag = false;
		}
		
	}

}
