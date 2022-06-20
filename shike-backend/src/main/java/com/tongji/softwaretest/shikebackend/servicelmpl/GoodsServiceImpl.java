package com.tongji.softwaretest.shikebackend.servicelmpl;

import com.tongji.softwaretest.shikebackend.entity.Goods;
import com.tongji.softwaretest.shikebackend.mapper.GoodsMapper;
import com.tongji.softwaretest.shikebackend.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getAllGoods() {
        return null;
    }

    @Override
    public List<Goods> getGoodsList(int storeId) {
        return goodsMapper.selectByStoreId(storeId);
    }

    @Override
    public Goods getGoodsById(int goodsId) {
        return null;
    }

    @Override
    public boolean addGoods(Goods goods) {
        return false;
    }

    @Override
    public boolean modifyGoods(Goods goods) {
        return false;
    }

    @Override
    public boolean deleteGoods(int goodsId) {
        return false;
    }
}
