package com.zl.demo.designmodel.builder.builder;

public class OppoBuilder implements PhoneBuilder {
	private Phone phone = new Phone();
	
	@Override
	public void builderScreen() {
		System.out.println("Screen made in China!");
		phone.add("Chinese Screen!");
	}

	@Override
	public void builderCpu() {
		System.out.println("Cpu made in China!");
		phone.add("Chinese Cpu!");
	}

	@Override
	public void builderBattery() {
		System.out.println("Battery made in China!");
		phone.add("Chinese Battery!");
	}

	@Override
	public Phone getPhone() {
		// TODO Auto-generated method stub
		return phone;
		
	}

}
