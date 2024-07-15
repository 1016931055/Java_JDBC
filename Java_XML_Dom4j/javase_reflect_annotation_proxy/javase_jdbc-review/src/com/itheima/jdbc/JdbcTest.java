package com.itheima.jdbc;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTest {


    @Test
    public void testJdbcDelete() throws ClassNotFoundException, SQLException {
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2、连接数据库
        String url="jdbc:mysql://127.0.0.1:3306/db5";
        String name="root";
        String password="itheima";
        Connection conn = DriverManager.getConnection(url, name, password);

        //设置：手动事务
        conn.setAutoCommit(false);

        //3、编写SQL语句
        String sql="delete from user where id = ?";

        //4、执行SQSL语句（把sql语句发送给数据库，数据库执行sql语句，并返回执行结果）
        PreparedStatement pstmt = conn.prepareStatement(sql);//数据库操作对象
        pstmt.setInt(1 , 5);//给占位符赋值
        int rowCount = pstmt.executeUpdate();

        //5、处理sql执行结果
        if(rowCount > 0){
            conn.commit();//提交事务
            System.out.println("删除成功");
        }

        //6、释放资源

        pstmt.close();
        conn.close();


    }


    @Test
    public void testJdbc() throws ClassNotFoundException, SQLException {
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2、连接数据库
        String url="jdbc:mysql://127.0.0.1:3306/db5";
        String name="root";
        String password="itheima";
        Connection conn = DriverManager.getConnection(url, name, password);


        //3、编写SQL语句
        String sql="select id,username,password from user";

        //4、执行SQSL语句（把sql语句发送给数据库，数据库执行sql语句，并返回执行结果）
        PreparedStatement pstmt = conn.prepareStatement(sql);//数据库操作对象
        ResultSet rs = pstmt.executeQuery();

        //集合：存储User对象
        List<User> userList= new ArrayList<>();
        //5、处理sql语句执行结果
        while(rs.next()){
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String pwd = rs.getString("password");

            //把取出的数据封装到User对象中
            User user = new User(id,username,pwd);

            //把User对象，存储到集合中
            userList.add(user);
        }
        //6、释放资源
        rs.close();
        pstmt.close();
        conn.close();

        //打印User对象
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
