package com.gec.domain;

public class InWareOrder {
    private String id;
    private String orderNo;
    private String serviceType;
    private String receiverId;
    private String inputerId;
    private String userName;
    private String sourceType;
    private String sourceNo;
    private String requireTime;
    private String InwareTime;
    private Integer step;
    private String status;

    private String meterialNo;
    private String meterialName;
    private String note;
    private String count;
    @Override
    public String toString() {
        return "InWareOrder{" +
                "id='" + id + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", receiverId='" + receiverId + '\'' +
                ", inputerId='" + inputerId + '\'' +
                ", sourceType='" + sourceType + '\'' +
                ", sourceNo='" + sourceNo + '\'' +
                ", requireTime='" + requireTime + '\'' +
                ", InwareTime='" + InwareTime + '\'' +
                ", step='" + step + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMeterialNo() {
        return meterialNo;
    }

    public void setMeterialNo(String meterialNo) {
        this.meterialNo = meterialNo;
    }

    public String getMeterialName() {
        return meterialName;
    }

    public void setMeterialName(String meterialName) {
        this.meterialName = meterialName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getId() {
        return id;
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

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public String getInputerId() {
        return inputerId;
    }

    public void setInputerId(String inputerId) {
        this.inputerId = inputerId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getSourceNo() {
        return sourceNo;
    }

    public void setSourceNo(String sourceNo) {
        this.sourceNo = sourceNo;
    }

    public String getRequireTime() {
        return requireTime;
    }

    public void setRequireTime(String requireTime) {
        this.requireTime = requireTime;
    }

    public String getInwareTime() {
        return InwareTime;
    }

    public void setInwareTime(String inwareTime) {
        InwareTime = inwareTime;
    }
}
