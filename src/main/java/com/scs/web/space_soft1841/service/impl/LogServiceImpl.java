package com.scs.web.space_soft1841.service.impl;

import com.scs.web.space_soft1841.domain.dto.LogDto;
import com.scs.web.space_soft1841.domain.entity.Log;
import com.scs.web.space_soft1841.domain.entity.User;
import com.scs.web.space_soft1841.mapper.LogMapper;
import com.scs.web.space_soft1841.service.LogService;
import com.scs.web.space_soft1841.until.Result;
import com.scs.web.space_soft1841.until.ResultCode;
import com.sun.org.apache.regexp.internal.RE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LogServiceImpl
 * @Description TODOw
 * @Author yh_chen
 * @Date 2019/12/10
 **/
@Service
public class LogServiceImpl implements LogService {
    private Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);
    @Resource
    private LogMapper logMapper;
    @Resource
    private LogService logService;

    @Override
    public Result selectLogByPage(int currentPage,int pageSize,int userId){
        List<LogDto> maps = logMapper.selectByPage(currentPage,pageSize,userId);
        List<LogDto> maps1 = new ArrayList<>();

        if (maps!=null){
            for (int i=0;i<maps.size();i++){
                LogDto logDto = new LogDto();
                if (logMapper.isLike(maps.get(i).getLogId(),userId)!=null){
                    logDto.setIsLike(1);
                }else {
                    logDto.setIsLike(0);
                }
                logDto.setLogLike(maps.get(i).getLogLike());
                logDto.setAvatar(maps.get(i).getAvatar());
                logDto.setLogContent(maps.get(i).getLogContent());
                logDto.setLogCover(maps.get(i).getLogCover());
                logDto.setLogCreateTime(maps.get(i).getLogCreateTime());
                logDto.setUserId(maps.get(i).getUserId());
                logDto.setLogName(maps.get(i).getLogName());
                logDto.setNickname(maps.get(i).getNickname());
                logDto.setLogId(maps.get(i).getLogId());
                logDto.setMobile(maps.get(i).getMobile());
                maps1.add(logDto);
            }
            return Result.success(maps1);
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }

    @Override
    public Result isLike(long logId, int userId) {
        LogDto isLike = logMapper.isLike(logId,userId);
        if (isLike!=null){
            return Result.success(isLike);
        }
        else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result selectByLogId(long id) {
        List<Map> mapList = logMapper.selectByLogId(id);
        if (mapList.size()!=0){
            return Result.success(mapList);
        }
        return Result.failure(ResultCode.LOG_SELECT_ERROR);
    }

    @Override
    public Result getLogByLogId(long logId) {
        Log log = logMapper.getLogByLogId(logId);
        if (log!=null){
            return Result.success(log);
        }
        return Result.failure(ResultCode.LOG_SELECT_ERROR);
    }

    @Override
    public Result updateLogLikeByLogId(long logId,int userId) {
        int logLike = logMapper.getLogByLogId(logId).getLogLike();
        if (logService.isLike(logId,userId).getData()==null){
            int a  = logMapper.insertLogLike(userId,logId);
            if (a==1){
                logMapper.updateLogLikeByLogId(logLike+1,logId);
                return Result.success();
            }
        }
        else if (logService.isLike(logId,userId).getData()!=null){
            int b = logMapper.deleteLogLike(userId,logId);
            if (b==1){
                logMapper.updateLogLikeByLogId(logLike-1,logId);
                return Result.success();
            }
        }

        return Result.failure(ResultCode.LOG_UPDATE_ERROR);
    }

    @Override
    public Result deleteLogLike(int userId, long logId) {
        if (logMapper.isLike(logId,userId)!=null){
            int delete = logMapper.deleteLogLike(userId,logId);
            if (delete==1){
                return Result.success();
            }
            else {
                return Result.failure(ResultCode.LOG_DELETE_ERROR);
            }
        }
        return Result.failure(ResultCode.LOG_DELETE_ERROR);

    }

    @Override
    public Result insertLogLike(int userId, long logId) {
        if (logMapper.isLike(logId,userId)==null){
            int insert = logMapper.insertLogLike(userId,logId);
            if (insert==1){
                return Result.success();
            }else {
                return Result.failure(ResultCode.LOG_INSERT_ERROR);
            }
        }
        return Result.failure(ResultCode.LOG_INSERT_ERROR);
    }

    @Override
    public Result deleteLog(long logId, int userId) {
        int n = logMapper.deleteLog(logId, userId);
        if (n == 1) {
            return Result.success();
        }
        return Result.failure(ResultCode.LOG_DELETE_FAILURE);
    }

    @Override
    public Result insertLog(Log log) {
        log.setUserId(log.getUserId());
        log.setLogName(log.getLogName());
        log.setLogCover(log.getLogCover());
        log.setLogContent(log.getLogContent());
        log.setLogCreateTime(LocalDateTime.now());
        int n = logMapper.insertLog(log);
        if (n == 1) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.LOG_INSERT_FAILURE);
        }
    }
}