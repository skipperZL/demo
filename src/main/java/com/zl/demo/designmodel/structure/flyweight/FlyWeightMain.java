package com.zl.demo.designmodel.structure.flyweight;

public class FlyWeightMain {

	public static void main(String[] args) {
		DriveFactory factory = new DriveFactory();
		 
		Drive drive1 = factory.getDrive("AoDi");
		Drive drive2 = factory.getDrive("BenChi");
		Drive drive3 = factory.getDrive("MaShaLaDi");
		Drive drive4 = factory.getDrive("AoDi");
		
		Person person1 = new Person("LiBai");
		Person person2 = new Person("ZhangFei");
		Person person3 = new Person("LeiNing");
		Person person4 = new Person("Potter");
		
		System.out.println(drive1 == drive4);
		drive1.go(person1);
		drive1.go(person2);
		drive2.go(person2);
		drive3.go(person3);
		drive4.go(person4);
		
	}

}
