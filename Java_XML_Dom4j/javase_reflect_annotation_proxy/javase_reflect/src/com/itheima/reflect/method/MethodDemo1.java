package com.itheima.reflect.method;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo1 {

    @Test
    public void testMethod() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //1、获取Class对象
        Class<Student> studentClass = Student.class;
        Student student = studentClass.newInstance();//可以使用Class类中的newInstance()方法直接调用Student类中的无参构造创建对象

        //2、基于Class对象，获取到Method对象（成员方法对象）
        Method method = studentClass.getMethod("study");//获取public修饰的无参study方法

        //3、利用Method对象，运行方法
        method.invoke(student);
    }
}
