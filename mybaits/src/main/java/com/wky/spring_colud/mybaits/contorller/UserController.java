package com.wky.spring_colud.mybaits.contorller;


import com.wky.spring_colud.mybaits.dto.User;
import com.wky.spring_colud.mybaits.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping("registe")
    @ResponseBody
    public String registeUser(String userName, String passWord){
        String status = userService.creat(userName, passWord);
        return "用户： " + userName + "  注册状态： " +   status;
    }

    @RequestMapping("creat")
    public String creatUser(String userName, String passWord){
        String status = userService.creatByMybatis(userName, passWord);
        return "用户： " + userName + "  注册状态： " +   status;
    }

    @RequestMapping("/selectByName")
    public User selectByName(String userName){
        return userService.selectByName(userName);
    }

}
