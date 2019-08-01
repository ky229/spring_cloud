package com.wky.springcloud.orderingsystem.productserver.exception;

import com.wky.springcloud.orderingsystem.productserver.enums.ResultStatusEnum;

/**
 * @author wky (kaiyun.wu@qq.com)
 * @version 1.0
 * @date 2019/8/1 0001 15:50
 */
public class ProductException extends RuntimeException{
    private Integer status;

    public ProductException(Integer status, String message) {
        super(message);
        this.status = status;
    }

    public ProductException(ResultStatusEnum resultEnum) {
        super(resultEnum.getMessage());
        this.status = resultEnum.getStatus();
    }
}
