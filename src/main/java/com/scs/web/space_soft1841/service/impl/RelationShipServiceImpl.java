package com.scs.web.space_soft1841.service.impl;

import com.scs.web.space_soft1841.domain.entity.Relationship;

import com.scs.web.space_soft1841.domain.entity.User;
import com.scs.web.space_soft1841.domain.vo.RelationShipVO;
import com.scs.web.space_soft1841.mapper.RelationShipMapper;
import com.scs.web.space_soft1841.mapper.UserMapper;
import com.scs.web.space_soft1841.service.RelationShipService;
import com.scs.web.space_soft1841.until.Result;

import com.scs.web.space_soft1841.until.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


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

    @Resource
    private UserMapper userMapper;

    @Override
    public Result confirmFriend(String reqMobile, String resMobile) {
        List<Relationship> relationshipList;
        relationshipList = relationShipMapper.confirmFriend(reqMobile, resMobile);
        User user = userMapper.findUserByMobile(resMobile);
        if (relationshipList.size() != 0) {
            if (relationshipList.get(0).getStatus().equals(1)) {
                return Result.success(user);
            } else {
                return Result.failure(ResultCode.REQUEST_FRIEND, user);
            }
        } else {
            return Result.failure(ResultCode.CONFIRM_FRIEND_NOT_ADD, user);
        }
    }

    @Override
    public Result requestFriend(String reqMobile, String resMobile) {
        if (relationShipMapper.requestFriend(reqMobile, resMobile) == 1) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.REQUEST_FRIEND_FAILURE);
        }
    }

    @Override
    public Result updateStatus(String reqMobile, String resMobile) {
        if (relationShipMapper.updateStatue(reqMobile, resMobile) == 1) {
            return Result.success();
        }
        return Result.failure(ResultCode.RELATIONSHIP_UPDATE_STATUS);
    }

    @Override
    public Result selectMyRequest(String reqMobile) {
        List<Relationship> relationshipList;
        relationshipList = relationShipMapper.selectMyRequest(reqMobile);
        if (relationShipMapper.selectMyRequest(reqMobile).size() != 0) {
            return Result.success(relationshipList);
        } else {
            return Result.failure(ResultCode.SELECT_REQUEST_FRIEND_FAILURE);
        }
    }

    @Override
    public Result deleteRelationship(String reqMobile, String resMobile) {
        if (relationShipMapper.deleteRelationship(reqMobile, resMobile) == 1) {
            return Result.success();
        }
        return Result.failure(ResultCode.DELETE_RELATIONSHIP);

    }
}