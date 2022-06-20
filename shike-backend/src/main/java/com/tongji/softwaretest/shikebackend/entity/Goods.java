package com.tongji.softwaretest.shikebackend.entity;

import lombok.Data;

@Data
public class Goods {

    private Integer goodsId;
    private String goodsCategory;
    private String goodsName;
    private Float goodsPrice;
    private Integer goodsSalesAmount;
    private String goodsImage;
    private Integer tStoreStoreId;
    private Integer tCategoryCategoryId;

}
