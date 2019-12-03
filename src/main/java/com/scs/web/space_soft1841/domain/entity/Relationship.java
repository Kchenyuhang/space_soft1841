package com.scs.web.space_soft1841.domain.entity;

import lombok.Data;

/**
 * @ClassName Relationship
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/3
 **/
@Data
public class Relationship {
    private Long relationshipId;
    private Integer user1Id;
    private Integer user2Id;
}