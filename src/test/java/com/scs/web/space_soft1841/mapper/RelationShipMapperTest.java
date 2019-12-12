package com.scs.web.space_soft1841.mapper;

import com.scs.web.space_soft1841.SpaceSoft1841Application;
<<<<<<< HEAD
import com.scs.web.space_soft1841.domain.entity.Relationship;
=======
>>>>>>> origin/master
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
<<<<<<< HEAD
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
=======
>>>>>>> origin/master

@SpringBootTest(classes = SpaceSoft1841Application.class)
class RelationShipMapperTest {
    @Resource
    private RelationShipMapper relationShipMapper;
<<<<<<< HEAD

    @Test
    void confirmFriend() {
        String reqMobile = "13921557438";
        String resMobile = "13937241160";
        List<Relationship> relationshipList = relationShipMapper.confirmFriend(reqMobile,resMobile);
        System.out.println(relationshipList);
=======
    @Test
    void updateStatue() {
        System.out.println(relationShipMapper.updateStatue("13921557438","13937241160"));
    }

    @Test
    void deleteRelationship() {
        System.out.println(relationShipMapper.deleteRelationship("123","123"));
>>>>>>> origin/master
    }
}