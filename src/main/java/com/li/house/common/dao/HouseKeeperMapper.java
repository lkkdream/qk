package com.li.house.common.dao;

import com.li.house.common.domain.HouseKeeper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface HouseKeeperMapper {
    int deleteByPrimaryKey(String hkId);

    int insert(HouseKeeper record);

    int insertSelective(HouseKeeper record);

    HouseKeeper selectByPrimaryKey(String hkId);

    int updateByPrimaryKeySelective(HouseKeeper record);

    int updateByPrimaryKey(HouseKeeper record);


    /**
     * **************************       自定义       *************************
     */


    /**
     * 房管员列表
     * @return
     */
    List<HouseKeeper> getHouserKeeperList();


    /**
     * 房管员统计
     * @return
     */
    List<Map> hkCount();


    /**
     * 手机号查找
     * @param hkPhonenum
     * @return
     */
    HouseKeeper getHouserByPhone(@Param("hkPhonenum") String hkPhonenum);
}