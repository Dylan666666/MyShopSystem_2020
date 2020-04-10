package com.oym.o2o.service;

/**
 * @Author: Mr_OO
 * @Date: 2020/3/25 13:39
 */
public interface CacheService {
    /**
     * 依据 key前缀删除匹配该模式下的所有key-value 如传入:shopcategory,则shopcategory_allfirstlevel等
     * 以 shopcategory打头的 key_value都会被清空
     * @param keyPrefix
     * @return
     */
    void removeFromCache(String keyPrefix);
}
