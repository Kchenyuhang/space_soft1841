package com.scs.web.space_soft1841.mapper;

import com.scs.web.space_soft1841.domain.entity.Relationship;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;

/**
 * @ClassName RelationShip
 * @Description TODO
 * @Author yh_chen
 * @Date 2019/12/12
 **/
public interface RelationShipMapper {
    /**
     * 查询是否已经为好友
     *
     * @param reqMobile
     * @param resMobile
     * @return List<RelationShip>
     */
    @Select("SELECT * FROM t_relationship WHERE req_mobile = #{reqMobile} AND res_mobile = #{resMobile}")
    List<Relationship> confirmFriend(String reqMobile, String resMobile);


    @Select("")

    /**
     * 发送好友请求
     * @param reqMobile
     * @param resMobile
     * @return
     */
    @Insert("INSERT INTO t_relationship (req_mobile,res_mobile) VALUES (#{reqMobile},#{resMobile})")
    int requestFriend(String reqMobile,String resMobile);

    /**
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

    /**
     * 我的请求信息，根据状态来升序排列
     * @param reqMobile
     * @return
     */
    @Select("SELECT t1.id,t1.req_mobile,t1.status,t2.mobile,t2.avatar,t2.nickname FROM t_relationship t1\n" +
            "            LEFT JOIN t_user t2\n" +
            "            ON t1.res_mobile = t2.mobile WHERE t1.req_mobile = #{reqMobile} ORDER BY status ASC")
    List<Map> friendsRequest(String reqMobile);

    /**
     * 根据用户手机查询所有该用户发送的好友请求（同意、拒绝和未处理）
     * @param reqMobile
     * @return
     */
    @Select("SELECT t1.*,t2.mobile,t2.avatar,t2.nickname FROM t_relationship t1\n" +
            "LEFT JOIN t_user t2\n" +
            "ON t1.res_mobile = t2.mobile WHERE t1.req_mobile = #{reqMobile} ORDER BY status ASC")
    List<Relationship> selectMyRequest(String reqMobile);


}
