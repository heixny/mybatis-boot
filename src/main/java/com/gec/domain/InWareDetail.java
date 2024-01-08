package com.gec.domain;

public class InWareDetail {
    private String id;
    private String orderNo;
    private String meterialNo;
    private String meterialName;
    private String count;
    private String note;
    private String unit;

    private String InwareTime;
    private String inputerId;
    private String userName;

    public InWareDetail() {
    }
    public InWareDetail(String orderNo,String meterialNo,String count) {
        this.orderNo=orderNo;
        this.meterialNo=meterialNo;
        this.count=count;
    }
    @Override
    public String toString() {
        return "InWareDetail{" +
                "id='" + id + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", meterialNo='" + meterialNo + '\'' +
                ", count='" + count + '\'' +
                ", note='" + note + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }

    public String getInwareTime() {
        return InwareTime;
    }

    public void setInwareTime(String inwareTime) {
        InwareTime = inwareTime;
    }

    public String getInputerId() {
        return inputerId;
    }

    public void setInputerId(String inputerId) {
        this.inputerId = inputerId;
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

    public String getMeterialName() {
        return meterialName;
    }

    public void setMeterialName(String meterialName) {
        this.meterialName = meterialName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getMeterialNo() {
        return meterialNo;
    }

    public void setMeterialNo(String meterialNo) {
        this.meterialNo = meterialNo;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
