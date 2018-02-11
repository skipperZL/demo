package com.zl.demo.javase;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import static com.zl.demo.javase.Printer.print;

import java.util.ArrayList;
import java.util.List;

public class JsonDemo {
	
	/**
	 * Not include some fields.
	 * But it executes the getter method.
	 * 
	 * */
	private void testFilter1() {
        JsonConfig jsonConfig = new JsonConfig();
		List<JsonDemoPepole> list = new ArrayList<>();
		for (int i = 0; i < 3; i ++) {
			list.add(new JsonDemoPepole("TOM", "123", 18, 1));
		}
        jsonConfig.setJsonPropertyFilter(new PropertyFilter() {
            public boolean apply(Object source, String name, Object value)
            {
                return source instanceof JsonDemoPepole &&( name.equals("name"));
            }
        });
        print(JSONArray.fromObject(list, jsonConfig));
	}
	
	/**
	 * Not include some fields.
	 * Does not execute the getter method.
	 * 
	 * */
	private void testFilter2() {
        JsonConfig jsonConfig = new JsonConfig();
		List<JsonDemoPepole> list = new ArrayList<>();
		for (int i = 0; i < 3; i ++) {
			list.add(new JsonDemoPepole("TOM", "123", 18, 1));
		}
        jsonConfig.setExcludes(new String[] { "name","id" });
        print(JSONArray.fromObject(list, jsonConfig));
	}
	
	private void testFilter3() {
        JsonConfig jsonConfig = new JsonConfig();
		List<JsonDemoTeacher> list = new ArrayList<>();
		for (int i = 0; i < 3; i ++) {
			list.add(new JsonDemoTeacher("TOM", "123", 18, 1));
		}
        print(JSONArray.fromObject(list, jsonConfig));
	}
	
	public static void main(String[] args) {
		JsonDemo jd = new JsonDemo();
		//jd.testFilter1();
		jd.testFilter2();
		//jd.testFilter3();
	}
}

