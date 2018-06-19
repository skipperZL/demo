package com.zl.demo.designmodel.builder.builder;

public class IphoneBuilder implements PhoneBuilder{
	private Phone phone = new Phone();
	
	@Override
	public void builderScreen() {
		System.out.println("Builder best screen!");
		phone.add("best screen!");
	}

	@Override
	public void builderCpu() {
		System.out.println("Builder best Cpu!");
		phone.add("best Cpu!");
	}

	@Override
	public void builderBattery() {
		System.out.println("Builder best battery!");
		phone.add("best battery!");
	}

	@Override
	public Phone getPhone() {
		return phone;
	}

}
