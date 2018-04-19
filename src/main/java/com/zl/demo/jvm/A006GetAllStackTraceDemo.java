package com.zl.demo.jvm;

import java.util.Map;

public class A006GetAllStackTraceDemo {

	public static void main(String[] args) {
 
		Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
		for (Thread t : map.keySet()) {
			System.out.println(t.getName());
			for (StackTraceElement e : map.get(t)) {
				System.out.println(e);
			}
		}
	}

}
