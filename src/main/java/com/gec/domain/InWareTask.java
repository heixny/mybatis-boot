package com.gec.domain;

import lombok.Data;

@Data
public class InWareTask {
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
    private String status="进行中";

    private String meterialNo;
    private String meterialName;
    private String note;
    private String count;

    public InWareTask() {
    }

    public InWareTask(String id, String orderNo, String serviceType, String receiverId, String inputerId, String userName, String sourceType, String sourceNo, String requireTime, String inwareTime, Integer step, String status, String meterialNo, String meterialName, String note, String count) {
        this.id = id;
        this.orderNo = orderNo;
        this.serviceType = serviceType;
        this.receiverId = receiverId;
        this.inputerId = inputerId;
        this.userName = userName;
        this.sourceType = sourceType;
        this.sourceNo = sourceNo;
        this.requireTime = requireTime;
        InwareTime = inwareTime;
        this.step = step;
        this.status = status;
        this.meterialNo = meterialNo;
        this.meterialName = meterialName;
        this.note = note;
        this.count = count;
    }

    public InWareTask(InWareOrder order){
        this.orderNo=order.getOrderNo();
        this.serviceType=order.getServiceType();
        this.inputerId=order.getInputerId();
        this.sourceType=order.getSourceType();
        this.sourceNo=order.getSourceNo();

    }

}
