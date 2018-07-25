package com.zl.demo.designmodel.behavior.memento;

public class Game {
	
	private int level;
	private int health;
	private int mana;
	
	public Game(int level, int health, int mana) {
		this.level = level;
		this.health = health;
		this.mana = mana;
	}
	
	public Memento createMemento() {
		return new Memento(level, health, mana);
	}
	
	public void recovery(Memento memento) {
		this.level = memento.getLevel();
		this.health = memento.getHealth();
		this.mana = memento.getMana();
	}
	
	public void show() {
		System.out.println("Level: " + level);
		System.out.println("Health: " + health);
		System.out.println("Mana: " + mana);
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	
}
