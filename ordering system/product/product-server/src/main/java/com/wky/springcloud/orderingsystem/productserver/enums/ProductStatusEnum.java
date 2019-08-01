package com.wky.springcloud.orderingsystem.productserver.enums;

import lombok.Getter;

/**
 * @author wky (kaiyun.wu@qq.com)
 * @version 1.0
 * @date 2019/8/1 0001 14:13
 */
@Getter
public enum ProductStatusEnum {
    /**
     * 商品状态为上架
     */
    UP(1,"上架"),
    /**
     * 商品状态为下架
     */
    DOWN(2,"下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
