package com.oym.o2o.service;

import com.oym.o2o.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: Mr_OO
 * @Date: 2020/2/23 15:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceTest {
    
    @Autowired
    private AreaService areaService;
    
    @Test
    public void testGetAreaList() {
        List<Area> areaList = areaService.getAreaList();
        System.out.println(areaList.get(0).getAreaName());
    }
    
}
