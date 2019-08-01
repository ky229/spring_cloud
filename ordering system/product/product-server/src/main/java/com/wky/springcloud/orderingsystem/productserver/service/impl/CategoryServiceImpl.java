package com.wky.springcloud.orderingsystem.productserver.service.impl;

import com.wky.springcloud.orderingsystem.productserver.dataobject.ProductCategory;
import com.wky.springcloud.orderingsystem.productserver.repository.ProductCategoryRepository;
import com.wky.springcloud.orderingsystem.productserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wky (kaiyun.wu@qq.com)
 * @version 1.0
 * @date 2019/8/1 0001 11:50
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository categoryRepository;
    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return categoryRepository.findProductCategoriesByCategoryTypeIn(categoryTypeList);
    }
}
