package com.scs.web.space_soft1841.controller;

import com.scs.web.space_soft1841.domain.Page;
import com.scs.web.space_soft1841.service.LogService;
import com.scs.web.space_soft1841.service.UserService;
import com.scs.web.space_soft1841.until.Result;
import com.scs.web.space_soft1841.until.ResultCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @ClassName LogController
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/10
 **/
@RestController
@RequestMapping(value = "/api/log")
public class LogController {
    @Resource
    private LogService logService;

    /**
     * 分页获取日志
     *
     * @param page
     * @return
     */
    @PostMapping(value = "/page")
    public Result getTopicByPage(@RequestBody Page page) {
        //客户端发送json参数 后端使用@RequstBody接收 注意要用Post方法
        System.out.println(page);
        return logService.selectLogByPage(page.getCurrentPage(), page.getPageSize(), page.getUserId());
    }

    /**
     * 根据logId查询日志
     * @param id
     * @return
     */
    @PostMapping(value = "/select")
    public Result selectByLogId(@RequestParam long id) {
        Result result = logService.selectByLogId(id);
        return result;
    }

    /**
     * 更新喜欢数
     * @param logId
     * @param userId
     * @return
     */
    @PostMapping(value = "/updateLike")
    public Result updateLogLikeByLogId(@RequestParam long logId, int userId) {
        return logService.updateLogLikeByLogId(logId, userId);
    }

    /**
     * 根据logId和userId删除日志
     * @param logId
     * @param userId
     * @return
     */
    @PostMapping(value = "/delete")
    public Result deleteLog(@RequestParam long logId,int userId){
        Result result = logService.deleteLog(logId,userId);
        return result;
    }
}