package com.scs.web.space_soft1841.mapper;

import com.scs.web.space_soft1841.SpaceSoft1841Application;
import com.scs.web.space_soft1841.until.Md5;
import com.scs.web.space_soft1841.domain.entity.User;
import com.scs.web.space_soft1841.until.Result;
import com.scs.web.space_soft1841.until.ResultCode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = SpaceSoft1841Application.class)
class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    void register() throws SQLException {
        User user = new User();
        user.setMobile("123456");
        user.setPassword("111");
        user.setCreateTime(LocalDateTime.now());
        userMapper.register(user);
    }

    @Test
    void findUserByMobile() {
        System.out.println(userMapper.findUserByMobile("18061752267") != null);
    }

    @Test
    void deleteByMobile() throws SQLException {
        userMapper.deleteByMobile("13917310803");
    }

    @Test
    void confirmRelationByMobile() {
        if (userMapper.confirmRelationByMobile("13917310803", "13937241160") != 0) {
            System.out.println(Result.success());
        } else {
            System.out.println(Result.failure(ResultCode.USER_CONFIRM_FAILURE_));
        }
    }

    @Test
    void deleteRelationByMobile() {
        int n = userMapper.deleteRelationByMobile("13983862268", "13917310803");
        System.out.println(n);
    }

    @Test
    void updateUserById() {
        User user = new User();
        user.setUserId(24);
        user.setMobile("18932386185");
        user.setPassword(Md5.MD5("111"));
        user.setNickname("测试");
        user.setEmail("测试");
        user.setAvatar("测试");
        user.setAddress("测试");
        user.setGender("测试");
        user.setIntroduction("测试");
        user.setBirthday(Date.valueOf("1999-12-14"));
        userMapper.updateUser(user);
    }

    @Test
    void userLogin() {
        String mobile= "18932386185";
        String password = Md5.MD5("111");
        userMapper.userLogin(mobile,password);
    }

    @Test
    void findQueryMobile() {
        List<User> list = userMapper.findQueryMobile("13937241160");
        System.out.println(list);
    }

    @Test
    void selectUserAllById() {
        List<User> list = userMapper.selectUserAllById(2);
        System.out.println(list);
    }
}