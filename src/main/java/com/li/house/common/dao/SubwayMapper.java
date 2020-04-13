package com.li.house.common.dao;

import com.li.house.common.domain.Subway;

import java.util.List;
import java.util.Map;

public interface SubwayMapper {
    int deleteByPrimaryKey(String sId);

    int insert(Subway record);

    int insertSelective(Subway record);

    Subway selectByPrimaryKey(String sId);

    int updateByPrimaryKeySelective(Subway record);

    int updateByPrimaryKey(Subway record);


    /**
     * ******************** 自定义 **********
     */

    /**
     * 得到地铁线路
     * @return
     */
    List<Subway> getSubwayLines();
}