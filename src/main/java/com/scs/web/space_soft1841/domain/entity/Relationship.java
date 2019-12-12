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
    private Long id;
    private String reqMobile;
    private String resMobile;
    private Integer status;
    private String mobile;
    private String nickname;
}