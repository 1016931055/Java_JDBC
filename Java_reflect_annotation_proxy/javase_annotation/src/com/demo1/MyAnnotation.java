package com.demo1;

//自定义注解
public @interface MyAnnotation {
    //在注解中只能定义属性：  public 属性类型  属性名() default 默认值

    /* 属性类型必须是以下范围之一：
       1、 8种基本数据类型
       2、 String类型
       3、 Class类型
       4、 枚举类型
       5、 注解类型
       6、 以上所有类型的一维数组形式。  例： String[] 、Class[]
    * */

    public String name();
    public double price() default 99.0;
}
