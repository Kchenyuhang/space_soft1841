package com.scs.web.space_soft1841.service;

import com.scs.web.space_soft1841.SpaceSoft1841Application;
import com.scs.web.space_soft1841.until.Md5;
import com.scs.web.space_soft1841.domain.entity.User;
import com.scs.web.space_soft1841.until.Result;
import com.scs.web.space_soft1841.until.ResultCode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.Date;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SpaceSoft1841Application.class)
class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    void signUp() {
        User user = new User();
        user.setMobile("13988882222");
        user.setPassword(Md5.MD5("111"));
        Result result = userService.signUp(user);
        System.out.println(result);
//        assertEquals(1,result.getCode());
    }

    @Test
    void deleteByMobile() {
        Result result = userService.deleteByMobile("13988882222");
        System.out.println(result);
    }

    @Test
    void findUserByMobile() {
        boolean a =userService.findUserByMobile("13013947768");
        System.out.println(a);
    }

    @Test
    void updateUser() {
        User user = new User();
        user.setUserId(24);
        user.setMobile("13013947768");
        user.setPassword("111");
        user.setNickname("测试");
        user.setEmail("测试");
        user.setAvatar("测试");
        user.setAddress("测试");
        user.setGender("测试");
        user.setIntroduction("测试");
        Result result = userService.updateUser(user);
        System.out.println(result);
    }

    @Test
    void findUser() {
        User user = new User();
        user.setMobile("13013947768");
        user.setPassword("111");
        Result result = userService.findUser(user);
        System.out.println(result);
    }

    @Test
    void insert() {
        User user = new User();
        user.setMobile("13012344444");
        user.setPassword(Md5.MD5("111"));
        user.setNickname("测");
        user.setEmail("测");
        user.setAvatar("测");
        user.setAddress("测");
        user.setGender("测");
        user.setIntroduction("测");
        user.setBirthday(new Date(2101-01-12));
        user.setCreateTime(LocalDateTime.now());
        Result result = userService.insert(user);
        System.out.println(result);
    }

    @Test
    void confirmRelationByMobile() {
       Result result =  userService.confirmRelationByMobile("13937241160","13921557438");
        System.out.println(result);
    }

    @Test
    void deleteRelationByMobile() {
        Result result = userService.deleteRelationByMobile("13937241160","13921557438");
        System.out.println(result);
    }
}