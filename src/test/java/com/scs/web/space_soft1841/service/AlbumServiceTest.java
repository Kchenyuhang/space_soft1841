package com.scs.web.space_soft1841.service;

import com.scs.web.space_soft1841.SpaceSoft1841Application;
import com.scs.web.space_soft1841.until.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.reflect.generics.tree.VoidDescriptor;

import javax.annotation.Resource;

@SpringBootTest(classes = SpaceSoft1841Application.class)
class AlbumServiceTest {
    @Resource
    private AlbumService albumService;
    @Test
    void selectAlbum() {
        Result result = albumService.selectAlbum();
        System.out.println(result);
    }

    @Test
    void selectPhoto() {
        Result result = albumService.selectPhoto(1);
        System.out.println(result);
    }
    @Test
    void  countAlbum(){
        Result result =albumService.countAlbum(2);
        System.out.println(result);
    }
    @Test
    void  deletePhotoId(){
        Result result = albumService.deletePhotoId(27);
        System.out.println(result);
    }

    @Test
    void insertAlbumByUserId() {
        Result result = albumService.insertAlbumByUserId(4,"新增测试3");
        System.out.println(result);
    }
}