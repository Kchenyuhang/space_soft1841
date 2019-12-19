package com.scs.web.space_soft1841.mapper;

import com.scs.web.space_soft1841.SpaceSoft1841Application;
import com.scs.web.space_soft1841.domain.dto.PhotoDto;
import com.scs.web.space_soft1841.domain.entity.Album;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

@SpringBootTest(classes = SpaceSoft1841Application.class)
class AlbumMapperTest {
    @Resource
    private AlbumMapper albumMapper;
    @Test
    void selectPhoto() {
        List<PhotoDto> photoList = albumMapper.selectPhoto(1);
        photoList.forEach(photoDto -> System.out.println(photoDto));
    }

    @Test
    void selectAlbum() {
        List<Album> list  = albumMapper.selectAlbum();
        list.forEach(album -> System.out.println(album));
    }
    @Test
    void countAlbum(){
        List<Map> list = albumMapper.countAlbum(2);
        list.forEach(map -> System.out.println(map));
    }
    @Test
    void deletePhotoId(){
        System.out.println(albumMapper.deletePhotoId(27));
    }

    @Test
    void insertAlbumByUserId() {
        System.out.println(albumMapper.insertAlbumByUserId(2,"新增测试"));
    }
}