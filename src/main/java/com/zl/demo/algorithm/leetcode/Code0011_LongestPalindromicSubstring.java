package com.zl.demo.algorithm.leetcode;

public class Code0011_LongestPalindromicSubstring {
	
	// brute force
	public String longestPalindrome1(String s) {
        if (s == null) {
            return "";
        }
        s = s.trim();
        if (s.length() == 1) {
            return s;
        }
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                String tmp = s.substring(i, j + 1);
                if (check(tmp)) {
                    if (tmp.length() > result.length()) {
                        result = tmp;
                    } else {
                        break;
                    }
                } 
            }
        }
        return "".equals(result) ? s.substring(0, 1) : result;
    }
    
    private boolean check(String str) {
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 -i)) {
                return false;
            }
        }
        return true;
    }
    // expand around center
    public String longestPalindrome2(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length() - 1; i++) {
        	// center : one element . like   aba 
        	int len1 = expandAroundCenter(s, i, i);
        	// center : two element . like bb
        	int len2 = expandAroundCenter(s, i, i+1);
        	int len = Math.max(len1, len2);
        	if (len > (end - start + 1)) {
        		start = i - (len - 1)/2;
        		end = i + len/2;
        	}
        }
        
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        	left--;
        	right++;
        }
        return right - left - 1;
    }
	
	public static void main(String[] args) {
		Code0011_LongestPalindromicSubstring obj = new Code0011_LongestPalindromicSubstring();
		System.out.println(obj.longestPalindrome2("bb"));
	}

}
