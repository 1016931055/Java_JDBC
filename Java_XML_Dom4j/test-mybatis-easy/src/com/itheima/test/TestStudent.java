package com.itheima.test;

import cn.itcast.config.SqlSession;
import com.itheima.mapper.StudentMapper;

import java.util.List;

public class TestStudent {

    public static void main(String[] args) {
        //使用JDBC框架提供的API方法，实现数据库交互

        //创建SqlSession对象
        SqlSession sqlSession = new SqlSession();

        //调用getMapper方法，获取到StudentMapper接口的代理类对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        //调用StudentMapper接口中的方法 （不是要去执行抽象方法，而是获取抽象方法上的@Select注解）
        List students = studentMapper.findAllStudent();//是使用代理类对象调用方法（会被InvocationHandler拦截）


        //遍历
        for (Object student : students) {
            System.out.println(student);
        }

    }
}
