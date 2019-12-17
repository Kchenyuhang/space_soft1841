package com.scs.web.space_soft1841.mapper;

import com.scs.web.space_soft1841.SpaceSoft1841Application;
import com.scs.web.space_soft1841.domain.entity.Relationship;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@SpringBootTest(classes = SpaceSoft1841Application.class)
class RelationShipMapperTest {
    @Resource
    private RelationShipMapper relationShipMapper;

    @Test
    void confirmFriend() {
        String reqMobile = "13921557438";
        String resMobile = "13937241160";
        System.out.println(relationShipMapper.confirmFriend(reqMobile, resMobile));
    }
    @Test
    void updateStatue() {
        System.out.println(relationShipMapper.updateStatue("13921557438","13937241160"));
    }

    @Test
    void deleteRelationship() {
        System.out.println(relationShipMapper.deleteRelationship("123","123"));
    }

    @Test
    void requestFriend() {
        System.out.println(relationShipMapper.requestFriend("18932386185","18851697959"));
    }

    @Test
    void friendsRequest() {
        List<Map> list = relationShipMapper.friendsRequest("13937241160");
        System.out.println(list);
    }
}