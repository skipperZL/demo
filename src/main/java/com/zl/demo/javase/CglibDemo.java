package com.zl.demo.javase;

import static com.zl.demo.javase.Printer.print;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibDemo {
	
	public void test() {
		print("Hello, Everyone.");
	}
	
	
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(CglibDemo.class);
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				print("Before!");
				Object result = proxy.invokeSuper(obj, args);
				print("After!");
				return result;
			}
			
		});
		CglibDemo cd = (CglibDemo) enhancer.create();
		cd.test();
		print(cd.getClass());
		print(cd.toString());

	}

}
