package com.zl.demo.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Code0005_GenerateParetheses {
	int count1 = 0;
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		generate(list, "", 0, 0, n);
		return list;
	}

	private void generate(List<String> list, String cur, int open, int close, int max) {
		count1++;
		if (cur.length() == max * 2) {
			list.add(cur);
			return;
		}
		if (open < max) {
			generate(list, cur + "(", open + 1, close, max);
		}
		if (close < open) {
			generate(list, cur + ")", open, close + 1, max);
		}
	}
	
	int count = 0;
	
	public List<String> generateParenthesis1(int n) {
		List<String> ans = new ArrayList();
		count++;
		if (n == 0) {
			ans.add("");
		} else {
			for (int c = 0; c < n; ++c)
				for (String left : generateParenthesis1(c)) {
					System.out.println("left" + ":" + left);
					for (String right : generateParenthesis1(n - 1 - c)) {
						System.out.println("right" + ":" + right);
						ans.add("(" + left + ")" + right);
					}
						
				}
					
		}
		return ans;
	}


	public static void main(String[] args) {
		Code0005_GenerateParetheses obj = new Code0005_GenerateParetheses();
		System.out.println(obj.generateParenthesis(2));
		System.out.println(obj.generateParenthesis1(2));
		System.out.println(obj.count1);
		System.out.println(obj.count);
		
	}

}
