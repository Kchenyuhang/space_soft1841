package com.scs.web.space_soft1841.mapper;

import com.scs.web.space_soft1841.SpaceSoft1841Application;
import com.scs.web.space_soft1841.domain.dto.PhotoDto;
import com.scs.web.space_soft1841.domain.entity.Album;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

@SpringBootTest(classes = SpaceSoft1841Application.class)
class PhotoMapperTest {
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
}