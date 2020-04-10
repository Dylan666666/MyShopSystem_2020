package com.oym.ssm.dao;

import com.oym.ssm.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/2/24 13:02
 */
public interface ShopDao {
    
    /**
     * 分页查询店铺，可输入的条件有：店铺名（模糊）；店铺状态；店铺类别；区域ID；owner
     * @param shopCondition
     * @param rowIndex 从第几行开始取数据
     * @param pageSize 返回的条数
     * @return
     */
    List<Shop> queryShopList(@Param("shopCondition")Shop shopCondition,
                             @Param("rowIndex")int rowIndex,
                             @Param("pageSize")int pageSize);

    /**
     * 返回queryShopList的总数
     * @param shopCondition
     * @return
     */
    int queryShopCount(@Param("shopCondition") Shop shopCondition);
    
    /**
     * 根据商铺的ID进行查询
     * @param shopId
     * @return
     */
    Shop queryByShopId(@Param("shopId") long shopId);

    /**
     * 新增店铺     
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     * @param shop
     * @return
     */
    int updateShop(Shop shop);

}
