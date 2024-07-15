package com.junit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)//当前自定义注解只能书写在方法上
//省略了注解的生命周期（验证：注解默认的生命周期）
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTest {
    //空属性
}