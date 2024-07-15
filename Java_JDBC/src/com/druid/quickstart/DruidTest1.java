package com.druid.quickstart;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DruidTest1 {

    //要使用Druid连接池，需要： 导入druid.jar文件
    @Test
    public void testDruid() throws Exception {
        //创建Properties对象（读取druid配置文件）
        Properties prop = new Properties();
        //读取配置文件，并把读取的配置参数存储到Propeties对象中
        prop.load(new FileInputStream("druid.properties"));

        //利用Druid工厂类，获取数据库连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //从连接池中，获取一个Connection对象
        Connection conn = dataSource.getConnection();

        //编写SQL语句
        String sql="select id,username as name,password from user";

        //执行SQL
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        //处理sql执行结果
        while(rs.next()){
            System.out.print(rs.getInt("id")+"\t");
            System.out.print(rs.getString("name")+"\t");
            System.out.println(rs.getString("password"));
            System.out.println("----------------------------------------");
        }

        //释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }

}
