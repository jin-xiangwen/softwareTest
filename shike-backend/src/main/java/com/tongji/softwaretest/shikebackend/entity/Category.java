package com.tongji.softwaretest.shikebackend.entity;

import lombok.Data;

import java.util.List;

@Data
public class Category {

    private List<Goods> goodslist;
    private Integer categoryId;
    private String categoryName;
    private Integer tStoreStoreId;
}
