package com.zl.demo.jvm;

import java.io.IOException;
import java.io.InputStream;

public class A007ClassLoaderDemo {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		ClassLoader myClassLoader = new ClassLoader(){
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException{
				try {
					String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
					InputStream is = getClass().getResourceAsStream(fileName);
					if (is == null) {
						return super.loadClass(name);
					}
					byte[]  b = new byte[is.available()];
					is.read(b);
					return defineClass(name, b, 0, b.length);
				} catch (IOException e) {
					throw new ClassNotFoundException();
				}
			}
		};
		Object obj = myClassLoader.loadClass("com.zl.demo.jvm.A006GetAllStackTraceDemo").newInstance();
		System.out.println(obj.getClass());
		System.out.println(obj instanceof com.zl.demo.jvm.A006GetAllStackTraceDemo);
	}

}
