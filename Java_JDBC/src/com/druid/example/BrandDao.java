package com.druid.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//dao层
public class BrandDao {

    //查询所有
    public List<Brand> findAllBrand() throws Exception {
        //使用Properties读取配置文件
        Properties properties = new Properties();
        //加载并读取配置文件
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(is);
        //创建数据库连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //基于数据库连接池，获取一个Connection对象
        Connection conn = dataSource.getConnection();

        //编写sql语句
        String sql="select id, brand_name, company_name, ordered, description, status from tb_brand";
        //执行SQL语句
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        List<Brand> brandList = new ArrayList<>(); //集合对象
        //处理sql执行结果
        while(rs.next()){
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");

            //把取出的数据封装到Brand对象中
            Brand brand = new Brand(id,brandName,companyName,ordered,description,status);

            //把brand对象存储到集合中
            brandList.add(brand);
        }
        //释放资源
        rs.close();//存储在ResultSet对象中的查询结果全部消失了
        pstmt.close();
        conn.close();

        //返回存储商品品牌对象的集合
        return brandList;
    }






    //添加
    public int addBrand(Brand brand){
        return 0;
    }

    //修改
    public int updateBrand(Brand brand){
        return 0;
    }

    //删除
    public int deleteBrand(Brand brand){
        return 0;
    }

}
