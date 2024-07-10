package com.reflect.cons;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ConstructorDemo3 {
    @Test
    public void testMethod() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //创建用户服务对象
        //UserServiceImpl userService = new UserServiceImpl();
        //以上代码存在：强耦合 （当业务类变更时，需要修改等号两边的代码）

        //改进方案： 多态
        //UserService userService = new UserServiceImpl2();
        //以上代码还存在耦合 （当业务类变更时，要修改等号右边代码）
        //解决方案： 反射 + 配置文件

        //模拟配置文件： className=com.reflect.cons.UserServiceImpl2
        //模拟读取配置文件中的内容：
        String className = "com.reflect.cons.UserServiceImpl2";
        //反射技术：
        //1、获取Class对象
        Class cls = Class.forName(className);

        //2、获取构造器
        Constructor cons = cls.getConstructor();//无参

        //3、基于构造器，创建对象
        // 强制转换！
        UserService userService = (UserService) cons.newInstance();//不需要传参数

        //调用方法
        List<User> userList = userService.queryAllUser();

        for (User user : userList) {
            System.out.println(user);
        }
    }
}
