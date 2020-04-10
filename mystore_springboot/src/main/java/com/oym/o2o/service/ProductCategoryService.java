package com.oym.o2o.service;

import com.oym.o2o.dto.ProductCategoryExecution;
import com.oym.o2o.entity.ProductCategory;
import com.oym.o2o.exceptions.ProductCategoryOperationException;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/3/4 10:51
 */
public interface ProductCategoryService {

    /**
     * 查询某个指定店铺下的所有商品类别信息
     * @param shopId
     * @return
     */
    List<ProductCategory> getProductCategoryList(long shopId);

    /**
     * 批量添加商品类别
     * @param productCategoryList
     * @return
     * @throws ProductCategoryOperationException
     */
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
        throws ProductCategoryOperationException;

    /**
     * 将此类别下的商品里的类别ID置为空，再删除该商品类别
     * @param productCategoryId
     * @param shopId
     * @return
     */
    ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId);
    
}
