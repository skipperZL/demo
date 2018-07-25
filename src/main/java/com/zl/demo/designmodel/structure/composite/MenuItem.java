package com.zl.demo.designmodel.structure.composite;

public class MenuItem extends MenuComponent{

	@Override
	public void print(int level) {
		String prefix = "";
		for (int i = 0; i < level; i++) {
			prefix += "--";
		}
		System.out.println(prefix + "Leaf");
	}

}
