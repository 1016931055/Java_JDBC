package com.reflect.cons_反射获取构造器;

import java.util.ArrayList;
import java.util.List;

//按照规则编写
public class UserServiceImpl2 implements UserService{
    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(Integer id) {
        return false;
    }

    @Override
    public List<User> queryAllUser() {
        List<User> users = new ArrayList<>();
        users.add(new User("熊大","123"));
        users.add(new User("熊二","123"));
        users.add(new User("熊三","123"));
        users.add(new User("熊四","123"));

        return users;
    }
}
