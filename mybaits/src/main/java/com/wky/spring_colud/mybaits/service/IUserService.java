package com.wky.spring_colud.mybaits.service;

import com.wky.spring_colud.mybaits.dto.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    public abstract String creat(String userName, String passWord);

    public String creatByMybatis(String userName, String passWord);

    public User selectByName(String userName);

}
