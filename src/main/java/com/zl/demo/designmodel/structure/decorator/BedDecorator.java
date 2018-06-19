package com.zl.demo.designmodel.structure.decorator;

public class BedDecorator extends RoomDecorator {

	public BedDecorator(Room room) {
		super(room);
	}

	@Override
	public void show() {
		System.out.println("You can go to bed!");
		room.show();
	}

	@Override
	public String list() {
		return room.list() + " + Bed";
	}

}
