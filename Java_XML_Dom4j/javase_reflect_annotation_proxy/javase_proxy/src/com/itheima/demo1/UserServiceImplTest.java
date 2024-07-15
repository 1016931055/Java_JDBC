package com.itheima.demo1;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

//测试类
public class UserServiceImplTest {
    //成员变量
    private  UserService userService = null;

    @Before //每一个测试方式（@Test修饰的方法）执行前，都要执行@Before修饰的方法
    public void init(){
        userService = new UserServiceImpl();
    }

    @Test
    public void testLogin(){
        boolean loginResult = userService.login("admin", "admin");
        System.out.println("登录结果："+loginResult);
    }

    @Test
    public void testFindAllUser() {
        List<User> userList = userService.findAllUser();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testDeleteUserById() {
       userService.deleteUserById(1);

    }
}
