package com.wky.springcloud.orderingsystem.productserver.utils;

import com.wky.springcloud.orderingsystem.productserver.VO.ResultVO;
import com.wky.springcloud.orderingsystem.productserver.enums.ResultStatusEnum;

/**
 * @author wky (kaiyun.wu@qq.com)
 * @version 1.0
 * @date 2019/8/1 0001 15:15
 */
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setStatus(ResultStatusEnum.SUCCESS.getStatus());
        resultVO.setMessage(ResultStatusEnum.SUCCESS.getMessage());
        resultVO.setDate(object);
        return resultVO;
    }
}
