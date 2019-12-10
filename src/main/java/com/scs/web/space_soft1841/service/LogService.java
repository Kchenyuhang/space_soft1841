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
     * @return
     */
    Result selectLogByPage(int currentPage,int pageSize);

    /**
     * 根据log_id查询log
     * @param logId
     * @return
     */
    Result getByLogId(int logId);

    Result updateLogLikeByLogId(int logId);

}
