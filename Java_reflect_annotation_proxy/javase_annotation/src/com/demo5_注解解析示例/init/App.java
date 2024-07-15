package com.demo5_注解解析示例.init;

import com.demo5_注解解析示例.dao.UserDao;
import com.demo5_注解解析示例.service.UserService;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //项目程序启动，就会初始化一些对象和参数

        //获取到UserSerivce的Class对象
        Class<UserService> userServiceClass = UserService.class;

        //构造器
        Constructor<UserService> cons = userServiceClass.getConstructor();

        //成员变量
        Field[] fields = userServiceClass.getDeclaredFields();

        //遍历
        for (Field field : fields) {
            //判断：成员变量上是否有@CreateObject注解
            if(field.isAnnotationPresent(CreateObject.class)){
                //有注解就解析
                CreateObject obj = field.getDeclaredAnnotation(CreateObject.class);

                String objectValue = obj.value();

                UserDao userDao = new UserDao();

                if(objectValue.equals("userDao")){
                    field.setAccessible(true);//暴力破解
                    field.set(cons.newInstance() , userDao );
                }
            }
        }
    }
}
