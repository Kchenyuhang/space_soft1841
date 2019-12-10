package com.scs.web.space_soft1841.controller;

import com.alibaba.druid.sql.visitor.functions.If;
import com.scs.web.space_soft1841.domain.entity.User;
import com.scs.web.space_soft1841.mapper.UserMapper;
import com.scs.web.space_soft1841.service.UserService;
import com.scs.web.space_soft1841.until.LegalPhone;
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
        //判断手机号是否合法
        if (LegalPhone.isMobiPhoneNum(mobile)){
            //手机号已经被注册
            if (userService.findUserByMobile(mobile)) {
                return Result.failure(ResultCode.USER_MOBILE_EXIST_);
            } else {
                //发送验证码
                code = SMSUtil.send(mobile);
                hash.remove(mobile);
                phone = mobile;
                try {
                    hash.put(mobile, code);
                    Thread.sleep(5000);
                    hash.remove(mobile);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return Result.success();
            }
        } else {
            return Result.failure(ResultCode.USER_MOBILE_ERROR);
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
        if (hash.get(mobile)!=null){
            if (hash.get(mobile).equals(verifyCode)) {
                hash.remove(mobile);
                return Result.success();
            } else {
                phone="";
                return Result.failure(ResultCode.USER_VERIFYCODE_ERROR_);
            }
        }else {
            return Result.failure(ResultCode.USER_CODE_NONSEXIST);
        }
    }

    /**
     * 用户注册
     * @param mobile
     * @param password
     * @return
     */
    @PostMapping(value = "/register")
    public Result register(@RequestParam("mobile") String mobile,@RequestParam("password")String password){
        User user = new User();
        user.setMobile(mobile);
        user.setPassword(password);
        user.setCreateTime(LocalDateTime.now());
        userService.register(user);
        return Result.success();
    }

    /**
     * 用户个人资料更新
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
     * 用户登录
     *
     * @param mobile
     * @param password
     * @return user
     */
    @PostMapping(value = "/login")
    public Result userLogin(@RequestParam String mobile, String password) {
        User user1 = new User();
        List<User> list = userService.userLogin(mobile, password);
        List<User> existList = userService.findQueryMobile(mobile);
        if (existList.size()==0){
            return Result.failure(ResultCode.USER_NOT_EXIST);
        }else {
            if (list.size()!=0){
                for (User  user :list ){
                    user1.setUserId(user.getUserId());
                    user1.setMobile(user.getMobile());
                    user1.setPassword(user.getPassword());
                    user1.setNickname(user.getNickname());
                    user1.setIntroduction(user.getIntroduction());
                    user1.setEmail(user.getEmail());
                    user1.setAvatar(user.getAvatar());
                    user1.setAddress(user.getAddress());
                    user1.setGender(user.getGender());
                    user1.setBirthday(user.getBirthday());
                    user1.setHomepage(user.getHomepage());
                    user1.setCreateTime(user.getCreateTime());
                    user1.setStatus(user.getStatus());
                }
                return Result.success(user1);
            }else {
                return Result.failure(ResultCode.USER_LOGINPASSWORD_ERROR);
            }
        }
    }

    /**
     * 用户登入进去之后 得到昵称和头像
     * @param mobile
     * @return user
     */
    @PostMapping(value = "/findQuery")
    public Result findQuery(@RequestParam String mobile){
        User user1 =new User();
        List<User> list1 = userService.findQueryMobile(mobile);
        if (list1.size()==0){
            return Result.failure(ResultCode.USER_SELECT_FAILURE_);
        } else {
            for (User user:list1){
                user1.setNickname(user.getNickname());
                user1.setAvatar(user.getAvatar());
            }
            return Result.success(user1);
        }
    }

    /**
     * 登陆进去后，根据用户Id查询该用户的所有信息
     * @param userId
     * @return
     */
    @PostMapping(value = "/selectUser")
    public Result selectUserById(@RequestParam Integer userId){
        User user1 = new User();
        List<User> list = userService.selectUserAllById(userId);
        if (list.size() == 0) {
            return Result.failure(ResultCode.USER_SELECT_FAILURE_);
        } else {
            for (User  user :list ){
                user1.setUserId(user.getUserId());
                user1.setMobile(user.getMobile());
                user1.setPassword(user.getPassword());
                user1.setNickname(user.getNickname());
                user1.setIntroduction(user.getIntroduction());
                user1.setEmail(user.getEmail());
                user1.setAvatar(user.getAvatar());
                user1.setAddress(user.getAddress());
                user1.setGender(user.getGender());
                user1.setBirthday(user.getBirthday());
                user1.setHomepage(user.getHomepage());
                user1.setCreateTime(user.getCreateTime());
                user1.setStatus(user.getStatus());
            }
            return Result.success(user1);
        }
    }
}