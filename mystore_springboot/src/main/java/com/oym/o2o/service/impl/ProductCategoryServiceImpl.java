package com.oym.o2o.service.impl;

import com.oym.o2o.dao.ProductCategoryDao;
import com.oym.o2o.dao.ProductDao;
import com.oym.o2o.dto.ProductCategoryExecution;
import com.oym.o2o.entity.ProductCategory;
import com.oym.o2o.enums.ProductCategoryStateEnum;
import com.oym.o2o.exceptions.ProductCategoryOperationException;
import com.oym.o2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/3/4 10:53
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;
    
    @Autowired
    private ProductDao productDao;
    
    @Override
    public List<ProductCategory> getProductCategoryList(long shopId) {
        return productCategoryDao.queryProductCategoryList(shopId);
    }

    @Override
    @Transactional
    public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) 
            throws ProductCategoryOperationException {
        if (productCategoryList != null && productCategoryList.size() > 0) {
            try {
                int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
                if (effectedNum < 0) {
                    throw new ProductCategoryOperationException("店铺创建失败！");
                } else {
                    return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS,productCategoryList);
                }
            } catch (Exception e) {
                throw new ProductCategoryOperationException("error: " + e.getMessage());
            }
        } else {
            return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
        }
    }

    @Override
    @Transactional
    public ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId) 
            throws ProductCategoryOperationException {
        //将此类别下的商品里的类别ID置为空
        try {
            int effectedNum = productDao.updateProductCategoryToNull(productCategoryId);
            if (effectedNum < 0) {
                throw new RuntimeException("商品类别更新失败");
            }
        } catch (Exception e) {
            throw new ProductCategoryOperationException("deleteProductCategory error: " + e.getMessage());
        }
        //删除该productCategory
        try {
            int effectedNum = productCategoryDao.deleteProductCategory(productCategoryId,shopId);
            if (effectedNum <= 0) {
                throw new ProductCategoryOperationException("商品类别删除失败");
            } else {
                return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
            }
        } catch (Exception e) {
            throw new ProductCategoryOperationException("delete error: " + e.getMessage());
        }
    }

}
