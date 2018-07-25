package com.zl.demo.designmodel.behavior.state;

public class StateDemo {

	public static void main(String[] args) {
		Work work = new Work(new WakeUpState(), 0);
		work.toWork();
		work.setHour(17);
		work.toWork();
		work.setHour(20);
		work.toWork();
	}
	
}
