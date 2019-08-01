package com.wky.springcloud.orderingsystem.productserver.repository;

import com.wky.springcloud.orderingsystem.productserver.ProductServerApplicationTests;
import com.wky.springcloud.orderingsystem.productserver.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wky (kaiyun.wu@qq.com)
 * @version 1.0
 * @date 2019/8/1 0001 10:38
 */
public class ProductCategoryRepositoryTest extends ProductServerApplicationTests {

    @Autowired
    private  ProductCategoryRepository productCategoryRepository;

    @Test
    public void findProductCategoriesByCategoryIdIn() {
        List<ProductCategory> list = productCategoryRepository.findProductCategoriesByCategoryTypeIn(Arrays.asList(Integer.valueOf(11),22));
        Assert.assertTrue(list.size() > 0);
    }
}