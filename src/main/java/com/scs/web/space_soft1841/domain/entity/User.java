package com.scs.web.space_soft1841.domain.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName User实现类
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/2
 **/
@Data
public class User {
    private Integer userId;
    private String mobile;
    private String password;
    private String nickname;
    private String email;
    private String avatar;
    private String address;
    private String gender;
    private String introduction;
    private LocalDate birthday;
    private LocalDateTime createTime;
    private String homepage;
    private Short status;
}