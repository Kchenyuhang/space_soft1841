package com.scs.web.space_soft1841.controller;

import com.scs.web.space_soft1841.domain.entity.User;
import com.scs.web.space_soft1841.mapper.UserMapper;
import com.scs.web.space_soft1841.service.UserService;
import com.scs.web.space_soft1841.until.Result;
import com.scs.web.space_soft1841.until.ResultCode;
import com.scs.web.space_soft1841.until.SMSUtil;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    private String phone;
    String code;
    HashMap<String, String> hash = new HashMap<>();

    /**
     * 根据电话删除用户
     *
     * @param mobile
     * @return
     */
    @DeleteMapping(value = "/deleteUser")
    public Result deleteUserByMobile(@RequestParam String mobile) {
        Result result = userService.deleteByMobile(mobile);
        return result;
    }

    /**
     * 通过短信验证注册
     *
     * @param mobile
     * @return
     */
    @PostMapping(value = "/verify")
    public Result getVerifyCode(@RequestParam("mobile") String mobile) {
        //手机号已经被注册
        if (userService.findUserByMobile(mobile) == true) {
            return Result.failure(ResultCode.USER_MOBILE_EXIST_);
        } else {
            //发送验证码
            code = SMSUtil.send(mobile);
            phone = mobile;
            hash.put(mobile, code);
            //手机号和验证码作为键值对存入redis中
            return Result.success();
        }
    }

    /**
     * 从Redis中取出这个手机号的验证码
     * 和客户端传过来的验证码比对
     *
     * @param mobile
     * @param verifyCode
     * @return
     */
    @PostMapping(value = "/check")
    public Result checkVerifyCode(@RequestParam("mobile") String mobile, @RequestParam("verifyCode") String verifyCode) {
        //从Redis中取出这个手机号的验证码
        //和客户端传过来的验证码比对
        if (hash.get(mobile).equals(verifyCode)) {
            hash.remove(mobile);
            return Result.success();
        } else {
            phone="";
            return Result.failure(ResultCode.USER_VERIFYCODE_ERROR_);
        }
    }


    @PostMapping(value = "/register")
    public Result register(@RequestParam("mobile") String mobile,@RequestParam("password")String password){
        User user = new User();
//        mobile =phone;
        user.setMobile(mobile);
        user.setPassword(password);
        user.setCreateTime(LocalDateTime.now());
        Result result = userService.register(user);
        return result;
    }

    /**
     * 用户个人资料更新（未完成）
     *
     * @param user
     * @return user
     */
    @GetMapping(value = "/updateUser")
    public Result updateUserMessage(@RequestBody User user) {
        Result result = userService.updateUser(user);
        return result;
    }

    /**
     * 用户登录(未完成)
     *
     * @param mobile
     * @param password
     * @return user
     */
    @PostMapping(value = "/login")
    public Result userLogin(@RequestParam String mobile, String password) {
        List<User> userList = new ArrayList<>();
        List<User> list = userService.userLogin(mobile, password);
        if (list.size()!=0){
            for (User  user :list ){
                userList.add(user);
            }
            return Result.success(userList);
        }
        return Result.failure(ResultCode.USER_LOGIN_FAIL);
    }

    /**
     * 用户登入进去之后 得到昵称和头像
     * @param mobile
     * @return list
     */
    @PostMapping(value = "/findQuery")
    public Result findQuery(@RequestParam String mobile){
        List<User> list = new ArrayList<>();
        List<User> list1 = userService.findQueryMobile(mobile);
        if (list1.size()==0){
            return Result.failure(ResultCode.USER_SELECT_FAILURE_);
        } else {
            for (User user:list1){
                list.add(user);
            }
            return Result.success(list);
        }
    }
}