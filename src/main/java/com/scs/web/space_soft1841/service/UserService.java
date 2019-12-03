package com.scs.web.space_soft1841.service;

import com.scs.web.space_soft1841.domain.entity.User;
import com.scs.web.space_soft1841.until.Result;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/2
 **/
public interface UserService {
    /**
     *
     * @param user
     * @return
     */
    Result signUp(User user);

    /**
     * 通过手机号码注销用户
     * @param mobile
     * @return
     */
    Result deleteByMobile(String mobile);

    /**
     * 根据手机号查询用户信息，用户验证登录
     * @param mobile
     * @return
     */
    Result findUserByMobile(String mobile);

    /**
     * 修改用户个人信息
     * @param user
     * @return
     */
    Result updateUser(User user);

    /**
     * 根据手机号和密码进行登录验证
     * @param user
     * @return
     */
    Result findUser(User user);

    /**
     * 新增用户信息
     * @param user
     * @return
     */
    Result insert(User user);

    /**
     * 根据双方是否有手机号来判断是否之间为好友
     * @param mobile1
     * @param mobile2
     * @return
     */
    Result confirmRelationByMobile(String mobile1,String mobile2);

}
