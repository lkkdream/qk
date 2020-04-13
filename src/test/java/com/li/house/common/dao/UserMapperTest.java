package com.li.house.common.dao;


import com.li.house.common.domain.Admin;
import com.li.house.common.domain.Appointment;
import com.li.house.common.domain.Atlas;
import com.li.house.common.domain.Room;
import com.li.house.common.dto.AppointmentDTO;
import com.li.house.common.dto.KeyWordsDTO;
import com.li.house.common.util.UUIDUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private AtlasMapper atlasMapper;
    @Autowired
    private SubwayMapper subwayMapper;
    @Autowired
    private AdministrationMapper administrationMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AppointmentMapper appointmentMapper;

    @Test
    public void InsertUser(){

    }
}