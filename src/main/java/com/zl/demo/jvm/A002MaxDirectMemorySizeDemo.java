package com.zl.demo.jvm;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class A002MaxDirectMemorySizeDemo {

	/**
	 * VM Args:-XX:MaxDirectMemorySize=5M
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		Field[] fields = Unsafe.class.getDeclaredFields();
		for (Field f : fields) {
			System.out.println(f.getName()  + f.getType());
		}
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsafeField.get(null);
		while(true) {
			unsafe.allocateMemory(1024 * 1024);
		}
	}
	

}
