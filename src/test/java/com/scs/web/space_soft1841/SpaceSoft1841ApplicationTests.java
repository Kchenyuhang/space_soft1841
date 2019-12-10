package com.scs.web.space_soft1841;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootTest(classes = SpaceSoft1841Application.class)
class SpaceSoft1841ApplicationTests {
    @Resource
    private DataSource dataSource;
    @Test
    void contextLoads() {
        System.out.println(this.dataSource);
    }

}