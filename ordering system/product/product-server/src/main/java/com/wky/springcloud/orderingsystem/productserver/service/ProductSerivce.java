package com.wky.springcloud.orderingsystem.productserver.service;

import com.wky.springcloud.orderingsystem.productcommon.common.DecreaseStockInput;
import com.wky.springcloud.orderingsystem.productcommon.common.ProductInfoOutput;
import com.wky.springcloud.orderingsystem.productserver.dataobject.ProductInfo;
import com.wky.springcloud.orderingsystem.productserver.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wky (kaiyun.wu@qq.com)
 * @version 1.0
 * @date 2019/8/1 0001 11:40
 */
public interface ProductSerivce {
    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);

}
