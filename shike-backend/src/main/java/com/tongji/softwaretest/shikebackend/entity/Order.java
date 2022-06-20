package com.tongji.softwaretest.shikebackend.entity;

import lombok.Data;

import java.util.List;

@Data
public class Order {

    private List<OrderGoods> goods;
    private Integer commentFlag;
    private String orderId;
    private Integer orderStatus;
    private Integer storeId;
    private String storeName;
    private String orderTime;
    private String arriveTime;
    private String address;
    private String deliverySide;
    private String payWay;
    private Float deliveryCost;
    private Float preferentialPrice;
    private Float payCost;
    private Integer userId;
}
