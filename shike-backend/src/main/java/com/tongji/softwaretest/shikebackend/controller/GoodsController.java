package com.tongji.softwaretest.shikebackend.controller;

import com.tongji.softwaretest.shikebackend.entity.Goods;
import com.tongji.softwaretest.shikebackend.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/getgoodsbystoreid")
    private Map<String,Object> getGoodsByStoreId(Integer storeId){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<Goods> list = goodsService.getGoodsList(storeId);
        modelMap.put("data", list);
        return modelMap;
    }
}
