package com.oym.ssm.service;

import com.oym.ssm.dto.ImageHolder;
import com.oym.ssm.dto.ShopExecution;
import com.oym.ssm.entity.Shop;
import com.oym.ssm.exceptions.ShopOperationException;

/**
 * @Author: Mr_OO
 * @Date: 2020/2/25 11:33
 */
public interface ShopService {

    /**
     * 根据shopCondition分页返回相应店铺列表
     * @param shopCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    ShopExecution getShopList(Shop shopCondition,int pageIndex,int pageSize);
    
    /**
     * 注册店铺信息，包括图片处理
     * @param shop
     * @param thumbnail
     * @return
     */
    ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;

    /**
     * 通过店铺的ID获取店铺
     * @param shopId
     * @return
     */
    Shop getByShopId(long shopId);

    /**
     * 更新店铺信息，包括图片处理
     * @param shop
     * @param thumbnail
     * @return
     */
    ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
    
}
