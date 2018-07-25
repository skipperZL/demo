package com.zl.demo.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code0009_4sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return list;
        }
        // sort the array.
        Arrays.sort(nums);
        for (int n1 = 0; n1 < nums.length - 3; n1++) {
            // skip the same value.
            if (n1 > 0 && nums[n1] == nums[n1-1]) {
                continue;
            }
            for (int n2 = n1 + 1; n2 < nums.length -2; n2++) {
                // skip the same value.
                if (n2 > n1 + 1 && nums[n2] == nums[n2 - 1]) {
                    continue;
                }
                int tmp = target - nums[n1] - nums[n2];
                int n3 = n2 + 1;
                int n4 = nums.length - 1;
                while(n3 < n4) {
                    if ((nums[n3] + nums[n4]) > tmp) {
                        n4--;
                        continue;
                    } else if ((nums[n3] + nums[n4]) < tmp) {
                        n3++;
                        continue;
                    } else {
                         List<Integer> data = new ArrayList<>();
                        data.add(nums[n1]);
                        data.add(nums[n2]);
                        data.add(nums[n3]);
                        data.add(nums[n4]);
                        list.add(data);
                    }
                    // skip the same value
                    while (n3 < n4 && nums[n3] == nums[++n3]){}
                    
                    while (n3 < n4 && nums[n4] == nums[--n4]){}
                }
            }
            
        }
        return list;
    }
	
	public static void main(String[] args) {
		
	}
}
