package com.tongji.softwaretest.shikebackend.mapper;

import com.tongji.softwaretest.shikebackend.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AddressMapper {

    int deleteByPrimaryKey(Integer addressId);

    int insert(Address record);

    Address selectByPrimaryKey(Integer addressId);

    List<Address> selectAll(Integer userId);

    int updateByPrimaryKey(Address record);
}
