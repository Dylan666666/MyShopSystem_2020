package com.oym.ssm.o2o.dao;

import com.oym.ssm.dao.ProductDao;
import com.oym.ssm.entity.Product;
import com.oym.ssm.entity.ProductCategory;
import com.oym.ssm.entity.Shop;
import com.oym.ssm.o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/3/5 18:57
 */
public class ProductDaoTest extends BaseTest {
    @Autowired
    private ProductDao productDao;
    
    @Test
    public void testInsertProduct() {
        Shop shop = new Shop();
        shop.setShopId(21L);
        ProductCategory pc = new ProductCategory();
        pc.setProductCategoryId(2L);
        Product product1 = new Product();
        product1.setProductName("阿萨姆");
        product1.setProductDesc("阿萨姆哟");
        product1.setImgAddr("1");
        product1.setPriority(1);
        product1.setEnableStatus(1);
        product1.setCreateTime(new Date());
        product1.setLastEditTime(new Date());
        product1.setShop(shop);
        product1.setProductCategory(pc);
        Product product2 = new Product();
        product2.setProductName("四季奶青");
        product2.setProductDesc("好喝哟");
        product2.setImgAddr("2");
        product2.setPriority(1);
        product2.setEnableStatus(1);
        product2.setCreateTime(new Date());
        product2.setLastEditTime(new Date());
        product2.setShop(shop);
        product2.setProductCategory(pc);
        int effectedNum = productDao.insertProduct(product1);
        System.out.println("商品插入情况为：" + effectedNum);
        effectedNum = productDao.insertProduct(product2);
        System.out.println("商品插入情况为：" + effectedNum);
    }
    
    @Test
    public void testQueryProductByProductId() {
        Product product = productDao.queryProductById(1);
        if (product != null) {
            System.out.println(product.getProductName());
        }
    }
    
    @Test
    public void testUpdateProduct() {
        Product product = new Product();
        product.setProductId(1L);
        Shop shop = new Shop();
        shop.setShopId(21L);
        product.setShop(shop);
        product.setPromotionPrice("6");
        System.out.println("更新情况为：" + productDao.updateProduct(product));
    }
    
    @Test
    public void testQueryProductList() throws Exception {
        Product productCondition = new Product();
        List<Product> productList = productDao.queryProductList(productCondition,0,100);
        int count = productDao.queryProductCount(productCondition);
        System.out.println("第一次无条件查询：" + productList.size() + "count: " + count);
        Shop shop = new Shop();
        shop.setShopId(21L);
        productCondition.setShop(shop);
        List<Product> productList01 = productDao.queryProductList(productCondition,0,100);
        count = productDao.queryProductCount(productCondition);
        System.out.println("第二次条件查询：" + productList01.size() + "count: " + count);
    }
    
    @Test
    public void testUpdateProductCategoryToNull() {
        int effectedNum = productDao.updateProductCategoryToNull(2L);
        System.out.println("删除情况为：" + effectedNum);
    }
}
