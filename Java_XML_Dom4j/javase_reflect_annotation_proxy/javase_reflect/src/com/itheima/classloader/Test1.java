package com.itheima.classloader;

import org.junit.Test;

//Test1是自定义类（是由应用程序类加载器加载）
public class Test1 {

    @Test
    public void testClassLoader() {
        //获取到Test1类的Class对象
        Class test1Class = Test1.class;

        //获取类加载器对象
        ClassLoader appClassLoader = test1Class.getClassLoader();
        System.out.println(appClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2


        //获取应用程序类加载器的父类：扩展类加载器
        ClassLoader parent = appClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类： 启动类加载器
        System.out.println(parent.getParent()); //启动类加载器对象为null
    }

}
