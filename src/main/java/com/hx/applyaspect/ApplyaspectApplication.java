package com.hx.applyaspect;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hx.applyaspect.mapper")
public class ApplyaspectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApplyaspectApplication.class, args);
    }

}
