package com.zl.demo.designmodel.behavior.state;

public class WorkingState implements WorkState {

	@Override
	public void work() {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeState(Work work) {
		if (work.getHour() <= 17 && work.getHour() >= 8) {
			System.out.println("It is " + work.getHour() + ". I am working.");
		} else {
			work.setState(new OffWorkState());
			work.toWork();
		}
	}

}
