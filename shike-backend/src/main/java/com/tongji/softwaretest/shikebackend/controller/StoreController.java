package com.tongji.softwaretest.shikebackend.controller;

import com.tongji.softwaretest.shikebackend.entity.Store;
import com.tongji.softwaretest.shikebackend.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/liststore")
    private Map<String,Object> listStore(){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<Store> list = storeService.getStoreList();
        modelMap.put("storeList", list);
        return modelMap;
    }

    @GetMapping("/getstorebyid")
    private Map<String,Object> getStoreById(Integer storeId){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        Store store = storeService.getStoreById(storeId);
        modelMap.put("store", store);
        return modelMap;
    }

    @PostMapping("/addstore")
    private Map<String,Object> addStore(@RequestBody Store store){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", storeService.addStore(store));
        return modelMap;
    }

    @PostMapping("/modifystore")
    private Map<String,Object> modifyStore(@RequestBody Store store){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", storeService.modifyStore(store));
        return modelMap;
    }

    @GetMapping("/removestore")
    private Map<String,Object> removeStore(Integer storeId){
        Map<String,Object> modelMap = new HashMap<String, Object>();

        modelMap.put("success", storeService.deleteStore(storeId));
        return modelMap;
    }

}
