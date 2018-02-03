package com.zl.demo.javase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static com.zl.demo.javase.Printer.print;

public class CollectionsDemo {
	
	private void test() {
		List<SortTest> lists = generator(10);
		print("Before sort.");
		for (SortTest s : lists) {
			print(s.getCreated());
		}
		Collections.sort(lists, new Comparator<SortTest>() {
			@Override
			public int compare(SortTest o1, SortTest o2) {
				return o1.getCreated().compareTo(o2.getCreated());
			}
		});
		print("After sort.");
		for (SortTest s : lists) {
			print(s.getCreated());
		}
	}
	
	private List<SortTest> generator(int length) {
		List<SortTest> lists = new ArrayList<SortTest>();
		Random random = new Random();
		for(int i = 0; i < length; i++) {
			lists.add(new SortTest(new Date(System.currentTimeMillis() + random.nextInt(80000))));
		}
		return lists;
	}

	public static void main(String[] args) {
		CollectionsDemo col = new CollectionsDemo();
		col.test();

	}

}

class SortTest {
	private Date created;

	public SortTest(Date date) {
		this.created = date;
	}
	
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
}
