package com.examplecom.wky.springcloud.orderingsystem.orderserver.utils;

import com.examplecom.wky.springcloud.orderingsystem.orderserver.VO.ResultVO;

/**
 * @author wky (kaiyun.wu@qq.com)
 * @version 1.0
 * @date 2019/8/2 0002 15:41
 */
public class ResultVOUtil {
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
