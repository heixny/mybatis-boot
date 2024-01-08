package com.gec.domain;

public class OrderTask {
    private String id;
    private String status="待执行";
    private String nodeType;
    private String inwareOrderNo;
    private String CommitTime;
    private String assigneeId;
    private Integer step;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getInwareOrderNo() {
        return inwareOrderNo;
    }

    public void setInwareOrderNo(String inwareOrderNo) {
        this.inwareOrderNo = inwareOrderNo;
    }

    public String getCommitTime() {
        return CommitTime;
    }

    public void setCommitTime(String commitTime) {
        CommitTime = commitTime;
    }

    public String getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    @Override
    public String toString() {
        return "OrderTask{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", nodeType='" + nodeType + '\'' +
                ", inwareOrderNo='" + inwareOrderNo + '\'' +
                ", CommitTime='" + CommitTime + '\'' +
                ", assigneeId='" + assigneeId + '\'' +
                ", step='" + step + '\'' +
                '}';
    }
}
