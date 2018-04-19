package com.zl.demo.jvm;

public class A004FinalizeEscapeGC {
	public static A004FinalizeEscapeGC obj = null;
	
	private void isAlive() {
		System.out.println("I am alive!");
	}
	
	@Override
	protected void finalize()  throws Throwable {
		super.finalize();
		System.err.println("Finalize method executed!");
		obj = this;
	}

	/**
	 * VM args -XX:+PrintGCDetails
	 * */
	public static void main(String[] args) throws InterruptedException {
		obj = new A004FinalizeEscapeGC();
		obj = null;
		System.gc();
		Thread.sleep(500);
		
		if (obj != null) {
			obj.isAlive();
		} else {
			System.out.println("I am dead!");
		}
		
		obj = null;
		System.gc();
		Thread.sleep(500);
		if (obj != null) {
			obj.isAlive();
		} else {
			System.out.println("I am dead!");
		}
	}

}
