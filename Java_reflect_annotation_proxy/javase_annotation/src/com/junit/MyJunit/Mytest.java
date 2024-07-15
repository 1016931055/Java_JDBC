package com.junit.MyJunit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)  // 当前注解只能用在方法上
@Retention(RetentionPolicy.RUNTIME)
public @interface Mytest {

}
