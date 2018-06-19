package com.zl.demo.algorithm.leetcode;

public class Code0002_AddTwoNumber {
	
	// 当超过int最大值时，运行错误。
	public Code0002_ListNode addTwoNumbers1(Code0002_ListNode l1, Code0002_ListNode l2) {
		return number2List(list2Number(l1) + list2Number(l2));
	}
	
	public Code0002_ListNode addTwoNumbers2(Code0002_ListNode l1, Code0002_ListNode l2) {
		int carry = 0;	
		Code0002_ListNode head = new Code0002_ListNode(0);
		Code0002_ListNode curList = head;
		while(l1 != null || l2 != null) {
			int x = (l1 != null ? l1.val : 0);
			int y = (l2 != null ? l2.val : 0);
			int sum = x + y + carry;
			carry = sum / 10;
			sum = sum % 10;
			Code0002_ListNode list = new Code0002_ListNode(sum);
			curList.next = list;
			curList = list;
			if (l1 != null) l1 = l1.next;
	        if (l2 != null) l2 = l2.next;
		}
		if (carry > 0) {
			curList.next = new Code0002_ListNode(carry);
	    }
		return head.next;
	}
	
	private int list2Number(Code0002_ListNode list) {
		int result = 0;
		result = list.val;
		int coefficient = 10;
		while(list.next != null) {
			list = list.next;
			result = result + list.val * coefficient;
			coefficient = coefficient * 10;
		}
		return result;
	}
	
	private Code0002_ListNode number2List(int num) {
		if (num == 0)
			return new Code0002_ListNode(num);
		int i = 0;
		Code0002_ListNode list = null;
		Code0002_ListNode currentList = null;
		while (num > 0) {
			i = num % 10;
			num = num/10;
			Code0002_ListNode newList = new Code0002_ListNode(i);
			if (currentList != null) {
				currentList.next = newList;
			}
			currentList = newList;
			if (list == null)
				list = currentList;
		}
		return list;
	}

	public static void main(String[] args) {
		Code0002_AddTwoNumber twoNumber = new Code0002_AddTwoNumber();
		Code0002_ListNode list10 = twoNumber.number2List(9);
		Code0002_ListNode list20 = twoNumber.number2List(999999991);
		twoNumber.addTwoNumbers1(list10, list20);
		twoNumber.addTwoNumbers2(list10, list20);
		System.out.println(twoNumber.list2Number(list10) + twoNumber.list2Number(list20));
	}
}
