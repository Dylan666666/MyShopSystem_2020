package com.oym.o2o.web.shopadmin;

import com.oym.o2o.dto.UserAwardMapExecution;
import com.oym.o2o.entity.Award;
import com.oym.o2o.entity.Shop;
import com.oym.o2o.entity.UserAwardMap;
import com.oym.o2o.service.ShopAuthMapService;
import com.oym.o2o.service.UserAwardMapService;
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
 * @Date: 2020/4/8 16:30
 */
@Controller
@RequestMapping("/shopadmin")
public class UserAwardManagementController {
    @Autowired
    private UserAwardMapService userAwardMapService;
    @Autowired
    private ShopAuthMapService shopAuthMapService;

    /**
     * 列出某个店铺的用户奖品领取情况列表
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/listuserawardmapsbyshop")
    @ResponseBody
    private Map<String, Object> listUserAwardMapsByShop(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        // 从session里获取店铺信息
        Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
        // 获取分页信息
        int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
        int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
        // 空值判断
        if ((pageIndex > -1) && (pageSize > -1) && (currentShop != null) && (currentShop.getShopId() != null)) {
            UserAwardMap userAwardMap = new UserAwardMap();
            userAwardMap.setShop(currentShop);
            // 从请求中获取奖品名
            String awardName = HttpServletRequestUtil.getString(request, "awardName");
            if (awardName != null) {
                // 如果需要按照奖品名称搜索，则添加搜索条件
                Award award = new Award();
                award.setAwardName(awardName);
                userAwardMap.setAward(award);
            }
            // 分页返回结果
            UserAwardMapExecution ue = userAwardMapService.listReceivedUserAwardMap(userAwardMap, pageIndex, pageSize);
            modelMap.put("userAwardMapList", ue.getUserAwardMapList());
            modelMap.put("count", ue.getCount());
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "empty pageSize or pageIndex or shopId");
        }
        return modelMap;
    }

}
