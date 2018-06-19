package com.zl.demo.designmodel.structure.decorator;

public abstract class RoomDecorator implements Room {
	protected Room room;
	
	public RoomDecorator(Room room) {
		this.room = room;
	}
	
	public abstract void show();
	
	public abstract String list();

}
