package com.reflect.cons_反射获取构造器;

import java.util.List;

//定义规则
public interface UserService {
    public boolean addUser(User user);

    public boolean deleteUser(Integer id);

    public List<User> queryAllUser();
}
