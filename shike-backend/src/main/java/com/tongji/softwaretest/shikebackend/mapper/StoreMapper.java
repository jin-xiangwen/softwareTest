package com.tongji.softwaretest.shikebackend.mapper;

import com.tongji.softwaretest.shikebackend.entity.Store;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StoreMapper{

    int deleteByPrimaryKey(Integer storeId);
    int insert(Store record);
    Store selectByPrimaryKey(Integer storeId);
    List<Store> selectAll();
    int updateByPrimaryKey(Store record);
}
