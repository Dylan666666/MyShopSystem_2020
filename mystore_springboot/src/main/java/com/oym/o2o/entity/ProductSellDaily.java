package com.oym.o2o.entity;

import java.util.Date;

/**
 * 商品的每日销量
 * @Author: Mr_OO
 * @Date: 2020/3/29 17:50
 */
public class ProductSellDaily {
    // 主键Id
    private Long productSellDailyId;
    // 哪天的销量，精确到天
    private Date createTime;
    // 销量
    private Integer total;
    // 商品信息实体类
    private Product product;
    // 店铺信息实体类
    private Shop shop;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Long getProductSellDailyId() {
        return productSellDailyId;
    }

    public void setProductSellDailyId(Long productSellDailyId) {
        this.productSellDailyId = productSellDailyId;
    }
}
