package com.gec.domain;

import lombok.Data;


public class MeterialType {

    private String id;
    private String typeNo;
    private String typeName;
    private String typeDesc;
    private String ruleNo;
    private String inputerId;
    private String userName;
    private String createDate;

    @Override
    public String toString() {
        return "MeterialType{" +
                "id='" + id + '\'' +
                ", typeNo='" + typeNo + '\'' +
                ", typeName='" + typeName + '\'' +
                ", typeDesc='" + typeDesc + '\'' +
                ", ruleNo='" + ruleNo + '\'' +
                ", inputerId='" + inputerId + '\'' +
                ", userName='" + userName + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public String getRuleNo() {
        return ruleNo;
    }

    public void setRuleNo(String ruleNo) {
        this.ruleNo = ruleNo;
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
