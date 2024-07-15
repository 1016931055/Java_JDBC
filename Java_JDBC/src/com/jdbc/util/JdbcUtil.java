package com.jdbc.util;

import java.sql.*;

//JDBC工具类（抽取并封装共性内容）
/*编写工具类：
  1、私有构造方法
  2、提供静态方法
*/
public class JdbcUtil {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    //数据库连接参数
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/db5";
    private static final String NAME = "root";
    private static final String PASSWORD = "itheima";

    //注册驱动（仅注册1次）
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //数据库连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, NAME, PASSWORD);
    }

    //释放资源
    public static void close(Connection conn, Statement stmt) {
        close(conn, stmt, null);//方法重用
    }
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
