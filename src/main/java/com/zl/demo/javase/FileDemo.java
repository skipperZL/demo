package com.zl.demo.javase;

import static com.zl.demo.javase.Printer.print;

import java.io.File;
import java.io.IOException;
public class FileDemo {
	
	private void test() throws IOException {
		print(this.getClass().getResource(""));
		print(this.getClass().getClassLoader().getResource("").getPath());
		print(System.getProperty("user.dir"));
		File file=new File(".\\src");
		String srcPath=file.getCanonicalPath(); 
		print(srcPath);
		print(getClass().getPackage().getName());
	}
	
	public static void main(String[] args) throws IOException {
		FileDemo fd = new FileDemo();
		fd.test();
	}
}
