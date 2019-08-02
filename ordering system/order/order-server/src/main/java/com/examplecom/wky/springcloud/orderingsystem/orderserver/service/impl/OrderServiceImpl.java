package com.examplecom.wky.springcloud.orderingsystem.orderserver.service.impl;

import com.examplecom.wky.springcloud.orderingsystem.orderserver.dto.OrderDTO;
import com.examplecom.wky.springcloud.orderingsystem.orderserver.repository.OrderDetailRepository;
import com.examplecom.wky.springcloud.orderingsystem.orderserver.repository.OrderMasterRepository;
import com.examplecom.wky.springcloud.orderingsystem.orderserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wky (kaiyun.wu@qq.com)
 * @version 1.0
 * @date 2019/8/2 0002 15:21
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDetailRepository detailRepository;

    @Autowired
    private OrderMasterRepository masterRepository;

    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        return null;
    }

    /**
     * 完结订单(只能卖家操作)
     *
     * @param orderId
     * @return
     */
    @Override
    public OrderDTO finish(String orderId) {
        return null;
    }
}
