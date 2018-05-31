package com.zl.demo.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ThreadThreadLocalDemo {
	// 第一次get()方法调用时会进行初始化（如果set方法没有调用），每个线程会调用一次
	private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
		protected Long initialValue() {
			return System.currentTimeMillis();
		}
	};
	
	private static final ThreadLocal<String> stringLocal = new ThreadLocal<String>();

	public static final void begin() {
		TIME_THREADLOCAL.set(System.currentTimeMillis());
	}

	public static final long end() {
		return System.currentTimeMillis() - TIME_THREADLOCAL.get();
	}
	
	public void test() {
		List<Thread> list = new ArrayList<Thread>();
		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					int flag = 0;
					stringLocal.set(Thread.currentThread().getName());
					while (flag ++ < 10) {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName());
						System.out.println(stringLocal.get());
					}
				}
			});
			list.add(thread);
			thread.start();
		}
	}
	
	public void test1() {
		new Thread() {
			public void run() {
				System.out.println("Before wait!");
				synchronized (this) {
					try {
						this.wait(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("After wait!");
				}
				
			}
		}.start();
	}

	public static void main(String[] args) throws Exception {
		ThreadThreadLocalDemo.begin();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Cost: " + ThreadThreadLocalDemo.end() + " mills");
		//new ThreadThreadLocalDemo().test();
		new ThreadThreadLocalDemo().test1();
	}
}
