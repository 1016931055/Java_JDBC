import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

public class test {
    public static void main(String[] args) {

    }

    @Test
    public void hw1() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 1). 使用反射获取Student的Class对象。
        Class<Student> studentClass = Student.class;

// 2). 获取 “公有、全参构造方法”；
        Constructor<Student> studentConstructor = studentClass.getConstructor(int.class, String.class);

// 3). 调用 “公有、全参构造方法”传入：“柳岩”,17 两个参数。
        Student stu = studentConstructor.newInstance(17, "柳岩");

// 4). 反射获取show()方法
        Method show = studentClass.getDeclaredMethod("show");

// 5). 调用show()方法
        show.invoke(stu);
    }

    @Test
    public void hw2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //1. 现有集合：ArrayList<Integer> list = new ArrayList();
        //2. 利用反射机制在这个泛型为Integer的ArrayList中存放一个String类型的对象。
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);


        // 通过反射获得Class对象
        Class c = list.getClass();

        // 获得add方法对象
        // 这里写上了Object.class!
        Method add = c.getMethod("add", Object.class);

        // 通过反射调用list对象的add方法
        add.invoke(list, "123");

        for (Object o : list)
            System.out.println(o);
    }

    /*
    需求：按要求完成下面两个方法的方法体
    1. 写一个方法，此方法可将obj对象中名为propertyName的属性的值设置为value.
      `public void setProperty(Object obj, String propertyName, Object value){}`
      - Object  obj  ：  对象 （实例化的对象）
      - String  propertyName ： 属性名（成员变量名）
      - Object  value ： 属性值（成员变量的数据值）
      - 方法的功能： 给obj对象中的propertyName属性，赋值为value
    2. 写一个方法，此方法可以获取obj对象中名为propertyName的属性的值
      `public Object getProperty(Object obj, String propertyName){}`
      - Object  obj ： 对象 （实例化的对象）
      - String  propertyName ： 属性名（成员变量名）
      - 方法的功能： 获取obj对象中的propertyName属性的值
    > 使用反射技术实现。 使用Field对象给成员变量赋值、取值
            */
    public void setProperty(Object obj, String propertyName, Object value) throws NoSuchFieldException, IllegalAccessException {
        // 获取Object类
        Class cls = obj.getClass();

        // 获取成员属性:propertyName
        Field field = cls.getDeclaredField(propertyName);

        field.setAccessible(true);

        field.set(obj,value);
    }

    public Object getProperty(Object obj, String propertyName) throws NoSuchFieldException, IllegalAccessException {
        Class cls = obj.getClass();

        Field field = cls.getDeclaredField(propertyName);

        field.setAccessible(true);

        return field.get(field);
    }


    @Test
    public void hw4() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //1. 定义一个Person类，包含私有属性name、age，getXxx和setXxx方法和有参满参构造方法。
        //2. 使用反射的方式创建一个实例、调用构造函数初始化name、age。
        // 使用反射方式调用setName方法对姓名进行设置，不使用setAge方法直接使用反射方式对age赋值
        //1.获取Person类的字节码对象
        Class clazz = Person.class;

        //2.利用反射获取有参构造方法
        Constructor constructor  = clazz.getConstructor(int.class,String.class);

        //3.调用构造方法,给属性初始化
        Person person =  (Person)constructor.newInstance(30,"灭绝师太");
        System.out.println(person);

        //4.使用反射方式调用setName方法对名称进行设置
        Method setNameMethod = clazz.getMethod("setName", String.class);
        setNameMethod.invoke(person, "张三丰");

        //5.不使用setAge方法直接使用反射方式对age赋值。
        Field ageField = clazz.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(person, 50);

        System.out.println(person);
    }

    @Test
    public void hw5()
            throws IOException, InstantiationException,
            IllegalAccessException, NoSuchMethodException,
            InvocationTargetException, ClassNotFoundException {
        /*
        (1) 写一个Properties格式的配置文件，配置文件内容如下：

        config.properties

        className=com.itcast.test07.DemoClass

        (2)写一个程序，读取这个Properties配置文件，获得类的完整名称并加载这个类，

        (3)用反射的方式运行run方法。
        */
        // 创建集合对象
        Properties props = new Properties();

        FileInputStream fis = new FileInputStream("config.properties");
        // 从属性文件中加载数据
        props.load(fis);

        // 获得类全名
        String name = (String) props.get("className");

        // 获得Class对象
        Class clazz = Class.forName(name);

        //利用反射创建一个对象
        Object obj = clazz.newInstance();//Class对象中提供的newInstance()方法：已过时

        //利用反射获取run方法
        Method runMethod = clazz.getMethod("run");
        //利用反射调用run方法
        runMethod.invoke(obj);
        fis.close();
    }
}