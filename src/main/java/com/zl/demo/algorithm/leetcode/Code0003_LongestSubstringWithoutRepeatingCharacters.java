package com.zl.demo.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Code0003_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring1(String s) {
    	if (s == null || s.length() == 0)
    		return 0;
        int max = 0;
        int tmp = 0;
        int start = 0;
        int pos = 0;
        int end = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
        	int j = pos;
        	boolean flag = false;
        	for (; j < i; j++) {
        		if (array[i] == array[j]) {
        			flag = true;
        			pos = j + 1;
        			break;
        		}
        	}
        	if (!flag) {
        		tmp++;
        	} else {
        		tmp = i - j;
        	}
        	if (tmp > max) {
        		max = tmp;
        		end = i;
        		start = pos;
        	}
        }
        System.out.println(s.substring(start, end + 1));
        return max;
    }
    
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        System.out.println(ans);
        return ans;
    }
    
    // HashMap
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int j = 0, i = 0; j < n; j++) {
        	if (map.containsKey(s.charAt(j))) {
        		i = Math.max(map.get(s.charAt(j)), i);
        	}
        	max = Math.max(max, j - i + 1);
        	map.put(s.charAt(j), j + 1);
        }
        System.out.println(max);
        return max;
    }
    
    // ASCII
    public int lengthOfLongestSubstring4(String s) {
    	int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        System.out.println(ans);
        return ans;
    }
    
    public int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
            x = -x;
        }
    	String xString = String.valueOf(x);      
    	StringBuffer stringBuffer = new StringBuffer();
    	for (int i = xString.length() - 1; i >= 0 ; i--) {
    		stringBuffer.append(xString.charAt(i));
    	}
        long result = Long.valueOf(stringBuffer.toString());
        if (negative) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)result;
    }
    
    public static void main(String[] args) {
    	Code0003_LongestSubstringWithoutRepeatingCharacters obj = new Code0003_LongestSubstringWithoutRepeatingCharacters();
    	obj.lengthOfLongestSubstring1("pwwkew");
    	obj.lengthOfLongestSubstring2("abcdeafghij");
    	obj.lengthOfLongestSubstring3("aabcd");
    	obj.lengthOfLongestSubstring4("aa");
    	//obj.reverse(-2147483648);
    	System.out.println(Integer.MAX_VALUE);
	}
}
