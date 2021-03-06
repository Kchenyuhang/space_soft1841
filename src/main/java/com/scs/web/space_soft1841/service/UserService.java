package com.scs.web.space_soft1841.service;

import com.scs.web.space_soft1841.domain.entity.User;
import com.scs.web.space_soft1841.until.Result;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/2
 **/
public interface UserService {
    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    Result register(User user);

    /**
     * 根据手机号注销账号
     *
     * @param mobile
     * @return
     */
    Result deleteByMobile(String mobile);

    /**
     * 根据手机号查询用户
     *
     * @param mobile
     * @return
     */
    boolean findUserByMobile(String mobile);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    Result updateUser(User user);

    /**
     * 修改密码、重置密码、找回密码、忘记密码
     * @param mobile
     * @param password
     * @return
     */
    Result updatePassword(String mobile,String password);

    /**
     * 确定好友关系
     *
     * @param mobile1
     * @param mobile2
     * @return
     */
    boolean confirmRelationByMobile(String mobile1, String mobile2);

    /**
     * 删除好友关系
     *
     * @param mobile1
     * @param mobile2
     * @return
     */
    Result deleteRelationByMobile(String mobile1, String mobile2);

    /**
     * 用户登录
     *
     * @param mobile
     * @param password
     * @return
     */
    List<User> userLogin(String mobile, String password);

    /**
     * 登入进去之后 把头像和昵称传过去
     *
     * @param mobile
     * @return
     */
    List<User> findQueryMobile(String mobile);

    /**
     * 通过用户id查询所有
     *
     * @param userId
     * @return
     */
    List<User> selectUserAllById(Integer userId);

    /**
     * 更改用户头像，头像地址为本地图片上传到阿里云返回的的地址
     * @param file
     * @param userId
     * @return
     */
    Result updateAvatarByUserId(MultipartFile file, int userId);

}
