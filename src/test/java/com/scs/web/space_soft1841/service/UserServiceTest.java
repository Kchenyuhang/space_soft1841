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
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = SpaceSoft1841Application.class)
class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    void register() {
        User user = new User();
        user.setMobile("121233");
        user.setPassword(Md5.MD5("111"));
        user.setCreateTime(LocalDateTime.now());
        userService.register(user);
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
        user.setMobile("18932386185");
        user.setPassword(Md5.MD5("222"));
        user.setNickname("测试");
        user.setEmail("1797262364@qq.com");
        user.setAvatar("测试");
        user.setAddress("测试");
        user.setGender("男");
        user.setIntroduction("测试");
        user.setBirthday(Date.valueOf("2000-10-10"));
        Result result = userService.updateUser(user);
        System.out.println(result);
    }

    @Test
    void confirmRelationByMobile() {
        boolean result =  userService.confirmRelationByMobile("13937241160","13921557438");
        System.out.println(result);
    }

    @Test
    void deleteRelationByMobile() {
        Result result = userService.deleteRelationByMobile("13937241160","13921557438");
        System.out.println(result);
    }

    @Test
    void userLogin() {
        String mobile = "18932386185";
        String password = "222";
        List<User> userList = userService.userLogin(mobile,password);
        System.out.println(userList);
    }

    @Test
    void findQueryMobile() {
        List<User> list = new ArrayList<>();
        list = userService.findQueryMobile("13921557438");
        System.out.println(list);
    }

    @Test
    void selectUserAllById() {
        List<User> list = new ArrayList<>();
        list = userService.selectUserAllById(3);
        System.out.println(list);
    }
}