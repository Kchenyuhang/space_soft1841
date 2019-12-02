package com.scs.web.space_soft1841.mapper;

import com.scs.web.space_soft1841.SpaceSoft1841Application;
import com.scs.web.space_soft1841.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SpaceSoft1841Application.class)
class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    void insert() throws SQLException {
        User user = new User();
        user.setMobile("13988887777");
        user.setPassword("111");
        userMapper.insert(user);
    }

    @Test
    void findUserByMobile() {
        User user = userMapper.findUserByMobile("13988887777");
        System.out.println(user);
    }
}