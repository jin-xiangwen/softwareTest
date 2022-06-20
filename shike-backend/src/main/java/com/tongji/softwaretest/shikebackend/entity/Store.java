package com.tongji.softwaretest.shikebackend.entity;

import lombok.Data;

@Data
public class Store {

    private Integer storeId;
    private String storeName;
    private Integer salesAmount;
    private Float storeGrade;
    private Integer sendingPrice;
    private Float deliveryCost;
    private Integer storeDistance;
    private String storeActivityTip1;
    private String storeActivityTip2;
    private String storeImage;
    private String briefIntroduction;
    private String storeNotice;
    private String storeTel;
    private String storeAddress;
    private String sendStartTime;
    private String sentEndTime;
    private String storeQualification;
}
