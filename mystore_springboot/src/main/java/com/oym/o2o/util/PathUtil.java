package com.oym.o2o.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Mr_OO
 * @Date: 2020/2/24 19:58
 */
@Configuration
public class PathUtil {
    private static String winPath;
    private static String linuxPath;
    private static String shopPath;

    @Value("${win.base.path}")
    public void setWinPath(String winPath) {
        PathUtil.winPath = winPath;
    }

    @Value("${linux.base.path}")
    public void setLinuxPath(String linuxPath) {
        PathUtil.linuxPath = linuxPath;
    }

    @Value("${shop.relevant.path}")
    public void setShopPath(String shopPath) {
        PathUtil.shopPath = shopPath;
    }

    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        String windows = "windows";
        if(os.toLowerCase().startsWith(windows)) {
            basePath = winPath;
        } else {
            basePath = linuxPath;
        }
        return basePath;
    }
    
    public static String getShopImagePath(long shopId) {
        String imagePath = shopPath +shopId +  "/";
        return imagePath;
    }
    
}
