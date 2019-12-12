package com.scs.web.space_soft1841.mapper;

import com.scs.web.space_soft1841.domain.entity.Relationship;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

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
    @Select("SELECT * FROM t_relationship WHERE req_mobile = #{reqMobile} AND res_mobile = #{resMobile} AND status = 1 ")
    List<Relationship> confirmFriend(String reqMobile, String resMobile);

}
