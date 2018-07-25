package com.zl.demo.designmodel.behavior.command;

import java.util.ArrayList;
import java.util.List;

public class Wife {
	String name;
	
	private List<Command> commands = new ArrayList<>();
	
	public Wife(String name) {
		this.name = name;
	}
	
	public void add(Command command) {
		commands.add(command);
	}
	
	public void remove(Command command) {
		commands.remove(command);
	}
	
	public void action() {
		for (Command command : commands) {
			command.excute();
		}
	}
	
	public void actionAndClear() {
		for (Command command : commands) {
			command.excute();
		}
		commands.clear();
	}
}
