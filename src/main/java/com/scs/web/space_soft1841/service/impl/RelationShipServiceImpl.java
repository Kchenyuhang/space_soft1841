package com.scs.web.space_soft1841.service.impl;

import com.scs.web.space_soft1841.domain.entity.Relationship;
<<<<<<< HEAD
import com.scs.web.space_soft1841.domain.entity.User;
import com.scs.web.space_soft1841.mapper.RelationShipMapper;
import com.scs.web.space_soft1841.mapper.UserMapper;
import com.scs.web.space_soft1841.service.RelationShipService;
import com.scs.web.space_soft1841.until.Result;
=======
import com.scs.web.space_soft1841.mapper.LogMapper;
import com.scs.web.space_soft1841.mapper.RelationShipMapper;
import com.scs.web.space_soft1841.service.RelationShipService;
import com.scs.web.space_soft1841.until.Result;
import com.scs.web.space_soft1841.until.ResultCode;
>>>>>>> origin/master
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> origin/master

/**
 * @ClassName RelationShipServiceImpl
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/12
 **/
@Service
public class RelationShipServiceImpl implements RelationShipService {
    private Logger logger = LoggerFactory.getLogger(RelationShipServiceImpl.class);
    @Resource
    private RelationShipMapper relationShipMapper;
<<<<<<< HEAD
    @Resource
    private UserMapper userMapper;

    @Override
    public Result confirmFriend(String reqMobile, String resMobile) {
        if (relationShipMapper.confirmFriend(reqMobile, resMobile) != null) {
            return Result.success();
        }
        return null;
=======
    @Override
    public Result updateStatus(String reqMobile, String resMobile) {
        if (relationShipMapper.updateStatue(reqMobile,resMobile)==1){
            return Result.success();
        }
        return Result.failure(ResultCode.RELATIONSHIP_UPDATE_STATUS);
    }

    @Override
    public Result deleteRelationship(String reqMobile, String resMobile) {
        if (relationShipMapper.deleteRelationship(reqMobile,resMobile)==1){
            return Result.success();
        }
        return Result.failure(ResultCode.DELETE_RELATIONSHIP);
>>>>>>> origin/master
    }
}