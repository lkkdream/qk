package com.li.house.api.impl;

import com.li.house.api.VerificationCodeService;
import com.li.house.common.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Autowired
    private JWTRedisUtils jwtRedisUtils;

    /**
     * 验证码
     * @param phoneNum
     * @return
     */
    @Override
    public RestResult sendMsm(String phoneNum,String type) {
        if (phoneNum==null||phoneNum.equals("")){
            return new RestResultBuilder().setCode(ResultCode.ERROR.getCode()).setMsg("手机号不能为空").build();
        }
        String code = CodeUtils.createCode();
        if (type.equals("0")){
            MessageUtils.sendMsg("SMS_140065206",phoneNum,code);
        }
        jwtRedisUtils.set(phoneNum,code,60*5);
        return new RestResultBuilder().setCode(ResultCode.SUCCESS.getCode()).setMsg("发送成功").build();
    }
}
