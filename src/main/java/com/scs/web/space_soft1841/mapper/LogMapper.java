package com.scs.web.space_soft1841.mapper;

import com.scs.web.space_soft1841.domain.dto.LogDto;
import com.scs.web.space_soft1841.domain.entity.Log;
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

    /**根据文章创建时间降序查询
     * @param currentPage
     * @param pageSize
     * @param uerId
     * @return
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
    @Select("SELECT t1.*,t2.nickname,t2.avatar,t2.mobile FROM t_log t1 " +
            "LEFT JOIN t_user t2 " +
            "ON t1.user_id = t2.user_id ORDER BY log_createTime DESC LIMIT ${pageSize*(currentPage-1)},#{pageSize}")
    List<LogDto> selectByPage(int currentPage, int pageSize,int uerId);


    /**
     * 根据日志表log中的user_id查询到user表中的昵称 和 头像
     * @param userId
     * @return
     */
    @Select("SELECT t1.*,t2.nickname,t2.avatar,t2.mobile FROM t_log t1\n" +
            "LEFT JOIN t_user t2\n" +
            "ON t1.user_id = t2.user_id WHERE t1.user_id = #{userId} ORDER BY log_createTime DESC")
    List<Map> selectByLogId(long userId);

    /**
     * 根据logId查询日志
     * @param logId
     * @return
     */
    @Select("SELECT * FROM t_log WHERE log_id=#{logId}")
    Log getLogByLogId(long logId);

    /**
     * 根据user_id和log_id查询该用户是否喜欢该log
     * @param logId
     * @param userId
     * @return
     */
    @Select("SELECT * FROM t_likes WHERE log_id=#{logId} AND user_id=#{userId}")
    LogDto isLike(long logId, int userId);

    /**
     * 点赞功能的实现，通过log_like=log_like+1
     * @param logLike
     * @param logId
     * @return
     */
    @Update("UPDATE t_log SET log_like = #{logLike} WHERE log_id=#{logId}")
    int updateLogLikeByLogId(int logLike,long logId);

    /**
     * 点赞功能的实现，通过userId和logId删除t_likes中的数据
     * @param userId
     * @param logId
     * @return
     */
    @Delete("DELETE FROM t_likes WHERE user_id=#{userId} AND log_id=#{logId}")
    int deleteLogLike(int userId,long logId);

    /**
     * 点赞功能的实现，通过userId和logId增加t_likes中的数据
     * @param userId
     * @param logId
     * @return
     */
    @Insert("INSERT INTO t_likes (user_id,log_id) VALUES (#{userId},#{logId}) ")
    int insertLogLike(int userId,long logId);

    /**
     * 根据日志id和用户id 来删除日志表中的日志
     *
     * @param logId
     * @param userId
     * @return
     */
    @Delete("DELETE FROM t_log WHERE log_id = #{logId} AND user_id = #{userId}")
    int deleteLog(long logId, int userId);
}
