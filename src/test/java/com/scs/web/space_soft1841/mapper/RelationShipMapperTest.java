package com.scs.web.space_soft1841.mapper;

import com.scs.web.space_soft1841.SpaceSoft1841Application;
import com.scs.web.space_soft1841.domain.entity.Relationship;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SpaceSoft1841Application.class)
class RelationShipMapperTest {
    @Resource
    private RelationShipMapper relationShipMapper;

    @Test
    void confirmFriend() {
        String reqMobile = "13921557438";
        String resMobile = "13937241160";
        List<Relationship> relationshipList = relationShipMapper.confirmFriend(reqMobile,resMobile);
        System.out.println(relationshipList);
    }
}