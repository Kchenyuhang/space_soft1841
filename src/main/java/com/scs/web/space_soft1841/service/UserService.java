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
    /**
     * 判断是否有改用户
     * @param user
     * @return
     */
    Result signUp(User user);

    /**
     * 根据手机号注销账号
     * @param mobile
     * @return
     */
    Result deleteByMobile(String mobile);

    /**
     * 根据手机号查询用户
     * @param mobile
     * @return
     */
    boolean findUserByMobile(String mobile);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    Result updateUser(User user);

}
