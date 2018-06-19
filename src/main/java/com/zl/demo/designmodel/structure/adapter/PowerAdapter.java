package com.zl.demo.designmodel.structure.adapter;

public class PowerAdapter implements JapanesePower {
	private ChinesePower cp;
	
	public PowerAdapter(ChinesePower cp) {
		this.cp = cp;
	}
	
	@Override
	public void apply110v() {
		System.out.println("PowerAdapter convert 220v to 110v!");
		cp.apply220v();
	}

}
