package com.reflect.cons;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorDemo1 {

    //获取到无参构造器，并创建对象
    @Test
    public void testConstructor1() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /*
        获取构造器的方法：
        Constructor<?>[] getConstructors()	返回所有构造器对象的数组（只能拿public的）
        Constructor<?>[] getDeclaredConstructors()	返回所有构造器对象的数组，存在就能拿到
        Constructor<T> getConstructor(Class<?>... parameterTypes)	返回单个构造器对象（只能拿public的）
        Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)	返回单个构造器对象，存在就能拿到
         */

        //第1步：获取到Class对象
        Class<User> userClass = User.class;

        //第2步：基于Class对象，获取到构造器（Constructor）
        Constructor<User> constructor = userClass.getConstructor();//方法中没有指定参数类型，故获取到的是无参构造方法

        //第3步：利用构造器，创建对象
        User user = constructor.newInstance();//无参构造方法中不需要传递具体的数据

        //第4步：给对象赋值
        user.setName("熊大");
        user.setPassword("123123");

        System.out.println(user);
    }
}