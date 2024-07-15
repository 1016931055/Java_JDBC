package com.jdbc.example.service;

import com.jdbc.example.dao.UserDao;
import com.jdbc.example.pojo.User;

//用户业务类
public class UserService {

    /**
     * 用户登录
     * @param loginUser   用户对象
     * @return    登录状态（true：登录成功、false：登录失败）
     */
    public boolean userLogin(User loginUser){
        //校验： 传递的数据是否合法
        if(loginUser == null){
            throw  new RuntimeException("传递的参数为null");
        }

        //省略了：复杂的业务逻辑

        //调用dao层方法
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);

        if(user != null){
            return true;
        }

        return false;
    }
}
