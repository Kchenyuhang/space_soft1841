package com.scs.web.space_soft1841.service;

import com.scs.web.space_soft1841.SpaceSoft1841Application;
import com.scs.web.space_soft1841.until.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SpaceSoft1841Application.class)
class LogServiceTest {
    @Resource
    private LogService logService;

    @Test
    void getTopicByPage() throws SQLException {
        Result result = logService.selectLogByPage(1,5);
        System.out.println(result.getCode());
        System.out.println(result.getMsg());
        List<Map> maps = (List<Map>) result.getData();
        maps.forEach(log -> System.out.println(log));
    }
}