package com.li.house.api;

import com.li.house.common.domain.User;
import com.li.house.common.dto.UserDTO;
import com.li.house.common.util.RestResult;

public interface UserService {

    /**
     * 用户登录
     * @param userDTO
     * @return
     */
    RestResult loginUser(UserDTO userDTO);


    /**
     * 用户注册
     * @param userDTO
     * @return
     */
    RestResult insertUser(UserDTO userDTO);



    /**
     * 得到用户信息
     * @param userDTO
     * @return
     */
    RestResult getUserInfo(UserDTO userDTO);


    /**
     * 修改用户信息
     * @param userDTO
     * @return
     */
    RestResult updateUserInfo(UserDTO userDTO);



    RestResult updateByPrimaryKeySelective(User user);

}
