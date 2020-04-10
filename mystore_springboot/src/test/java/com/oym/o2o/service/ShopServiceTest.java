package com.oym.o2o.service;

import com.oym.o2o.dto.ImageHolder;
import com.oym.o2o.dto.ShopExecution;
import com.oym.o2o.entity.Area;
import com.oym.o2o.entity.PersonInfo;
import com.oym.o2o.entity.Shop;
import com.oym.o2o.entity.ShopCategory;
import com.oym.o2o.exceptions.ShopOperationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

/**
 * @Author: Mr_OO
 * @Date: 2020/2/25 14:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopServiceTest {
    @Autowired
    private ShopService shopService;
    
    @Test
    public void testQueryShopListAndCount() {
        Shop shopCondition = new Shop();
        ShopCategory sc = new ShopCategory();
        sc.setShopCategoryId(2L);
        shopCondition.setShopCategory(sc);
        ShopExecution se = shopService.getShopList(shopCondition, 0, 100);
        System.out.println("店铺列表数为：" + se.getShopList().size());
        System.out.println("店铺总数为：" + se.getCount());
    }
    
    @Test
    public void testModifyShop() throws ShopOperationException,FileNotFoundException {
        Shop shop = new Shop();
        shop.setShopId(21L);
        shop.setShopName("泡泡~Coffee");
        File shopImg = new File("o:/myimage/ftea.jpg");
        InputStream is = new FileInputStream(shopImg);
        ImageHolder thumbnail = new ImageHolder(is,"ftea.jpg");
        ShopExecution shopExecution = shopService.modifyShop(shop,thumbnail);
//        System.out.println("图片新地址：" + shopExecution.getShop().getShopImg());
    };
    
    @Test
    public void testAddShop() throws FileNotFoundException {
        Shop shop = new Shop();
        PersonInfo personInfo = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        personInfo.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(personInfo);
        shop.setArea(area);
        shop.setShopName("测试店铺");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(0);    
        File shopImg =  new File("O:/myimage/paidax.jpg") ;
        InputStream shopImgInputStream = new FileInputStream(shopImg);
        ImageHolder thumbnail = new ImageHolder(shopImgInputStream,shopImg.getName());
        ShopExecution se = shopService.addShop(shop,thumbnail);
        System.out.println(se.getState());
    }
    
}
