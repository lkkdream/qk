package com.li.house.api.impl;

import com.li.house.api.SubwayService;
import com.li.house.common.dao.SubwayMapper;
import com.li.house.common.domain.Subway;
import com.li.house.common.util.RestResult;
import com.li.house.common.util.RestResultBuilder;
import com.li.house.common.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class SubwayServiceImpl implements SubwayService {

    @Autowired
    private SubwayMapper subwayMapper;

    @Override
    public RestResult getSubwayLines() {
        List<Subway> subways = subwayMapper.getSubwayLines();
        return new RestResultBuilder().setData(subways).setCode(ResultCode.SUCCESS.getCode()).setMsg("地铁沿线").build();
    }
}
