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

    @Override
    public Result deleteByMobile(String mobile) {
        User user = userMapper.findUserByMobile(mobile);
        if (user != null) {
            try {
                userMapper.deleteByMobile(mobile);
            } catch (SQLException e) {
                logger.error("注销用户账号出现异常");
                return Result.failure(ResultCode.USER_DELETE_FAILURE_);
            }
        }
        return Result.success();
    }

    @Override
    public boolean findUserByMobile(String mobile) {
        User user = userMapper.findUserByMobile(mobile);
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Result updateUser(User user) {
        userMapper.updateUser(user);
        return Result.success();
    }

    @Override
    public boolean confirmRelationByMobile(String mobile1, String mobile2) {
        if (userMapper.confirmRelationByMobile(mobile1, mobile2) == 0) {
            return false;
        }
        return true;
    }

    @Override
    public Result deleteRelationByMobile(String mobile1, String mobile2) {
        if (userMapper.deleteRelationByMobile(mobile1, mobile2) == 1) {
            return Result.success();
        }
        return Result.failure(ResultCode.USER_DELETE_FAILURE_);
    }

    @Override
    public Result login(User user) {
        Result result = Result.success(userMapper.login(user));
        if (result.getCode()==1){
            return Result.success(user.getMobile());
        } else {
            return Result.failure(ResultCode.USER_LOGIN_FAIL);
        }

    }
}