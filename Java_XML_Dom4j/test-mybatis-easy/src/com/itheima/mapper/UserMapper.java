package com.itheima.mapper;

import cn.itcast.anno.ResultType;
import cn.itcast.anno.Select;

import java.util.List;

public interface UserMapper {

    @Select("select id,user_name AS name, birthday,sex ,address from user")
    @ResultType("com.itheima.pojo.User")
    public abstract List queryAllUser();

}
