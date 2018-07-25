package com.zl.demo.designmodel.behavior.command;

public class DishCommand extends Command{

	public DishCommand(Husband husband) {
		super(husband);
	}

	@Override
	public void excute() {
		husband.doTheDishes();
	}

	
}
