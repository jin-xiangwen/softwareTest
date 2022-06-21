package com.tongji.softwaretest.shikebackend.integrationTest.orderManageModule;

import com.tongji.softwaretest.shikebackend.entity.OrderGoods;

import java.util.ArrayList;
import java.util.List;

public class getOrderGoodsStub {

    private Integer orderGoodsId;
    private String goodsName;
    private Integer goodsCount;
    private String goodsPrice;
    private String goodsImage;
    private String orderId;

    public void getOrderGoodsStub(String orderId) {
        this.goodsName = "nameTest";
        this.goodsPrice = "20";
        this.orderId = orderId;
    }

    protected List<OrderGoods> getOrderGoods(String orderId) {
        this.getOrderGoodsStub(orderId);
        List<OrderGoods> orderGoodsList = new ArrayList<OrderGoods>();
        OrderGoods orderGoods = new OrderGoods();
        orderGoods.setGoodsName(this.goodsName);
        orderGoods.setGoodsPrice(this.goodsPrice);
        orderGoods.setOrderId(this.orderId);
        orderGoodsList.add(orderGoods);
        return orderGoodsList;
    }
}
