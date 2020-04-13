package com.li.house.controller;

import com.li.house.api.RoomService;
import com.li.house.common.dto.KeyWordsDTO;
import com.li.house.common.dto.RoomDTO;
import com.li.house.common.util.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/room")
public class RoomController {
    @Autowired
    private RoomService roomService;


    /**
     *
     * 无条件
     * 筛选房屋
     * （时间顺序）
     * @param
     */
    @RequestMapping(value = "/all",method = RequestMethod.POST)
    public RestResult getRoomByKeyWords(@RequestBody KeyWordsDTO keyWordsDTO){
        return roomService.getRoomsByKeyWords(keyWordsDTO);
    }



    /**
     * 房屋总数
     * @return
     */
    @RequestMapping(value = "/total",method = RequestMethod.POST)
    public RestResult getRoomsNum(){
        return roomService.getRoomsNum();
    }


    /**
     * 同过id
     * 得到具体信息
     * @param roomDTO
     * @return
     */
    @RequestMapping(value = "/details",method = RequestMethod.POST)
    public RestResult getRoomDetailsById(@RequestBody RoomDTO roomDTO){
        String rId = roomDTO.getrId();
        return roomService.getRoomDetails(rId);
    }
}
