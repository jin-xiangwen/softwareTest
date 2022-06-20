package com.tongji.softwaretest.shikebackend.serviceTest;

import com.tongji.softwaretest.shikebackend.ShikeBackendApplication;
import com.tongji.softwaretest.shikebackend.entity.User;
import com.tongji.softwaretest.shikebackend.servicelmpl.UserServiceImpl;
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
public class userServiceTest {
    @Autowired
    UserServiceImpl userService;

    // 测 试 deleteUser 功 能
    /* 被测特性：
     * 1. 输入userId不存在时，delete失败
     * 2. 输入userId为空时，delete失败
     * 3. 输入userId存在时，delete成功，用户被删除
     */
    /* 测试方法：
     * userId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为userId存在和不存在情况
     */
    //失败：userId为空
    @Test(expected = NullPointerException.class)
    public void deleteUserTest01() {
        Integer userId = null;
        boolean res = userService.deleteUser(userId);
        assertEquals(false,res);
    }
    //失败：userId不存在
    @Test
    public void deleteUserTest02() {
        Integer userId = 0;
        boolean res = userService.deleteUser(userId);
        assertEquals(false,res);
    }
    //成功：userId存在
    @Test
    public void deleteUserTest03() {
        Integer userId = 1111;
        boolean res = userService.deleteUser(userId);
        assertEquals(true,res);
    }

    // 测 试 addUser 功 能
    /* 被测特性：
     * 1. 输入userId为空时，add失败
     * 2. 输入userId存在时，add失败
     * 3. 输入userName为空时，add失败
     * 4. 输入参数合法时，add成功
     */
    /* 测试方法：
     * 1. userId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为userId存在和不存在情况
     * 2. userName的等价类划分考虑空和非空情况。
     */
    //失败：userId为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addUserTest01() {
        User user = new User();
        user.setUserId(null);
        user.setUserName("nameTest");
        user.setUserPassword("pwdTest");
        user.setUserImage("imageTest");
        user.setUserTel("telTest");
        boolean res = userService.addUser(user);
        assertEquals(false,res);
    }
    //失败：userId存在
    @Test(expected = DuplicateKeyException.class)
    public void addUserTest02() {
        User user = new User();
        user.setUserId(1111);
        user.setUserName("nameTest");
        user.setUserPassword("pwdTest");
        user.setUserImage("imageTest");
        user.setUserTel("telTest");
        boolean res = userService.addUser(user);
        assertEquals(false,res);
    }
    //失败：userName为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addUserTest03() {
        User user = new User();
        user.setUserId(111);
        user.setUserName(null);
        user.setUserPassword("pwdTest");
        user.setUserImage("imageTest");
        user.setUserTel("telTest");
        boolean res = userService.addUser(user);
        assertEquals(false,res);
    }
    //成功：参数合法
    @Test
    public void addUserTest04() {
        User user = new User();
        user.setUserId(2222);
        user.setUserName("nameTest");
        user.setUserPassword("pwdTest");
        user.setUserImage("imageTest");
        user.setUserTel("telTest");
        boolean res = userService.addUser(user);
        assertEquals(true,res);
    }

    // 测 试 modifyUser 功 能
    /* 被测特性：
     * 1. 输入userId为空时，modify失败
     * 2. 输入userName为空时，modify失败
     * 3. 输入userId不存在时，modify失败
     * 4. 输入参数合法时，modify成功
     */
    /* 测试方法：
     * 1. userId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为userId存在和不存在情况
     * 2. userName的等价类划分考虑空和非空情况。
     */
    //失败：userId为空
    @Test
    public void modifyUserTest01() {
        User user = new User();
        user.setUserId(null);
        user.setUserName("nameTest");
        user.setUserPassword("pwdTest");
        user.setUserImage("imageTest");
        user.setUserTel("telTest");
        boolean res = userService.modifyUser(user);
        assertEquals(false,res);
    }
    //失败：userName为空
    @Test(expected = DataIntegrityViolationException.class)
    public void modifyUserTest02() {
        User user = new User();
        user.setUserId(1111);
        user.setUserName(null);
        user.setUserPassword("pwdTest");
        user.setUserImage("imageTest");
        user.setUserTel("telTest");
        boolean res = userService.modifyUser(user);
        assertEquals(false,res);
    }
    //失败：userId不存在
    @Test
    public void modifyUserTest03() {
        User user = new User();
        user.setUserId(0);
        user.setUserName("nameTest");
        user.setUserPassword("pwdTest");
        user.setUserImage("imageTest");
        user.setUserTel("telTest");
        boolean res = userService.modifyUser(user);
        assertEquals(false,res);
    }
    //成功：参数合法
    @Test
    public void modifyUserTest04() {
        User user = new User();
        user.setUserId(1111);
        user.setUserName("nameTest");
        user.setUserPassword("pwdTest");
        user.setUserImage("imageTest");
        user.setUserTel("telTest");
        boolean res = userService.modifyUser(user);
        assertEquals(true,res);
    }
}
