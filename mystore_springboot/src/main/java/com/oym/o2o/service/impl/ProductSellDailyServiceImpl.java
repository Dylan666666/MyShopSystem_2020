package com.oym.o2o.service.impl;

import com.oym.o2o.dao.ProductSellDailyDao;
import com.oym.o2o.entity.ProductSellDaily;
import com.oym.o2o.service.ProductSellDailyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/4/7 19:47
 */
@Service
public class ProductSellDailyServiceImpl implements ProductSellDailyService {
    
    private static final Logger log = LoggerFactory.getLogger(ProductSellDailyServiceImpl.class);
    @Autowired
    private ProductSellDailyDao productSellDailyDao;

    /**
     * 根据查询条件返回商品日销售的统计列表
     * @param productSellDailyCondition
     * @param beginTime
     * @param endTime
     * @return
     */
    @Override
    public List<ProductSellDaily> listProductSellDaily(ProductSellDaily productSellDailyCondition, 
                                                       Date beginTime, 
                                                       Date endTime) {
        return productSellDailyDao.queryProductSellDailyList(productSellDailyCondition, beginTime, endTime);
    }

    /**
     * 每日定时对所有店铺的商品销量进行统计
     */
    @Override
    public void dailyCalculate() {
        log.info("Quartz Running!");
        // 统计在tb_user_product_map里面产生销量的每个店铺的各件商品的日销量
        productSellDailyDao.insertProductSellDaily();
        // 统计余下的商品的日销量，全部置为0（为了迎合echarts的数据请求）
        productSellDailyDao.insertDefaultProductSellDaily();
    }
}
