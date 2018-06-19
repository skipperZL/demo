package com.zl.demo.designmodel.structure.decorator;

public class DecoratorMain {
	
	public static void main(String[] args) {
		Room room1 = new LivingRoom();
		Room room2 = new Bedroom();
		
		RoomDecorator plant1 = new PlantDecorator(room1);
		RoomDecorator tv1 = new TVDecorator(plant1);
		tv1.show();
		System.out.println(tv1.list());
		
		RoomDecorator plant2 = new PlantDecorator(room2);
		RoomDecorator tv2 = new TVDecorator(plant2);
		RoomDecorator bed2 = new BedDecorator(tv2);
		bed2.show();
		System.out.println(bed2.list());
	}
}
