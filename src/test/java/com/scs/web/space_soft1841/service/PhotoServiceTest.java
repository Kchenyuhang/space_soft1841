package com.scs.web.space_soft1841.service;

import com.scs.web.space_soft1841.SpaceSoft1841Application;
import com.scs.web.space_soft1841.until.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = SpaceSoft1841Application.class)
class PhotoServiceTest {
    @Resource
    private AlbumService albumService;
    @Test
    void selectAlbum() {
        Result result = albumService.selectAlbum();
        System.out.println(result);
    }

    @Test
    void selectPhoto() {
        Result result = albumService.selectPhoto(2);
        System.out.println(result);
    }
    @Test
    void  countAlbum(){
        Result result =albumService.countAlbum(2);
        System.out.println(result);
    }
}