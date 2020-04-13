package com.li.house.api.impl;

import com.li.house.api.AppointmentService;
import com.li.house.common.dao.AppointmentMapper;
import com.li.house.common.domain.Appointment;
import com.li.house.common.dto.AppointmentDTO;
import com.li.house.common.util.RestResult;
import com.li.house.common.util.RestResultBuilder;
import com.li.house.common.util.ResultCode;
import com.li.house.common.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Max;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentMapper appointmentMapper;

    /**
     * 添加订单
     * @param appointment
     * @return
     */
    @Override
    public RestResult insertOrder(Appointment appointment) {
        if (appointment==null){
            return new RestResultBuilder().setCode(ResultCode.ERROR.getCode()).setMsg("整个对象为空").build();
        }
        if (appointment.getuId()==null||appointment.getrId()==null||appointment.getOrderNum()==null){
            return new RestResultBuilder().setCode(ResultCode.ERROR.getCode()).setMsg("必要信息为空").build();
        }
        Appointment newAppointment = new Appointment();
        newAppointment.setApId(UUIDUtils.UUIDGenerate());
        newAppointment.setuId(appointment.getuId());
        newAppointment.setrId(appointment.getrId());
        newAppointment.setOrderNum(appointment.getOrderNum());
        newAppointment.setPrice(appointment.getPrice());
        newAppointment.setApCreatetime(new Date());
        newAppointment.setApLooktime(new Date());
        appointmentMapper.insertSelective(appointment);
        return new RestResultBuilder().setCode(ResultCode.SUCCESS.getCode()).setMsg("添加成功").build();
    }


    /**
     * 预约信息
     * @param uId
     * @return
     */
    @Override
    public RestResult getOrdersByUserId(String uId) {
        if (uId==null){
            return new RestResultBuilder().setCode(ResultCode.ERROR.getCode()).setMsg("用户id为空").build();
        }
        List<Appointment> list = appointmentMapper.getAppointmentsByUserId(uId);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<AppointmentDTO> appointments = new ArrayList();
        for (Appointment a:list
        ) {
            String orderNo=a.getOrderNum();
            String createTime= formatter.format(a.getApCreatetime());
            String rId =a.getrId();
            String price = a.getPrice();
            AppointmentDTO appointmentDTO = new AppointmentDTO(orderNo,createTime,rId,price);
            appointments.add(appointmentDTO);
        }
        return new RestResultBuilder().setCode(ResultCode.SUCCESS.getCode()).setData(appointments).setMsg("订单信息列表").build();
    }
}
