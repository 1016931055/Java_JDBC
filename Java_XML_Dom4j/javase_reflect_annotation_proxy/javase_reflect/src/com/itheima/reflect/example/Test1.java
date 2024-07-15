package com.itheima.reflect.example;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test1 {
    /*实现思路：
          读取info.properties配置文件
          获取配置文件中的：className、methodName

          利用反射技术：
             使用Class中的静态方法forName,动态加载类的字节码文件
             利用Class对象，获取指定的Method对象
     * */
    @Test
    public void testMethod() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //读取配置文件中的内容
        Properties properties = new Properties();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("info.properties");
        properties.load(is);

        //解析配置文件中的内容
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        System.out.println(className + " || " + methodName);

        //使用反射技术：实现对象的创建、方法的调用
        Class cls = Class.forName(className);
        //基于Class对象，获取Constructor对象
        Constructor cons = cls.getConstructor();
        //基于Class对象，获取Method对象
        Method method = cls.getMethod(methodName);

        //运行方法
        method.invoke( cons.newInstance()  );
    }
}
