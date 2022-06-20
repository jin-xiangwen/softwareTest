package com.tongji.softwaretest.shikebackend.controller;

import com.tongji.softwaretest.shikebackend.entity.Category;
import com.tongji.softwaretest.shikebackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getgoods")
    private Map<String,Object> getGoods(Integer storeId){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<Category> list = categoryService.getGoodsList(storeId);
        modelMap.put("data", list);
        return modelMap;
    }
}
