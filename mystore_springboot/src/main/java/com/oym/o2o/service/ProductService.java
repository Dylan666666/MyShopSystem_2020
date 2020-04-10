package com.oym.o2o.service;

import com.oym.o2o.dto.ImageHolder;
import com.oym.o2o.dto.ProductExecution;
import com.oym.o2o.entity.Product;
import com.oym.o2o.exceptions.ProductOperationException;
import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/3/6 16:23
 */
public interface ProductService {
    /**
     *添加商品信息以及图片处理
     * @param product
     * @param thumbnail
     * @param imageHolderList
     * @return
     * @throws ProductOperationException
     */
    ProductExecution addProduct(Product product, ImageHolder thumbnail,
                                List<ImageHolder> imageHolderList) throws ProductOperationException;

    /**
     * 查询商品列表并分页，可输入的条件有：商品名（模糊），商品状态，店铺ID，商品类别
     * @param productCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);

    /**
     * 通过商品ID查询唯一的商品信息
     * @param productId
     * @return
     */
    Product getProductById(long productId);

    /**
     * 修改商品信息以及图片处理
     * @param product
     * @param thumbnail
     * @param productImgList
     * @return
     * @throws ProductOperationException
     */
    ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList) 
            throws ProductOperationException; 
        
}
