package com.examplecom.wky.springcloud.orderingsystem.orderserver.service;

import com.examplecom.wky.springcloud.orderingsystem.orderserver.dto.OrderDTO;

/**
 * @author wky (kaiyun.wu@qq.com)
 * @version 1.0
 * @date 2019/8/2 0002 15:20
 */
public interface OrderService {
    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 完结订单(只能卖家操作)
     * @param orderId
     * @return
     */
    OrderDTO finish(String orderId);
}
