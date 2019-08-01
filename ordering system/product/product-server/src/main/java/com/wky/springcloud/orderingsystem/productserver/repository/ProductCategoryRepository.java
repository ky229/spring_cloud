package com.wky.springcloud.orderingsystem.productserver.repository;

import com.wky.springcloud.orderingsystem.productserver.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wky (kaiyun.wu@qq.com)
 * @version 1.0
 * @date 2019/8/1 0001 10:35
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{
    List<ProductCategory> findProductCategoriesByCategoryTypeIn(List<Integer> productCategoryTypes);
}
