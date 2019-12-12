package com.scs.web.space_soft1841.mapper;

import com.scs.web.space_soft1841.SpaceSoft1841Application;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = SpaceSoft1841Application.class)
class RelationShipMapperTest {
    @Resource
    private RelationShipMapper relationShipMapper;
    @Test
    void updateStatue() {
        System.out.println(relationShipMapper.updateStatue("13921557438","13937241160"));
    }

    @Test
    void deleteRelationship() {
        System.out.println(relationShipMapper.deleteRelationship("123","123"));
    }
}