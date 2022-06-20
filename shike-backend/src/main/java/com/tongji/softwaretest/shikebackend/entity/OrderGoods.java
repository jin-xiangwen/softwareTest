package com.tongji.softwaretest.shikebackend.entity;

import lombok.Data;

@Data
public class OrderGoods {

    private Integer orderGoodsId;
    private String goodsName;
    private Integer goodsCount;
    private String goodsPrice;
    private String goodsImage;
    private String orderId;
}
