package com.li.house.controller;
import com.li.house.api.AppointmentService;
import com.li.house.api.UserService;
import com.li.house.common.config.AliYunOSS;
import com.li.house.common.domain.User;
import com.li.house.common.dto.UserDTO;
import com.li.house.common.util.AliYunOSSUtil;
import com.li.house.common.util.RestResult;
import com.li.house.common.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;


@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AppointmentService appointmentService;

    /**
     * 用户登录
     *
     * @param userDTO
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RestResult loginUser(@RequestBody UserDTO userDTO) {
        return userService.loginUser(userDTO);
    }


    /**
     * 用户注册
     *
     * @param userDTO
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public RestResult insertUser(@RequestBody UserDTO userDTO) {
        return userService.insertUser(userDTO);
    }


    /**
     * 用户信息
     *
     * @param userDTO
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public RestResult getUserInfo(@RequestBody UserDTO userDTO) {
        return userService.getUserInfo(userDTO);
    }


    /**
     * 修改用户信息
     *
     * @param userDTO
     * @return
     */
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public RestResult updateUserInfo(@RequestBody UserDTO userDTO) {
        return userService.updateUserInfo(userDTO);
    }


    /**
     * 用户订单信息
     *
     * @param userDTO
     * @return
     */
    @RequestMapping(value = "/appointment", method = RequestMethod.POST)
    public RestResult getOrdersByUserID(@RequestBody UserDTO userDTO) {
        String uId = userDTO.getuId();
        return appointmentService.getOrdersByUserId(uId);
    }


    /**
     *修改用户头像
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public RestResult upload(String uId,MultipartFile file) throws IOException {
        System.out.println(uId);
        String path="F:\\chromedown\\";
        String newFile = path+UUIDUtils.UUIDGenerate()+file.getOriginalFilename();
        System.out.println(newFile);
        file.transferTo(new File(newFile));
        File file1 = new File(newFile);
        String total = "https://likuiting.oss-cn-shenzhen.aliyuncs.com/";
        String url = AliYunOSSUtil.upload(file1);
        String totalPath= total+url;
        User user = new User();
        user.setuId(uId);
        user.setuPicture(totalPath);
        return userService.updateByPrimaryKeySelective(user);
    }



}
