package com.zl.demo.designmodel.structure.decorator;

public class PlantDecorator extends RoomDecorator {

	public PlantDecorator(Room room) {
		super(room);
	}

	@Override
	public void show() {
		System.out.println("This is a plant!");
		room.show();
	}

	@Override
	public String list() {
		// TODO Auto-generated method stub
		return room.list() + "+ Plant";
	}

}
