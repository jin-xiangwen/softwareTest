package com.tongji.softwaretest.shikebackend.serviceTest;

import com.tongji.softwaretest.shikebackend.ShikeBackendApplication;
import com.tongji.softwaretest.shikebackend.entity.Comment;
import com.tongji.softwaretest.shikebackend.servicelmpl.CommentServiceImpl;
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
public class commentServiceTest {
    @Autowired
    CommentServiceImpl commentService;

    // 测 试 addComment 功 能
    /* 被测特性：
     * 1. 输入commentId存在时，add失败
     * 2. 输入storeId为空时，add失败
     * 3. 输入storeName为空时，add失败
     * 4. 输入goodsName为空时，add失败
     * 5. 输入userId为空时，add失败
     * 6. 输入userName为空时，add失败
     * 7. 输入commitTime为空时，add失败
     * 8. 输入storeId不存在时，add失败
     * 9. 输入userId不存在时，add失败
     * 10. 输入storeId和storeName不匹配时，add失败
     * 11. 输入参数合法时，add成功
     */
    /* 测试方法：
     * 1. commentId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为commentId存在和不存在情况
     * 2. storeId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为storeId存在和不存在情况
     * 3. storeName的等价类划分考虑空和非空情况。
     * 4. goodsName的等价类划分考虑空和非空情况。
     * 5. userId的等价类划分考虑空和非空情况。对于非空情况，又可以划分为tStoreStoreId存在和不存在情况
     * 6. userName的等价类划分考虑空和非空情况。
     * 7. commitTime的等价类划分考虑空和非空情况。
     */
    //失败：commentId存在
    @Test(expected = DuplicateKeyException.class)
    public void addCommentTest01() {
        Comment comment = new Comment();
        comment.setCommentId(1);
        comment.setStoreId(101);
        comment.setStoreName("哆吉客");
        comment.setGoodsName("nameTest");
        comment.setUserId(1111);
        comment.setUserName("test");
        comment.setCommitTime("2022-06-20 12:54:21");
        boolean res = commentService.addComment(comment);
        assertEquals(false,res);
    }
    //失败：storeId为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addCommentTest02() {
        Comment comment = new Comment();
        comment.setCommentId(10);
        comment.setStoreId(null);
        comment.setStoreName("哆吉客");
        comment.setGoodsName("nameTest");
        comment.setUserId(1111);
        comment.setUserName("test");
        comment.setCommitTime("2022-06-20 12:54:21");
        boolean res = commentService.addComment(comment);
        assertEquals(false,res);
    }
    //失败：storeName为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addCommentTest03() {
        Comment comment = new Comment();
        comment.setCommentId(10);
        comment.setStoreId(101);
        comment.setStoreName(null);
        comment.setGoodsName("nameTest");
        comment.setUserId(1111);
        comment.setUserName("test");
        comment.setCommitTime("2022-06-20 12:54:21");
        boolean res = commentService.addComment(comment);
        assertEquals(false,res);
    }
    //失败：goodsName为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addCommentTest04() {
        Comment comment = new Comment();
        comment.setCommentId(10);
        comment.setStoreId(101);
        comment.setStoreName("哆吉客");
        comment.setGoodsName(null);
        comment.setUserId(1111);
        comment.setUserName("test");
        comment.setCommitTime("2022-06-20 12:54:21");
        boolean res = commentService.addComment(comment);
        assertEquals(false,res);
    }
    //失败：userId为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addCommentTest05() {
        Comment comment = new Comment();
        comment.setCommentId(10);
        comment.setStoreId(101);
        comment.setStoreName("哆吉客");
        comment.setGoodsName("nameTest");
        comment.setUserId(null);
        comment.setUserName("test");
        comment.setCommitTime("2022-06-20 12:54:21");
        boolean res = commentService.addComment(comment);
        assertEquals(false,res);
    }
    //失败：userName为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addCommentTest06() {
        Comment comment = new Comment();
        comment.setCommentId(10);
        comment.setStoreId(101);
        comment.setStoreName("哆吉客");
        comment.setGoodsName("nameTest");
        comment.setUserId(1111);
        comment.setUserName(null);
        comment.setCommitTime("2022-06-20 12:54:21");
        boolean res = commentService.addComment(comment);
        assertEquals(false,res);
    }
    //失败：commitTime为空
    @Test(expected = DataIntegrityViolationException.class)
    public void addCommentTest07() {
        Comment comment = new Comment();
        comment.setCommentId(10);
        comment.setStoreId(101);
        comment.setStoreName("哆吉客");
        comment.setGoodsName("nameTest");
        comment.setUserId(1111);
        comment.setUserName("test");
        comment.setCommitTime(null);
        boolean res = commentService.addComment(comment);
        assertEquals(false,res);
    }
    //失败：storeId不存在
    @Test(expected = DataIntegrityViolationException.class)
    public void addCommentTest08() {
        Comment comment = new Comment();
        comment.setCommentId(10);
        comment.setStoreId(0);
        comment.setStoreName("哆吉客");
        comment.setGoodsName("nameTest");
        comment.setUserId(1111);
        comment.setUserName("test");
        comment.setCommitTime("2022-06-20 12:54:21");
        boolean res = commentService.addComment(comment);
        assertEquals(false,res);
    }
    //失败：userId不存在
    @Test(expected = DataIntegrityViolationException.class)
    public void addCommentTest09() {
        Comment comment = new Comment();
        comment.setCommentId(10);
        comment.setStoreId(101);
        comment.setStoreName("哆吉客");
        comment.setGoodsName("nameTest");
        comment.setUserId(0);
        comment.setUserName("test");
        comment.setCommitTime("2022-06-20 12:54:21");
        boolean res = commentService.addComment(comment);
        assertEquals(false,res);
    }
    //失败：storeId和storeName不匹配
    @Test(expected = DataIntegrityViolationException.class)
    public void addCommentTest10() {
        Comment comment = new Comment();
        comment.setCommentId(10);
        comment.setStoreId(101);
        comment.setStoreName("");
        comment.setGoodsName("nameTest");
        comment.setUserId(1111);
        comment.setUserName("test");
        comment.setCommitTime("2022-06-20 12:54:21");
        boolean res = commentService.addComment(comment);
        assertEquals(false,res);
    }
    //成功：参数合法
    @Test
    public void addCommentTest11() {
        Comment comment = new Comment();
        comment.setCommentId(10);
        comment.setStoreId(101);
        comment.setStoreName("哆吉客");
        comment.setGoodsName("nameTest");
        comment.setUserId(1111);
        comment.setUserName("test");
        comment.setCommitTime("2022-06-20 12:54:21");
        boolean res = commentService.addComment(comment);
        assertEquals(true,res);
    }
}
