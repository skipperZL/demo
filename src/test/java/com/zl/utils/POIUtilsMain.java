package com.zl.utils;

import java.util.Arrays;
import java.util.List;

public class POIUtilsMain {

	public static void main(String[] args) throws Exception {
		List<List<String>> datas = POIUtils.showExcel("F:/123.xlsx", Arrays.asList(2, 5, 7, 8, 10, 15), 2);
	}
	
}
