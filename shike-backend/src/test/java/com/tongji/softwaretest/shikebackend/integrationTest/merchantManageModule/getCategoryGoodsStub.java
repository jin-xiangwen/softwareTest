package com.tongji.softwaretest.shikebackend.integrationTest.merchantManageModule;

import com.tongji.softwaretest.shikebackend.entity.Goods;

import java.util.ArrayList;
import java.util.List;

public class getCategoryGoodsStub {

    private Integer goodsId;
    private String goodsCategory;
    private String goodsName;
    private Float goodsPrice;
    private Integer goodsSalesAmount;
    private String goodsImage;
    private Integer tStoreStoreId;
    private Integer tCategoryCategoryId;

    public void getCategoryGoodsStub(Integer categoryId,String categoryName) {
        this.goodsCategory = categoryName;
        this.goodsName = "nameTest";
        this.goodsPrice = 0f;
        this.tStoreStoreId = 101;
        this.tCategoryCategoryId = categoryId;
    }

    protected List<Goods> getCategoryGoods(Integer categoryId,String categoryName) {
        this.getCategoryGoodsStub(categoryId,categoryName);
        List<Goods> categoryGoodsList = new ArrayList<Goods>();
        Goods categoryGoods = new Goods();
        categoryGoods.setGoodsCategory(this.goodsCategory);
        categoryGoods.setGoodsName(this.goodsName);
        categoryGoods.setGoodsPrice(this.goodsPrice);
        categoryGoods.setTStoreStoreId(this.tStoreStoreId);
        categoryGoods.setTCategoryCategoryId(this.tCategoryCategoryId);
        categoryGoodsList.add(categoryGoods);
        return categoryGoodsList;
    }
}
