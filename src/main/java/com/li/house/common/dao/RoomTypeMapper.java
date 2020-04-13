package com.li.house.common.dao;

import com.li.house.common.domain.RoomType;

public interface RoomTypeMapper {
    int deleteByPrimaryKey(String rId);

    int insert(RoomType record);

    int insertSelective(RoomType record);

    RoomType selectByPrimaryKey(String rId);

    int updateByPrimaryKeySelective(RoomType record);

    int updateByPrimaryKey(RoomType record);
}