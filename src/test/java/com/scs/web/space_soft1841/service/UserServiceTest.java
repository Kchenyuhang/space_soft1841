package com.scs.web.space_soft1841.service;

import com.scs.web.space_soft1841.SpaceSoft1841Application;
import com.scs.web.space_soft1841.controller.Md5;
import com.scs.web.space_soft1841.domain.entity.User;
import com.scs.web.space_soft1841.until.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

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
        Result result = userService.findUserByMobile("13932330575");
        System.out.println(result);
    }
}