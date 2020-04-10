package com.oym.ssm.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: Mr_OO
 * @Date: 2020/2/27 10:11
 */
@Controller
@RequestMapping(value = "shopadmin",method = RequestMethod.GET)
public class ShopAdminController {
    /**
     * 转发至店铺注册/编辑页面
     * @return
     */
    @RequestMapping(value = "/shopoperation")
    public String shopOperation() {
        return "shop/shopoperation";
    }

    /**
     * 转发至店铺列表页面
     * @return
     */
    @RequestMapping(value = "/shoplist")
    public String shopList() {
        return "shop/shoplist";
    }

    /**
     * 转发至店铺管理页面
     * @return
     */
    @RequestMapping(value = "/shopmanagement")
    public String shopManagement() {
        return "shop/shopmanagement";
    }

    /**
     * 转发至商品类别管理页面
     * @return
     */
    @RequestMapping(value = "/productcategorymanagement")
    private String productCategoryManagement() {
        return "shop/productcategorymanagement";
    }

    /**
     * 转发到商品添加/编辑页面
     * @return
     */
    @RequestMapping(value = "/productoperation")
    public String productOperation() {
        return "shop/productoperation";
    }

    @RequestMapping(value = "/productmanagement")
    public String productManagement() {
        // 转发至商品管理页面
        return "shop/productmanagement";
    }
    
}
