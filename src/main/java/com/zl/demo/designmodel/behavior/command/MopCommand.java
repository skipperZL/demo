package com.zl.demo.designmodel.behavior.command;

public class MopCommand extends Command{

	public MopCommand(Husband husband) {
		super(husband);
	}

	@Override
	public void excute() {
		husband.mop();
	}

}
