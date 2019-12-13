package com.scs.web.space_soft1841.mapper;

import com.scs.web.space_soft1841.SpaceSoft1841Application;
import com.scs.web.space_soft1841.domain.dto.LogDto;
import com.scs.web.space_soft1841.domain.entity.Log;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = SpaceSoft1841Application.class)
class LogMapperTest {
    @Resource
    private LogMapper logMapper;

    @Test
    void selectByPage() {
        List<LogDto> maps = logMapper.selectByPage(1,5,2);
        maps.forEach(log -> System.out.println(log.getLogLike()));
    }

    @Test
    void selectByLogId() {
        List<Map> mapList = logMapper.selectByLogId(2);
        mapList.forEach(log-> System.out.println(log));
    }

    @Test
    void getLogByLogId(){
        System.out.println(logMapper.getLogByLogId(6));
    }

    @Test
    void isLike() {
        System.out.println(logMapper.isLike(7L,2));
    }

    @Test
    void insertLike(){
        System.out.println(logMapper.insertLogLike(6,2));
    }

    @Test
    void updateLike() {
        logMapper.updateLogLikeByLogId(6,2);
    }

    @Test
    void deleteLog() {
        System.out.println(logMapper.deleteLog(6, 5));
    }

}