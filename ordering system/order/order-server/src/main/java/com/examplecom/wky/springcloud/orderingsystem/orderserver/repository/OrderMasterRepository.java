package com.examplecom.wky.springcloud.orderingsystem.orderserver.repository;

import com.examplecom.wky.springcloud.orderingsystem.orderserver.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wky (kaiyun.wu@qq.com)
 * @version 1.0
 * @date 2019/8/2 0002 15:17
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
