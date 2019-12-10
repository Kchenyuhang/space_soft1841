package com.scs.web.space_soft1841;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.scs.web.space_soft1841.mapper")
@EnableSwagger2Doc
/**
 * Application
 */
public class SpaceSoft1841Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(SpaceSoft1841Application.class, args);
    }

}
