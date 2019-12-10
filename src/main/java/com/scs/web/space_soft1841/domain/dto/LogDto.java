package com.scs.web.space_soft1841.domain.dto;

import com.scs.web.space_soft1841.domain.entity.Log;
import com.scs.web.space_soft1841.domain.entity.User;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName LogDto
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/3
 **/
@Data
public class LogDto {
    private Log log;
    private User user;
}