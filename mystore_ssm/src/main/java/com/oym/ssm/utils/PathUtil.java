package com.oym.ssm.utils;

/**
 * @Author: Mr_OO
 * @Date: 2020/2/24 19:58
 */
public class PathUtil {
    
    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        String windows = "windows";
        if(os.toLowerCase().startsWith(windows)) {
            basePath = "O:/store_project/image";
        } else {
            basePath = "/home/project/image";
        }
        return basePath;
    }
    
    public static String getShopImagePath(long shopId) {
        String imagePath = "/upload/shop/" +shopId +  "/";
        return imagePath;
    }
    
}
