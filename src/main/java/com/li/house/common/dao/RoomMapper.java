package com.li.house.common.dao;

import com.li.house.common.domain.Room;
import com.li.house.common.dto.KeyWordsDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoomMapper {
    int deleteByPrimaryKey(String rId);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(String rId);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);


    /**
     * 关键字查询
     * @param
     * @return
     */
    List<Map> getAllRoomsByKeyWords(KeyWordsDTO keyWordsDTO);


    /**
     * 得到房屋总数
     * @return
     */
    int getRoomsCount(KeyWordsDTO keyWordsDTO);


    /**
     * 通过房屋id
     * 得到房屋信息
     * @param rId
     * @return
     */
    List<Map> getRoomDetails(@Param("rId") String rId);




    /**
     * 分页
     * @param keyWordsDTO
     * @return
     */
    List<Room> getRoomsByKeyWords(KeyWordsDTO keyWordsDTO);


    /**
     * 列表
     * @return
     */
    List<Room> getRoomList();


    /**
     * 统计
     * @return
     */
    List<Map> roomAdministrationCount();


    /**
     *
     * @return
     */
    List<Map> roomAdminSubwayCount();


    /**
     *
     * @return
     */
    List<Map> priceCount();

    /**
     * 批量添加
     * @param rooms
     * @return
     */
    int insertByBach(List<Room> rooms);

}