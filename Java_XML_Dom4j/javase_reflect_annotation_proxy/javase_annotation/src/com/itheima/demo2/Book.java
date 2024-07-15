package com.itheima.demo2;

//自定义注解
public @interface Book {
    //属性
    public String value();
    public double price() default 99.0; //有默认价格
    public String[] author(); //有多个作者
}
