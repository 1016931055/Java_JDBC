package com.reflect.method_反射获取成员方法;

public class Student {
    public Student() {
    }

    //成员方法
    public void study() {
        System.out.println("努力学习...");
    }

    public void sleep(String name) {
        System.out.println(name + "上课睡觉~~~");
    }

    //私有方法
    private String sayHello(String msg, String name) {
        return msg + name;
    }

    //静态方法
    public static void hello(String name){
        System.out.println(name);
    }
}
