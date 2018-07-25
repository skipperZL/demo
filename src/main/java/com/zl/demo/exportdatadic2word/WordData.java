package com.zl.demo.exportdatadic2word;

import java.util.ArrayList;
import java.util.List;

public class WordData {

	private String name;
	
	private List<DBTable> tables = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DBTable> getTables() {
		return tables;
	}

	public void setTables(List<DBTable> tables) {
		this.tables = tables;
	}
	
	public void addTable(DBTable table) {
		tables.add(table);
	}
	

}
