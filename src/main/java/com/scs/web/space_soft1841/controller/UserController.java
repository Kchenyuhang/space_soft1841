package com.scs.web.space_soft1841.controller;

import com.scs.web.space_soft1841.domain.entity.User;
import com.scs.web.space_soft1841.service.UserService;
import com.scs.web.space_soft1841.until.Result;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

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
}