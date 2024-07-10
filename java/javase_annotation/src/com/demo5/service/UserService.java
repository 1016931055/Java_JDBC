package com.demo5.service;


import com.demo5.dao.UserDao;
import com.demo5.init.CreateObject;
import com.demo5.pojo.User;

import java.util.List;

//业务类
public class UserService {
    //成员变量（需要依赖UserDao对象）
    @CreateObject("userDao")
    private UserDao userDao ;



    public List<User> queryAllUser(){
        //调用UserDao对象中的方法

        List<User> userList = userDao.findAllUser();

        return userList;
    }


    //添加用户
    public boolean addUser(User user){

        //调用UserDao对象中的方法


        return false;
    }

    //添加用户
    public boolean deleteUser(int id){
        //调用UserDao对象中的方法



        return false;
    }


}
