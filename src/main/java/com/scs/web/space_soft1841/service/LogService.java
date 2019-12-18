package com.scs.web.space_soft1841.service;

import com.scs.web.space_soft1841.domain.entity.Log;
import com.scs.web.space_soft1841.until.Result;

import java.sql.SQLException;

/**
 * @ClassName LogService
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/10
 **/
public interface LogService {
    /**
     * 分页查询专题
     * @param currentPage
     * @param pageSize
     * @param userId
     * @return
     */
    Result selectLogByPage(int currentPage,int pageSize,int userId);

    /**
     * 根据user_id和log_id查询该用户是否喜欢该log
     * @param logId
     * @param userId
     * @return
     */
    Result isLike(long logId,int userId);

    /**
     * 根据日志表log中的user_id查询到user表中的昵称 和 头像
     * @param id
     * @return
     */
    Result selectByLogId(long id);

    /**
     * 根据logId查询日志
     * @param logId
     * @return
     */
    Result getLogByLogId(long logId);

    /**
     * 点赞功能的实现，通过log_like=log_like+1
     * @param logId
     * @param userId
     * @return
     */
    Result updateLogLikeByLogId(long logId,int userId);

    /**
     * 点赞功能的实现，通过userId和logId删除t_likes中的数据
     * @param userId
     * @param logId
     * @return
     */
    Result deleteLogLike(int userId,long logId);

    /**
     * 点赞功能的实现，通过userId和logId增加t_likes中的数据
     * @param userId
     * @param logId
     * @return
     */
    Result insertLogLike(int userId,long logId);

    /**
     * 根据日志id和用户id 来删除日志表中的日志
     * @param logId
     * @param userId
     * @return
     */
    Result deleteLog(long logId,int userId);

    /**
     * 新增日志
     * @param log
     * @return
     */
    Result insertLog(Log log);
}
