package com.itheima;

import cn.itcast.anno.ResultType;
import cn.itcast.anno.Select;

import java.util.List;

//接口
public interface UserMaper {


    @Select("select id, name, birthday,sex ,address from tb_user")//SQL语句
    @ResultType("com.itheima.User")//POJO类
    public abstract List queryAllUser();


}
