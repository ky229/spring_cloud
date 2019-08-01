package com.wky.springcloud.orderingsystem.productserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wky (kaiyun.wu@qq.com)
 * @version 1.0
 * @date 2019/8/1 0001 17:12
 */
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "this is product-server' msg";
    }
}
