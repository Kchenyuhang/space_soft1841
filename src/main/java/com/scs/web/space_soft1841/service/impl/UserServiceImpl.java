package com.scs.web.space_soft1841.service.impl;

import com.scs.web.space_soft1841.domain.entity.User;
import com.scs.web.space_soft1841.mapper.LogMapper;
import com.scs.web.space_soft1841.mapper.UserMapper;
import com.scs.web.space_soft1841.service.UserService;
import com.scs.web.space_soft1841.until.AliOSSUtil;
import com.scs.web.space_soft1841.until.Md5;
import com.scs.web.space_soft1841.until.Result;
import com.scs.web.space_soft1841.until.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public Result register(User user) {
        User user1 = userMapper.findUserByMobile(user.getMobile());
        if (user1 != null) {
            return Result.failure(ResultCode.USER_HAS_EXISTED);
        } else {
            try {
                user.setPassword(Md5.MD5(user.getPassword()));
                userMapper.register(user);
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
    public Result updateUser(User user) {
        userMapper.updateUser(user);
        return Result.success();
    }

    @Override
    public Result updatePassword(String mobile, String password) {
        if (userMapper.updatePassword(mobile, Md5.MD5(password)) == 1) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.UPDATE_PASSWORD_FAILURE);
        }

    }

    @Override
    public List<User> userLogin(String mobile, String password) {
        return userMapper.userLogin(mobile, Md5.MD5(password));
    }

    @Override
    public List<User> findQueryMobile(String mobile) {
        List<User> list = new ArrayList<>();
        list = userMapper.findQueryMobile(mobile);
        return list;
    }

    @Override
    public List<User> selectUserAllById(Integer userId) {
        List<User> list = new ArrayList<>();
        list = userMapper.selectUserAllById(userId);
        return list;
    }

    @Override
    public Result updateAvatarByUserId(MultipartFile file, int userId) {
        String url = (String) AliOSSUtil.upload(file).getData();
        int n = userMapper.updateAvatarByUserId(url,userId);
        User user = new User();
        user.setAvatar(url);
        if (n==1){
            return Result.success(user);
        }
        return Result.failure(ResultCode.USER_UPDATE_AVATAR_FAILURE);
    }

}