package com.tongji.softwaretest.shikebackend.mapper;

import com.tongji.softwaretest.shikebackend.entity.OrderGoods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderGoodsMapper {

    int deleteByPrimaryKey(Integer orderGoodsId);

    int insert(OrderGoods record);

    OrderGoods selectByPrimaryKey(Integer orderGoodsId);

    List<OrderGoods> selectAll();

    int updateByPrimaryKey(OrderGoods record);

    int insertRecordBatch(List<OrderGoods> record);

    int deleteByOrderId(String orderId);

    List<OrderGoods> getGoods(String orderId);
}
