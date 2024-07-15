package com.demo5_注解解析示例.dao;

import com.demo5_注解解析示例.pojo.User;

import java.util.ArrayList;
import java.util.List;

//dao层
public class UserDao {

    //查询所有的用户
    public List<User> findAllUser(){
       List<User> users  = new ArrayList<>();
       users.add(new User(1,"熊大",23));
       users.add(new User(2,"熊二",22));

       return users;
    }

    //添加

    //删除

    //修改

    //.....
}
