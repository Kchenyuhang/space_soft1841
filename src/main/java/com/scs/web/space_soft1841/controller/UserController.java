package com.scs.web.space_soft1841.controller;

import com.scs.web.space_soft1841.domain.entity.User;
import com.scs.web.space_soft1841.mapper.UserMapper;
import com.scs.web.space_soft1841.service.UserService;
import com.scs.web.space_soft1841.until.Result;
import com.scs.web.space_soft1841.until.ResultCode;
import com.scs.web.space_soft1841.until.SMSUtil;
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

    @DeleteMapping(value = "/deleteUser")
    public Result deleteUserByMobile(@RequestParam String mobile){
        Result result = userService.deleteByMobile(mobile);
        return result;
    }

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

    /**
     * 用户个人资料更新（未完成）
     * @param user
     * @return
     */
    @GetMapping(value = "/updateUser")
    public Result updateUserMessage(@RequestBody User user){
        Result result = userService.updateUser(user);
        return result;
    }

    /**
     * 用户登录
     * @param mobile
     * @param password
     * @return
     */
    @PostMapping(value = "/login")
    public Result userLogin(@RequestParam String mobile, String password){
        User user = new User();
        user.setMobile(mobile);
        user.setPassword(password);
        Result result = Result.success(userService.login(user));
        return result;
    }
}