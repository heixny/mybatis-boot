package com.gec;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gec.mapper")
public class MybatisBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisBootApplication.class, args);
        System.out.println("+--------------------------------+");
        System.out.println("{SpringBootApp} ");
        System.out.println("Link: http://localhost:8082/");
        System.out.println("+--------------------------------+");
    }

}
