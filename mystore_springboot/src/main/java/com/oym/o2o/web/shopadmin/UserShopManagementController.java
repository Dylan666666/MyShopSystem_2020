package com.oym.o2o.web.shopadmin;

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
 * @Date: 2020/4/8 15:36
 */
@Controller
@RequestMapping(value = "/shopadmin")
public class UserShopManagementController {
    @Autowired
    private UserShopMapService userShopMapService;

    /**
     * 获取某个店铺的用户积分信息
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/listusershopmapsbyshop")
    @ResponseBody
    private Map<String, Object> listUserShopMapsByShop(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap();
        // 获取分页信息
        int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
        int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
        // 从session中获取当前店铺的信息
        Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
        // 空值判断
        if ((pageIndex > -1) && (pageSize > -1) && (currentShop != null) && (currentShop.getShopId() != null)) {
            UserShopMap userShopMapCondition = new UserShopMap();
            // 传入查询条件
            userShopMapCondition.setShop(currentShop);
            String userName = HttpServletRequestUtil.getString(request, "userName");
            if (userName != null) {
                // 若传入顾客名，则按照顾客名模糊查询
                PersonInfo customer = new PersonInfo();
                customer.setName(userName);
                userShopMapCondition.setUser(customer);
            }
            // 分页获取该店铺下的顾客积分列表
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
