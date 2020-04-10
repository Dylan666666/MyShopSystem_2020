package com.oym.ssm.o2o.dao;

import com.oym.ssm.dao.ShopCategoryDao;
import com.oym.ssm.entity.ShopCategory;
import com.oym.ssm.o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/2/27 14:21
 */
public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
    private ShopCategoryDao shopCategoryDao;
    
    @Test
    public void testQueryShopCategory() { 
        List<ShopCategory> shopCategories = shopCategoryDao.queryShopCategory(null);
        System.out.println("商店种类有：" + shopCategories.size() + "种");
    }
    
}
