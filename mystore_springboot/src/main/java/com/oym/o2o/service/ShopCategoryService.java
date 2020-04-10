package com.oym.o2o.service;

import com.oym.o2o.entity.ShopCategory;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/2/27 15:55
 */
public interface ShopCategoryService {
    public final static String SC_LIST_KEY = "shopcategorylist";
    
    /**
     * 根据传入的条件返回指定的店铺类别列表
     * @param shopCategoryCondition
     * @return
     */
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
