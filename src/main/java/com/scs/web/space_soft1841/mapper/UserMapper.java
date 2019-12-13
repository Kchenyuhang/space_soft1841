package com.scs.web.space_soft1841.mapper;

import com.scs.web.space_soft1841.domain.entity.User;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/2
 **/
public interface UserMapper {
    /**
     * 密码(password),创建时间(createTime)等新增用户
     *
     * @param user
     * @throws SQLException
     */
    @Insert("INSERT INTO t_user(mobile,password,create_time) VALUES (#{mobile},#{password},#{createTime})")
    void register(User user) throws SQLException;

    /**
     * 根据手机号查询用户信息，用于：验证登录，获取用户信息
     *
     * @param mobile
     * @return
     */
    @Select("SELECT * FROM t_user WHERE mobile = #{mobile}")
    User findUserByMobile(String mobile);

    /**
     * 根据手机号注销用户
     *
     * @param mobile
     * @throws SQLException
     */
    @Delete("DELETE FROM t_user WHERE mobile = #{mobile} ")
    void deleteByMobile(String mobile) throws SQLException;

    /**
     * 根据是否有双方手机号关系来判断双方是否为好友
     * mobile1->mobile2存在，mobile2是mobile1好友
     * 若mobile1删除mobile2,则只删除mobile1->mobile2
     *
     * @param mobile1
     * @param mobile2
     * @return 1, 0
     */
    @Select("SELECT * FROM t_relationship WHERE mobile1 =#{mobile1} AND mobile2=#{mobile2}")
    int confirmRelationByMobile(String mobile1, String mobile2);

    /**
     * 单方面删除
     * 根据手机号来删除mobile1的好友mobile2
     *
     * @param mobile1
     * @param mobile2
     * @return 1, 0
     */
    @Delete("DELETE  FROM t_relationship WHERE mobile1 =#{mobile1} AND mobile2=#{mobile2}")
    int deleteRelationByMobile(String mobile1, String mobile2);

    /**
     * 修改用户个人信息
     *
     * @param user
     */
    @Update({"UPDATE t_user SET avatar=#{avatar},gender=#{gender},address=#{address}," +
            "nickname=#{nickname},introduction=#{introduction},email=#{email}," +
            "birthday=#{birthday} WHERE user_id=#{userId}"})
    void updateUser(User user);

    /**
     * 修改密码、重置密码、找回密码、忘记密码
     *
     * @param mobile
     * @param password
     * @return int
     */
    @Update({"UPDATE t_user SET password=#{password} WHERE mobile=#{mobile}"})
    int updatePassword(String mobile, String password);

    /**
     * 查询用户手机号 和密码 进行登录功能
     *
     * @param mobile
     * @param password
     * @return user
     */
    @Select("SELECT * FROM t_user WHERE mobile = #{mobile} AND password=#{password}")
    List<User> userLogin(String mobile, String password);

    /**
     * 用户登入进去之后 把昵称和头像带过去。
     *
     * @param mobile
     * @return
     */
    @Select("SELECT nickname,avatar FROM t_user WHERE mobile = #{mobile}")
    List<User> findQueryMobile(String mobile);

    /**
     * 根据用户Id查询
     *
     * @param userId
     * @return
     */
    @Select("SELECT * FROM t_user WHERE user_id = #{userId}")
    List<User> selectUserAllById(Integer userId);

    /**
     * 更改用户头像，头像地址为本地图片上传到阿里云返回的的地址
     *
     * @param avatar
     * @param userId
     * @return
     */
    @Update("UPDATE t_user SET avatar=#{avatar} WHERE user_id=#{userId}")
    int updateAvatarByUserId(String avatar, int userId);



}
