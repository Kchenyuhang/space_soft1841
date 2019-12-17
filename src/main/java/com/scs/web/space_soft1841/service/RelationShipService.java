package com.scs.web.space_soft1841.service;

import com.scs.web.space_soft1841.until.Result;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RelationShipService
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/12
 **/
public interface RelationShipService {

    /**
     * 查询是否已经为好友
     * @param reqMobile
     * @param resMobile
     * @return
     */
    Result confirmFriend(String reqMobile,String resMobile);

    /**
     * 发送好友请求
     * @param reqMobile
     * @param resMobile
     * @return
     */
    Result requestFriend(String reqMobile,String resMobile);

    /**
     * 通过删除记录来拒绝添加好友的请求
     * @param reqMobile
     * @param resMobile
     * @return
     */
    Result deleteRelationship(String reqMobile,String resMobile);

    /**
     * 同意添加好友请求
     * @param reqMobile
     * @param resMobile
     * @return
     */
    Result updateStatus(String reqMobile,String resMobile);

    /**
     * 我的请求消息，根据状态升序排列
     * @param resMobile
     * @return
     */
    Result friendRequest(String resMobile);

}
