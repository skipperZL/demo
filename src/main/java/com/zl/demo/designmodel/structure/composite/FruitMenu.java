package com.zl.demo.designmodel.structure.composite;

import java.util.ArrayList;
import java.util.List;

public class FruitMenu extends MenuComponent{
	
	
	private List<MenuComponent> list = new ArrayList<>();

	public FruitMenu() {
		// TODO Auto-generated constructor stub
	}
	
	public FruitMenu(String name) {
		this.name = name;
	}
	
	@Override
	public void print(int level) {
		String prefix = "";
		for (int i = 0; i < level; i++) {
			prefix += "--";
		}
		System.out.println(prefix + name);
		for (MenuComponent menu : list) {
			menu.print(level + 1);
		}
	}
	
	public void add(MenuComponent menu) {
		list.add(menu);
	}
	
	public void remove(MenuComponent menu) {
		list.remove(menu);
	}


}
