package com.zl.demo.exportdatadic2word;

import java.util.ArrayList;
import java.util.List;

public class DBTable {
	private String tableName;
	private List<String> fields = new ArrayList<String>();
	private List<String> types = new ArrayList<String>();
	private List<String> comments = new ArrayList<String>();
	private List<String> fieldsLen = new ArrayList<String>();
	private List<String> digits = new ArrayList<String>();
	private List<String> defaultValues = new ArrayList<String>();
	private List<String> isNulls = new ArrayList<String>();
	private List<String> pks = new ArrayList<String>();
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public List<String> getFieldsLen() {
		return fieldsLen;
	}

	public void setFieldsLen(List<String> fieldsLen) {
		this.fieldsLen = fieldsLen;
	}

	public List<String> getDigits() {
		return digits;
	}

	public void setDigits(List<String> digits) {
		this.digits = digits;
	}

	public List<String> getDefaultValues() {
		return defaultValues;
	}

	public void setDefaultValues(List<String> defaultValues) {
		this.defaultValues = defaultValues;
	}

	public List<String> getIsNulls() {
		return isNulls;
	}

	public void setIsNulls(List<String> isNulls) {
		this.isNulls = isNulls;
	}

	public List<String> getPks() {
		return pks;
	}

	public void setPks(List<String> pks) {
		this.pks = pks;
	}

}
