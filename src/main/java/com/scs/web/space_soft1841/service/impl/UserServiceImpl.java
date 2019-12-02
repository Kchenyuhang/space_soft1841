package com.scs.web.space_soft1841.service.impl;

import com.scs.web.space_soft1841.domain.entity.User;
import com.scs.web.space_soft1841.mapper.UserMapper;
import com.scs.web.space_soft1841.service.UserService;
import com.scs.web.space_soft1841.until.Result;
import com.scs.web.space_soft1841.until.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/2
 **/
@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    private UserMapper userMapper;

    @Override
    public Result signUp(User user) {
        User user1 = userMapper.findUserByMobile(user.getMobile());
        if (user1 != null) {
            return Result.failure(ResultCode.USER_HAS_EXISTED);
        } else {
            try {
                userMapper.insert(user);
            } catch (SQLException e) {
                logger.error("新增用户出现异常");
                return Result.failure(ResultCode.USER_SIGN_UP_FAILURE_);
            }
            return Result.success();
        }
    }
}