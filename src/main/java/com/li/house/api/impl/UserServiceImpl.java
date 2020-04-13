package com.li.house.api.impl;

import com.li.house.api.UserService;
import com.li.house.common.dao.UserMapper;
import com.li.house.common.domain.User;
import com.li.house.common.dto.UserDTO;
import com.li.house.common.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JWTRedisUtils jwtRedisUtils;


    /**
     * 用户登录
     * @param userDTO
     * @return
     */
    @Override
    public RestResult loginUser(UserDTO userDTO) {
        if (userDTO==null||userDTO.equals("")||userDTO.getPhoneNum()==null||userDTO.getPhoneNum().equals("")
                ||userDTO.getPassword()==null||userDTO.getPassword().equals("")){
            return new RestResultBuilder().setCode(ResultCode.ERROR.getCode()).setMsg("必填信息为空，请检查").build();
        }
        User checkUser = userMapper.selectByUserPhoneNum(userDTO.getPhoneNum());
        if (checkUser==null||checkUser.equals("")){
            return new RestResultBuilder().setCode(ResultCode.ERROR.getCode()).setMsg("用户不存在，请检查").build();
        }
        if (!checkUser.getuPassword().equals(userDTO.getPassword())){
            return new RestResultBuilder().setCode(ResultCode.ERROR.getCode()).setMsg("密码错误，请检查").build();
        }
        return new RestResultBuilder().setCode(ResultCode.SUCCESS.getCode()).setMsg("登录成功，请稍后").setData(checkUser).build();
    }


    /**
     * 用户注册
     * @param userDTO
     * @return
     */
    @Override
    public RestResult insertUser(UserDTO userDTO) {
        if (userDTO.equals("")||userDTO==null){
            return new RestResultBuilder().setMsg("必填信息为空，请检查").setCode(ResultCode.ERROR.getCode()).build();
        }
        User checkUser = userMapper.selectByUserPhoneNum(userDTO.getPhoneNum());
        if (checkUser!=null){
            return new RestResultBuilder().setMsg("该手机号已注册，是否去登录").setCode(ResultCode.ERROR.getCode()).build();
        }
        String SMSCode = jwtRedisUtils.get(userDTO.getPhoneNum());
        if (userDTO.getVerificationCode().equals("")||userDTO.getVerificationCode()==null||!SMSCode.equals(userDTO.getVerificationCode())){
            return new RestResultBuilder().setMsg("验证码错误或者已经失效，请重新请求").setCode(ResultCode.ERROR.getCode()).build();
        }
        User insertUser = new User();
        insertUser.setuId(UUIDUtils.UUIDGenerate());
        insertUser.setuPhonenum(userDTO.getPhoneNum());
        insertUser.setuPassword(userDTO.getPassword());
        insertUser.setuCreatetime(new Date());
        userMapper.insertSelective(insertUser);
        return new RestResultBuilder().setMsg("注册成功，请登录").setCode(ResultCode.SUCCESS.getCode()).build();
    }


    /**
     * 得到用户信息
     * @param userDTO
     * @return
     */
    @Override
    public RestResult getUserInfo(UserDTO userDTO) {
        if (userDTO==null||userDTO.getuId()==null){
            new RestResultBuilder().setMsg("用户信息失效，请重新登录").setCode(ResultCode.ERROR.getCode()).build();
        }
        User user = userMapper.selectByPrimaryKey(userDTO.getuId());
        if (user==null){
            new RestResultBuilder().setMsg("用户信息失误，请重新登录").setCode(ResultCode.ERROR.getCode()).build();
        }
        return new RestResultBuilder().setData(user).setMsg("用户信息").setCode(ResultCode.SUCCESS.getCode()).build();
    }




    /**
     * 修改用户信息
     * @param userDTO
     * @return
     */
    @Override
    public RestResult updateUserInfo(UserDTO userDTO) {
        System.out.println(userDTO);
        if (userDTO==null||userDTO.equals("")){
            return new RestResultBuilder().setCode(ResultCode.ERROR.getCode()).setMsg("信息为空").build();
        }
        if (userDTO.getuId()==null||userDTO.getuId().equals("")){
            return new RestResultBuilder().setCode(ResultCode.ERROR.getCode()).setMsg("用户信息有误，请重新登录").build();
        }
        User user = userMapper.selectByPrimaryKey(userDTO.getuId());
        System.out.println(user);
        if (user==null){
            return new RestResultBuilder().setCode(ResultCode.ERROR.getCode()).setMsg("信息有错，请重新登录").build();
        }
        User newUser = new User();
        newUser.setuId(userDTO.getuId());
        newUser.setuEmail(userDTO.getEmail());
        newUser.setuNickname(userDTO.getNickname());
        System.out.println(newUser);
        userMapper.updateByPrimaryKeySelective(newUser);
        return new RestResultBuilder().setCode(ResultCode.SUCCESS.getCode()).setMsg("修改成功").build();
    }


    /**
     *
     * @param user
     * @return
     */
    @Override
    public RestResult updateByPrimaryKeySelective(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        return new RestResultBuilder().setCode(ResultCode.SUCCESS.getCode()).setMsg("修改成功").build();
    }

}
