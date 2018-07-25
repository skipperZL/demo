package com.zl.demo.designmodel.behavior.state;

public class SleepingState implements WorkState {

	@Override
	public void work() {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeState(Work work) {
		if (work.getHour() > 22 || work.getHour() < 7) {
			System.out.println("It is " + work.getHour() + ". Go to bed.");
		} else {
			work.setState(new WakeUpState());
			work.toWork();
		}
	}

}
