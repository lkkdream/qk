package com.li.house.api;

import com.li.house.common.domain.Appointment;
import com.li.house.common.util.RestResult;

public interface AppointmentService {

    RestResult insertOrder(Appointment appointment);


    /**
     * 预约信息
     * @param uId
     * @return
     */
    RestResult getOrdersByUserId(String uId);
}
