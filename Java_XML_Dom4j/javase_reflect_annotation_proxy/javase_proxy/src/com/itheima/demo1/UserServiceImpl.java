package com.itheima.demo1;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//编写业务实现类(按照接口中制定的业务规则开发代码)
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(String name, String password){
        //记录开始时间
        long beginTime = System.currentTimeMillis();


        boolean result = false;//登录状态（true：登录成功  false:登录失败）

        //模拟：查询数据
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return result;
    }

    @Override
    public List<User> findAllUser() {
        //记录开始时间
        long beginTime = System.currentTimeMillis();

        //定义集合
        List<User> userList = new ArrayList<>();

        //模拟查询数据
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userList.add(new User(1,"itheima","123"));
        userList.add(new User(2,"shheima","123"));
        userList.add(new User(3,"zhangsan","123456"));
        userList.add(new User(4,"admin","admin"));

        //记录结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("login执行消耗："+(endTime-beginTime)+"毫秒");

        return userList;
    }

    @Override
    public void deleteUserById(Integer id) {
        //记录开始时间
        long beginTime = System.currentTimeMillis();

        //模拟删除数据时间
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //记录结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("login执行消耗："+(endTime-beginTime)+"毫秒");

    }
}
