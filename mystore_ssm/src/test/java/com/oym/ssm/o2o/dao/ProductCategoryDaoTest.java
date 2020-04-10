package com.oym.ssm.o2o.dao;

import com.oym.ssm.dao.ProductCategoryDao;
import com.oym.ssm.entity.ProductCategory;
import com.oym.ssm.o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/3/3 23:13
 */
public class ProductCategoryDaoTest extends BaseTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;
    
    @Test
    public void testQueryByShopId() throws Exception {
        long shopId = 21;
        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
        System.out.println("商品种类有：" + productCategoryList.size() + "种");
    }
    
    @Test
    public void testBatchInsertProductCategory() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryName("类别4");
        productCategory.setPriority(5);
        productCategory.setCreateTime(new Date());
        productCategory.setShopId(21L);
        ProductCategory productCategory2 = new ProductCategory();
        productCategory2.setProductCategoryName("类别5");
        productCategory2.setPriority(5);
        productCategory2.setCreateTime(new Date());
        productCategory2.setShopId(21L);
        List<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList.add(productCategory);
        productCategoryList.add(productCategory2);
        int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
        System.out.println("插入结果为 ：" + effectedNum);
    }
    
    @Test
    public void testDeleteProductCategory() throws Exception {
        int effectedNum = productCategoryDao.deleteProductCategory(6,21L);
        System.out.println("删除的条数为：" + effectedNum);
    }
    
}
