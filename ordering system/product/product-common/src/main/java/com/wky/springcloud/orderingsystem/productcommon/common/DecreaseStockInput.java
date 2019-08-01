package com.wky.springcloud.orderingsystem.productcommon.common;

import lombok.Data;

@Data
public class DecreaseStockInput {

    private String productId;

    private Integer productQuantity;

}