package com.scs.web.space_soft1841.service;

import com.scs.web.space_soft1841.until.Result;
<<<<<<< HEAD
import org.springframework.stereotype.Service;

import java.util.List;
=======
>>>>>>> origin/master

/**
 * @ClassName RelationShipService
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/12
 **/
public interface RelationShipService {
<<<<<<< HEAD

    /**
     * 查询是否已经为好友,查询你的好友列表
=======
    /**
     * 处理加好友时候的请求
     * @param reqMobile
     * @param resMobile
     * @return
     */
    Result updateStatus(String reqMobile,String resMobile);

    /**
     * 通过删除记录来拒绝添加好友的请求
>>>>>>> origin/master
     * @param reqMobile
     * @param resMobile
     * @return
     */
<<<<<<< HEAD
    Result confirmFriend(String reqMobile,String resMobile);
=======
    Result deleteRelationship(String reqMobile,String resMobile);
>>>>>>> origin/master
}
