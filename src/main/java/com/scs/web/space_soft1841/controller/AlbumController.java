package com.scs.web.space_soft1841.controller;

import com.scs.web.space_soft1841.service.AlbumService;
import com.scs.web.space_soft1841.until.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @ClassName PhotoController
 * @Description TODO
 * @Author yj_hou
 * @Date 2019/12/17
 **/
@RestController
@RequestMapping(value = "/api/photo")
public class AlbumController {
    @Resource
    private AlbumService albumService;

    @PostMapping(value = "/upload")
    public Result updateUserAvatar(@RequestParam MultipartFile[] files , int albumId){
        return albumService.insertPhotosByAlbumId(files,albumId);
    }

    @GetMapping(value = "/selectAlbum")
    public Result selectAlbum(){
        Result result =  albumService.selectAlbum();
        return result;
    }

    @PostMapping(value = "/selectAlbumId")
    public Result selectAlbumId(@RequestParam long albumId){
        Result result = albumService.selectPhoto(albumId);
        return result;
    }

    @PostMapping(value = "/count")
    public Result countAlbum(@RequestParam long userId){
        Result result = albumService.countAlbum(userId);
        return result;
    }

    @PostMapping(value = "/delete")
    public Result deletePhotoId(@RequestParam long photoId){
        Result result = albumService.deletePhotoId(photoId);
        return result;
    }
}
