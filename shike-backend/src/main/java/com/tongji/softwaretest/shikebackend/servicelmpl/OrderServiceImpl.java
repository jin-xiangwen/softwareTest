package com.tongji.softwaretest.shikebackend.servicelmpl;

import com.tongji.softwaretest.shikebackend.entity.Order;
import com.tongji.softwaretest.shikebackend.entity.OrderGoods;
import com.tongji.softwaretest.shikebackend.mapper.OrderGoodsMapper;
import com.tongji.softwaretest.shikebackend.mapper.OrderMapper;
import com.tongji.softwaretest.shikebackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    @Override
    public List<Order> getOrderList(int userId) {
        return orderMapper.selectAll(userId);
    }

    @Override
    public Order getOrderById(String orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public boolean addOrder(Order order) {
        List<OrderGoods> list = order.getGoods();
        int effectedNum = orderMapper.insert(order) + orderGoodsMapper.insertRecordBatch(list);
        if (effectedNum > 1){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean modifyOrder(Order order) {
        int effectedNum = orderMapper.updateByPrimaryKey(order);
        if (effectedNum > 0){
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean deleteOrder(String orderId) {
        int eNum = orderGoodsMapper.deleteByOrderId(orderId);
        int effectedNum = orderMapper.deleteByPrimaryKey(orderId);
        if (effectedNum + eNum > 1){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateFlag(String orderId) {
        int effectedNum = orderMapper.updateFlag(orderId);
        if (effectedNum > 0){
            return true;
        } else {
            return false;
        }
    }
}
