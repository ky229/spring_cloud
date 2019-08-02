package com.examplecom.wky.springcloud.orderingsystem.orderserver.dto;

import lombok.Data;

/**
 * @author wky (kaiyun.wu@qq.com)
 * @version 1.0
 * @date 2019/8/2 0002 15:18
 */
@Data
public class CartDTO {
    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
