package com.li.house.api.impl;

import com.li.house.api.AdministrationService;
import com.li.house.common.dao.AdministrationMapper;
import com.li.house.common.domain.Administration;
import com.li.house.common.util.RestResult;
import com.li.house.common.util.RestResultBuilder;
import com.li.house.common.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdministrationServiceImpl implements AdministrationService {
    @Autowired
    private AdministrationMapper administrationMapper;


    @Override
    public RestResult getAdministrations() {
        List<Administration> administrations = administrationMapper.getAllAdministrations();
        return new RestResultBuilder().setData(administrations).setCode(ResultCode.SUCCESS.getCode()).setMsg("地铁沿线").build();
    }
}
