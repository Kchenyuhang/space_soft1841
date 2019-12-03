package com.scs.web.space_soft1841.domain.entity;

import lombok.Data;

/**
 * @ClassName Region
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/3
 **/
@Data
public class Region {
    private Integer areaId;
    private String areaName;
    private Integer parentId;
    private Integer level;
    private String cityCode;
    private String postCode;
    private String mergeName;
}