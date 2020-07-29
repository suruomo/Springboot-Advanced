package com.suruomo.springboot10mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot10MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot10MybatisApplication.class, args);
    }

}
