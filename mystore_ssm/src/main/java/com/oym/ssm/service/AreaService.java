package com.oym.ssm.service;

import com.oym.ssm.entity.Area;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/2/23 15:51
 */
public interface AreaService {
    public final static String AREA_LIST_KEY = "arealist";

    /**
     * 获取区域列表
     * @return
     */
    List<Area> getAreaList();
}
