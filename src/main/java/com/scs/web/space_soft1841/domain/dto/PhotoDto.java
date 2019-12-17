package com.scs.web.space_soft1841.domain.dto;

import lombok.Data;

/**
 * @ClassName PhotoDto
 * @Description TODO
 * @Author yj_hou
 * @Date 2019/12/17
 **/
@Data
public class PhotoDto {
    private Long photoId;
    private String photoName;
    private String photoUrl;
    private Long albumId;
    private String albumName;
    private String albumCover;
}
