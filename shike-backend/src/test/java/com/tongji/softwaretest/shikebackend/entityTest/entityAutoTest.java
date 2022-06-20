package com.tongji.softwaretest.shikebackend.entityTest;

import com.tongji.softwaretest.shikebackend.entity.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class entityAutoTest {

    @Test
    public void test() throws InstantiationException,IllegalAccessException,IllegalArgumentException,InvocationTargetException {
        autoTest(Address.class);
        autoTest(Category.class);
        autoTest(Comment.class);
        autoTest(Goods.class);
        autoTest(Order.class);
        autoTest(OrderGoods.class);
        autoTest(Store.class);
        autoTest(User.class);
    }

    private void autoTest(Class<?> a) throws InstantiationException,IllegalAccessException,IllegalArgumentException, InvocationTargetException {
        Method[] methods = a.getMethods();
        for (Method me : methods) {
            Object obj = a.newInstance();
            String name = me.getName();
            if (name.contains("set")) {
                // 调 用 set 方 法
                Class<?>[] cls = me.getParameterTypes();
                if (cls.length == 1) {
                    if (cls[0] == String.class) {
                        me.invoke(obj, "");
                    } else if (cls[0] == Integer.class) {
                        me.invoke(obj,123);
                    } else if (cls[0] == Float.class) {
                        me.invoke(obj,123.456f);
                    } else if (cls[0] == List.class) {
                        me.invoke(obj, new ArrayList<Object>());
                    }
                }
            } else if (name.contains("get")) {
                // 调 用 get 方 法
                Class<?>[] cls = me.getParameterTypes();
                if (cls.length == 0) {
                    me.invoke(obj);
                }
            }
        }
    }
}
