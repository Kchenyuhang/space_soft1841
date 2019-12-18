package com.scs.web.space_soft1841.service.impl;

import com.scs.web.space_soft1841.domain.dto.CountDto;
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
import java.util.Map;

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
    private AlbumMapper albumMapper;
    @Override
    public Result selectAlbum() {
        List<Album> albumList = albumMapper.selectAlbum();
        List<Album> list = new ArrayList<>();
        if (albumList.size()!=0){
            for (int i=0;i<albumList.size();i++){
                Album album = new Album();
                album.setAlbumId(albumList.get(i).getAlbumId());
                album.setAlbumName(albumList.get(i).getAlbumName());
                album.setAlbumCover(albumMapper.selectPhoto(album.getAlbumId()).get(0).getAlbumCover());
                list.add(album);
            }
            return Result.success(list);
        }
        return Result.failure(ResultCode.PHOTO_SELECT_ALBUM);
    }

    @Override
    public Result selectPhoto(long albumId) {
        List<PhotoDto> photoDtoList = albumMapper.selectPhoto(albumId);
        List<PhotoDto> list = new ArrayList<>();
        if (photoDtoList.size()!=0){
            for (int i=0;i<photoDtoList.size();i++){
                PhotoDto photoDto1 = new PhotoDto();
                photoDto1.setAlbumId(photoDtoList.get(i).getAlbumId());
                photoDto1.setPhotoName(photoDtoList.get(i).getPhotoName());
                photoDto1.setPhotoId(photoDtoList.get(i).getPhotoId());
                photoDto1.setPhotoUrl(photoDtoList.get(i).getPhotoUrl());
                list.add(photoDto1);
            }
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
            albumMapper.insertPhotosByAlbumId(name,url ,albumId);
            photo.setPhotoUrl(url);
            photo.setAlbumId((long) albumId);
            photo.setPhotoName(name);
        }
        return Result.success(photo);
    }

    @Override
    public Result countAlbum(long userId) {
        List<Map> list = albumMapper.countAlbum(userId);
        List<CountDto> list1 = new ArrayList<>();
        if (list.size()!=0){
            for (int i=0;i<list.size();i++){
                CountDto countDto = new CountDto();
                countDto.setUserId((Long) list.get(i).get("user_id"));
                countDto.setAlbumId((Long) list.get(i).get("album_id"));
                countDto.setCountAlbum(Integer.parseInt(String.valueOf(list.get(i).get("count"))) );
                countDto.setAlbumName((String) list.get(i).get("album_name"));
               countDto.setAlbumCover((String) list.get(i).get("album_cover"));
               list1.add(countDto);

        }
            return Result.success(list1);
    }
        return Result.failure(ResultCode.PHOTO_SELECT_ALBUM);
    }
}
