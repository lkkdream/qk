package com.li.house.controller;

import com.li.house.api.UserService;
import com.li.house.api.VerificationCodeService;
import com.li.house.common.dto.UserDTO;
import com.li.house.common.util.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/code")
public class VerificationCodeController {
    @Autowired
    private VerificationCodeService verificationCodeService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public RestResult sendMsm(@RequestBody UserDTO userDTO){
        return verificationCodeService.sendMsm(userDTO.getPhoneNum(),userDTO.getType());
    }
}
