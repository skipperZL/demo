package com.zl.demo.javase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.zl.demo.javase.Printer.print;

public class RegexDemo {
	
	private static void test(String reg, String s) {
		 Pattern p = Pattern.compile(reg);
		 Matcher m = p.matcher(s);
		 print(m);
		 while(m.find()) {
			 print(m.group());
		 }
	}
	
	public static void main(String[] args) {
		String s = "aadaaabaaeaaabaaafaab";
		String greedy = "a\\w*b";
		String relucant = "a\\w*?b";
		String possesive = "a\\w*+b";
		test(greedy, s);
		test(relucant, s);
		test(possesive, s);
		 
		 // Pattern.matches() 匹配整个字符串
		 print(Pattern.matches("\\d{2}:\\d{2}:\\d{2}", "12:12:12"));
		 print(Pattern.matches("\\d{2}:\\d{2}:\\d{2}", "12:12:121"));
	}

}
