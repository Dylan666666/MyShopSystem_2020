package com.oym.o2o.dao;

import com.oym.o2o.entity.ProductSellDaily;
import com.oym.o2o.entity.Shop;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/4/5 15:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductSellDailyDaoTest {
    @Autowired
    private ProductSellDailyDao productSellDailyDao;

    /**
     * 测试添加功能
     *
     * @throws Exception
     */
    @Test
    public void testAInsertProductSellDaily() throws Exception {
        // 创建商品日销量统计
        int effectedNum = productSellDailyDao.insertProductSellDaily();
        System.out.println("insert" + effectedNum);
    }

    /**
     * 测试添加功能
     * @throws Exception
     */
    @Test
    public void testBInsertDefaultProductSellDaily() throws Exception {
        // 创建商品日销量统计
        int effectedNum = productSellDailyDao.insertDefaultProductSellDaily();
        System.out.println("insertDefault" + effectedNum);
    }

    /**
     * 测试查询功能
     * @throws Exception
     */
    @Test
    public void testCQueryProductSellDaily() throws Exception {
        ProductSellDaily productSellDaily = new ProductSellDaily();
        // 叠加店铺去查询
        Shop shop = new Shop();
        shop.setShopId(21L);
        productSellDaily.setShop(shop);
        List<ProductSellDaily> productSellDailyList = productSellDailyDao.queryProductSellDailyList(productSellDaily,
                null, null);
        System.out.println(productSellDailyList.size());
    }
}
