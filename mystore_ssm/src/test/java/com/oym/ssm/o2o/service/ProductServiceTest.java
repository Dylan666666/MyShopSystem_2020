package com.oym.ssm.o2o.service;

import com.oym.ssm.dto.ImageHolder;
import com.oym.ssm.dto.ProductExecution;
import com.oym.ssm.entity.Product;
import com.oym.ssm.entity.ProductCategory;
import com.oym.ssm.entity.Shop;
import com.oym.ssm.exceptions.ShopOperationException;
import com.oym.ssm.o2o.BaseTest;
import com.oym.ssm.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/3/6 19:31
 */
public class ProductServiceTest extends BaseTest {
    @Autowired
    private ProductService productService;
    
    @Test
    public void testAddProduct() throws ShopOperationException, FileNotFoundException {
        //创建shopId为21且productCategoryId为2的商品实例并赋值
        Product product = new Product();
        Shop shop = new Shop();
        shop.setShopId(21L);
        ProductCategory pc = new ProductCategory();
        pc.setProductCategoryId(2L);
        product.setShop(shop); 
        product.setProductCategory(pc);
        product.setProductName("咖啡烤奶");
        product.setProductDesc("浓浓的，淳淳的");
        product.setPriority(1);
        product.setCreateTime(new Date());
        product.setEnableStatus(1);
        //创建缩略图文件流
        File thumbnailFile = new File("O:/myimage/1.jpg");
        InputStream is = new FileInputStream(thumbnailFile);
        ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(),is);
        File thumbnailFile1 = new File("O:/myimage/2.jpg");
        InputStream is2 = new FileInputStream(thumbnailFile1);
        File thumbnailFile2 = new File("O:/myimage/3.jpg");
        InputStream is3 = new FileInputStream(thumbnailFile2);
        List<ImageHolder> imageHolderList = new ArrayList<>();
        imageHolderList.add(new ImageHolder(thumbnailFile.getName(),is2));
        imageHolderList.add(new ImageHolder(thumbnailFile.getName(),is3));
        //添加商品并验证
        ProductExecution pe = productService.addProduct(product,thumbnail,imageHolderList);
        System.out.println("添加商品状态为：" + pe);
    }

    @Test
    public void testModifyProduct() throws ShopOperationException {
        Product product = new Product();
        product.setProductId(1L);
        Shop shop = new Shop();
        shop.setShopId(21L);
        product.setShop(shop);
        product.setPromotionPrice("6.8");
        ProductExecution pe = productService.modifyProduct(product,null,null);
        System.out.println("更新商品状态为：" + pe.getStateInfo());
    }
    
}
