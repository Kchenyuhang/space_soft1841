package com.scs.web.space_soft1841.domain.dto;

import lombok.Data;

/**
 * @ClassName CountDto
 * @Description TODO
 * @Author yj_hou
 * @Date 2019/12/18
 **/
@Data
public class CountDto {
    private Long albumId;
    private Long userId;
    private String albumName;
    private String albumCover;
    private int countAlbum;
}
