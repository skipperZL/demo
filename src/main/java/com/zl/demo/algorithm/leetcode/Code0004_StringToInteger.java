package com.zl.demo.algorithm.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
public class Code0004_StringToInteger {
	
    public int myAtoi1(String str) {
        str = str.trim();
        String result = getString(str);
        if (result.length() == 0) 
        	return 0;
       if (result.startsWith("-")) {
        	if (result.length() > 11) {
        		return Integer.MIN_VALUE;
        	}
        } else {
        	if (result.length() > 11) {
        		return Integer.MAX_VALUE;
        	}
        }
        long num = Long.parseLong(result);
        if (num > Integer.MAX_VALUE) {
        	return Integer.MAX_VALUE;
        } else if (num < Integer.MIN_VALUE) {
        	return Integer.MIN_VALUE;
        } else {
        	return (int)num;
        }
    }
    
    public int myAtoi2(String str) {
        str = str.trim();
        if (str.length() == 0) 
        	return 0;
        int symbol = 1;
        int start = 0;
        int end = 0;
        long result = 0;
        
        char[] nums = str.toCharArray();
        if (nums[start] == '-') {
        	symbol = -1;
        	start++;
        	end = start;
        } else if (nums[start] == '+') {
        	start++;
        	end = start;
        } else if (Character.isDigit(nums[start])) {
        	end = start;
        } else {
        	return 0;
        }
        
        while (end < nums.length && Character.isDigit(nums[end])) {
        	// If use character to calculate, it need subtract '0';
        	result = result * 10 + nums[end] - '0';
        	long tmp = result * symbol;
        	if (tmp >Integer.MAX_VALUE) {
        		return Integer.MAX_VALUE;
        	} else if (tmp < Integer.MIN_VALUE) {
        		return Integer.MIN_VALUE;
        	}
        	end++;
        }
        result = result * symbol;
        return (int)result;
       
    }
    
    private String getString(String str) {
    	 Pattern p = Pattern.compile("(^(-|\\+)\\d+)|^\\d+");
		 Matcher m = p.matcher(str);
		 String result = "";
		 if (m.find()) {
			 result = m.group();
		 }
		 String pre = "";
		 if (result.startsWith("+")) {
			 pre = "+";
		 } else if (result.startsWith("-")) {
			 pre = "-";
		 }
		 
		 if (!"".equals(pre)) {
			 result = result.substring(1, result.length());
			 if (result.length() == 0) {
				 return "";
			 }
		 }
		 result = pre + result.replaceAll("^0+", "");
		 if (!"".equals(pre) && result.length() == 1) {
			 result ="";
		 } 
		 return result;
    }
    
    
    
	

	public static void main(String[] args) {
		Code0004_StringToInteger obj = new Code0004_StringToInteger();
		System.out.println("0".replaceAll("^0+", ""));
		System.out.println(obj.myAtoi1("-0a9"));
		System.out.println((10 + '9' - '0'));
	}

}
