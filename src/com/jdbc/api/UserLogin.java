package com.jdbc.api;

import org.junit.Test;

import java.sql.*;

public class UserLogin {
    //使用PreparedStatement解决SQL注入问题
    @Test
    public void loginTest2() throws ClassNotFoundException, SQLException {
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2、连接数据库
        final String URL = "jdbc:mysql://127.0.0.1:3306/db5";
        final String NAME = "root";
        final String PASSWORD = "";
        Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);

        //3、编写SQL语句
        String username = "aaa";
        String password = "aaa' or 1=1-- ";
        String sql = "select id,username,password from user where username=? and password=?";

        //4、执行SQL语句
        PreparedStatement pstmt = conn.prepareStatement(sql);//创建预编译对象（对sql语句进行预编译操作）
        //给SQL语句中的占位符赋值
        pstmt.setString(1, username);
        pstmt.setString(2, password);

        ResultSet rs = pstmt.executeQuery();//执行SQL，查询结果封装在ResultSet对象中

        //5、处理SQL执行结果
        if (rs.next()) { //if判断，适用于查询的结果集中仅有一行记录
            String strname = rs.getString("username");
            String pwd = rs.getString("password");
            System.out.println("欢迎" + strname + "登录成功");

        } else {
            System.out.println("登录失败!");
        }

        //6、释放资源（倒着书写关闭功能）
        rs.close();
        pstmt.close();
        conn.close();
    }


    @Test
    public void loginTest() throws ClassNotFoundException, SQLException {
        //1、注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2、连接数据库
        final String URL = "jdbc:mysql://127.0.0.1:3306/db5";
        final String NAME = "root";
        final String PASSWORD = "";
        Connection conn = DriverManager.getConnection(URL, NAME, PASSWORD);

        //3、编写SQL语句
        String username = "aaa";
        String password = "aaa' or 1=1-- ";
        String sql = "select id,username,password " +
                "from user " +
                "where username='" + username + "' and password='" + password + "';";

        //4、执行SQL语句
        Statement stmt = conn.createStatement();//创建执行SQL的对象
        ResultSet rs = stmt.executeQuery(sql);//执行SQL，查询结果封装在ResultSet对象中

        //5、处理SQL执行结果
        if (rs.next()) { //if判断，适用于查询的结果集中仅有一行记录
            String strname = rs.getString("username");
            String pwd = rs.getString("password");
            System.out.println("欢迎" + strname + "登录成功");

        } else {
            System.out.println("登录失败!");
        }

        //6、释放资源（倒着书写关闭功能）
        rs.close();
        stmt.close();
        conn.close();
    }
}
