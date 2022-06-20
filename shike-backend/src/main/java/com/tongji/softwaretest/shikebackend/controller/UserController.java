package com.tongji.softwaretest.shikebackend.controller;

import com.tongji.softwaretest.shikebackend.entity.User;
import com.tongji.softwaretest.shikebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getuser")
    private Map<String,Object> getUserById(Integer userId){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        User user = userService.getUserById(userId);
        modelMap.put("user", user);
        return modelMap;
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    private Map<String,Object> addUser(@RequestBody User user){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userService.addUser(user));
        return modelMap;
    }

}
