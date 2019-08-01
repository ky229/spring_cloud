package com.wky.springcloud.orderingsystem.productserver.controller;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.wky.springcloud.orderingsystem.productcommon.common.DecreaseStockInput;
import com.wky.springcloud.orderingsystem.productcommon.common.ProductInfoOutput;
import com.wky.springcloud.orderingsystem.productserver.VO.ProductInfoVO;
import com.wky.springcloud.orderingsystem.productserver.VO.ProductVO;
import com.wky.springcloud.orderingsystem.productserver.VO.ResultVO;
import com.wky.springcloud.orderingsystem.productserver.dataobject.ProductCategory;
import com.wky.springcloud.orderingsystem.productserver.dataobject.ProductInfo;
import com.wky.springcloud.orderingsystem.productserver.enums.ProductStatusEnum;
import com.wky.springcloud.orderingsystem.productserver.service.CategoryService;
import com.wky.springcloud.orderingsystem.productserver.service.ProductSerivce;
import com.wky.springcloud.orderingsystem.productserver.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author wky (kaiyun.wu@qq.com)
 * @version 1.0
 * @date 2019/8/1 0001 11:36
 */
@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductSerivce productService;

    /**
     * 1. 查询所有在架的商品
     * 2. 获取类目type列表
     * 3. 查询类目
     * 4. 构造数据
     */
    @GetMapping("/all")
    public ResultVO findAllProduct(){
        //1. 查询所有在架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2. 获取类目type列表
        List<Integer> categoryTypeLists = productInfoList.stream().
                map(ProductInfo::getCategoryType).collect(Collectors.toList());

        //3. 查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeLists);

        //4. 构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory perCategory:categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(perCategory.getCategoryName());
            productVO.setCategoryType(perCategory.getCategoryType());

            //构造ProductInfoVOList
            List<ProductInfoVO> infoVOList = new ArrayList<>();
            for (ProductInfo productInfo:productInfoList) {
                if(perCategory.getCategoryType().equals(productInfo.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    infoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(infoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }


    /**
     * 获取商品列表(给订单服务用的)
     *
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return productService.findList(productIdList);
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList) {
        productService.decreaseStock(decreaseStockInputList);
    }
}
