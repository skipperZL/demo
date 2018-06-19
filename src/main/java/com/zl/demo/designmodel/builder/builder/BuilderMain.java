package com.zl.demo.designmodel.builder.builder;

public class BuilderMain {

	public static void main(String[] args) {
		PhoneBuilder iphoneBuilder = new IphoneBuilder();
		PhoneBuilder oppoBuilder = new OppoBuilder();
		Director director = new Director();
		director.createPhone(iphoneBuilder);
		iphoneBuilder.getPhone().show();
		
		director.createPhone(oppoBuilder);
		oppoBuilder.getPhone().show();
	}

}
