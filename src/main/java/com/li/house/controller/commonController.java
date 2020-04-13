package com.li.house.controller;


import com.li.house.api.AdministrationService;
import com.li.house.api.SubwayService;
import com.li.house.common.util.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/common")
public class commonController {
    @Autowired
    private SubwayService subwayService;
    @Autowired
    private AdministrationService administrationService;



    /**
     *
     * 地铁沿线
     * @param
     */
    @RequestMapping(value = "/subway",method = RequestMethod.POST)
    public RestResult getSubwayLines(){
        return subwayService.getSubwayLines();
    }

    /**
     *
     * 行政区域
     * @param
     */
    @RequestMapping(value = "/administration",method = RequestMethod.POST)
    public RestResult getAdministrations(){
        return administrationService.getAdministrations();
    }
}
