package com.jdbc.example.dao;

import com.jdbc.example.pojo.User;
import com.jdbc.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//数据访问层（和数据库交互）
public class UserDao {

    //登录
    public User login(User loginUser) {
        //声明User对象
        User user = null;
        //声明数据库相关API对象
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            //数据库连接(通过JdbcUtil)
            conn = JdbcUtil.getConnection();
            //编写SQL代码
            String sql = "select id,username,password from user where username=? and password=?";
            //执行SQL语句
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, loginUser.getUserName());
            pstmt.setString(2, loginUser.getPassword());
            rs = pstmt.executeQuery();

            //处理SQL执行结果
            if (rs != null && rs.next()) {
                //取出结果中的数据
                String username = rs.getString("username");
                int id = rs.getInt("id");
                String password = rs.getString("password");

                //把取出的数据，封装到User对象
                user = new User(id, username, password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //释放资源
            JdbcUtil.close(conn, pstmt, rs);
        }
        //返回
        return user;
    }

    //添加用户
    public int addUser(User user) {

        return 0;
    }

    //查询所有用户
    public List<User> findAllUser() {
        return null;
    }


    //删除用户
    public int deleteUser(User user) {


        return 0;
    }
}
