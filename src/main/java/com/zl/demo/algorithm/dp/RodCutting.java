package com.zl.demo.algorithm.dp;

public class RodCutting {
	
	public int recursive(int[] p, int n) {
		if (n == 0)
			return 0;
		int q = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			q = Math.max(q, p[i - 1] + recursive(p, n - i));
		}
		return q;
	}
	
	public int top2bottom(int[] p, int n) {
		int[] r = new int[p.length + 1];
		for (int i = 0; i < r.length; i++)
			r[i] = -1;
		return top2bottomCut(p, n, r);
	}

	public int top2bottomCut(int[] p, int n, int[] r) {
		int q = Integer.MIN_VALUE;
		if (r[n] >= 0)
			return r[n];
		if (n == 0)
			q = 0;
		else {
			for (int i = 1; i <= n; i++) {
				q = Math.max(q, top2bottomCut(p, n - i, r) + p[i -1]);
			}
		}
		r[n] = q;
		return q;
	}
	
	public int bottom2top(int[] p, int n) {
		int[] r = new int[n + 1];
		r[0] = 0;
		for (int i = 1; i <= n; i++) {
			int q = Integer.MIN_VALUE;
			for (int j = 1; j <= i; j++) {
				q = Math.max(q, p[j - 1] + r[i - j]);
			}
			r[i] = q;
			System.out.println(q);
		}
		return r[n];
	}
	
	public static void main(String[] args) {
		RodCutting rc = new RodCutting();
		int[] prices = { 1, 5, 8, 9, 10, 17, 17, 20, 24, 25 };
		int n = 10;
		System.out.println(rc.recursive(prices, n));
		System.out.println(rc.top2bottom(prices, n));
		System.out.println(rc.bottom2top(prices, n));
	}

}
