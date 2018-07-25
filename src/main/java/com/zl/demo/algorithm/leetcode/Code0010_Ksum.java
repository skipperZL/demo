package com.zl.demo.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code0010_Ksum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		return kSum(nums, target, 4);
	}

	public List<List<Integer>> kSum(int[] nums, int target, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length < k)
			return res;
		kSum(nums, target, 0, k, res, new int[k]);
		return res;
	}

	private void kSum(int[] nums, int target, int i, int k, List<List<Integer>> res, int[] arr) {
		// System.out.println(nums[i] + "," + k + "," + target);
		if (k == 0 && target == 0) {
			List<Integer> temp = new ArrayList<>();
			for (int val : arr)
				temp.add(val);
			res.add(temp);
		} else if (k > 0) {
			int len = nums.length;
			int max = nums[len - 1];
			if (max * k < target)
				return;
			for (int x = i; x <= len - k; x++) {
				if (x > i && nums[x] == nums[x - 1])
					continue;
				if (nums[x] + max * (k - 1) < target)
					continue;
				if (nums[x] * k > target)
					break;
				arr[arr.length - k] = nums[x];
				kSum(nums, target - nums[x], x + 1, k - 1, res, arr);
			}
		}
	}
}
