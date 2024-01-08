package com.gec.domain;

public class ProcConfig {
    private Integer id;
    private Integer step;
    private String taskName;
    private String nodeType;
    private String deptId;
    private String roleId;
    private String procName;
    private String note;
    public OrderTask toOrderTask(
            String assigneeId, String orderNo ) {
        OrderTask task = new OrderTask();
        task.setAssigneeId( assigneeId );
        task.setInwareOrderNo( orderNo );
        task.setStep( this.step );
        task.setNodeType( this.nodeType );
        task.setAssigneeId( assigneeId );
        if( nodeType.equals("start") ){
            task.setStatus("已完成");
            task.setCommitTime( "2022-11-19" );
        }
        return task;
    }
    @Override
    public String toString() {
        return "ProcConfig{" +
                "id=" + id +
                ", step=" + step +
                ", taskName='" + taskName + '\'' +
                ", nodeType='" + nodeType + '\'' +
                ", deptId='" + deptId + '\'' +
                ", roleId='" + roleId + '\'' +
                ", procName='" + procName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getProcName() {
        return procName;
    }

    public void setProcName(String procName) {
        this.procName = procName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
