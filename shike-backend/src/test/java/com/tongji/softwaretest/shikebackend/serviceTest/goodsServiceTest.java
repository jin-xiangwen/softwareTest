package com.tongji.softwaretest.shikebackend.serviceTest;

import com.tongji.softwaretest.shikebackend.ShikeBackendApplication;
import com.tongji.softwaretest.shikebackend.entity.Goods;
import com.tongji.softwaretest.shikebackend.servicelmpl.GoodsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@SpringBootTest(classes = ShikeBackendApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class goodsServiceTest {
    @Autowired
    GoodsServiceImpl goodsService;

    // 测 试 deleteGoods 功 能
    /* 被测特性：
     * 1. 输入goodsId不存在时，delete失败
     * 2. 输入goodsId为空时，delete失败
     * 3. 输入goodsId存在时，delete成功，商品被删除
     */
    /* 测试方法：
     * goodsId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为goodsId存在和不存在情况
     */
    //失败：goodsId不存在
    @Test
    public void deleteGoodsTest01() {
        Integer goodsId = 0;
        boolean res = goodsService.deleteGoods(goodsId);
        assertEquals(false,res);
    }
    //失败：goodsId为空
    @Test(expected = NullPointerException.class)
    public void deleteGoodsTest02() {
        Integer goodsId = null;
        boolean res = goodsService.deleteGoods(goodsId);
        assertEquals(false,res);
    }
    //成功：goodsId存在
    @Test
    public void deleteGoodsTest03() {
        Integer goodsId = 54;
        boolean res = goodsService.deleteGoods(goodsId);
        assertEquals(true,res);
    }

    // 测 试 addGoods 功 能
    /* 被测特性：
     * 1. 输入goodsId存在时，add失败
     * 2. 输入goodsCategory为空时，add失败
     * 3. 输入goodsName为空时，add失败
     * 4. 输入goodsPrice为空时，add失败
     * 5. 输入tStoreStoreId为空时，add失败
     * 6. 输入tCategoryCategoryId为空时，add失败
     * 7. 输入tStoreStoreId不存在时，add失败
     * 8. 输入tCategoryCategoryId不存在时，add失败
     * 9. 输入goodsCategory和tCategoryCategoryId不匹配时，add失败
     * 10. 输入参数合法时，add成功
     */
    /* 测试方法：
     * 1. goodsId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为goodsId存在和不存在情况
     * 2. goodsCategory的等价类划分考虑空和非空情况。
     * 3. goodsName的等价类划分考虑空和非空情况。
     * 4. goodsPrice的等价类划分考虑空和非空情况。
     * 5. tStoreStoreId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为tStoreStoreId存在和不存在情况
     * 6. tCategoryCategoryId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为tCategoryCategoryId存在和不存在情况
     */
    //失败：goodsId存在
    @Test(expected = DataIntegrityViolationException.class)
    public void addGoodsTest01() {
        Goods goods = new Goods();
        goods.setGoodsId(54);
        goods.setGoodsCategory("categoryTest");
        goods.setGoodsName("nameTest");
        goods.setGoodsPrice(0f);
        goods.setTStoreStoreId(888);
        goods.setTCategoryCategoryId(26);
        boolean res = goodsService.addGoods(goods);
        assertEquals(false,res);
    }
    //失败：goodsCategory为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addGoodsTest02() {
        Goods goods = new Goods();
        goods.setGoodsId(60);
        goods.setGoodsCategory(null);
        goods.setGoodsName("nameTest");
        goods.setGoodsPrice(0f);
        goods.setTStoreStoreId(888);
        goods.setTCategoryCategoryId(26);
        boolean res = goodsService.addGoods(goods);
        assertEquals(false,res);
    }
    //失败：goodsName为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addGoodsTest03() {
        Goods goods = new Goods();
        goods.setGoodsId(60);
        goods.setGoodsCategory("categoryTest");
        goods.setGoodsName(null);
        goods.setGoodsPrice(0f);
        goods.setTStoreStoreId(888);
        goods.setTCategoryCategoryId(26);
        boolean res = goodsService.addGoods(goods);
        assertEquals(false,res);
    }
    //失败：goodsPrice为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addGoodsTest04() {
        Goods goods = new Goods();
        goods.setGoodsId(60);
        goods.setGoodsCategory("categoryTest");
        goods.setGoodsName("nameTest");
        goods.setGoodsPrice(null);
        goods.setTStoreStoreId(888);
        goods.setTCategoryCategoryId(26);
        boolean res = goodsService.addGoods(goods);
        assertEquals(false,res);
    }
    //失败：tStoreStoreId为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addGoodsTest05() {
        Goods goods = new Goods();
        goods.setGoodsId(60);
        goods.setGoodsCategory("categoryTest");
        goods.setGoodsName("nameTest");
        goods.setGoodsPrice(0f);
        goods.setTStoreStoreId(null);
        goods.setTCategoryCategoryId(26);
        boolean res = goodsService.addGoods(goods);
        assertEquals(false,res);
    }
    //失败：tCategoryCategoryId为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addGoodsTest06() {
        Goods goods = new Goods();
        goods.setGoodsId(60);
        goods.setGoodsCategory("categoryTest");
        goods.setGoodsName("nameTest");
        goods.setGoodsPrice(0f);
        goods.setTStoreStoreId(888);
        goods.setTCategoryCategoryId(null);
        boolean res = goodsService.addGoods(goods);
        assertEquals(false,res);
    }
    //失败：tStoreStoreId不存在
    @Test(expected = DataIntegrityViolationException.class)
    public void addGoodsTest07() {
        Goods goods = new Goods();
        goods.setGoodsId(60);
        goods.setGoodsCategory("categoryTest");
        goods.setGoodsName("nameTest");
        goods.setGoodsPrice(0f);
        goods.setTStoreStoreId(0);
        goods.setTCategoryCategoryId(26);
        boolean res = goodsService.addGoods(goods);
        assertEquals(false,res);
    }
    //失败：tCategoryCategoryId不存在
    @Test(expected = DataIntegrityViolationException.class)
    public void addGoodsTest08() {
        Goods goods = new Goods();
        goods.setGoodsId(60);
        goods.setGoodsCategory("categoryTest");
        goods.setGoodsName("nameTest");
        goods.setGoodsPrice(0f);
        goods.setTStoreStoreId(888);
        goods.setTCategoryCategoryId(0);
        boolean res = goodsService.addGoods(goods);
        assertEquals(false,res);
    }
    //失败：goodsCategory和tCategoryCategoryId不匹配
    @Test(expected = DataIntegrityViolationException.class)
    public void addGoodsTest09() {
        Goods goods = new Goods();
        goods.setGoodsId(60);
        goods.setGoodsCategory("categoryTest");
        goods.setGoodsName("nameTest");
        goods.setGoodsPrice(0f);
        goods.setTStoreStoreId(888);
        goods.setTCategoryCategoryId(26);
        boolean res = goodsService.addGoods(goods);
        assertEquals(false,res);
    }
    //成功：参数合法
    @Test
    public void addGoodsTest10() {
        Goods goods = new Goods();
        goods.setGoodsId(60);
        goods.setGoodsCategory("热销");
        goods.setGoodsName("nameTest");
        goods.setGoodsPrice(0f);
        goods.setTStoreStoreId(888);
        goods.setTCategoryCategoryId(26);
        boolean res = goodsService.addGoods(goods);
        assertEquals(true,res);
    }

    // 测 试 modifyGoods 功 能
    /* 被测特性：
     * 1. 输入goodsId不存在时，modify失败
     * 2. 输入goodsCategory为空时，modify失败
     * 3. 输入goodsName为空时，modify失败
     * 4. 输入goodsPrice为空时，modify失败
     * 5. 输入tStoreStoreId为空时，modify失败
     * 6. 输入tCategoryCategoryId为空时，modify失败
     * 7. 输入参数合法时，add成功
     */
    /* 测试方法：
     * 1. goodsId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为goodsId存在和不存在情况
     * 2. goodsCategory的等价类划分考虑空和非空情况。
     * 3. goodsName的等价类划分考虑空和非空情况。
     * 4. goodsPrice的等价类划分考虑空和非空情况。
     * 5. tStoreStoreId的等价类划分考虑空和非空情况。
     * 6. tCategoryCategoryId的等价类划分考虑空和非空情况。
     */
    //失败：goodsId不存在
    @Test
    public void modifyGoodsTest01() {
        Goods goods = new Goods();
        goods.setGoodsId(60);
        goods.setGoodsCategory("热销");
        goods.setGoodsName("nameTest");
        goods.setGoodsPrice(0f);
        goods.setTStoreStoreId(888);
        goods.setTCategoryCategoryId(26);
        boolean res = goodsService.modifyGoods(goods);
        assertEquals(false,res);
    }
    //失败：goodsCategory为空
    @Test(expected = DataIntegrityViolationException.class)
    public void modifyGoodsTest02() {
        Goods goods = new Goods();
        goods.setGoodsId(54);
        goods.setGoodsCategory(null);
        goods.setGoodsName("nameTest");
        goods.setGoodsPrice(0f);
        goods.setTStoreStoreId(888);
        goods.setTCategoryCategoryId(26);
        boolean res = goodsService.modifyGoods(goods);
        assertEquals(false,res);
    }
    //失败：goodsName为空
    @Test(expected = DataIntegrityViolationException.class)
    public void modifyGoodsTest03() {
        Goods goods = new Goods();
        goods.setGoodsId(54);
        goods.setGoodsCategory("热销");
        goods.setGoodsName(null);
        goods.setGoodsPrice(0f);
        goods.setTStoreStoreId(888);
        goods.setTCategoryCategoryId(26);
        boolean res = goodsService.modifyGoods(goods);
        assertEquals(false,res);
    }
    //失败：goodsPrice为空
    @Test(expected = DataIntegrityViolationException.class)
    public void modifyGoodsTest04() {
        Goods goods = new Goods();
        goods.setGoodsId(54);
        goods.setGoodsCategory("热销");
        goods.setGoodsName("nameTest");
        goods.setGoodsPrice(null);
        goods.setTStoreStoreId(888);
        goods.setTCategoryCategoryId(26);
        boolean res = goodsService.modifyGoods(goods);
        assertEquals(false,res);
    }
    //失败：tStoreStoreId为空
    @Test(expected = DataIntegrityViolationException.class)
    public void modifyGoodsTest05() {
        Goods goods = new Goods();
        goods.setGoodsId(54);
        goods.setGoodsCategory("热销");
        goods.setGoodsName("nameTest");
        goods.setGoodsPrice(0f);
        goods.setTStoreStoreId(null);
        goods.setTCategoryCategoryId(26);
        boolean res = goodsService.modifyGoods(goods);
        assertEquals(false,res);
    }
    //失败：tCategoryCategoryId为空
    @Test(expected = DataIntegrityViolationException.class)
    public void modifyGoodsTest06() {
        Goods goods = new Goods();
        goods.setGoodsId(54);
        goods.setGoodsCategory("热销");
        goods.setGoodsName("nameTest");
        goods.setGoodsPrice(0f);
        goods.setTStoreStoreId(888);
        goods.setTCategoryCategoryId(null);
        boolean res = goodsService.modifyGoods(goods);
        assertEquals(false,res);
    }
    //成功：参数合法
    @Test
    public void modifyGoodsTest07() {
        Goods goods = new Goods();
        goods.setGoodsId(54);
        goods.setGoodsCategory("热销");
        goods.setGoodsName("nameTest");
        goods.setGoodsPrice(0f);
        goods.setTStoreStoreId(888);
        goods.setTCategoryCategoryId(26);
        boolean res = goodsService.modifyGoods(goods);
        assertEquals(true,res);
    }
}
