package com.wky.spring_colud.mybaits.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(basePackages = "com.wky") //拦截异常的扫描路径
public class RuntimeExceptionHandler {

    @ExceptionHandler(RuntimeException.class)   //表示拦截运行时异常
    @ResponseBody
    public Map<String,Object>runtimeExceptionHandler(HttpServletRequest request, RuntimeException e){
        e.printStackTrace();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("path",request.getRequestURI());
        map.put("code",100);
        map.put("message","系统错误，请联系管理员！");
        map.put("errormessge",e.getMessage());
        return map;
    }
}

