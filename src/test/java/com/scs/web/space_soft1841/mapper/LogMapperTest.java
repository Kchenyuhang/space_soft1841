package com.scs.web.space_soft1841.mapper;

import com.scs.web.space_soft1841.SpaceSoft1841Application;
import com.scs.web.space_soft1841.domain.entity.Log;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = SpaceSoft1841Application.class)
class LogMapperTest {
    @Resource
    private LogMapper logMapper;

    @Test
    void selectByPage() {
        List<Map> maps = logMapper.selectByPage(1,5);
        maps.forEach(log -> System.out.println(log));
    }

    @Test
    void selectByLogId() {
        Log log = logMapper.getByLogId(6);
        System.out.println(log.getLogLike());
    }
}