package com.scs.web.space_soft1841.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Page
 * @Description TODO
 * @Author yj_hou
 * @Date 2019/11/30
 **/
@Data
public class Page implements Serializable {
    private Integer currentPage;
    private Integer pageSize;
    private Integer userId;
}
