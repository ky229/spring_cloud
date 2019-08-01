package com.wky.springcloud.orderingsystem.productserver.VO;

import lombok.Data;

/**
 * @author wky (kaiyun.wu@qq.com)
 * @version 1.0
 * @date 2019/8/1 0001 10:31
 */
@Data
public class ResultVO<T> {
    //状态码
    private Integer status;
    //提示信息
    private String message;
    //返回内容
    private T date;
}
