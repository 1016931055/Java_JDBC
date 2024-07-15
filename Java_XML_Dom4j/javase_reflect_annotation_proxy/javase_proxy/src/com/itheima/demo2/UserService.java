package com.itheima.demo2;

import java.util.List;

//业务接口（规则标准）
public interface UserService {
    //登录
    public boolean login(String name,String password);

    //查询所有用户
    public List<User> findAllUser();


    //根据用户id删除用户
    public void deleteUserById(Integer id);
}
