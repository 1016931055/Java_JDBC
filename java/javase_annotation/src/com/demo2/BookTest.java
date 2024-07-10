package com.demo2;

import org.junit.Test;

@Book(value = "Java高级开发", author = {"黑马", "老唐", "小杨"})
//@Book("Java高级开发")//如果自定义注解仅有一个value属性，且其他属性都有默认值的情况下，可以省略value属性
public class BookTest {
    @Test //只能书写在方法上
    public void testMethod(){
    }
}
