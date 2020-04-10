package com.oym.ssm.service.impl;

import com.oym.ssm.cache.JedisUtil;
import com.oym.ssm.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @Author: Mr_OO
 * @Date: 2020/3/25 13:40
 */
public class CacheServiceImpl implements CacheService {
    @Autowired
    private JedisUtil.Keys jedisKeys;
    
    @Override
    public void removeFromCache(String keyPrefix) {
        Set<String> keySet = jedisKeys.keys(keyPrefix + "*");
        for (String key : keySet) {
            jedisKeys.del(key);
        }
    }
}
