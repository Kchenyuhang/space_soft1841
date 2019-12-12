package com.scs.web.space_soft1841.mapper;

<<<<<<< HEAD
import com.scs.web.space_soft1841.domain.entity.Relationship;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

=======
import org.apache.ibatis.annotations.*;

>>>>>>> origin/master
/**
 * @ClassName RelationShip
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/12
 **/
public interface RelationShipMapper {
    /**
<<<<<<< HEAD
     * 查询是否已经为好友
     *
     * @param reqMobile
     * @param resMobile
     * @return List<RelationShip>
     */
    @Select("SELECT * FROM t_relationship WHERE req_mobile = #{reqMobile} AND res_mobile = #{resMobile} AND status = 1 ")
    List<Relationship> confirmFriend(String reqMobile, String resMobile);
=======
     * 处理加好友时候的请求
     * @param reqMobile
     * @param resMobile
     * @return
     */
    @Update("UPDATE t_relationship SET status=1 WHERE req_mobile=#{reqMobile} AND res_mobile=#{resMobile}")
    int updateStatue(String reqMobile,String resMobile);

    /**
     * 通过删除记录来拒绝添加好友的请求
     * @param reqMobile
     * @param resMobile
     * @return
     */
    @Delete("DELETE FROM  t_relationship WHERE req_mobile=#{reqMobile} AND res_mobile=#{resMobile}")
    int deleteRelationship(String reqMobile,String resMobile);
>>>>>>> origin/master

}
