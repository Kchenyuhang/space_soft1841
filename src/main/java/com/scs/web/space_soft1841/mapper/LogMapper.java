package com.scs.web.space_soft1841.mapper;

import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


/**
 * @ClassName TopicMapper
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/10
 **/
public interface LogMapper {
    /**
     *根据文章创建时间降序查询
     * @param currentPage
     * @param pageSize
     * @return List<Map>
     * @throws SQLException
     */
    @Results(id = "log",value = {
            @Result(property = "logId",column = "log_id"),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "logName",column = "log_name"),
            @Result(property = "logLike",column = "log_like"),
            @Result(property = "logCover",column = "log_cover"),
            @Result(property = "logContent",column = "log_content"),
            @Result(property = "logCreateTime",column = "log_createTime"),
            @Result(property = "nickname",column = "nickname"),
            @Result(property = "avatar",column = "avatar")
    })
    @Select("SELECT t1.*,t2.nickname,t2.avatar FROM t_log t1 " +
            "LEFT JOIN t_user t2 " +
            "ON t1.user_id = t2.user_id ORDER BY log_createTime DESC LIMIT ${pageSize*(currentPage-1)},#{pageSize}")
    List<Map> selectByPage(int currentPage,int pageSize);


    /**
     * 根据日志表log中的user_id查询到user表中的昵称 和 头像
     */
    @Select("SELECT t1.*,t2.nickname,t2.avatar FROM t_log t1\n" +
            "LEFT JOIN t_user t2\n" +
            "ON t1.user_id = t2.user_id WHERE t1.user_id = #{userId}")
    List<Map> selectBylogId(long userId);
}
