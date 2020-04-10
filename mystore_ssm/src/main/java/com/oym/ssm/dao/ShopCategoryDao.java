package com.oym.ssm.dao;

import com.oym.ssm.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/2/27 14:06
 */
public interface ShopCategoryDao {
    /**
     * 根据传入的查询条件返回店铺类别列表
     * @param shopCategoryCondition
     * @return
     */
    List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition")ShopCategory shopCategoryCondition);
}
