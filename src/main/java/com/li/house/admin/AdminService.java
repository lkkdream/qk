package com.li.house.admin;

import com.li.house.common.domain.Admin;
import com.li.house.common.domain.HouseKeeper;
import com.li.house.common.domain.User;
import com.li.house.common.dto.KeyWordsDTO;
import com.li.house.common.dto.RoomDTO;
import com.li.house.common.dto.UserDTO;
import com.li.house.common.util.RestResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

public interface AdminService {

    /**
     * 登录管理员
     * @param admin
     * @return
     */
    RestResult loginAdmin(Admin admin);


    /**
     * 用户列表
     * @return
     */
    RestResult userList();


    /**
     * 添加用户
     * @return
     */
    RestResult insertUser(User user);


    /**
     * 修改用户
     * @param userDTO
     * @return
     */
    RestResult updataUser(UserDTO userDTO);


    /**
     * 查找用户
     * @param account
     * @return
     */
    RestResult findUserByUserAccount(String account);


    /**
     * 删除用户
     * @param uId
     * @return
     */
    RestResult deleteUser(String uId);

    /**
     * 房管员列表
     * @return
     */
    RestResult houserKeeperList();


    /**
     * 添加房管员
     * @return
     */
    RestResult insertHouserKeeper(HouseKeeper houseKeeper);


    /**
     * 修改房管
     * @param houseKeeper
     * @return
     */
    RestResult updateHouserKeeper(HouseKeeper houseKeeper);


    /**
     *
     * @param houseKeeper
     * @return
     */
    RestResult findHouserByPhone(HouseKeeper houseKeeper);

    /**
     * 删除房管员
     * @return
     */
    RestResult deleteKeeper(HouseKeeper houseKeeper);


    /**
     * 房源列表
     * @return
     */
    RestResult roomList(KeyWordsDTO keyWordsDTO);


    /**
     * 统计
     * @return
     */
    RestResult roomAdministrationCount();


    /**
     * 房管员统计
     * @return
     */
    RestResult hkCount();


    /**
     * 用户租房占比
     * @return
     */
    RestResult userGetRoomCount();




    RestResult subwayCount();


    /**
     * 价格统计
     * @return
     */
    RestResult priceCount();


    /**
     * 批量添加
     * @param file
     * @return
     */
    RestResult uploadExcel(MultipartFile file) throws FileNotFoundException;


    /**
     * 删除房源
     * @return
     */
    RestResult deleteRoomById(RoomDTO roomDTO);

}
