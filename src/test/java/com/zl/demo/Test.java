package com.zl.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	@org.junit.Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		App app = (App) ac.getBean("testBean");
		app.show();
	}

}
