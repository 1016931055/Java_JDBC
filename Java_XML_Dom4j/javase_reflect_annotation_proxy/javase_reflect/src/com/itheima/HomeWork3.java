package com.itheima;

import org.junit.Test;

import java.lang.reflect.Field;

public class HomeWork3 {

    @Test
    public void testMethod1() throws NoSuchFieldException, IllegalAccessException {
        User user = new User();

        setProperty(user , "name" , "张三");

        Object result = getProperty(user, "name");

        System.out.println(result);
    }

    /**
     * 功能： 利用反射技术，获取指定对象中的指定属性的值
     * @param obj             对象 （实例化的对象）
     * @param propertyName    属性名（成员变量名）
     * @return                属性的值
     */
    public Object getProperty(Object obj, String propertyName) throws NoSuchFieldException, IllegalAccessException {
        //获取Class对象 ： 通过对象名获取Class对象
        Class cls = obj.getClass();

        //基于Class对象，获取成员变量对象（属性）
        Field field = cls.getDeclaredField(propertyName);
        //通常一个类中的属性，都使用private修饰
        field.setAccessible(true);//取消本次权限检查

        //利用Field对象，获取成员变量的值
        return field.get(obj);
    }


    /**
     * 功能 ：利用反射，给指定的对象中的属性进行赋值
     *
     * @param obj             对象 （实例化的对象）
     * @param propertyName    属性名（成员变量名）
     * @param value           属性值（成员变量的数据值）
     */
    public void setProperty(Object obj, String propertyName, Object value) throws NoSuchFieldException, IllegalAccessException {
        //获取Class对象 ： 通过对象名获取Class对象
        Class cls = obj.getClass();

        //基于Class对象，获取成员变量对象（属性）
        Field field = cls.getDeclaredField(propertyName);
        //通常一个类中的属性，都使用private修饰
        field.setAccessible(true);//取消本次权限检查

        //给成员变量赋值
        field.set(obj , value);
    }

}
