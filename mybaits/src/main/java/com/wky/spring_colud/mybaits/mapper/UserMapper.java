package com.wky.spring_colud.mybaits.mapper;

import com.wky.spring_colud.mybaits.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

//    @Insert("insert into t_user (user_name,pass_word) VALUES(#{userName},#{passWord})")
    public void create(@Param("userName") String userName, @Param("passWord") String passWord);

    public User selectByUserName(@Param("userName") String userName);
}
