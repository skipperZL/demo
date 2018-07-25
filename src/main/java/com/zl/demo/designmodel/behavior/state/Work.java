package com.zl.demo.designmodel.behavior.state;

public class Work {
	
	private int hour;
	
	private WorkState state;
	
	public Work(WorkState state, int hour) {
		this.state = state;
		this.hour = hour;
	}

	public void toWork() {
		state.changeState(this);
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public WorkState getState() {
		return state;
	}

	public void setState(WorkState state) {
		this.state = state;
	}
	
	
}
