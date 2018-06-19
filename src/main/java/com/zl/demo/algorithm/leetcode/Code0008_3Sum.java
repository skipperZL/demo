package com.zl.demo.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code0008_3Sum {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return list;
        // sort
        Arrays.sort(nums);
        for (int left = 0, tmp = 0; left < nums.length - 2; left++) {
            if (left > 0 && nums[left] == nums[left - 1])
                continue;
            tmp = -nums[left];
            int mid = left + 1;
            int right = nums.length - 1;
            while (mid < right) {
                if ((nums[mid] + nums[right]) > tmp) {
                    right--;
                }else if ((nums[mid] + nums[right]) < tmp) {
                    mid++;
                } else {
					int tmpM = nums[mid], tmpR = nums[right];
                    list.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    while (mid < right && nums[++mid] == tmpM);
                    while (mid < right && nums[--right] == tmpR);
                }
            }
        }
        return list;
    }

	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		Code0008_3Sum obj = new Code0008_3Sum();
		obj.threeSum(nums);
	}

}
