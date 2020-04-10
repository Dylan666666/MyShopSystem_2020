package com.oym.o2o.dto;

import com.oym.o2o.entity.Product;
import com.oym.o2o.enums.ProductStateEnum;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/3/6 16:07
 */
public class ProductExecution {
    /**
     * 结果状态
     */
    private int state;
    /**
     * 状态标识
     */
    private String stateInfo;
    /**
     * 商品数量
     */
    private int count;
    /**
     * 单个操作的 product  
     */
    private Product product;
    /**
     * 获取的product列表（查询商品时使用）
     */
    private List<Product> productList;

    public ProductExecution() {
    }

    public ProductExecution(ProductStateEnum productStateEnum) {
        this.state = productStateEnum.getState();
        this.stateInfo = productStateEnum.getStateInfo();
    }

    public ProductExecution(ProductStateEnum productStateEnum, Product product) {
        this.state = productStateEnum.getState();
        this.stateInfo = productStateEnum.getStateInfo();
        this.product = product;
    }

    public ProductExecution(ProductStateEnum productStateEnum, List<Product> list) {
        this.state = productStateEnum.getState();
        this.stateInfo = productStateEnum.getStateInfo();
        this.productList = list;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public int getCount() {
        return count;
    }

    public Product getProduct() {
        return product;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    
}
