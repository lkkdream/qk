package com.li.house.api.impl;

import com.li.house.api.RoomService;
import com.li.house.common.dao.AdministrationMapper;
import com.li.house.common.dao.AtlasMapper;
import com.li.house.common.dao.RoomMapper;
import com.li.house.common.dao.SubwayMapper;
import com.li.house.common.domain.Administration;
import com.li.house.common.domain.Atlas;
import com.li.house.common.domain.Room;
import com.li.house.common.domain.Subway;
import com.li.house.common.dto.KeyWordsDTO;
import com.li.house.common.util.RestResult;
import com.li.house.common.util.RestResultBuilder;
import com.li.house.common.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service

public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private AdministrationMapper administrationMapper;
    @Autowired
    private AtlasMapper atlasMapper;
    @Autowired
    private SubwayMapper subwayMapper;

    /**
     * 得到所有房屋信息
     * 按发布时间排序
     * @return
     */
    @Override
    public RestResult getAllRooms() {
        KeyWordsDTO keyWordsDTO = new KeyWordsDTO();
        List<Map> roomList = roomMapper.getAllRoomsByKeyWords(keyWordsDTO);
        return new RestResultBuilder().setMsg("").setCode(ResultCode.SUCCESS.getCode()).setData(roomList).build();
    }



    /**
     * 关键字查询房屋
     * @param keyWordsDTO
     * @return
     */
    @Override
    public RestResult getRoomsByKeyWords(KeyWordsDTO keyWordsDTO) {
        System.out.println("AA"+keyWordsDTO);
        //初始化，重要变量
        Map resultMap = new HashMap();//返回结果集
        List<Map> roomList = new ArrayList<>();
        //当无条件查询时
        List<Room> rooms = roomMapper.getRoomsByKeyWords(keyWordsDTO);//房屋结果集
        System.out.println("BB"+rooms.size());
        Integer total = roomMapper.getRoomsCount(keyWordsDTO);
        System.out.println("CC"+total);
        //循环得到有关房屋的信息
        for (int i=0; i<rooms.size();i++){
            Map roomMap = new HashMap();//房屋信息结果集
            Room room = rooms.get(i);
            Administration administration = administrationMapper.selectByPrimaryKey(room.getrAId());//行政区域结果
            Subway subway = subwayMapper.selectByPrimaryKey(room.getrSId());//地铁结果
            List<Atlas> atlases = atlasMapper.getAtlasByRoomId(room.getrId());//房间图片图集
            roomMap.put("room",room);
            roomMap.put("administration",administration);
            roomMap.put("subway",subway);
            roomMap.put("atlases",atlases);
            roomList.add(roomMap);
        }
        resultMap.put("data",roomList);
        resultMap.put("total",total);
        return new RestResultBuilder().
                setMsg("房屋集合").
                setCode(ResultCode.SUCCESS.getCode())
                .setData(resultMap).build();
    }


    /**
     * 房屋数量
     * @return
     */
    @Override
    public RestResult getRoomsNum() {
        Integer totalNum = 100;
        return new RestResultBuilder().setData(totalNum).setMsg("").setCode(ResultCode.SUCCESS.getCode()).build();
    }


    /**
     * 通过id
     * 得到具体信息
     * @param rId
     * @return
     */
    @Override
    public RestResult getRoomDetails(String rId) {
        if (rId==null||rId.equals("")){
            return new RestResultBuilder().setMsg("房屋id为空").setCode(ResultCode.ERROR.getCode()).build();
        }
        List<Map> roomMap = roomMapper.getRoomDetails(rId);
        System.out.println(roomMap);
        return new RestResultBuilder().setData(roomMap).setMsg("房屋信息").setCode(ResultCode.SUCCESS.getCode()).build();
    }
}
