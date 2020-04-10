package com.oym.o2o.dao;

import com.oym.o2o.entity.PersonInfo;
import com.oym.o2o.entity.Product;
import com.oym.o2o.entity.Shop;
import com.oym.o2o.entity.UserProductMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/4/5 14:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserProductMapDaoTest {
    @Autowired
    private UserProductMapDao userProductMapDao;

    /**
     * 测试添加功能
     * @throws Exception
     */
    @Test
    public void testAInsertUserProductMap() throws Exception {
        // 创建用户商品映射信息1
        UserProductMap userProductMap = new UserProductMap();
        PersonInfo customer = new PersonInfo();
        customer.setUserId(1L);
        userProductMap.setUser(customer);
        userProductMap.setOperator(customer);
        Product product = new Product();
        product.setProductId(1L);
        userProductMap.setProduct(product);
        Shop shop = new Shop();
        shop.setShopId(21L);
        userProductMap.setShop(shop);
        userProductMap.setCreateTime(new Date());
        int effectedNum = userProductMapDao.insertUserProductMap(userProductMap);
        System.out.println("插入状况为：" + effectedNum );
        // 创建用户商品映射信息2
        UserProductMap userProductMap2 = new UserProductMap();
        userProductMap2.setUser(customer);
        userProductMap2.setOperator(customer);
        Product product2 = new Product();
        product2.setProductId(2L);
        userProductMap2.setProduct(product2);
        Shop shop2 = new Shop();
        shop2.setShopId(21L);
        userProductMap2.setShop(shop2);
        userProductMap2.setCreateTime(new Date());
        effectedNum = userProductMapDao.insertUserProductMap(userProductMap2);
        System.out.println("插入状况为：" + effectedNum );
    }

    /**
     * 测试查询功能
     *
     * @throws Exception
     */
    @Test
    public void testBQueryUserProductMap() throws Exception {
        UserProductMap userProductMap = new UserProductMap();
        PersonInfo customer = new PersonInfo();
        // 按顾客名字模糊查询
        customer.setName("鸣");
        userProductMap.setUser(customer);
        List<UserProductMap> userProductMapList = userProductMapDao.queryUserProductMapList(userProductMap, 0, 2);
        System.out.println(userProductMapList.size());
        int count = userProductMapDao.queryUserProductMapCount(userProductMap);
        System.out.println(count);
        // 叠加店铺去查询
        Shop shop = new Shop();
        shop.setShopId(21L);
        userProductMap.setShop(shop);
        userProductMapList = userProductMapDao.queryUserProductMapList(userProductMap, 0, 3);
        System.out.println(userProductMapList.size());
        count = userProductMapDao.queryUserProductMapCount(userProductMap);
        System.out.println(count);
    }

}
