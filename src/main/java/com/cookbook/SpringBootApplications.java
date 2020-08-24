package com.cookbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.cookbook.dao.backstageDao")
public class SpringBootApplications{
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplications.class,args);
    }
}
