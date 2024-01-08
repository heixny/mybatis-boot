package com.gec.domain;

import lombok.Data;


public class MeterialGroup {

    private String id;
    private String groupNo;
    private String groupName;
    private String groupDesc;
    private String ruleNo;
    private String note;
    private String inputerId;
    private String userName;
    private String createDate;

    @Override
    public String toString() {
        return "MeterialGroup{" +
                "id='" + id + '\'' +
                ", groupNo='" + groupNo + '\'' +
                ", groupName='" + groupName + '\'' +
                ", groupDesc='" + groupDesc + '\'' +
                ", note='" + note + '\'' +
                ", inputerId='" + inputerId + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(String ruleNo) {
        this.ruleNo = ruleNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getInputerId() {
        return inputerId;
    }

    public void setInputerId(String inputerId) {
        this.inputerId = inputerId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
