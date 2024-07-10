package com.demo3;

@Book2
public class BookTest {

    @Book2
    public void method(){

    }

    @Override //在编码阶段(源码)检查：父类型中是否有toString()方法
    public String toString() {
        return "BookTest{}";
    }
}
