package com.scs.web.space_soft1841.service;

import com.scs.web.space_soft1841.domain.entity.User;
import com.scs.web.space_soft1841.until.Result;

import java.sql.SQLException;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/2
 **/
public interface UserService {
    Result signUp(User user);

    Result deleteByMobile(String mobile);

    Result findUserByMobile(String mobile);

    Result updateUserById(User user);
}
