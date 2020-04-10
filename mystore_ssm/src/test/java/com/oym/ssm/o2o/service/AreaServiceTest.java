package com.oym.ssm.o2o.service;

import com.oym.ssm.entity.Area;
import com.oym.ssm.o2o.BaseTest;
import com.oym.ssm.service.AreaService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/2/23 15:55
 */
public class AreaServiceTest extends BaseTest {
    
    @Autowired
    private AreaService areaService;
    
    @Test
    public void testGetAreaList() {
        List<Area> areaList = areaService.getAreaList();
        System.out.println(areaList.get(0).getAreaName());
    }
    
}
