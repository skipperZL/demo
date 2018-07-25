package com.zl.demo.designmodel.behavior.memento;

public class MementoDemo {
	
	public static void main(String[] args) {
		
		Game game = new Game(100, 200, 300);
		game.show();
		
		System.out.println("Before +++++++++++++++++++++++++++");
		Memento memento = game.createMemento();
		game.setHealth(20);
		game.setMana(30);
		game.show();
		
		game.recovery(memento);
		
		
	}
}
