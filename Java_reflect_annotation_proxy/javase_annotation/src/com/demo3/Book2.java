package com.demo3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
//@Target(ElementType.METHOD)//限定当前自定义注解，只能书写在方法上
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface Book2 {
}
