package com.demo4_注解解析方式;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) //只能书写在成员变量上
@Retention(RetentionPolicy.RUNTIME) //存活范围：源码阶段、 字节码阶段、 运行时
public @interface Book {
    public String value();//属性
}
