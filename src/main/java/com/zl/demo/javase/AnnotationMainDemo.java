package com.zl.demo.javase;

import java.lang.reflect.Method;

public class AnnotationMainDemo {

	@AnnotationDemo(priority = AnnotationDemo.Priority.MEDIUM, author = "Yashwant", status = AnnotationDemo.Status.STARTED)
	public void incompleteMethod1() {
		// Some business logic is written
		// But it’s not complete yet
	}
	
	@AnnotationDemo
	public void incompleteMethod2() {
		// Some business logic is written
		// But it’s not complete yet
	}

	public static void main(String[] args) {
		Class annotation = AnnotationMainDemo.class;
		for (Method method : annotation.getMethods()) {
			AnnotationDemo todoAnnotation = method.getAnnotation(AnnotationDemo.class);
			if (todoAnnotation != null) {
				System.out.println(" Method Name : " + method.getName());
				System.out.println(" Author : " + todoAnnotation.author());
				System.out.println(" Priority : " + todoAnnotation.priority());
				System.out.println(" Status : " + todoAnnotation.status());
			}
		}
	}

}
