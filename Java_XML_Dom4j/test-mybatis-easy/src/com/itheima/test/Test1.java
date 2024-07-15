package com.itheima.test;

import cn.itcast.config.SqlSession;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;

import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        //创建SqlSeesion对象
        SqlSession sqlSesstion = new SqlSession();

        //获取UserMapper的代理对象
        UserMapper mapper = sqlSesstion.getMapper(UserMapper.class);



        //调用UserMaper中的方法
        List<User> users = mapper.queryAllUser();

        for (User u : users) {
            System.out.println(u);
        }
    }
}
