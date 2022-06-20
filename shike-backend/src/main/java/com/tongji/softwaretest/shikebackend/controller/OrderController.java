package com.tongji.softwaretest.shikebackend.controller;

import com.tongji.softwaretest.shikebackend.entity.Order;
import com.tongji.softwaretest.shikebackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getorder")
    private Map<String,Object> getOrder(String orderId){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        Order order = orderService.getOrderById(orderId);
        modelMap.put("data", order);
        return modelMap;
    }

    @GetMapping("/listorder")
    private Map<String,Object> listOrder(Integer userId){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<Order> list = orderService.getOrderList(userId);
        modelMap.put("data", list);
        return modelMap;
    }

    @PostMapping("/addorder")
    private Map<String,Object> addOrder(@RequestBody Order order){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", orderService.addOrder(order));
        return modelMap;
    }

    @PostMapping("/modifyorder")
    private Map<String,Object> modifyOrder(@RequestBody Order order){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", orderService.modifyOrder(order));
        return modelMap;
    }

    @PostMapping("/updateorderflag")
    private Map<String,Object> updateOrderFlag(String orderId){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", orderService.updateFlag(orderId));
        return modelMap;
    }

    @DeleteMapping("/removeorder")
    private Map<String,Object> removeOrder(String orderId){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", orderService.deleteOrder(orderId));
        return modelMap;
    }
}
