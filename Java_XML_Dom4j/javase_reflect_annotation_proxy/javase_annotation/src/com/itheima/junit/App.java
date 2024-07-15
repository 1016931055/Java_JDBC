package com.itheima.junit;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取Class对象
        Class cls = Class.forName("com.itheima.junit.JunitDemo");

        //基于Class获取构造器
        Constructor cons = cls.getConstructor();

        //基于Class获取类中所有的方法
        Method[] methods = cls.getDeclaredMethods();

        //遍历：所有的方法对象
        for (Method method : methods) {
            //判断：Method对象上是否存在@MyTest注解
            if(method.isAnnotationPresent(MyTest.class)){
                //存在： 执行方法
                method.invoke(cons.newInstance());
            }
        }
    }
}
