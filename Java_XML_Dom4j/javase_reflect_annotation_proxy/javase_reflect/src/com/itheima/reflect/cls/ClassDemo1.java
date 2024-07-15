package com.itheima.reflect.cls;

import org.junit.Test;

public class ClassDemo1 {
    @Test
    public void testMethod() throws ClassNotFoundException {
        Class aClass = Class.forName("com.mysql.jdbc.Driver");//即使Driver类不存在，编写代码时不会报错。
        //在程序运行时，会动态加载：com.mysql.jdbc.Driver类的.class文件到内存中，并创建Class对象
    }
}
