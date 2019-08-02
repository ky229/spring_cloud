package com.examplecom.wky.springcloud.orderingsystem.orderserver.contorller;

import com.examplecom.wky.springcloud.orderingsystem.orderserver.VO.OrderVO;
import com.examplecom.wky.springcloud.orderingsystem.orderserver.VO.ResultVO;
import com.examplecom.wky.springcloud.orderingsystem.orderserver.converter.OrderVO2OrderDTOConverter;
import com.examplecom.wky.springcloud.orderingsystem.orderserver.dto.OrderDTO;
import com.examplecom.wky.springcloud.orderingsystem.orderserver.enums.ResultEnum;
import com.examplecom.wky.springcloud.orderingsystem.orderserver.exception.OrderException;
import com.examplecom.wky.springcloud.orderingsystem.orderserver.service.OrderService;
import com.examplecom.wky.springcloud.orderingsystem.orderserver.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wky (kaiyun.wu@qq.com)
 * @version 1.0
 * @date 2019/8/2 0002 15:32
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 1. 参数检验
     * 2. 查询商品信息(调用商品服务)
     * 3. 计算总价
     * 4. 扣库存(调用商品服务)
     * 5. 订单入库
     */
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderVO orderVO,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确, OrderVO={}", orderVO);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        // OrderVO -> orderDTO
        OrderDTO orderDTO = OrderVO2OrderDTOConverter.convert(orderVO);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());
        return ResultVOUtil.success(map);
    }

    /**
     * 完结订单
     * @param orderId
     * @return
     */
    @PostMapping("/finish")
    public ResultVO<OrderDTO> finish(@RequestParam("orderId") String orderId) {
        return ResultVOUtil.success(orderService.finish(orderId));
    }

}
