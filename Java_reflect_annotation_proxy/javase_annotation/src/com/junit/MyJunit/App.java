package com.junit.MyJunit;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 获取Class对象
        Class<Demo> demo = Demo.class;

        // 反射获取构造器
        Constructor<Demo> demoConstructor = demo.getConstructor();
        // 获取对象
        Demo demo1 = demoConstructor.newInstance();

        // 反射获取方法
        Method[] methods = demo.getDeclaredMethods();

        for (Method method : methods) {
            // 若方法上存在Mytest注解
            if(method.isAnnotationPresent(Mytest.class))
                method.invoke(demo1);
        }

    }
}
