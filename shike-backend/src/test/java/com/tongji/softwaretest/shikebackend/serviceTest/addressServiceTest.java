package com.tongji.softwaretest.shikebackend.serviceTest;

import com.tongji.softwaretest.shikebackend.ShikeBackendApplication;
import com.tongji.softwaretest.shikebackend.entity.Address;
import com.tongji.softwaretest.shikebackend.servicelmpl.AddressServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@SpringBootTest(classes = ShikeBackendApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class addressServiceTest {
    @Autowired
    AddressServiceImpl addressService;

    // 测 试 deleteAddress 功 能
    /* 被测特性：
     * 1. 输入addressId不存在时，delete失败
     * 2. 输入addressId为空时，delete失败
     * 3. 输入addressId存在时，delete成功，地址被删除
     */
    /* 测试方法：
     * addressId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为addressId存在和不存在情况
     */
    //失败：addressId为空
    @Test(expected = NullPointerException.class)
    public void deleteAddressTest01() {
        Integer addressId = null;
        boolean res = addressService.deleteAddress(addressId);
        assertEquals(false,res);
    }
    //失败：addressId不存在
    @Test
    public void deleteAddressTest02() {
        Integer addressId = 10;
        boolean res = addressService.deleteAddress(addressId);
        assertEquals(false,res);
    }
    //成功：addressId存在
    @Test
    public void deleteAddressTest03() {
        Integer addressId = 109;
        boolean res = addressService.deleteAddress(addressId);
        assertEquals(true,res);
    }

    // 测 试 addAddress 功 能
    /* 被测特性：
     * 1. 输入userId为空时，add失败
     * 2. 输入addressId存在时，add失败
     * 3. 输入userId不存在时，add失败
     * 4. 输入参数合法时，add成功
     */
    /* 测试方法：
     * 1. addressId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为addressId存在和不存在情况
     * 2. userId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为userId存在和不存在情况
     */
    //失败：userId为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addAddressTest01() {
        Address address = new Address();
        address.setAddressId(123);
        address.setUserId(null);
        address.setUserName("nameTest");
        address.setAddress("addressTest");
        address.setUserTel("telTest");
        boolean res = addressService.addAddress(address);
        assertEquals(false,res);
    }
    //失败：userId不存在
    @Test(expected = DataIntegrityViolationException.class)
    public void addAddressTest02() {
        Address address = new Address();
        address.setAddressId(123);
        address.setUserId(0);
        address.setUserName("nameTest");
        address.setAddress("addressTest");
        address.setUserTel("telTest");
        boolean res = addressService.addAddress(address);
        assertEquals(false,res);
    }
    //失败：addressId存在
    @Test(expected = DuplicateKeyException.class)
    public void addAddressTest03() {
        Address address = new Address();
        address.setAddressId(101);
        address.setUserId(1234567);
        address.setUserName("nameTest");
        address.setAddress("addressTest");
        address.setUserTel("telTest");
        boolean res = addressService.addAddress(address);
        assertEquals(false,res);
    }
    //成功：参数合法
    @Test
    public void addAddressTest04() {
        Address address = new Address();
        address.setAddressId(123);
        address.setUserId(1234567);
        address.setUserName("nameTest");
        address.setAddress("addressTest");
        address.setUserTel("telTest");
        boolean res = addressService.addAddress(address);
        assertEquals(true,res);
    }

    // 测 试 modifyAddress 功 能
    /* 被测特性：
     * 1. 输入userId为空时，modify失败
     * 2. 输入addressId为空时，modify失败
     * 3. 输入userId不存在时，modify失败
     * 4. 输入参数合法时，modify成功
     */
    /* 测试方法：
     * 1. addressId的等价类划分考虑空和非空情况。
     * 2. userId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为userId存在和不存在情况
     */
    //失败：userId为空
    @Test
    public void modifyAddressTest01() {
        Address address = new Address();
        address.setAddressId(123);
        address.setUserId(null);
        address.setUserName("nameTest");
        address.setAddress("addressTest");
        address.setUserTel("telTest");
        boolean res = addressService.modifyAddress(address);
        assertEquals(false,res);
    }
    //失败：addressId为空
    @Test
    public void modifyAddressTest02() {
        Address address = new Address();
        address.setAddressId(null);
        address.setUserId(1234567);
        address.setUserName("nameTest");
        address.setAddress("addressTest");
        address.setUserTel("telTest");
        boolean res = addressService.modifyAddress(address);
        assertEquals(false,res);
    }
    //失败：userId不存在
    @Test
    public void modifyAddressTest03() {
        Address address = new Address();
        address.setAddressId(123);
        address.setUserId(0);
        address.setUserName("nameTest");
        address.setAddress("addressTest");
        address.setUserTel("telTest");
        boolean res = addressService.modifyAddress(address);
        assertEquals(false,res);
    }
    //成功：参数合法
    @Test
    public void modifyAddressTest04() {
        Address address = new Address();
        address.setAddressId(109);
        address.setUserId(1234567);
        address.setUserName("nameTest");
        address.setAddress("addressTest");
        address.setUserTel("telTest");
        boolean res = addressService.modifyAddress(address);
        assertEquals(true,res);
    }
}
