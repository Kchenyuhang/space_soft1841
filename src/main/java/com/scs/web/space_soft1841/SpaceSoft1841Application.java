package com.scs.web.space_soft1841;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.scs.web.space_soft1841.mapper")
@EnableSwagger2Doc
/**
 *
 */

public class SpaceSoft1841Application {
    public static void main(String[] args) {
        SpringApplication.run(SpaceSoft1841Application.class, args);
    }

}
