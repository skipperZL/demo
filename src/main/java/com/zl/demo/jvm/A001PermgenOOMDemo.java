package com.zl.demo.jvm;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class A001PermgenOOMDemo {

	/**
	 * VM Args: -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
	 * @param args
	 */
	public static void main(String[] args) {
		while(true) {
			testCreate();
		}
	}
	
	
	private static void testCreate() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(OOMObject.class);
		enhancer.setUseCache(false);
		enhancer.setCallback(new MethodInterceptor() {
			
			@Override
			public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
				// TODO Auto-generated method stub
				return arg3.invokeSuper(arg0, arg2);
			}
		});
		enhancer.create();
	}

} 
class OOMObject {
	private String name;
}

