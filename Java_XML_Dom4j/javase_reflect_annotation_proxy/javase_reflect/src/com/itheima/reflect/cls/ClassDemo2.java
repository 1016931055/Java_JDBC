package com.itheima.reflect.cls;

import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

public class ClassDemo2 {

    @Test
    public void testGetClass2(){

        method(new Student());
    }

    //参数为对象时 ：  对象名.getClass()
    public void method(Student stu){
        Class stuClass = stu.getClass();

        System.out.println(stuClass);
    }

    //明确类名后 ：  类名.class
    @Test
    public void testGetClass3(){
        Class<Student> studentClass = Student.class;
        System.out.println(studentClass);
    }


    //读取配置文件 : Class.forName()
    @Test
    public void testGetClass() throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("student.ini"));

        String className = properties.getProperty("className");

        Class cls = Class.forName(className);

        System.out.println(cls);
    }
}
