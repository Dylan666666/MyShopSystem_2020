package com.oym.o2o.dao;

import com.oym.o2o.entity.PersonInfo;
import com.oym.o2o.entity.Shop;
import com.oym.o2o.entity.ShopAuthMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/4/5 21:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopAuthMapDaoTest {
    @Autowired
    private ShopAuthMapDao shopAuthMapDao;

    /**
     * 测试添加功能
     * @throws Exception
     */
    @Test
    public void testAInsertShopAuthMap() throws Exception {
        // 创建店铺授权信息1
        ShopAuthMap shopAuthMap1 = new ShopAuthMap();
        PersonInfo employee = new PersonInfo();
        employee.setUserId(1L);
        shopAuthMap1.setEmployee(employee);
        Shop shop = new Shop();
        shop.setShopId(21L);
        shopAuthMap1.setShop(shop);
        shopAuthMap1.setTitle("CEO");
        shopAuthMap1.setTitleFlag(1);
        shopAuthMap1.setCreateTime(new Date());
        shopAuthMap1.setLastEditTime(new Date());
        shopAuthMap1.setEnableStatus(1);
        int effectedNum = shopAuthMapDao.insertShopAuthMap(shopAuthMap1);
        System.out.println("插入情况为：" + effectedNum);
        // 创建店铺授权信息2
        ShopAuthMap shopAuthMap2 = new ShopAuthMap();
        shopAuthMap2.setEmployee(employee);
        Shop shop2 = new Shop();
        shop2.setShopId(45L);
        shopAuthMap2.setShop(shop2);
        shopAuthMap2.setTitle("财务主管");
        shopAuthMap2.setTitleFlag(2);
        shopAuthMap2.setCreateTime(new Date());
        shopAuthMap2.setLastEditTime(new Date());
        shopAuthMap2.setEnableStatus(0);
        effectedNum = shopAuthMapDao.insertShopAuthMap(shopAuthMap2);
        System.out.println("插入情况为：" + effectedNum);
    }

    /**
     * 测试查询功能
     *
     * @throws Exception
     */
    @Test
    public void testBQueryShopAuth() throws Exception {
        // 测试queryShopAuthMapListByShopId
        List<ShopAuthMap> shopAuthMapList = shopAuthMapDao.queryShopAuthMapListByShopId(21, 0, 2);
        System.out.println(shopAuthMapList.size());
        // 测试queryShopAuthMapById
        ShopAuthMap shopAuth = shopAuthMapDao.queryShopAuthMapById(shopAuthMapList.get(0).getShopAuthId());
        System.out.println("职位：" + shopAuth.getTitle());
        System.out.println("employee's name is :" + shopAuth.getEmployee().getName());
        System.out.println("shop name is :" + shopAuth.getShop().getShopName());
        // 测试queryShopAuthCountByShopId
        int count = shopAuthMapDao.queryShopAuthCountByShopId(21);
        System.out.println(count);
    }

    /**
     * 测试更新功能
     *
     * @throws Exception
     */
    @Test
    public void testCUpdateShopAuthMap() throws Exception {
        List<ShopAuthMap> shopAuthMapList = shopAuthMapDao.queryShopAuthMapListByShopId(21, 0, 1);
        shopAuthMapList.get(0).setTitle("CEO");
        shopAuthMapList.get(0).setTitleFlag(1);
        int effectedNum = shopAuthMapDao.updateShopAuthMap(shopAuthMapList.get(0));
        System.out.println(effectedNum);
    }

    /**
     * 测试删除功能
     *
     * @throws Exception
     */
    @Test
    public void testDeleteShopAuthMap() throws Exception {
        List<ShopAuthMap> shopAuthMapList1 = shopAuthMapDao.queryShopAuthMapListByShopId(45, 0, 1);

        int effectedNum = shopAuthMapDao.deleteShopAuthMap(shopAuthMapList1.get(0).getShopAuthId());
        System.out.println("删除情况为："  + effectedNum);
    }
       
}
