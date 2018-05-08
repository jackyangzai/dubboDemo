package com.wonder;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class BeginProvider {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring/dubbo-service.xml","spring/spring-mybatis.xml");
        context.start();
        System.out.println("服务已经开启");
        System.in.read();
    }
}
