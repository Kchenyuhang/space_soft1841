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
}
