package com.examplecom.wky.springcloud.orderingsystem.orderserver.VO;

import lombok.Data;

/**
 * @author wky (kaiyun.wu@qq.com)
 * @version 1.0
 * @date 2019/8/2 0002 15:30
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
