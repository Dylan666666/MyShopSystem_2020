package com.oym.o2o.dao;

import com.oym.o2o.entity.PersonInfo;
import com.oym.o2o.entity.Shop;
import com.oym.o2o.entity.UserShopMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/4/5 17:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserShopMapDaoTest {
    @Autowired
    private UserShopMapDao userShopMapDao;

    /**
     * 测试添加功能
     * @throws Exception
     */
    @Test
    public void testAInsertUserShopMap() throws Exception {
        // 创建用户店铺积分统计信息1
        UserShopMap userShopMap = new UserShopMap();
        PersonInfo customer = new PersonInfo();
        customer.setUserId(1L);
        userShopMap.setUser(customer);
        Shop shop = new Shop();
        shop.setShopId(21L);
        userShopMap.setShop(shop);
        userShopMap.setCreateTime(new Date());
        userShopMap.setPoint(1);
        int effectedNum = userShopMapDao.insertUserShopMap(userShopMap);
        System.out.println("插入情况为：" + effectedNum);
        // 创建用户店铺积分统计信息2
        UserShopMap userShopMap2 = new UserShopMap();
        PersonInfo customer2 = new PersonInfo();
        customer2.setUserId(1L);
        userShopMap2.setUser(customer2);
        Shop shop2 = new Shop();
        shop2.setShopId(45L);
        userShopMap2.setShop(shop2);
        userShopMap2.setCreateTime(new Date());
        userShopMap2.setPoint(2);
        effectedNum = userShopMapDao.insertUserShopMap(userShopMap2);
        System.out.println("插入情况为：" + effectedNum);
    }

    /**
     * 测试查询功能
     * @throws Exception
     */
    @Test
    public void testBQueryUserShopMap() throws Exception {
        UserShopMap userShopMap = new UserShopMap();
        // 查全部
        List<UserShopMap> userProductMapList = userShopMapDao.queryUserShopMapList(userShopMap, 0, 2);
        int count = userShopMapDao.queryUserShopMapCount(userShopMap);
        System.out.println(userProductMapList.size() + "------" + count);
        // 按店铺去查询
        Shop shop = new Shop();
        shop.setShopId(21L);
        userShopMap.setShop(shop);
        userProductMapList = userShopMapDao.queryUserShopMapList(userShopMap, 0, 3);
        count = userShopMapDao.queryUserShopMapCount(userShopMap);
        System.out.println(userProductMapList.size() + "------" + count);
        // 按用户Id和店铺查询
        userShopMap = userShopMapDao.queryUserShopMap(1, 21);
        System.out.println(userShopMap.getUser().getName());
    }

    /**
     * 测试更新功能
     *
     * @throws Exception
     */
    @Test
    public void testCUpdateUserShopMap() throws Exception {
        UserShopMap userShopMap = null;
        userShopMap = userShopMapDao.queryUserShopMap(1, 21);
        System.out.println("原始积分为：" + userShopMap.getPoint());
        userShopMap.setPoint(10);
        int effectedNum = userShopMapDao.updateUserShopMapPoint(userShopMap);
        System.out.println("更新情况为" + (effectedNum & 1));
    }
    
}
