package com.zl.demo.designmodel.behavior.state;

public class WakeUpState implements WorkState {
	
	public WakeUpState() {
		
	}

	@Override
	public void work() {
		
	}

	@Override
	public void changeState(Work work) {
		if (work.getHour() == 7) {
			System.out.println("It is " + work.getHour() + ". I should get up.");
		} else {
			work.setState(new WorkingState());
			work.toWork();
		}
	}

}
