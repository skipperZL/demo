package com.zl.demo.designmodel.behavior.observer;

public class ObserverDemo {

	public static void main(String[] args) {
		Observer observer1 = new GameStudent("Zhang fei");
		Observer observer2 = new NovelStudent("Wu Kong");
		Observer observer3 = new SleepStudent("Bai xue");
		
		Teacher teacher = new MathTeacher("Math teacher", "Lucy");
		teacher.add(observer1);
		teacher.add(observer2);
		teacher.add(observer3);
		
		teacher.notifeStudents();
	}
}
