package com.li.house.api;

import com.li.house.common.util.RestResult;

public interface VerificationCodeService {

    /**
     * 验证码
     * @param
     * @return
     */
    RestResult sendMsm(String phoneNum, String type);
}
