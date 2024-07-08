package com.jdbc.example.web;


import com.jdbc.example.pojo.User;
import com.jdbc.example.service.UserService;
import org.junit.Test;

//web层： 接收客户端发送的数据 -> 数据封装为对象 -> 调用service层方法 ->基于service层方法执行结果给客户回馈
//模拟：web层
public class LoginTest {

    @Test
    public void login() {
        //模拟：客户端发送过来的数据
        String loginName = "admin";//用户名
        String loginPassword = "123123";//密码

        //把数据封装为对象
        User loginUser = new User();
        loginUser.setUserName(loginName);
        loginUser.setPassword(loginPassword);

        //调用service层方法
        UserService userService = new UserService();//实例化service层对象
        boolean loginResult = userService.userLogin(loginUser);

        //基于service层方法执行结果给客户回馈
        if(loginResult){
            System.out.println("给客户端回馈：登录成功");
        }else{
            System.out.println("给客户端回馈：登录失败");
        }
    }
}
