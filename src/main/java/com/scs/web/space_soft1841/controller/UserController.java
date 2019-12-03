package com.scs.web.space_soft1841.controller;

import com.scs.web.space_soft1841.domain.entity.User;
import com.scs.web.space_soft1841.mapper.UserMapper;
import com.scs.web.space_soft1841.service.UserService;
import com.scs.web.space_soft1841.service.impl.RedisService;
import com.scs.web.space_soft1841.until.Result;
import com.scs.web.space_soft1841.until.ResultCode;
import com.scs.web.space_soft1841.until.SMSUtil;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/2
 **/

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Resource
    private UserService userService;
    private UserMapper userMapper;
    String code;
    HashMap<String ,String> hash = new HashMap<>();

    @PostMapping(value = "/sign-up")
    public Result userSignUp(@RequestBody User user){
        Result result = userService.signUp(user);
        return result;
    }

    @DeleteMapping(value = "/")
    public Result deleteByMobile(@RequestParam String mobile){
        Result result = userService.deleteByMobile(mobile);
        return result;
    }

//    @DeleteMapping(value = "/{id}")
//    public Result deleteUserById(@PathVariable int id){
//        Result result = userService.deleteUserById(id);
//        return result;
//    }

    @PostMapping(value = "/verify")
    public Result getVerifyCode(@RequestParam("mobile") String mobile) {
        //手机号已经被注册
        if (userService.findUserByMobile(mobile)==true) {
            return Result.failure(ResultCode.USER_MOBILE_EXIST_);
        } else {
            //发送验证码
             code= SMSUtil.send(mobile);
            hash.put(mobile,code);
            //手机号和验证码作为键值对存入redis中
            return Result.success();
        }
    }
    @PostMapping(value = "/check")
    public Result checkVerifyCode(@RequestParam("mobile") String mobile, @RequestParam("verifyCode") String verifyCode) {
        //从Redis中取出这个手机号的验证码
        //和客户端传过来的验证码比对
        if (hash.get(mobile).equals(verifyCode)) {
            hash.remove(mobile);
            return Result.success();
        } else {
            return Result.failure(ResultCode.USER_VERIFYCODE_ERROR_);
        }
    }
}