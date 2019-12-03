package com.scs.web.space_soft1841.mapper;

import com.scs.web.space_soft1841.domain.entity.User;
import com.sun.org.apache.xpath.internal.objects.XString;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/2
 **/
public interface UserMapper {
    /**
     * 根据手机号(mobile)，密码(password)，昵称(nickname)，邮箱(email)，头像(avatar)，地址(address)，
     * 性别(gender)，介绍(introduction)，生日(birthday)，创建时间(createTime)等新增用户
     * @param user
     * @throws SQLException
     */
    @Insert("INSERT INTO t_user (mobile,password,nickname,email,avatar,address,gender,introduction,birthday,create_time) " +
            "VALUES (#{mobile},#{password},#{nickname},#{email},#{avatar},#{address},#{gender},#{introduction},#{birthday},#{createTime})")
    void insert(User user)throws SQLException;

    /**
     * 根据手机号查询用户信息，用于：验证登录，获取用户信息
     * @param mobile
     * @return
     */
    @Select("SELECT * FROM t_user WHERE mobile = #{mobile}")
    User findUserByMobile(String mobile);
//    @Select("SELECT * FROM t_user WHERE id = #{id}")
//    User findUserById(int id);

//    @Delete("DELETE FROM t_user WHERE id = #{id} ")
//    void deleteById(int id)throws SQLException;
    /**
     * 根据手机号注销用户
     * @param mobile
     * @throws SQLException
     */
    @Delete("DELETE FROM t_user WHERE mobile = #{mobile} ")
    void deleteByMobile(String mobile)throws SQLException;

    /**
     * 根据是否有双方手机号关系来判断双方是否为好友
     * mobile1->mobile2存在，mobile2是mobile1好友
     * 若mobile1删除mobile2,则只删除mobile1->mobile2
     * @param mobile1
     * @param mobile2
     * @return 1,0
     */
    @Select("SELECT * FROM t_relationship WHERE mobile1 =#{mobile1} AND mobile2=#{mobile2}")
    int confirmRelationByMobile(String mobile1,String mobile2);

    /**
     * 单方面删除
     * 根据手机号来删除mobile1的好友mobile2
     * @param mobile1
     * @param mobile2
     * @return 1,0
     */
    @Delete("DELETE  FROM t_relationship WHERE mobile1 =#{mobile1} AND mobile2=#{mobile2}")
    int deleteRelationByMobile(String mobile1,String mobile2);

    /**
     * 修改用户个人信息
     * @param user
     */
    @Update({"UPDATE t_user SET avatar=#{avatar},gender=#{gender},address=#{address}," +
            "nickname=#{nickname},password=#{password},introduction=#{introduction},email=#{email}," +
            "birthday=#{birthday},mobile=#{mobile} WHERE user_id=#{userId}"})
    void updateUserById(User user);

    /**
     * 查询用户手机号 和密码 进行登录功能
     * @param user
     * @return boolean
     */
    @Select("SELECT * FROM t_user WHERE mobile = #{mobile} and password=#{password}")
    boolean findUser(User user);
}
