package com.scs.web.space_soft1841.domain.entity;

import lombok.Data;

/**
 * @ClassName Photo
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/3
 **/
@Data
public class Photo {
    private Long photoId;
    private String photoName;
    private String photoUrl;
    private Long albumId;
}