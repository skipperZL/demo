package com.zl.demo.algorithm.leetcode;

public class Code0007_MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int i = 0;
		int j = 0;
		int pos = 0;
		double result = 0.0;
		int[] tmp = new int[nums1.length + nums2.length];
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				tmp[pos++] = nums1[i++];
			} else {
				tmp[pos++] = nums2[j++];
			}
		}

		while (i < nums1.length) {
			tmp[pos++] = nums1[i++];
		}

		while (j < nums2.length) {
			tmp[pos++] = nums2[j++];
		}
		result = (pos % 2 == 0) ? (tmp[pos / 2] + tmp[pos / 2 - 1]) / 2.0 : tmp[pos / 2];
		return result;
	}
	 
	public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
		int l1 = nums1.length;
		int l2 = nums2.length;
		if (l1 > l2) {
			return findMedianSortedArrays(nums2, nums1);
		}

		int min1 = 0;
		int max1 = l1;
		int half = (l1 + l2 + 1) / 2; // when odd left = right + 1 even: left = right

		while (min1 <= max1) {
			int i = (min1 + max1) / 2;
			int j = half - i;
			if (i < max1 && nums2[j - 1] > nums1[i]) {
				min1++;
			} else if (i > min1 && nums1[i - 1] > nums2[j]) {
				max1--;
			} else {
				int maxLeft = 0;
				if (i == 0) {
					maxLeft = nums2[j - 1];
				} else if (j == 0) {
					maxLeft = nums1[i - 1];
				} else {
					maxLeft = Math.max(nums2[j - 1], nums1[i - 1]);
				}
				if ((l1 + l2) % 2 != 0) {
					return maxLeft;
				}
				int minRight = 0;
				if (i == l1) {
					minRight = nums2[j];
				} else if (j == l2) {
					minRight = nums1[i];
				} else {
					minRight = Math.min(nums2[j], nums1[i]);
				}
				return (maxLeft + minRight) / 2.0;
			}
		}

		return 0.0;
	}

	public static void main(String[] args) {
		Code0007_MedianofTwoSortedArrays obj = new Code0007_MedianofTwoSortedArrays();
		int[] nums1 = {111, 112, 113};
		int[] nums2 = {4, 5, 6, 7 ,8, 9};
		System.out.println(obj.findMedianSortedArrays(nums1, nums2));
		System.out.println(obj.findMedianSortedArrays1(nums1, nums2));
	}

}
