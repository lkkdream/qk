package com.li.house.common.dao;

import com.li.house.common.domain.Administration;

import java.util.List;


public interface AdministrationMapper {
    int deleteByPrimaryKey(String aId);

    int insert(Administration record);

    int insertSelective(Administration record);

    Administration selectByPrimaryKey(String aId);

    int updateByPrimaryKeySelective(Administration record);

    int updateByPrimaryKey(Administration record);


    /**
     * ************** 自定义****************
     */


    /**
     * 得到所有行政区域
     * @return
     */
    List<Administration> getAllAdministrations();



}