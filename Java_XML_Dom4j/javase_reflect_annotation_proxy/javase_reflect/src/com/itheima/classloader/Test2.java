package com.itheima.classloader;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Test2 {


    @Test
    public void testGetResourceAsStream() throws IOException {
        //获取到类加载器对象
        ClassLoader classLoader = Test2.class.getClassLoader();

        //使用类加载器中的方法，加载src目录下的配置文件（必须存放src目录下）
        InputStream is = classLoader.getResourceAsStream("student.ini");
        //创建Properties对象
        Properties properties = new Properties();
        properties.load( is );

        System.out.println(properties);

    }
}
