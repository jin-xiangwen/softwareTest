package com.tongji.softwaretest.shikebackend.controller;

import com.tongji.softwaretest.shikebackend.entity.Address;
import com.tongji.softwaretest.shikebackend.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/getaddress")
    private Map<String,Object> getaddress(Integer addressId){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        Address address = addressService.getAddressById(addressId);
        modelMap.put("data", address);
        return modelMap;
    }

    @GetMapping("/listaddress")
    private Map<String,Object> listAddress(Integer userId){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<Address> list = addressService.getAddressList(userId);
        modelMap.put("data", list);
        return modelMap;
    }

    @PostMapping("/addaddress")
    private Map<String,Object> addAddress(@RequestBody Address address){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", addressService.addAddress(address));
        return modelMap;
    }

    @PostMapping("/modifyaddress")
    private Map<String,Object> modifyAddress(@RequestBody Address address){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", addressService.modifyAddress(address));
        return modelMap;
    }

    @DeleteMapping("/removeaddress")
    private Map<String,Object> removeAddress(Integer addressId){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", addressService.deleteAddress(addressId));
        return modelMap;
    }
}
