package com.zl.demo.designmodel.structure.flyweight;

import java.util.HashMap;
import java.util.Map;

import com.zl.demo.designmodel.structure.flyweight.Drive;

public class DriveFactory {
	private Map<String, Drive> map = new HashMap<>();
	
	public Drive getDrive(String type) {
		if (!map.containsKey(type)) {
			map.put(type, new Car(type));
		}
		return map.get(type);
	}
}
