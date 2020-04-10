package com.oym.o2o.web.cache;

import com.oym.o2o.service.AreaService;
import com.oym.o2o.service.CacheService;
import com.oym.o2o.service.HeadLineService;
import com.oym.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Mr_OO
 * @Date: 2020/4/10 16:00
 */
@Controller
public class CacheController {
    @Autowired
    private CacheService cacheService;

    /**
     * 清除区域信息相关的所有redis缓存
     *
     * @return
     */
    @GetMapping(value = "/clearcache4area")
    private String clearCache4Area() {
        cacheService.removeFromCache(AreaService.AREA_LIST_KEY);
        return "shop/operationsuccess";
    }

    /**
     * 清除头条相关的所有redis缓存
     *
     * @return
     */
    @GetMapping(value = "/clearcache4headline")
    private String clearCache4Headline() {
        cacheService.removeFromCache(HeadLineService.HEAD_LIST_KEY);
        return "shop/operationsuccess";
    }

    /**
     * 清除店铺类别相关的所有redis缓存
     *
     * @return
     */
    @GetMapping(value = "/clearcache4shopcategory")
    private String clearCache4ShopCategory() {
        cacheService.removeFromCache(ShopCategoryService.SC_LIST_KEY);
        return "shop/operationsuccess";
    }
}
