package com.examplecom.wky.springcloud.orderingsystem.orderserver.converter;

import com.examplecom.wky.springcloud.orderingsystem.orderserver.VO.OrderVO;
import com.examplecom.wky.springcloud.orderingsystem.orderserver.dataobject.OrderDetail;
import com.examplecom.wky.springcloud.orderingsystem.orderserver.dto.OrderDTO;
import com.examplecom.wky.springcloud.orderingsystem.orderserver.enums.ResultEnum;
import com.examplecom.wky.springcloud.orderingsystem.orderserver.exception.OrderException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wky (kaiyun.wu@qq.com)
 * @version 1.0
 * @date 2019/8/2 0002 15:36
 */
@Slf4j
public class OrderVO2OrderDTOConverter {
    public static OrderDTO convert(OrderVO orderVO) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderVO.getName());
        orderDTO.setBuyerPhone(orderVO.getPhone());
        orderDTO.setBuyerAddress(orderVO.getAddress());
        orderDTO.setBuyerOpenid(orderVO.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderVO.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("【json转换】错误, string={}", orderVO.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
