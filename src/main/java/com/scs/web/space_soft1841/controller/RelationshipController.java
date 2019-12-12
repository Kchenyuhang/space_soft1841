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
