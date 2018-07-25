package com.zl.demo.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Code0012_IntToRoman {
	 static Map<Integer, String> nums = new HashMap<>();
	 static String[][] units = new String[][]{{"I", "V"},{"X", "L"},{"C", "D"},{"M", ""}};
	    
	    
	  
	    
	    public String intToRoman(int num) {
	        if (nums.size() == 0) {
	            init();
	        }
	        int remainder = 0;
	        int i = 0;
	        String result = "";
	        while (num > 0) {
	            remainder = num % 10;
	            num = num/10;
	            remainder = (int) (Math.pow(10, i) * remainder);
	            if (remainder > 0) {
	                result = nums.get(remainder) + result;
	            }
	            i++;
	        }
	        return result;
	    }
	    
	    private void init() {
	        for (int i = 0; i < 4; i++) {
	            for (int j = 1; j < 10; j++) {
	                int number = (int) (Math.pow(10, i) * j);
	                String unit = "";
	                int tmp = j;
	                if (j < 4) {
	                    while (tmp > 0) {
	                        unit += units[i][0];
	                        tmp--;
	                    }
	                } else if (j == 4) {
	                    unit = units[i][0] + units[i][1];
	                } else if (j == 5) {
	                	unit = units[i][1];
	                } else if (j < 9) {
	                    while (tmp > 5) {
	                        unit += units[i][0];
	                        tmp--;
	                    }
	                    unit = units[i][1] + unit;
	                } else {
	                    if ((i + 1) < 4)
	                        unit = units[i][0] + units[i + 1][0];
	                }
	                nums.put(number, unit);
	            }
	        }  
	    }
	    
	    public static void main(String[] args) {
			Code0012_IntToRoman obj = new Code0012_IntToRoman();
			System.out.println(obj.intToRoman(100));
		}
}
