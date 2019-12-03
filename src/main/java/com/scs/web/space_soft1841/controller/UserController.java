package com.scs.web.space_soft1841.controller;

import com.scs.web.space_soft1841.domain.entity.User;
import com.scs.web.space_soft1841.service.UserService;
import com.scs.web.space_soft1841.until.Md5;
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

    @DeleteMapping(value = "/delete")
    public Result deleteRelation(@RequestParam String mobile1,String mobile2){
        Result result = userService.deleteRelationByMobile(mobile1,mobile2);
        return result;
    }

    @GetMapping(value = "/select")
    public Result confirmRelation(@RequestParam String mobile1,String mobile2) {
        Result result = userService.confirmRelationByMobile(mobile1,mobile2);
        return result;
    }

    @PostMapping(value = "/login")
    public Result userLogin(@RequestParam String mobile,String password){
        User user = new User();
        user.setPassword(Md5.MD5(password));
        user.setMobile(mobile);
        Result result = userService.findUser(user);
        return result;
    }
//    @PutMapping(value = "/insert")
//    public Result insertUser(@RequestBody User user){
//        Result result = userService.insert(user);
//        return result;
//    }

}