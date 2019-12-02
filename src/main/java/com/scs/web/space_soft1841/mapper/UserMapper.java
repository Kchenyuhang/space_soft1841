package com.scs.web.space_soft1841.mapper;

import com.scs.web.space_soft1841.domain.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/2
 **/
public interface UserMapper {

    @Insert("INSERT INTO t_user (mobile,password) VALUES (#{mobile},#{password})")
    void insert(User user)throws SQLException;

    @Select("SELECT * FROM t_user WHERE mobile = #{mobile}")
    User findUserByMobile(String mobile);

    @Select("SELECT * FROM t_user WHERE id = #{id}")
    User findUserById(int id);

    @Delete("DELETE FROM t_user WHERE id = #{id} ")
    void deleteById(int id)throws SQLException;

    @Delete("DELETE FROM t_user WHERE mobile = #{mobile} ")
    void deleteByMobile(String mobile)throws SQLException;

}
