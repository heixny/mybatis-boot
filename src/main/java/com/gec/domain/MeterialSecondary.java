package com.gec.domain;

import lombok.Data;


public class MeterialSecondary {

    private String id;
    private String secondaryNo;
    private String secondaryName;
    private String typeDesc;
    private String ruleNo;
    private String inputerId;
    private String userName;
    private String createDate;

    @Override
    public String toString() {
        return "MeterialSecondary{" +
                "id='" + id + '\'' +
                ", secondaryNo='" + secondaryNo + '\'' +
                ", secondaryName='" + secondaryName + '\'' +
                ", typeDesc='" + typeDesc + '\'' +
                ", ruleNo='" + ruleNo + '\'' +
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
