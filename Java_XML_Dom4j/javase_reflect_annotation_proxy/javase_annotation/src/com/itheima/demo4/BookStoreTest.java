package com.itheima.demo4;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BookStoreTest {
    /*
        //构造器对象
        Constructor cons=null;
        //成员方法对象
        Method method = null;
        //成员变量对象
        Field field = null;
       以上三个对象都有实现：AnnotatedElement接口，并重写相关方法
    * */

    @Test
    public void testParse() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        //获取Class对象
        Class<BookStore> bookStoreClass = BookStore.class;
        BookStore bookStore = bookStoreClass.newInstance();

        //获取成员变量对象
        Field field = bookStoreClass.getDeclaredField("bookName");

        //判断：成员变量上是否有@Book注解
        if(field.isAnnotationPresent(Book.class)){
            //有注解：解析
            Book book = field.getDeclaredAnnotation(Book.class);
            //获取Book注解中的value属性值
            String bookName = book.value();

            //私有成员变量，要取消权限检查
            field.setAccessible(true);
            //使用反射技术，给私有成员变量赋值
            field.set( bookStore , bookName);
        }

        System.out.println(bookStore.getBookName());
    }
}
