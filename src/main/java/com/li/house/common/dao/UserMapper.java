package com.li.house.common.dao;

import com.li.house.common.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {


    /**
     * 删除用户
     * @param uId
     * @return
     */
    int deleteByPrimaryKey(String uId);


    /**
     * 添加用户
     * @param record
     * @return
     */
    int insertSelective(User record);


    /**
     * 查找用户
     * @param uId
     * @return
     */
    User selectByPrimaryKey(String uId);


    /**
     * 修改用户信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);


    /**
     * 自定义方法
     *******************************************/


    /**
     * 查找用户是否存在
     * @param uPhonenum
     * @return
     */
    User selectByUserPhoneNum(String uPhonenum);


    /**
     * 用户列表
     * @return
     */
    List<User> selectUserList();


    /**
     * 用户总数
     * @return
     */
    Integer getUserCountNum();


    /**
     * 用户已租房数量
     * @return
     */
    List<Map> userGetRoomNum();
}