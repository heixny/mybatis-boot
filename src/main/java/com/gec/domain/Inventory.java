package com.gec.domain;

import lombok.Data;

@Data
public class Inventory {
    private String id;
    private String inventoryNo;
    private String meterialNo;
    private String inventoryName;
    private String positionNo;
    private String positionName;
    private Integer count;
    private String unit;
    private String note;

}
