package com.tongji.softwaretest.shikebackend.entity;

import lombok.Data;

@Data
public class User {

    private Integer userId;
    private String userName;
    private String userPassword;
    private String userImage;
    private String userTel;
}
