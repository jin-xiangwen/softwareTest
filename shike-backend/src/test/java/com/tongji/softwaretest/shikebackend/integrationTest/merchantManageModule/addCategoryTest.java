package com.tongji.softwaretest.shikebackend.integrationTest.merchantManageModule;

import com.tongji.softwaretest.shikebackend.ShikeBackendApplication;
import com.tongji.softwaretest.shikebackend.entity.Category;
import com.tongji.softwaretest.shikebackend.servicelmpl.CategoryServiceImpl;
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
public class addCategoryTest {
    @Autowired
    CategoryServiceImpl categoryService;

    // 测 试 addCategory 功 能
    /* 被测特性：
     * 1. 输入categoryId存在时，add失败
     * 2. 输入categoryName为空时，add失败
     * 3. 输入tStoreStoreId为空时，add失败
     * 4. 输入tStoreStoreId不存在时，add失败
     * 5. 输入参数合法时，add成功
     */
    /* 测试方法：
     * 1. categoryId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为categoryId存在和不存在情况
     * 2. categoryName的等价类划分考虑空和非空情况。
     * 3. tStoreStoreId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为tStoreStoreId存在和不存在情况
     */
    //失败：categoryId存在
    @Test(expected = DataIntegrityViolationException.class)
    public void addCategoryTest01() {
        Category category = new Category();
        category.setCategoryId(26);
        category.setCategoryName("Test");
        category.setTStoreStoreId(101);
        boolean res = categoryService.addCategory(category);
        assertEquals(false,res);
    }
    //失败：categotyName为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addCategoryTest02() {
        Category category = new Category();
        category.setCategoryId(30);
        category.setCategoryName(null);
        category.setTStoreStoreId(101);
        boolean res = categoryService.addCategory(category);
        assertEquals(false,res);
    }
    //失败：tStoreStoreId为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addCategoryTest03() {
        Category category = new Category();
        category.setCategoryId(30);
        category.setCategoryName("Test");
        category.setTStoreStoreId(null);
        boolean res = categoryService.addCategory(category);
        assertEquals(false,res);
    }
    //失败：tStoreStoreId不存在
    @Test(expected = DataIntegrityViolationException.class)
    public void addCategoryTest04() {
        Category category = new Category();
        category.setCategoryId(30);
        category.setCategoryName("Test");
        category.setTStoreStoreId(0);
        boolean res = categoryService.addCategory(category);
        assertEquals(false,res);
    }
    //成功：参数合法
    @Test
    public void addCategoryTest05() {
        Category category = new Category();
        getCategoryGoodsStub getCategoryGoods_stub = new getCategoryGoodsStub();
        category.setGoodslist(getCategoryGoods_stub.getCategoryGoods(30,"Test"));
        category.setCategoryId(30);
        category.setCategoryName("Test");
        category.setTStoreStoreId(101);
        boolean res = categoryService.addCategory(category);
        assertEquals(true,res);
    }
}
