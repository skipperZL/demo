package com.zl.demo.designmodel.behavior.memento;

public class Memento {
	private int level;
	private int health;
	private int mana;
	public Memento(int level, int health, int mana) {
		this.level = level;
		this.health = health;
		this.mana = mana;
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
