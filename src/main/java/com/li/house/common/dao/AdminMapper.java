package com.li.house.common.dao;

import com.li.house.common.domain.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    int deleteByPrimaryKey(String adId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String adId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);


    /**
     * 登录管理员
     */
    Admin loginAdmin(@Param("account") String account);
}