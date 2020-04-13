package com.li.house.controller;

import com.li.house.admin.AdminService;
import com.li.house.common.domain.Admin;
import com.li.house.common.domain.HouseKeeper;
import com.li.house.common.domain.User;
import com.li.house.common.dto.KeyWordsDTO;
import com.li.house.common.dto.RoomDTO;
import com.li.house.common.dto.UserDTO;
import com.li.house.common.util.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

@RequestMapping(value = "/admin")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;



    /**
     * 管理员登录
     * @param admin
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public RestResult adminLogin(@RequestBody Admin admin){
        return adminService.loginAdmin(admin);
    }


    /**
     * 用户列表
     * @return
     */
    @RequestMapping(value = "/user/list",method = RequestMethod.POST)
    public  RestResult userList(){
        return adminService.userList();
    }


    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/insert",method = RequestMethod.POST)
    public RestResult insertUser(@RequestBody User user){
        return adminService.insertUser(user);
    }


    /**
     * 用户修改
     * @param userDTO
     * @return
     */
    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    public RestResult updateUser(@RequestBody UserDTO userDTO){
        return adminService.updataUser(userDTO);
    }


    /**
     * 查找用户
     * @param userDTO
     * @return
     */
    @RequestMapping(value = "/user/account",method = RequestMethod.POST)
    public RestResult findUserByUserAccount(@RequestBody UserDTO userDTO){
        return adminService.findUserByUserAccount(userDTO.getPhoneNum());
    }


    /**
     * 删除用户
     * @param userDTO
     * @return
     */
    @RequestMapping(value = "/user/delete",method = RequestMethod.POST)
    public RestResult deleteUser(@RequestBody UserDTO userDTO){
        return adminService.deleteUser(userDTO.getuId());
    }




    /**
     * 房管员列表
     * @return
     */
    @RequestMapping(value = "/houser/list",method = RequestMethod.POST)
    public  RestResult houserList(){
        return adminService.houserKeeperList();
    }


    /**
     * 添加房管员
     * @return
     */
    @RequestMapping(value = "/houser/insert",method = RequestMethod.POST)
    public  RestResult insertHouserKeeper(@RequestBody HouseKeeper houseKeeper){
        return adminService.insertHouserKeeper(houseKeeper);
    }


    /**
     * 修改
     * @param houseKeeper
     * @return
     */
    @RequestMapping(value = "/houser/update",method = RequestMethod.POST)
    public  RestResult updateHouserKeeper(@RequestBody HouseKeeper houseKeeper){
        return adminService.updateHouserKeeper(houseKeeper);
    }


    /**
     *
     * @param houseKeeper
     * @return
     */
    @RequestMapping(value = "/houser/account",method = RequestMethod.POST)
    public  RestResult findHouserByPhone(@RequestBody HouseKeeper houseKeeper){
        return adminService.findHouserByPhone(houseKeeper);
    }



    /**
     * 删除房管员
     * @return
     */
    @RequestMapping(value = "/houser/delete",method = RequestMethod.POST)
    public  RestResult deleteKeeper(@RequestBody HouseKeeper houseKeeper){
        return adminService.deleteKeeper(houseKeeper);
    }


    /**
     * 删除房管员
     * @return
     */
    @RequestMapping(value = "/room/list",method = RequestMethod.POST)
    public  RestResult roomList(@RequestBody KeyWordsDTO keyWordsDTO){
        return adminService.roomList(keyWordsDTO);
    }


    /**
     * 区域房源统计
     * @return
     */
    @RequestMapping(value = "/room/administa/count",method = RequestMethod.POST)
    public  RestResult roomAdministrationCount(){
        return adminService.roomAdministrationCount();
    }



    /**
     * 房管员统计
     * @return
     */
    @RequestMapping(value = "/hk/count",method = RequestMethod.POST)
    public  RestResult hkCount(){
        return  adminService.hkCount();
    }



    /**
     * 房管员统计
     * @return
     */
    @RequestMapping(value = "/user/count",method = RequestMethod.POST)
    public  RestResult userGetRoomCount(){
        return  adminService.userGetRoomCount();
    }




    /**
     * 房管员统计
     * @return
     */
    @RequestMapping(value = "/room/subway/count",method = RequestMethod.POST)
    public  RestResult subwayCount(){
        return  adminService.subwayCount();
    }


    /**
     * 房管员统计
     * @return
     */
    @RequestMapping(value = "/room/price/count",method = RequestMethod.POST)
    public  RestResult priceCount(){
        return  adminService.priceCount();
    }


    /**
     * 批量添加
     * @return
     */
    @RequestMapping(value = "/room/insertBash",method = RequestMethod.POST)
    public RestResult uploadExcel(MultipartFile file) throws FileNotFoundException {
        return adminService.uploadExcel(file);
    }


    /**
     * 批量添加
     * @return
     */
    @RequestMapping(value = "/room/delete",method = RequestMethod.POST)
    public RestResult deleteRoomById(@RequestBody RoomDTO roomDTO) {
        return adminService.deleteRoomById(roomDTO);
    }




}
