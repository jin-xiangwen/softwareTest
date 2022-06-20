package com.tongji.softwaretest.shikebackend.entity;

import lombok.Data;

@Data
public class Comment {

    private Integer commentId;
    private Integer storeId;
    private String storeName;
    private String goodsName;
    private String comments;
    private Integer userId;
    private String userName;
    private String commitTime;
    private String userImage;
}
