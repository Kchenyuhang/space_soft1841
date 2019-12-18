package com.scs.web.space_soft1841.mapper;

import com.scs.web.space_soft1841.domain.dto.PhotoDto;
import com.scs.web.space_soft1841.domain.entity.Album;
import com.scs.web.space_soft1841.domain.entity.Photo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @ClassName PhotoMapper
 * @Description TODO
 * @Author yj_hou
 * @Date 2019/12/17
 **/
public interface AlbumMapper {
    /**
     * 通过相册id 联查出相册下有有多少相片
     * @param albumId
     * @return
     */
    @Select("SELECT t1.* FROM t_photo t1\n" +
            "LEFT JOIN t_album t2\n" +
            "ON t1.album_id = t2.album_id\n" +
            "WHERE t2.album_id=#{albumId}")
    List<PhotoDto> selectPhoto(long albumId);

    /**
     * 查询出所有的相册
     * @return
     */
    @Select("SELECT * FROM t_album")
    List<Album> selectAlbum();

    /**
     * 根据相册id批量上传图片
     * @param name
     * @param url
     * @param albumId
     * @return
     */
    @Insert("INSERT INTO t_photo(photo_name,photo_url,album_id) VALUES(#{name},#{url},#{albumId})")
    int insertPhotosByAlbumId(String name,String url,int albumId);

    /**
     * 根据前台的用户id 统计出改用户相册下面相片的数量
     * @param userId
     * @return
     */
    @Select("select t1.*, count(t2.album_id) as count from t_album t1 \n" +
            "left join t_photo t2\n" +
            "on t1.album_id = t2.album_id\n" +
            "where t1.user_id=#{userId}\n" +
            "group by t1.album_id")
    List<Map> countAlbum(long userId);

}
