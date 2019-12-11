package com.scs.web.space_soft1841.service;

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
    Result getLogByLogId(int logId);

    /**
     * 点赞功能的实现，通过log_like=log_like+1
     * @param logId
     * @return
     */
    Result updateLogLikeByLogId(int logId);
}
