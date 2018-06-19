package com.zl.demo.designmodel.structure.decorator;

public class TVDecorator extends RoomDecorator {

	public TVDecorator(Room room) {
		super(room);
	}

	@Override
	public void show() {
		System.out.println("You can watch TV!");
		room.show();
	}

	@Override
	public String list() {
		// TODO Auto-generated method stub
		return room.list() + "+ TV";
	}

}
