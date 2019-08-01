package com.wky.springcloud.orderingsystem.productserver.service;

import com.wky.springcloud.orderingsystem.productserver.dataobject.ProductCategory;

import java.util.List;

/**
 * @author wky (kaiyun.wu@qq.com)
 * @version 1.0
 * @date 2019/8/1 0001 11:43
 */
public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
