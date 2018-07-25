package com.zl.demo.designmodel.structure.composite;

public class CompositeMain {
	
	public static void main(String[] args) {
		MenuComponent root = new FruitMenu("Root");
		
		MenuComponent m1 = new FruitMenu("Menu one");
		MenuComponent m2 = new FruitMenu("Menu two");
		MenuComponent m3 = new FruitMenu("Menu three");
		
		MenuComponent m11 = new FruitMenu("Menu one one");
		MenuComponent m12 = new FruitMenu("Menu one two");
		MenuComponent m13 = new FruitMenu("Menu one three");
		
		MenuComponent leaf1 = new MenuItem();
		MenuComponent leaf2 = new MenuItem();
		MenuComponent leaf3 = new MenuItem();
		
		m13.add(leaf1);
		m13.add(leaf2);
		m13.add(leaf3);
		
		m1.add(m11);
		m1.add(m12);
		m1.add(m13);
		
		root.add(m1);
		root.add(m2);
		root.add(m3);
		
		root.print(1);
		
		
		
	}
}
