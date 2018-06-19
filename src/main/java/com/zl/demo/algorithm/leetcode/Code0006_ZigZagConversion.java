package com.zl.demo.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Code0006_ZigZagConversion {
	
    public String convert(String s, int numRows) {
        if (numRows == 1)
        	return s;
        int len = s.length();
        int start = 0;
        char[] newArray = new char[numRows * len];
        char[] array = s.toCharArray();
        boolean changeColumn = false;
        int zCount = 0; // the count of ZigZag
        int tmpColumn = 1;
        boolean direction = true; // true:down false:up
        
        while (start < len) {
        	int pos;
        	if (!changeColumn) {
        		pos = (tmpColumn - 1) * len + zCount * (numRows -1);
        	} else {
        		pos = (tmpColumn - 1) * len + zCount * (numRows -1) + (numRows - tmpColumn);
        	}
        	newArray[pos] = array[start++];
        	
        	if (tmpColumn == numRows) {
        		direction = false;
        		changeColumn = true;
        	} else if (tmpColumn == 1) {
        		direction = true;
        		changeColumn = false;
        		zCount++;
        	}
        	if (direction) {
        		tmpColumn++;
        	} else {
        		tmpColumn--;
        	}
        }
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < newArray.length; i++) {
        	if (newArray[i] != '\0') {
        		result.append(newArray[i]);
        	}
        }
        return result.toString();
    }
    
    public String convert1(String s, int numRows) {
        if (numRows == 1) {
        	return s;
        }
        List<StringBuffer> list = new ArrayList<>();
        for (int i = 0; i < (Math.min(numRows, s.length())); i++) {
        	list.add(new StringBuffer());
        }
        boolean direction = false;
        int tmpRow = 0;
        for (int i = 0; i < s.length(); i++) {
        	list.get(tmpRow).append(s.charAt(i));
        	if ((tmpRow == numRows -1) || (tmpRow == 0)) {
        		direction = !direction;
        	}
        	tmpRow += direction == true ? 1 : -1;
        }
        StringBuffer result = new StringBuffer();
        for (StringBuffer row : list) {
        	result.append(row);
        }
        return result.toString();
    }

	public static void main(String[] args) {
		Code0006_ZigZagConversion obj = new Code0006_ZigZagConversion();
		System.out.println(obj.convert("AB", 2));
	}

}
