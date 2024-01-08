package com.gec.domain;

public class Meterial {
    private String id;
    private String meterialNo;
    private String meterialName;
    private String typeNo;
    private String typeName;
    private String secondaryNo;
    private String secondaryName;
    private String groupNo;
    private String groupName;
    private String specification;
    private String inputerId;
    private String status;
    private String version;
    private String createDate;

    //关联属性
    private User user;
    private MeterialGroup meterialGroup;
    private MeterialSecondary meterialSecondary;
    private MeterialType meterialType;

    @Override
    public String toString() {
        return "Meterial{" +
                "id='" + id + '\'' +
                ", meterialNo='" + meterialNo + '\'' +
                ", meterialName='" + meterialName + '\'' +
                ", typeNo='" + typeNo + '\'' +
                ", secondaryNo='" + secondaryNo + '\'' +
                ", groupNo='" + groupNo + '\'' +
                ", specification='" + specification + '\'' +
                ", inputerId='" + inputerId + '\'' +
                ", status='" + status + '\'' +
                ", version='" + version + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSecondaryName() {
        return secondaryName;
    }

    public void setSecondaryName(String secondaryName) {
        this.secondaryName = secondaryName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(String typeNo) {
        this.typeNo = typeNo;
    }

    public String getSecondaryNo() {
        return secondaryNo;
    }

    public void setSecondaryNo(String secondaryNo) {
        this.secondaryNo = secondaryNo;
    }

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getInputerId() {
        return inputerId;
    }

    public void setInputerId(String inputerId) {
        this.inputerId = inputerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MeterialGroup getMeterialGroup() {
        return meterialGroup;
    }

    public void setMeterialGroup(MeterialGroup meterialGroup) {
        this.meterialGroup = meterialGroup;
    }

    public MeterialSecondary getMeterialSecondary() {
        return meterialSecondary;
    }

    public void setMeterialSecondary(MeterialSecondary meterialSecondary) {
        this.meterialSecondary = meterialSecondary;
    }

    public MeterialType getMeterialType() {
        return meterialType;
    }

    public void setMeterialType(MeterialType meterialType) {
        this.meterialType = meterialType;
    }
}
