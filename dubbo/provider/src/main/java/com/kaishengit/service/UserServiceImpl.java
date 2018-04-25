package com.kaishengit.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class UserServiceImpl implements UserService {


    public String getUserName(Integer id) {
        if(id == 1){
          return "成功";
        }
        return "失败";
    }
}


class test{
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-dubbo.xml");
        classPathXmlApplicationContext.start();

        System.out.println("加载完毕");
        System.in.read();

    }
}