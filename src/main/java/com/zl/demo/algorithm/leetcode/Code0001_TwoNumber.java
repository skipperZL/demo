package com.zl.demo.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Code0001_TwoNumber {
	
	
	// Brute Force, Time Complexity O(n2)
	private int[] twoSum1(int[] nums, int target) {
		int i, j;
		for (i = 0; i < nums.length; i++) {
			for (j = i + 1; j < nums.length; j++) {
				if ((nums[i] + nums[j]) == target) {
					System.out.println(i + "," + j);
					return new int[]{nums[i], nums[j]};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution!");
	}
	
	// Two-pass Hash Table, Time Complexity O(n)
	private int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0 ; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		for (int i = 0; i < nums.length; i++) {
			int element = target - nums[i];
			if (map.containsKey(element) && map.get(element) != i) {
				System.out.println(i + "," + map.get(element));
				return new int[] {i, map.get(element)};
			}
		}
		
		throw new IllegalArgumentException("No two sum solution!");
	}
	
	// One-pass Hash Table, Time Complexity O(n)
	private int[] twoSum3(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			int element = target - nums[i];
			if (map.containsKey(element)) {
				System.out.println(map.get(element) + "," + i);
				return new int[] {map.get(element), i};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution!");
	}

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		System.out.println("Brute Force!");
		new Code0001_TwoNumber().twoSum1(nums, target);
		System.out.println("Two-pass Hash table!");
		System.out.println(new Code0001_TwoNumber().twoSum2(nums, target));
		System.out.println("One-pass Hash table!");
		System.out.println(new Code0001_TwoNumber().twoSum3(nums, target));
	}
}
