package com.li.house.common.dao;

import com.li.house.common.domain.Atlas;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AtlasMapper {
    int deleteByPrimaryKey(String atId);

    int insert(Atlas record);

    int insertSelective(Atlas record);

    Atlas selectByPrimaryKey(String atId);

    int updateByPrimaryKeySelective(Atlas record);

    int updateByPrimaryKey(Atlas record);


    /***
     * ***************  自定义   ****************
     *
     */



    /**得到房间图片
     * @param rId
     * @return
     */
    List<Atlas> getAtlasByRoomId(@Param("rId")String rId);


    /**
     * 批量添加
     * @param atlases
     * @return
     */
    int insertByBach(List<Atlas> atlases);
}