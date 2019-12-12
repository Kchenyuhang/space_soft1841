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
     * 查询是否已经为好友,查询你的好友列表
     * @param reqMobile
     * @param resMobile
     * @return
     */
    Result confirmFriend(String reqMobile,String resMobile);
}
