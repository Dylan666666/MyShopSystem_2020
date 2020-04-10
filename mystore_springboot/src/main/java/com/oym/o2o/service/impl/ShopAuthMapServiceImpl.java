package com.oym.o2o.service.impl;

import com.oym.o2o.dao.ShopAuthMapDao;
import com.oym.o2o.dto.ShopAuthMapExecution;
import com.oym.o2o.entity.ShopAuthMap;
import com.oym.o2o.enums.ShopAuthMapStateEnum;
import com.oym.o2o.exceptions.ShopAuthMapOperationException;
import com.oym.o2o.service.ShopAuthMapService;
import com.oym.o2o.util.PageCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/4/5 21:58
 */
@Service
public class ShopAuthMapServiceImpl implements ShopAuthMapService {
    
    @Autowired
    private ShopAuthMapDao shopAuthMapDao;
    private final static Logger LOG = LoggerFactory.getLogger(ShopAuthMapServiceImpl.class);
    
    @Override
    public ShopAuthMapExecution listShopAuthMapByShopId(Long shopId, Integer pageIndex, Integer pageSize) {
        // 空值判断
        if (shopId != null && pageIndex != null && pageSize != null) {
            // 页转行
            int beginIndex = PageCalculator.calculatorRowIndex(pageIndex, pageSize);
            // 查询返回该店铺的授权信息列表
            List<ShopAuthMap> shopAuthMapList = shopAuthMapDao
                    .queryShopAuthMapListByShopId(shopId, beginIndex, pageSize);
            // 返回总数
            int count = shopAuthMapDao.queryShopAuthCountByShopId(shopId);
            ShopAuthMapExecution se = new ShopAuthMapExecution();
            se.setShopAuthMapList(shopAuthMapList);
            se.setCount(count);
            return se;
        } else {
            return null;
        }
    }

    @Override
    public ShopAuthMap getShopAuthMapById(Long shopAuthId) {
        return shopAuthMapDao.queryShopAuthMapById(shopAuthId);
    }

    @Override
    @Transactional
    public ShopAuthMapExecution addShopAuthMap(ShopAuthMap shopAuthMap) throws ShopAuthMapOperationException {
        // 空值判断，主要是对店铺Id和员工Id做校验
        if (shopAuthMap != null && shopAuthMap.getShop() != null && shopAuthMap.getShop().getShopId() != null
                && shopAuthMap.getEmployee() != null && shopAuthMap.getEmployee().getUserId() != null) {
            shopAuthMap.setCreateTime(new Date());
            shopAuthMap.setLastEditTime(new Date());
            shopAuthMap.setEnableStatus(1);
            try {
                // 添加授权信息
                int effectedNum = shopAuthMapDao.insertShopAuthMap(shopAuthMap);
                if (effectedNum <= 0) {
                    LOG.error("添加0条授权信息");
                    throw new ShopAuthMapOperationException("添加授权失败");
                }
                return new ShopAuthMapExecution(ShopAuthMapStateEnum.SUCCESS, shopAuthMap);
            } catch (Exception e) {
                LOG.error("添加授权失败" + e.getMessage());
                throw new ShopAuthMapOperationException("添加授权失败");
            }
        } else {
            return new ShopAuthMapExecution(ShopAuthMapStateEnum.NULL_SHOP_AUTH_INFO);
        }
    }

    @Override
    @Transactional
    public ShopAuthMapExecution modifyShopAuthMap(ShopAuthMap shopAuthMap) throws ShopAuthMapOperationException {
        // 空值判断，主要是对授权Id做校验
        if (shopAuthMap == null || shopAuthMap.getShopAuthId() == null) {
            return new ShopAuthMapExecution(ShopAuthMapStateEnum.NULL_SHOP_AUTH_ID);
        } else {
            try {
                shopAuthMap.setLastEditTime(new Date());
                int effectedNum = shopAuthMapDao.updateShopAuthMap(shopAuthMap);
                if (effectedNum <= 0) {
                    return new ShopAuthMapExecution(ShopAuthMapStateEnum.INNER_ERROR);
                } else {
                    // 创建成功
                    return new ShopAuthMapExecution(ShopAuthMapStateEnum.SUCCESS, shopAuthMap);
                }
            } catch (Exception e) {
                LOG.error("更新授权信息失败" + e.getMessage());
                throw new ShopAuthMapOperationException("更新授权信息失败");
            }
        }
    }
}
