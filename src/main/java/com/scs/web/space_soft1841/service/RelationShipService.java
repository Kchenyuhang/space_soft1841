package com.scs.web.space_soft1841.service;

import com.scs.web.space_soft1841.until.Result;

/**
 * @ClassName RelationShipService
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/12
 **/
public interface RelationShipService {
    /**
     * 处理加好友时候的请求
     * @param reqMobile
     * @param resMobile
     * @return
     */
    Result updateStatus(String reqMobile,String resMobile);

    /**
     * 通过删除记录来拒绝添加好友的请求
     * @param reqMobile
     * @param resMobile
     * @return
     */
    Result deleteRelationship(String reqMobile,String resMobile);
}
