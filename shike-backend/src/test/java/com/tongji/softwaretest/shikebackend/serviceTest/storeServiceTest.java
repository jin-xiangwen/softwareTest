package com.tongji.softwaretest.shikebackend.serviceTest;

import com.tongji.softwaretest.shikebackend.ShikeBackendApplication;
import com.tongji.softwaretest.shikebackend.entity.Store;
import com.tongji.softwaretest.shikebackend.servicelmpl.StoreServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@SpringBootTest(classes = ShikeBackendApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class storeServiceTest {
    @Autowired
    StoreServiceImpl storeService;

    // 测 试 deleteStore 功 能
    /* 被测特性：
     * 1. 输入storeId不存在时，delete失败
     * 2. 输入storeId为空时，delete失败
     * 3. 输入storeId存在时，delete成功，商店被删除
     */
    /* 测试方法：
     * storeId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为storeId存在和不存在情况
     */
    //失败：storeId不存在
    @Test(expected = RuntimeException.class)
    public void deleteStoreTest01() {
        Integer storeId = 0;
        boolean res = storeService.deleteStore(storeId);
        assertEquals(false,res);
    }
    //失败：storeId为空
    @Test(expected = NullPointerException.class)
    public void deleteStoreTest02() {
        Integer storeId = null;
        boolean res = storeService.deleteStore(storeId);
        assertEquals(false,res);
    }
    //成功：storeId存在
    @Test
    public void deleteStoreTest03() {
        Integer storeId = 111;
        boolean res = storeService.deleteStore(storeId);
        assertEquals(true,res);
    }

    // 测 试 addStore 功 能
    /* 被测特性：
     * 1. 输入storeId存在时，add失败
     * 2. 输入storeName为空时，add失败
     * 3. 输入salesAmount为空时，add失败
     * 4. 输入storeGrade为空时，add失败
     * 5. 输入sendingPrice为空时，add失败
     * 6. 输入deliveryCost为空时，add失败
     * 7. 输入storeDistance为空时，add失败
     * 8. 输入参数合法时，add成功
     */
    /* 测试方法：
     * 1. storeId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为storeId存在和不存在情况
     * 2. storeName的等价类划分考虑空和非空情况。
     * 3. salesAmount的等价类划分考虑空和非空情况。
     * 4. storeGrade的等价类划分考虑空和非空情况。
     * 5. sendingPrice的等价类划分考虑空和非空情况。
     * 6. deliveryCost的等价类划分考虑空和非空情况。
     * 7. storeDistance的等价类划分考虑空和非空情况。
     */
    //失败：storeId存在
    @Test(expected = RuntimeException.class)
    public void addStoreTest01() {
        Store store = new Store();
        store.setStoreId(111);
        store.setStoreName("nameTest");
        store.setSalesAmount(0);
        store.setStoreGrade(0f);
        store.setSendingPrice(0);
        store.setDeliveryCost(0f);
        store.setStoreDistance(0);
        boolean res = storeService.addStore(store);
        assertEquals(false,res);
    }
    //失败：storeName为空
    @Test(expected = RuntimeException.class)
    public void addStoreTest02() {
        Store store = new Store();
        store.setStoreId(222);
        store.setStoreName(null);
        store.setSalesAmount(0);
        store.setStoreGrade(0f);
        store.setSendingPrice(0);
        store.setDeliveryCost(0f);
        store.setStoreDistance(0);
        boolean res = storeService.addStore(store);
        assertEquals(false,res);
    }
    //失败：salesAmount为空
    @Test(expected = RuntimeException.class)
    public void addStoreTest03() {
        Store store = new Store();
        store.setStoreId(222);
        store.setStoreName("nameTest");
        store.setSalesAmount(null);
        store.setStoreGrade(0f);
        store.setSendingPrice(0);
        store.setDeliveryCost(0f);
        store.setStoreDistance(0);
        boolean res = storeService.addStore(store);
        assertEquals(false,res);
    }
    //失败：storeGrade为空
    @Test(expected = RuntimeException.class)
    public void addStoreTest04() {
        Store store = new Store();
        store.setStoreId(222);
        store.setStoreName("nameTest");
        store.setSalesAmount(0);
        store.setStoreGrade(null);
        store.setSendingPrice(0);
        store.setDeliveryCost(0f);
        store.setStoreDistance(0);
        boolean res = storeService.addStore(store);
        assertEquals(false,res);
    }
    //失败：sendingPrice为空
    @Test(expected = RuntimeException.class)
    public void addStoreTest05() {
        Store store = new Store();
        store.setStoreId(222);
        store.setStoreName("nameTest");
        store.setSalesAmount(0);
        store.setStoreGrade(0f);
        store.setSendingPrice(null);
        store.setDeliveryCost(0f);
        store.setStoreDistance(0);
        boolean res = storeService.addStore(store);
        assertEquals(false,res);
    }
    //失败：deliveryCost为空
    @Test(expected = RuntimeException.class)
    public void addStoreTest06() {
        Store store = new Store();
        store.setStoreId(222);
        store.setStoreName("nameTest");
        store.setSalesAmount(0);
        store.setStoreGrade(0f);
        store.setSendingPrice(0);
        store.setDeliveryCost(null);
        store.setStoreDistance(0);
        boolean res = storeService.addStore(store);
        assertEquals(false,res);
    }
    //失败：storeDistance为空
    @Test(expected = RuntimeException.class)
    public void addStoreTest07() {
        Store store = new Store();
        store.setStoreId(null);
        store.setStoreName("nameTest");
        store.setSalesAmount(0);
        store.setStoreGrade(0f);
        store.setSendingPrice(0);
        store.setDeliveryCost(0f);
        store.setStoreDistance(null);
        boolean res = storeService.addStore(store);
        assertEquals(false,res);
    }
    //成功：参数合法
    @Test
    public void addStoreTest08() {
        Store store = new Store();
        store.setStoreId(222);
        store.setStoreName("nameTest");
        store.setSalesAmount(0);
        store.setStoreGrade(0f);
        store.setSendingPrice(0);
        store.setDeliveryCost(0f);
        store.setStoreDistance(0);
        boolean res = storeService.addStore(store);
        assertEquals(true,res);
    }

    // 测 试 modifyStore 功 能
    /* 被测特性：
     * 1. 输入userId不存在时，modify失败
     * 2. 输入userId为空时，modify失败
     * 3. 输入storeName为空时，modify失败
     * 4. 输入salesAmount为空时，modify失败
     * 5. 输入storeGrade为空时，modify失败
     * 6. 输入sendingPrice为空时，modify失败
     * 7. 输入deliveryCost为空时，modify失败
     * 8. 输入storeDistance为空时，modify失败
     * 9. 输入参数合法时，add成功
     */
    /* 测试方法：
     * 1. storeId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为storeId存在和不存在情况
     * 2. storeName的等价类划分考虑空和非空情况。
     * 3. salesAmount的等价类划分考虑空和非空情况。
     * 4. storeGrade的等价类划分考虑空和非空情况。
     * 5. sendingPrice的等价类划分考虑空和非空情况。
     * 6. deliveryCost的等价类划分考虑空和非空情况。
     * 7. storeDistance的等价类划分考虑空和非空情况。
     */
    //失败：storeId不存在
    @Test(expected = RuntimeException.class)
    public void modifyStoreTest01() {
        Store store = new Store();
        store.setStoreId(222);
        store.setStoreName("nameTest");
        store.setSalesAmount(0);
        store.setStoreGrade(0f);
        store.setSendingPrice(0);
        store.setDeliveryCost(0f);
        store.setStoreDistance(0);
        boolean res = storeService.modifyStore(store);
        assertEquals(false,res);
    }
    //失败：storeId为空
    @Test(expected = RuntimeException.class)
    public void modifyStoreTest02() {
        Store store = new Store();
        store.setStoreId(null);
        store.setStoreName("nameTest");
        store.setSalesAmount(0);
        store.setStoreGrade(0f);
        store.setSendingPrice(0);
        store.setDeliveryCost(0f);
        store.setStoreDistance(0);
        boolean res = storeService.modifyStore(store);
        assertEquals(false,res);
    }
    //失败：storeName为空
    @Test(expected = RuntimeException.class)
    public void modifyStoreTest03() {
        Store store = new Store();
        store.setStoreId(111);
        store.setStoreName(null);
        store.setSalesAmount(0);
        store.setStoreGrade(0f);
        store.setSendingPrice(0);
        store.setDeliveryCost(0f);
        store.setStoreDistance(0);
        boolean res = storeService.modifyStore(store);
        assertEquals(false,res);
    }
    //失败：salesAmount为空
    @Test(expected = RuntimeException.class)
    public void modifyStoreTest04() {
        Store store = new Store();
        store.setStoreId(111);
        store.setStoreName("nameTest");
        store.setSalesAmount(null);
        store.setStoreGrade(0f);
        store.setSendingPrice(0);
        store.setDeliveryCost(0f);
        store.setStoreDistance(0);
        boolean res = storeService.modifyStore(store);
        assertEquals(false,res);
    }
    //失败：storeGrade为空
    @Test(expected = RuntimeException.class)
    public void modifyStoreTest05() {
        Store store = new Store();
        store.setStoreId(111);
        store.setStoreName("nameTest");
        store.setSalesAmount(0);
        store.setStoreGrade(null);
        store.setSendingPrice(0);
        store.setDeliveryCost(0f);
        store.setStoreDistance(0);
        boolean res = storeService.modifyStore(store);
        assertEquals(false,res);
    }
    //失败：sendingPrice为空
    @Test(expected = RuntimeException.class)
    public void modifyStoreTest06() {
        Store store = new Store();
        store.setStoreId(111);
        store.setStoreName("nameTest");
        store.setSalesAmount(0);
        store.setStoreGrade(0f);
        store.setSendingPrice(null);
        store.setDeliveryCost(0f);
        store.setStoreDistance(0);
        boolean res = storeService.modifyStore(store);
        assertEquals(false,res);
    }
    //失败：deliveryCost为空
    @Test(expected = RuntimeException.class)
    public void modifyStoreTest07() {
        Store store = new Store();
        store.setStoreId(111);
        store.setStoreName("nameTest");
        store.setSalesAmount(0);
        store.setStoreGrade(0f);
        store.setSendingPrice(0);
        store.setDeliveryCost(null);
        store.setStoreDistance(0);
        boolean res = storeService.modifyStore(store);
        assertEquals(false,res);
    }
    //失败：storeDistance为空
    @Test(expected = RuntimeException.class)
    public void modifyStoreTest08() {
        Store store = new Store();
        store.setStoreId(111);
        store.setStoreName("nameTest");
        store.setSalesAmount(0);
        store.setStoreGrade(0f);
        store.setSendingPrice(0);
        store.setDeliveryCost(0f);
        store.setStoreDistance(null);
        boolean res = storeService.modifyStore(store);
        assertEquals(false,res);
    }
    //成功：参数合法
    @Test
    public void modifyStoreTest09() {
        Store store = new Store();
        store.setStoreId(111);
        store.setStoreName("nameTest");
        store.setSalesAmount(0);
        store.setStoreGrade(0f);
        store.setSendingPrice(0);
        store.setDeliveryCost(0f);
        store.setStoreDistance(0);
        boolean res = storeService.modifyStore(store);
        assertEquals(true,res);
    }
}
