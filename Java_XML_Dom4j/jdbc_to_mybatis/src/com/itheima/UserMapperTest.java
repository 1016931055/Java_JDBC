package com.itheima;

import cn.itcast.config.SqlSession;

import java.util.List;

public class UserMapperTest {
    public static void main(String[] args) {
        //创建JDBC框架中提供的API对象
        SqlSession sqlSession = new SqlSession();

        //使用SqlSession，调用方法，创建代理对象（基于给定的接口，创建了接口实现类，生成实现类代理对象）
        UserMaper userMaper = sqlSession.getMapper(UserMaper.class);

        List list = userMaper.queryAllUser();

        for (Object user : list) {
            System.out.println(user);
        }

    }
}
