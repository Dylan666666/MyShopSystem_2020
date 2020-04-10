package com.oym.o2o.service;

import com.oym.o2o.entity.ProductSellDaily;

import java.util.Date;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/4/7 19:45
 */
public interface ProductSellDailyService {
    /**
     * 每日定时对店铺商品销量进行统计
     */
    void dailyCalculate();

    /**
     *
     * @param productSellDailyCondition
     * @param beginTime
     * @param endTime
     * @return
     */
    public List<ProductSellDaily> listProductSellDaily(ProductSellDaily productSellDailyCondition, Date beginTime,
                                                       Date endTime);
}
