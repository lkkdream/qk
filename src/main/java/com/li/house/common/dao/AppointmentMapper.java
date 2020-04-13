package com.li.house.common.dao;

import com.li.house.common.domain.Appointment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppointmentMapper {
    int deleteByPrimaryKey(String apId);

    int insert(Appointment record);

    int insertSelective(Appointment record);

    Appointment selectByPrimaryKey(String apId);

    int updateByPrimaryKeySelective(Appointment record);

    int updateByPrimaryKey(Appointment record);


    /**
     * ****************         自定义           *******************
     */

    /***
     * 用户的预约信息
     * @param uId
     * @return
     */
    List<Appointment> getAppointmentsByUserId(@Param("uId") String uId);
}