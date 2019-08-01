package com.wky.spring_colud.mybaits.contorller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exceptionTest")
public class ExceptionTestController {

    @RequestMapping("byZero")
    @ResponseBody
    public String byZero(){
       int i =  10 / 0;
       return "byZero";
    }
}
