package com.oym.o2o.service;

import com.oym.o2o.dto.ShopAuthMapExecution;
import com.oym.o2o.entity.ShopAuthMap;
import com.oym.o2o.exceptions.ShopAuthMapOperationException;
import org.springframework.stereotype.Service;

/**
 * @Author: Mr_OO
 * @Date: 2020/4/5 21:43
 */
public interface ShopAuthMapService {
    /**
     * 根据店铺Id分页显示该店铺的授权信息
     *
     * @param shopId
     * @param pageIndex
     * @param pageSize
     * @return
     */
    ShopAuthMapExecution listShopAuthMapByShopId(Long shopId, Integer pageIndex, Integer pageSize);

    /**
     * 根据shopAuthId返回对应的授权信息
     *
     * @param shopAuthId
     * @return
     */
    ShopAuthMap getShopAuthMapById(Long shopAuthId);

    /**
     * 添加授权信息
     *
     * @param shopAuthMap
     * @return
     * @throws ShopAuthMapOperationException
     */
    ShopAuthMapExecution addShopAuthMap(ShopAuthMap shopAuthMap) throws ShopAuthMapOperationException;

    /**
     * 更新授权信息，包括职位，状态等
     * 
     * @param shopAuthMap
     * @return
     * @throws ShopAuthMapOperationException
     */
    ShopAuthMapExecution modifyShopAuthMap(ShopAuthMap shopAuthMap) throws ShopAuthMapOperationException;
}
