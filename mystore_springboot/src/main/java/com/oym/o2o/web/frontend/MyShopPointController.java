package com.oym.o2o.web.frontend;

import com.oym.o2o.dto.UserShopMapExecution;
import com.oym.o2o.entity.PersonInfo;
import com.oym.o2o.entity.Shop;
import com.oym.o2o.entity.UserShopMap;
import com.oym.o2o.service.UserShopMapService;
import com.oym.o2o.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Mr_OO
 * @Date: 2020/4/10 15:39
 */
@Controller
@RequestMapping("/frontend")
public class MyShopPointController {
    @Autowired
    private UserShopMapService userShopMapService;

    /**
     * 列出用户的积分情况
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/listusershopmapsbycustomer")
    @ResponseBody
    private Map<String, Object> listUserShopMapsByCustomer(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        // 获取分页信息
        int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
        int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
        // 从session中获取顾客信息
        PersonInfo user = (PersonInfo) request.getSession().getAttribute("user");
        // 空值判断
        if ((pageIndex > -1) && (pageSize > -1) && (user != null) && (user.getUserId() != null)) {
            UserShopMap userShopMapCondition = new UserShopMap();
            userShopMapCondition.setUser(user);
            long shopId = HttpServletRequestUtil.getLong(request, "shopId");
            if (shopId > -1) {
                // 若传入的店铺id不为空，则取出该店铺该顾客的积分情况
                Shop shop = new Shop();
                shop.setShopId(shopId);
                userShopMapCondition.setShop(shop);
            }
            String shopName = HttpServletRequestUtil.getString(request, "shopName");
            if (shopName != null) {
                // 若商品名为非空，则将其添加进查询条件里进行模糊查询
                Shop shop = new Shop();
                shop.setShopName(shopName);
                userShopMapCondition.setShop(shop);
            }
            // 根据查询条件获取顾客的各店铺积分情况
            UserShopMapExecution ue = userShopMapService.listUserShopMap(userShopMapCondition, pageIndex, pageSize);
            modelMap.put("userShopMapList", ue.getUserShopMapList());
            modelMap.put("count", ue.getCount());
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "empty pageSize or pageIndex or shopId");
        }
        return modelMap;
    }
    
}
