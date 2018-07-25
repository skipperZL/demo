package com.zl.demo.designmodel.behavior.state;

public class OffWorkState implements WorkState {

	@Override
	public void work() {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeState(Work work) {
		if (work.getHour() < 22 && work.getHour() > 17) {
			System.out.println("It is " + work.getHour() + ". OFF DUTY.");
		} else {
			work.setState(new SleepingState());
			work.toWork();
		}
	}

}
