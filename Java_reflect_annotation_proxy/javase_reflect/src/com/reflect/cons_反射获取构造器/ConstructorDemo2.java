package com.reflect.cons_反射获取构造器;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorDemo2 {

    @Test
    public void testGetConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //第1步： 获取Class对象
        Class<User> userClass = User.class;

        //第2步：基于Class对象，获取public修饰的全参构造方法
        Constructor<User> constructor = userClass.getConstructor(String.class , String.class);

        //第3步：使用构造器，创建对象
        User user = constructor.newInstance("光头强", "123123");

        System.out.println(user);
    }


    @Test
    public void testGetDeclaredConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //第1步： 获取Class对象
        Class<User> userClass = User.class;

        //第2步：基于Class对象，获取私有的构造方法
        Constructor<User> cons = userClass.getDeclaredConstructor(String.class);

        //取消权限检查
        cons.setAccessible(true);

        //第3步：使用私有构造器，创建对象
        User user = cons.newInstance("熊二");
        /* 继承中，父类私有的内容是可以继承的，但是由于java语言有权限检查过滤，故：不允许权限外的内容（私有内容，子类不能访问）
        *  Class对象中存储有private构造器，由于java语言有权限检查过滤，故：不允许访问私有构造器
        *
        *  反射技术的强大 ： 暴力破解 （可以设置本次访问时暂时取消权限检查）
        *  使用API方法： setAccessible(true)  表示取消权限检查
        *              必须书写在创建对象之前
        * */
        System.out.println(user);
    }


    @Test
    public void testGetDeclaredConstructors() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //第1步： 获取Class对象
        Class<User> userClass = User.class;

        //第2步：基于Class对象，获取所有的构造方法（包含：私有）
        Constructor<?>[] constructors = userClass.getDeclaredConstructors();

        //第3步：测试
        for (Constructor<?> cons : constructors) {
            System.out.println(cons);
        }
    }


    @Test
    public void testGetConstructors() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //第1步： 获取Class对象
        Class<User> userClass = User.class;

        //第2步：基于Class对象，只能获取到public修饰的构造方法
        Constructor<?>[] constructors = userClass.getConstructors();

        //第3步：测试
        for (Constructor<?> cons : constructors) {
            System.out.println(cons);
        }
    }
}
