package com.zl.demo.algorithm;

import java.util.Random;

public class MyInsertionSort {
	
	public void sort(int[] arr) {
		if (arr.length == 1) 
			return;
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i;
			while (j > 0 && temp > arr[j-1]) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = temp; 
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(500);
		}
		new MyInsertionSort().sort(arr);
		for (int e : arr)
			System.out.println(e);
	}
}
