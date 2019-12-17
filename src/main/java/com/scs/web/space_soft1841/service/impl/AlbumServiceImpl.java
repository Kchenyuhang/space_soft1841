package com.scs.web.space_soft1841.service.impl;

import com.scs.web.space_soft1841.domain.dto.PhotoDto;
import com.scs.web.space_soft1841.domain.entity.Album;
import com.scs.web.space_soft1841.domain.entity.Photo;
import com.scs.web.space_soft1841.mapper.AlbumMapper;
import com.scs.web.space_soft1841.service.AlbumService;
import com.scs.web.space_soft1841.until.AliOSSUtil;
import com.scs.web.space_soft1841.until.Result;
import com.scs.web.space_soft1841.until.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PhotoServiceImpl
 * @Description TODO
 * @Author yj_hou
 * @Date 2019/12/17
 **/
@Service
public class AlbumServiceImpl implements AlbumService {
    private Logger logger = LoggerFactory.getLogger(AlbumServiceImpl.class);
    @Resource
    private AlbumMapper photoMapper;
    @Override
    public Result selectAlbum() {
        List<Album> albumList = photoMapper.selectAlbum();
        List<Album> list = new ArrayList<>();
        if (albumList.size()!=0){
            for (int i=0;i<albumList.size();i++){
                Album album = new Album();
                album.setAlbumId(albumList.get(i).getAlbumId());
                album.setAlbumName(albumList.get(i).getAlbumName());
                album.setAlbumCover(photoMapper.selectPhoto(album.getAlbumId()).get(0).getAlbumCover());
                list.add(album);
            }
            return Result.success(list);
        }
        return Result.failure(ResultCode.PHOTO_SELECT_ALBUM);
    }

    @Override
    public Result selectPhoto(long albumId) {
        List<PhotoDto> photoDtoList = photoMapper.selectPhoto(albumId);
        List<PhotoDto> list = new ArrayList<>();
        PhotoDto photoDto1 = new PhotoDto();
        if (photoDtoList.size()!=0){
            for (PhotoDto photoDto:photoDtoList){
                photoDto1.setAlbumId(photoDto.getAlbumId());
                photoDto1.setAlbumCover(photoDto.getAlbumCover());
                photoDto1.setAlbumName(photoDto.getAlbumName());
                photoDto1.setPhotoName(photoDto.getPhotoName());
                photoDto1.setPhotoUrl(photoDto.getPhotoUrl());
                photoDto1.setPhotoId(photoDto.getPhotoId());
            }
            list.add(photoDto1);
            return Result.success(list);
        }
        return Result.failure(ResultCode.PHOTO_SELECT_ALBUM);
    }

    @Override
    public Result insertPhotosByAlbumId(MultipartFile[] files, int albumId) {
        String url = "";
        String name="photo";
        Photo photo = new Photo();
        for (int i=0;i<files.length;i++){
            name = name+(i+1);
            url=String.valueOf(AliOSSUtil.upload(files[i]).getData());
            photoMapper.insertPhotosByAlbumId(name,url ,albumId);
            photo.setPhotoUrl(url);
            photo.setAlbumId((long) albumId);
            photo.setPhotoName(name);
        }
        return Result.success(photo);
    }
}
