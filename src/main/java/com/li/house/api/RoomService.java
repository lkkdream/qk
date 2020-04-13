package com.li.house.api;

import com.li.house.common.dto.KeyWordsDTO;
import com.li.house.common.util.RestResult;

public interface RoomService {

    /**
     * 所有的房子
     * 按照房屋发布时间排序
     * @return
     */
    RestResult  getAllRooms();


    /**
     * 根据关键字，查找房屋
     * @param keyWordsDTO
     * @return
     */
    RestResult getRoomsByKeyWords(KeyWordsDTO keyWordsDTO);


    /**
     * 房屋总数
     * @return
     */
    RestResult getRoomsNum();


    /**
     * 通过id
     * 得到具体信息
     * @param rId
     * @return
     */
    RestResult getRoomDetails(String rId);

}
