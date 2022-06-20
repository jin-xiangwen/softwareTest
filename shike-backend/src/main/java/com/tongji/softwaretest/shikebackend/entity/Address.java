package com.tongji.softwaretest.shikebackend.entity;

import lombok.Data;

@Data
public class Address {

    private Integer addressId;
    private Integer userId;
    private String userName;
    private String address;
    private String userTel;
}
