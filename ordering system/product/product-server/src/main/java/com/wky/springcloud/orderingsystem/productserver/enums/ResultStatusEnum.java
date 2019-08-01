package com.wky.springcloud.orderingsystem.productserver.enums;

import lombok.Getter;

/**
 * @author wky (kaiyun.wu@qq.com)
 * @version 1.0
 * @date 2019/8/1 0001 14:57
 */
@Getter
public enum ResultStatusEnum {
    /**
     * 成功
     */
    SUCCESS(1,"success"),

    /**
     * 失败
     */
    FAILED(0,"failed"),

    PRODUCT_NOT_EXIST(1, "商品不存在"),

    PRODUCT_STOCK_ERROR(2, "库存有误"),;

    private Integer status;

    private String message;

    ResultStatusEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
