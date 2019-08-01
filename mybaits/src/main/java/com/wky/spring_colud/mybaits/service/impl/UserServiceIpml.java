package com.wky.spring_colud.mybaits.service.impl;


import com.wky.spring_colud.mybaits.dto.User;
import com.wky.spring_colud.mybaits.mapper.UserMapper;
import com.wky.spring_colud.mybaits.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public  class UserServiceIpml implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional  //启动事务
    @Override
    public String creat(String userName, String passWord){
        Integer status = 1;
        if(status > 0){
            return "success";
        }else
            return "fail";
    };

    @Transactional
    @Override
    public String creatByMybatis(String userName, String passWord){
        Integer status = 0;
        userMapper.create(userName,passWord);
        if(status > 0){
            return "success";
        }else
            return "fail";
    };

    @Override
    public User selectByName(String userName) {
        User user = userMapper.selectByUserName(userName);
        return user;
    }
}
