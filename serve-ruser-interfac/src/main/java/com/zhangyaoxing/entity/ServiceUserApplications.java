package com.zhangyaoxing.entity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.zhangyaoxing.entity.mapper")
public class ServiceUserApplications {
    public static void main(String[] args) {
        SpringApplication.run(ServiceUserApplications.class,args);
    }
}
