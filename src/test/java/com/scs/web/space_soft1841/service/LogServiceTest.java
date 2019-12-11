package com.scs.web.space_soft1841.service;

import com.scs.web.space_soft1841.SpaceSoft1841Application;
import com.scs.web.space_soft1841.domain.dto.LogDto;
import com.scs.web.space_soft1841.mapper.LogMapper;
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
    @Resource
    private LogMapper logMapper;

    @Test
    void getTopicByPage() throws SQLException {
        Result result = logService.selectLogByPage(1,5,2);
        System.out.println(result.getCode());
        System.out.println(result.getMsg());
        List<LogDto> maps = (List<LogDto>) result.getData();
        maps.forEach(log -> System.out.println(log));
    }

    @Test
    void selectByLogId() {
        Result result = logService.selectByLogId(2);
        List<Map> maps = (List<Map>) result.getData();
        maps.forEach(log -> System.out.println(log));
    }

    @Test
    void getLogByLogId(){
        System.out.println(logService.getLogByLogId(7));
    }

    @Test
    void updateLogLikeByLogId() {
        int first = logMapper.getLogByLogId(6).getLogLike();
        System.out.println(first);
        System.out.println("更改前："+first);
        logService.updateLogLikeByLogId(6,2);
        int second = logMapper.getLogByLogId(6).getLogLike();
        System.out.println("更改后："+second);

    }

    @Test
    void isLike() {
        System.out.println(logService.isLike(7,2));
    }

    @Test
    void deleteLike() {
        System.out.println(logService.deleteLogLike(2,2));
    }

    @Test
    void insertLike() {
        System.out.println(logService.insertLogLike(6,2));
    }

}