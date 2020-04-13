package com.li.house.common.dao;

import com.li.house.common.domain.Collect;

public interface CollectMapper {
    int deleteByPrimaryKey(String cId);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
}