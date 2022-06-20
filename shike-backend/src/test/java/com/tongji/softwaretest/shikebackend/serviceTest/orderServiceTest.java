package com.tongji.softwaretest.shikebackend.serviceTest;

import com.tongji.softwaretest.shikebackend.ShikeBackendApplication;
import com.tongji.softwaretest.shikebackend.entity.Goods;
import com.tongji.softwaretest.shikebackend.entity.Order;
import com.tongji.softwaretest.shikebackend.entity.OrderGoods;
import com.tongji.softwaretest.shikebackend.mapper.OrderGoodsMapper;
import com.tongji.softwaretest.shikebackend.servicelmpl.OrderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest(classes = ShikeBackendApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class orderServiceTest {
    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    OrderGoodsMapper orderGoodsMapper;

    //orderGoodsStub——为addOrder添加必要的orderGoods
    public List<OrderGoods> orderGoodsStub(String orderId) {
        List<OrderGoods> orderGoodsList = new ArrayList<OrderGoods>();
        OrderGoods orderGoods = new OrderGoods();
        orderGoods.setGoodsName("nameTest");
        orderGoods.setGoodsPrice("20");
        orderGoods.setOrderId(orderId);
        orderGoodsList.add(orderGoods);
        return orderGoodsList;
    }

    // 测 试 deleteOrder 功 能
    /* 被测特性：
     * 1. 输入orderId不存在时，delete失败
     * 2. 输入orderId为空时，delete失败
     * 3. 输入orderId存在时，delete成功，订单被删除
     */
    /* 测试方法：
     * orderId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为orderId存在和不存在情况
     */
    //失败：orderId不存在
    @Test
    public void deleteOrderTest01() {
        String orderId = "";
        boolean res = orderService.deleteOrder(orderId);
        assertEquals(false,res);
    }
    //失败：orderId为空
    @Test
    public void deleteOrderTest02() {
        String orderId = null;
        boolean res = orderService.deleteOrder(orderId);
        assertEquals(false,res);
    }
    //成功：orderId存在
    @Test
    public void deleteOrderTest03() {
        String orderId = "1655261964102";
        boolean res = orderService.deleteOrder(orderId);
        assertEquals(true,res);
    }

    // 测 试 addOrder 功 能
    /* 被测特性：
     * 1. 输入orderId存在时，add失败
     * 2. 输入orderStatus为空时，add失败
     * 3. 输入storeId为空时，add失败
     * 4. 输入storeName为空时，add失败
     * 5. 输入orderTime为空时，add失败
     * 6. 输入address为空时，add失败
     * 7. 输入deliverySide为空时，add失败
     * 8. 输入payWay为空时，add失败
     * 9. 输入deliveryCost为空，add失败
     * 10. 输入preferentialPrice为空，add失败
     * 11. 输入payCost为空，add失败
     * 12. 输入userId为空，add失败
     * 13. 输入commentFlag为空，add失败
     * 14. 输入storeId不存在时，add失败
     * 15. 输入userId不存在时，add失败
     * 16. 输入storeId与storeName不匹配，add失败
     * 17. 输入参数合法时，add成功
     */
    /* 测试方法：
     * 1. orderId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为orderId存在和不存在情况
     * 2. orderStatus的等价类划分考虑空和非空情况。
     * 3. storeId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为storeId存在和不存在情况
     * 4. storeName的等价类划分考虑空和非空情况。
     * 5. orderTime的等价类划分考虑空和非空情况。
     * 6. address的等价类划分考虑空和非空情况。
     * 7. deliverySide的等价类划分考虑空和非空情况。
     * 8. payWay的等价类划分考虑空和非空情况。
     * 9. deliveryCost的等价类划分考虑空和非空情况。
     * 10. preferentialPrice的等价类划分考虑空和非空情况。
     * 11. payCost的等价类划分考虑空和非空情况。
     * 12. userId的等价类划分考虑空和非空情况。
     * 13. commentFlag的等价类划分考虑空和非空情况。
     */
    //失败：orderId存在
    @Test(expected = DuplicateKeyException.class)
    public void addOrderTest01() {
        Order order =new Order();
        order.setOrderId("1655261964102");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.addOrder(order);
        assertEquals(false,res);
    }
    //失败：orderStatus为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addOrderTest02() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(null);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.addOrder(order);
        assertEquals(false,res);
    }
    //失败：storeId为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addOrderTest03() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(null);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.addOrder(order);
        assertEquals(false,res);
    }
    //失败：storeName为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addOrderTest04() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName(null);
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.addOrder(order);
        assertEquals(false,res);
    }
    //失败：orderTime为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addOrderTest05() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime(null);
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.addOrder(order);
        assertEquals(false,res);
    }
    //失败：address为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addOrderTest06() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress(null);
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.addOrder(order);
        assertEquals(false,res);
    }
    //失败：deliverySide为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addOrderTest07() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide(null);
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.addOrder(order);
        assertEquals(false,res);
    }
    //失败：payWay为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addOrderTest08() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay(null);
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.addOrder(order);
        assertEquals(false,res);
    }
    //失败：deliveryCost为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addOrderTest09() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(null);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.addOrder(order);
        assertEquals(false,res);
    }
    //失败：preferentialPrice为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addOrderTest10() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(null);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.addOrder(order);
        assertEquals(false,res);
    }
    //失败：payCost为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addOrderTest11() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(null);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.addOrder(order);
        assertEquals(false,res);
    }
    //失败：userId为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addOrderTest12() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(null);
        order.setCommentFlag(0);
        boolean res = orderService.addOrder(order);
        assertEquals(false,res);
    }
    //失败：commentFlag为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addOrderTest13() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(null);
        boolean res = orderService.addOrder(order);
        assertEquals(false,res);
    }
    //失败：storeId不存在
    @Test(expected = DataIntegrityViolationException.class)
    public void addOrderTest14() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(0);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.addOrder(order);
        assertEquals(false,res);
    }
    //失败：userId不存在
    @Test(expected = DataIntegrityViolationException.class)
    public void addOrderTest15() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(0);
        order.setCommentFlag(0);
        boolean res = orderService.addOrder(order);
        assertEquals(false,res);
    }
    //失败：storeId与storeName不匹配
    @Test(expected = DataIntegrityViolationException.class)
    public void addOrderTest16() {
        Order order =new Order();
        order.setGoods(orderGoodsStub("1111111111"));
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.addOrder(order);
        assertEquals(false,res);
    }
    //成功：参数合法
    @Test
    public void addOrderTest17() {
        Order order =new Order();
        order.setGoods(orderGoodsStub("1111111111"));
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.addOrder(order);
        assertEquals(true,res);
    }

    // 测 试 modifyOrder 功 能
    /* 被测特性：
     * 1. 输入orderId不存在时，modify失败
     * 2. 输入orderStatus为空时，modify失败
     * 3. 输入storeId为空时，modify失败
     * 4. 输入storeName为空时，modify失败
     * 5. 输入orderTime为空时，modify失败
     * 6. 输入address为空时，modify失败
     * 7. 输入deliverySide为空时，modify失败
     * 8. 输入payWay为空时，modify失败
     * 9. 输入deliveryCost为空，modify失败
     * 10. 输入preferentialPrice为空，modify失败
     * 11. 输入payCost为空，modify失败
     * 12. 输入userId为空，modify失败
     * 13. 输入commentFlag为空，modify失败
     * 14. 输入参数合法时，add成功
     */
    /* 测试方法：
     * 1. orderId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为orderId存在和不存在情况
     * 2. orderStatus的等价类划分考虑空和非空情况。
     * 3. storeId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为storeId存在和不存在情况
     * 4. storeName的等价类划分考虑空和非空情况。
     * 5. orderTime的等价类划分考虑空和非空情况。
     * 6. address的等价类划分考虑空和非空情况。
     * 7. deliverySide的等价类划分考虑空和非空情况。
     * 8. payWay的等价类划分考虑空和非空情况。
     * 9. deliveryCost的等价类划分考虑空和非空情况。
     * 10. preferentialPrice的等价类划分考虑空和非空情况。
     * 11. payCost的等价类划分考虑空和非空情况。
     * 12. userId的等价类划分考虑空和非空情况。
     * 13. commentFlag的等价类划分考虑空和非空情况。
     */
    //失败：orderId不存在
    @Test
    public void modifyOrderTest01() {
        Order order =new Order();
        order.setOrderId("0");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.modifyOrder(order);
        assertEquals(false,res);
    }
    //失败：orderStatus为空
    @Test
    public void modifyOrderTest02() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(null);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.modifyOrder(order);
        assertEquals(false,res);
    }
    //失败：storeId为空
    @Test
    public void modifyOrderTest03() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(null);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.modifyOrder(order);
        assertEquals(false,res);
    }
    //失败：storeName为空
    @Test
    public void modifyOrderTest04() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName(null);
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.modifyOrder(order);
        assertEquals(false,res);
    }
    //失败：orderTime为空
    @Test
    public void modifyOrderTest05() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime(null);
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.modifyOrder(order);
        assertEquals(false,res);
    }
    //失败：address为空
    @Test
    public void modifyOrderTest06() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress(null);
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.modifyOrder(order);
        assertEquals(false,res);
    }
    //失败：deliverySide为空
    @Test
    public void modifyOrderTest07() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide(null);
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.modifyOrder(order);
        assertEquals(false,res);
    }
    //失败：payWay为空
    @Test
    public void modifyOrderTest08() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay(null);
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.modifyOrder(order);
        assertEquals(false,res);
    }
    //失败：deliveryCost为空
    @Test
    public void modifyOrderTest09() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(null);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.modifyOrder(order);
        assertEquals(false,res);
    }
    //失败：preferentialPrice为空
    @Test
    public void modifyOrderTest10() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(null);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.modifyOrder(order);
        assertEquals(false,res);
    }
    //失败：payCost为空
    @Test
    public void modifyOrderTest11() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(null);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.modifyOrder(order);
        assertEquals(false,res);
    }
    //失败：userId为空
    @Test
    public void modifyOrderTest12() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(null);
        order.setCommentFlag(0);
        boolean res = orderService.modifyOrder(order);
        assertEquals(false,res);
    }
    //失败：commentFlag为空
    @Test
    public void modifyOrderTest13() {
        Order order =new Order();
        order.setOrderId("1111111111");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(null);
        boolean res = orderService.modifyOrder(order);
        assertEquals(false,res);
    }
    //成功：参数合法
    @Test
    public void modifyOrderTest14() {
        Order order =new Order();
        order.setOrderId("1654867718101");
        order.setOrderStatus(0);
        order.setStoreId(101);
        order.setStoreName("哆吉客");
        order.setOrderTime("2022-06-20 10:03:23");
        order.setAddress("addressTest");
        order.setDeliverySide("sideTest");
        order.setPayWay("wayTest");
        order.setDeliveryCost(0f);
        order.setPreferentialPrice(0f);
        order.setPayCost(0f);
        order.setUserId(1111);
        order.setCommentFlag(0);
        boolean res = orderService.modifyOrder(order);
        assertEquals(true,res);
    }

    // 测 试 updateFlag 功 能
    /* 被测特性：
     * 1. 输入orderId不存在时，update失败
     * 2. 输入orderId为空时，update失败
     * 3. 输入orderId存在时，update成功，订单状态被修改
     */
    /* 测试方法：
     * orderId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为orderId存在和不存在情况
     */
    //失败：orderId不存在
    @Test
    public void updateFlagTest01() {
        String orderId = "0";
        boolean res = orderService.updateFlag(orderId);
        assertEquals(false,res);
    }
    //失败：orderId为空
    @Test
    public void updateFlagTest02() {
        String orderId = null;
        boolean res = orderService.updateFlag(orderId);
        assertEquals(false,res);
    }
    //成功：orderId存在
    @Test
    public void updateFlagTest03() {
        String orderId = "1655261964102";
        boolean res = orderService.updateFlag(orderId);
        assertEquals(true,res);
    }
}
