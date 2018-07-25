package com.zl.demo.designmodel.behavior.command;

public class CommandDemo {
	
	public static void main(String[] args) {
		Wife wife = new Wife("ManMan");
		Husband husband = new Husband("Lili");
		Command cook = new CookCommand(husband);
		Command dish = new DishCommand(husband);
		Command mop = new MopCommand(husband);
		
		wife.add(cook);
		wife.add(dish);
		wife.add(mop);
		wife.add(dish);
		
		System.out.println("***************First***************");
		wife.action();
		System.out.println("***************Second***************");
		wife.action();
		System.out.println("***************Third***************");
		wife.actionAndClear();
		System.out.println("***************Fourth***************");
		wife.action();
		
	}
}
