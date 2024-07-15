package com.itheima.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DruidTest {
    @Test
    public void testDataSource() throws Exception {
        //读取配置文件
        Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("jdbc.properties"));
        //创建数据库连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //Connection对象是从数据库连接池中获取的
        Connection conn = dataSource.getConnection();


        //3、编写SQL语句
        String sql = "select id,username,password from user";

        //4、执行SQSL语句（把sql语句发送给数据库，数据库执行sql语句，并返回执行结果）
        PreparedStatement pstmt = conn.prepareStatement(sql);//数据库操作对象
        ResultSet rs = pstmt.executeQuery();

        //集合：存储User对象
        List<User> userList = new ArrayList<>();
        //5、处理sql语句执行结果
        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String pwd = rs.getString("password");

            //把取出的数据封装到User对象中
            User user = new User(id, username, pwd);

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
