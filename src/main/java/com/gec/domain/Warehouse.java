package com.gec.domain;

public class Warehouse {
    private String id;
    private String wareNo;
    private String wareName;
    private String typeNo;
    private String wareDesc;
    private String inputerId;
    private String createDate;
    private String userName;
    private String typeName;

    @Override
    public String toString() {
        return "Warehouse{" +
                "id='" + id + '\'' +
                ", wareNo='" + wareNo + '\'' +
                ", wareName='" + wareName + '\'' +
                ", typeNo='" + typeNo + '\'' +
                ", wareDesc='" + wareDesc + '\'' +
                ", inputerId='" + inputerId + '\'' +
                ", createDate='" + createDate + '\'' +
                ", userName='" + userName + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWareNo() {
        return wareNo;
    }

    public void setWareNo(String wareNo) {
        this.wareNo = wareNo;
    }

    public String getWareName() {
        return wareName;
    }


    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public String getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(String typeNo) {
        this.typeNo = typeNo;
    }

    public String getWareDesc() {
        return wareDesc;
    }

    public void setWareDesc(String wareDesc) {
        this.wareDesc = wareDesc;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
