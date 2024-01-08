package com.gec.domain;

public class Option {
	
	private String text;
	private String value;
	private String typeNo;
	private String typeName;
	private String secondaryNo;
	private String secondaryName;
	private String groupNo;
	private String groupName;
	public Option(){}
	public Option(String line){
		String[] data = line.split(",");
		this.text = data[0];
		this.value = data[1];
	}

	public String getTypeNo() {
		return typeNo;
	}

	public void setTypeNo(String typeNo) {
		this.typeNo = typeNo;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getSecondaryNo() {
		return secondaryNo;
	}

	public void setSecondaryNo(String secondaryNo) {
		this.secondaryNo = secondaryNo;
	}

	public String getSecondaryName() {
		return secondaryName;
	}

	public void setSecondaryName(String secondaryName) {
		this.secondaryName = secondaryName;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "Option{" +
				"text='" + text + '\'' +
				", value='" + value + '\'' +
				", typeNo='" + typeNo + '\'' +
				", typeName='" + typeName + '\'' +
				", secondaryNo='" + secondaryNo + '\'' +
				", secondaryName='" + secondaryName + '\'' +
				", groupNo='" + groupNo + '\'' +
				", groupName='" + groupName + '\'' +
				'}';
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String val) {
		this.value = val;
	}


}
