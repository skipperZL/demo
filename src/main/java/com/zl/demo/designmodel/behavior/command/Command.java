package com.zl.demo.designmodel.behavior.command;

public abstract class Command {
	protected Husband husband;

	public Command(Husband husband) {
		this.husband = husband;
	}
	
	public Husband getHusband() {
		return husband;
	}

	public void setHusband(Husband husband) {
		this.husband = husband;
	}

	public abstract void excute();
}
