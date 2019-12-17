package com.scs.web.space_soft1841.controller;

import com.scs.web.space_soft1841.service.RelationShipService;
import com.scs.web.space_soft1841.until.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName RelationshipController
 * @Description TODO
 * @Author yj_hou
 * @Date 2019/12/12
 **/
@RestController
@RequestMapping(value = "/api/relationship")
public class RelationshipController {
    @Resource
    private RelationShipService relationShipService;

    @PostMapping(value = "/search")
    public Result confirmFriend(@RequestParam String reqMobile,String resMobile){
        Result result = relationShipService.confirmFriend(reqMobile,resMobile);
        return result;
    }

    @PostMapping(value = "/request")
    public Result requestFriend(@RequestParam String reqMobile,String resMobile) {
        Result result = relationShipService.requestFriend(reqMobile, resMobile);
        return result;
    }

    @PostMapping(value = "/respone")
    public Result responeFriend(@RequestParam String reqMobile) {
        Result result = relationShipService.friendRequest(reqMobile);
        return result;
    }
    /**
     * 根据用户手机查询该用户所发送的所有好友请求（同意、拒绝和未处理）
     * @param reqMobile
     * @return
     */
    @PostMapping(value = "/select/request")
    public Result selectMyRequest(@RequestParam String reqMobile){
        Result result = relationShipService.selectMyRequest(reqMobile);
        return result;
    }

    /**
     * 根据用户mobile查询好友列表
     * @param mobile
     * @return
     */
    @PostMapping(value = "/select/friend")
    public Result selectFriend(@RequestParam String mobile){
        Result result = relationShipService.selectFriend(mobile);
        return result;
    }

    @PostMapping(value = "/status")
    public Result updateStatue(@RequestParam String reqMobile,String resMobile){
        Result result = relationShipService.updateStatus(reqMobile, resMobile);
        return result;
    }

    @PostMapping(value = "/delete")
    public Result deleteRelationship(@RequestParam String reqMobile,String resMobile){
        Result result = relationShipService.deleteRelationship(reqMobile, resMobile);
        return result;
    }
}
