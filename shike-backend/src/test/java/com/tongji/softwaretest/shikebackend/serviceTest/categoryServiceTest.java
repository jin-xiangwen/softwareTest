package com.tongji.softwaretest.shikebackend.serviceTest;

import com.tongji.softwaretest.shikebackend.ShikeBackendApplication;
import com.tongji.softwaretest.shikebackend.entity.Category;
import com.tongji.softwaretest.shikebackend.entity.Goods;
import com.tongji.softwaretest.shikebackend.entity.OrderGoods;
import com.tongji.softwaretest.shikebackend.servicelmpl.CategoryServiceImpl;
import com.tongji.softwaretest.shikebackend.servicelmpl.GoodsServiceImpl;
import io.swagger.models.auth.In;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest(classes = ShikeBackendApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class categoryServiceTest {
    @Autowired
    CategoryServiceImpl categoryService;

    @Autowired
    GoodsServiceImpl goodsService;

    //categoryGoodsStub——为添加category的goodStub
    public List<Goods> categoryGoodsStub(Integer categoryId,String categoryName) {
        List<Goods> categoryGoodsList = new ArrayList<Goods>();
        Goods categoryGoods = new Goods();
        categoryGoods.setGoodsCategory(categoryName);
        categoryGoods.setGoodsName("nameTest");
        categoryGoods.setGoodsPrice(0f);
        categoryGoods.setTStoreStoreId(101);
        categoryGoods.setTCategoryCategoryId(categoryId);
        categoryGoodsList.add(categoryGoods);
        return categoryGoodsList;
    }

    // 测 试 deleteCategory 功 能
    /* 被测特性：
     * 1. 输入categoryId不存在时，delete失败
     * 2. 输入categoryId为空时，delete失败
     * 3. 输入categoryId存在时，delete成功，类别被删除
     */
    /* 测试方法：
     * categoryId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为categoryId存在和不存在情况
     */
    //失败：categoryId不存在
    @Test
    public void deleteCategoryTest01() {
        Integer categoryId = 0;
        boolean res = categoryService.deleteCategory(categoryId);
        assertEquals(false,res);
    }
    //失败：categoryId为空
    @Test(expected = NullPointerException.class)
    public void deleteCategoryTest02() {
        Integer categoryId = null;
        boolean res = categoryService.deleteCategory(categoryId);
        assertEquals(false,res);
    }
    //成功：categoryId存在
    @Test
    public void deleteCategoryTest03() {
        Integer categoryId = 26;
        boolean res = categoryService.deleteCategory(categoryId);
        assertEquals(true,res);
    }

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
        category.setGoodslist(categoryGoodsStub(30,"Test"));
        category.setCategoryId(30);
        category.setCategoryName("Test");
        category.setTStoreStoreId(101);
        boolean res = categoryService.addCategory(category);
        assertEquals(true,res);
    }

    // 测 试 modifyCategory 功 能
    /* 被测特性：
     * 1. 输入categoryId不存在时，modify失败
     * 2. 输入categoryName为空时，modify失败
     * 3. 输入tStoreStoreId为空时，modify失败
     * 4. 输入参数合法时，add成功
     */
    /* 测试方法：
     * 1. categoryId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为categoryId存在和不存在情况
     * 2. categoryName的等价类划分考虑空和非空情况。
     * 3. tStoreStoreId的等价类划分考虑空和非空情况。
     */
    //失败：categoryId不存在
    @Test
    public void modifyCategoryTest01() {
        Category category = new Category();
        category.setCategoryId(30);
        category.setCategoryName("Test");
        category.setTStoreStoreId(888);
        boolean res = categoryService.modifyCategory(category);
        assertEquals(false,res);
    }
    //失败：categoryName为空
    @Test(expected = DataIntegrityViolationException.class)
    public void modifyCategoryTest02() {
        Category category = new Category();
        category.setCategoryId(26);
        category.setCategoryName(null);
        category.setTStoreStoreId(888);
        boolean res = categoryService.modifyCategory(category);
        assertEquals(false,res);
    }
    //失败：tStoreStoreId为空
    @Test(expected = DataIntegrityViolationException.class)
    public void modifyCategoryTest03() {
        Category category = new Category();
        category.setCategoryId(26);
        category.setCategoryName("Test");
        category.setTStoreStoreId(null);
        boolean res = categoryService.modifyCategory(category);
        assertEquals(false,res);
    }
    //成功：参数合法
    @Test
    public void modifyCategoryTest04() {
        Category category = new Category();
        category.setCategoryId(26);
        category.setCategoryName("Test");
        category.setTStoreStoreId(888);
        boolean res = categoryService.modifyCategory(category);
        assertEquals(true,res);
    }
}
