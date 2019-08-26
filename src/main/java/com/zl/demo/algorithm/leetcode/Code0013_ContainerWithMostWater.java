package com.zl.demo.algorithm.leetcode;

public class Code0013_ContainerWithMostWater {

	public int maxArea(int[] height) {
        if (height == null || height.length < 2) 
            return 0;
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            int temp = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, temp);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
	
	public static void main(String[] args) {
		Code0013_ContainerWithMostWater obj = new Code0013_ContainerWithMostWater();
		int[] height = new int[] {2,3,44,66,44,99,12,33,15,66,43,32};
		System.out.println(obj.maxArea(height));
	}

}
