package com.zwgangel.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zwgangel.www.mapper")
public class WechatByVideoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatByVideoApplication.class, args);
    }

}
