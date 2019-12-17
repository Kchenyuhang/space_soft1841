package com.scs.web.space_soft1841.service;

import com.scs.web.space_soft1841.SpaceSoft1841Application;
import com.scs.web.space_soft1841.until.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = SpaceSoft1841Application.class)
class RelationShipServiceTest {
    @Resource
    private RelationShipService relationShipService;

    @Test
    void confirmFriend() {
        Result result = relationShipService.confirmFriend("13921557438","13937241160");
        System.out.println(result);
    }

    @Test
    void updateStatus() {
        Result result = relationShipService.updateStatus("13937241160", "13915754775");
        System.out.println(result);
    }

    @Test
    void deleteRelationship() {
        Result result = relationShipService.deleteRelationship("123", "123");
        System.out.println(result);
    }


    @Test
    void requestFriend() {
        Result result = relationShipService.requestFriend("13776877867","18032386185");
        System.out.println(result);
    }

    @Test
    void friendRequest() {
        Result result = relationShipService.friendRequest("13937241160");
        System.out.println(result);
    }
}