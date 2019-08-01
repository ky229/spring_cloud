package com.wky.springcloud.orderingsystem.productserver.repository;

import com.wky.springcloud.orderingsystem.productserver.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wky (kaiyun.wu@qq.com)
 * @version 1.0
 * @date 2019/8/1 0001 11:34
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String>{
    List<ProductInfo> findByProductStatus(Integer productStatus);

    List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
