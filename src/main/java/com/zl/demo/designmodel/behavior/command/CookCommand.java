package com.zl.demo.designmodel.behavior.command;

public class CookCommand extends Command{
	
	public CookCommand(Husband husband) {
		super(husband);
	}

	@Override
	public void excute() {
		husband.cook();
	}
}
