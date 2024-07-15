package com.itheima.mapper;


import cn.itcast.anno.ResultType;
import cn.itcast.anno.Select;

import java.util.List;

/*
* 作用： 书写sql语句
* */
public interface StudentMapper {

    @Select("select id,name,age,score from student")
    @ResultType("com.itheima.pojo.Student")
    public List findAllStudent();

}
