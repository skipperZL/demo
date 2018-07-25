package com.zl.demo.designmodel.behavior.visitor;

public class VisitorDemo {

	public static void main(String[] args) {
		Visitor food = new FoodVisitor();
		Visitor game = new GameVisitor();
		Person husband = new Husband("Li");
		Person wife = new Wife("QM");
		
		husband.say(food);
		husband.say(game);
		wife.say(food);
		wife.say(game);
		
	}
	
}
