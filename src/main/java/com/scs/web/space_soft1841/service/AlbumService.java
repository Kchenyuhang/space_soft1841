package com.scs.web.space_soft1841.service;

import com.scs.web.space_soft1841.until.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName PhotoService
 * @Description TODO
 * @Author yj_hou
 * @Date 2019/12/17
 **/
public interface AlbumService {
    /**
     * 查询出所有的相册
     * @return
     */
    Result selectAlbum();

    /**
     * 根据相册id联查出相册下面的照片
     * @param albumId
     * @return
     */
    Result selectPhoto(long albumId);

    /**
     * 根据相册id批量上传图片
     * @param files
     * @param albumId
     * @return
     */
    Result insertPhotosByAlbumId(MultipartFile[] files, int albumId);

    /**
     * 根据前台传过来的userId来 统计出该用户有多少相册和相册下相片的数量
     * @param userId
     * @return
     */
    Result countAlbum(long userId);

    /**
     * 根据photoId来删除相片
     * @param photoId
     * @return
     */
    Result deletePhotoId(long photoId);
}
