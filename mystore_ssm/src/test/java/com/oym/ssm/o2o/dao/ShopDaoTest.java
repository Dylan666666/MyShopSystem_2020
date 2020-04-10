package com.oym.ssm.o2o.dao;

import com.oym.ssm.dao.ShopDao;
import com.oym.ssm.entity.Area;
import com.oym.ssm.entity.PersonInfo;
import com.oym.ssm.entity.Shop;
import com.oym.ssm.entity.ShopCategory;
import com.oym.ssm.o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/2/24 13:27
 */
public class ShopDaoTest extends BaseTest {
    
    @Autowired
    private ShopDao shopDao;
    
    @Test
    public void testQueryShopList() {
        Shop shopCondition = new Shop();
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1L);
        shopCondition.setOwner(owner);
        List<Shop> shopList = shopDao.queryShopList(shopCondition,0,100);
        System.out.println("店铺列表的大小：" + shopList.size());
        int count = shopDao.queryShopCount(shopCondition);
        System.out.println("count: " + count);
    }
    
    
    @Test
    public void testQueryByShopId() {
        long shopId = 21;
        Shop shop = shopDao.queryByShopId(shopId);
        System.out.println(shop.getArea().getAreaId());
        System.out.println(shop.getArea().getAreaName());
    }
    
    @Test
    public void testInsertShop() {
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
        int effectedNum = shopDao.insertShop(shop);
        System.out.println("插入状态：" + effectedNum);
    }

    @Test
    public void testUpdateShop() {
        Shop shop = new Shop();
        shop.setShopId(38L);
        shop.setShopName("测试店铺更新");
        shop.setShopDesc("测试地址");
        int effectedNum = shopDao.updateShop(shop);
        System.out.println("更新状态：" + effectedNum);
    }
    
}
