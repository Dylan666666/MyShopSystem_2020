package com.oym.ssm.dao;

import com.oym.ssm.entity.Area;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/2/23 9:48
 */
public interface AreaDao {
    
    /**
     * 列出区域列表
     * @return
     */
    List<Area> queryArea();
}
