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
     * 根据日志表log中的user_id查询到user表中的昵称 和 头像
     * @param id
     * @return
     */
    Result selectBylogId(long id);
}
